package dentist;

import java.util.*;
import java.sql.*;
/**
 * @author Djordje Milosevic 
 * @team alptuim/dentist
 * CRUD - 
 * Create(Kreira podatke)
 * Read	 (Cita podatke)
 * Update(Unosi podatke)
 * Delete(Brise podatke)
 **/

public class Main {

	public static void main(String[] args) throws SQLException {
		
		try(Scanner sc = new Scanner(System.in)) {

			System.out.println("--- Welcome! ---\nPlease enter your local database login informations.");
			
			System.out.println("\n1.Input your host, port and the database name: example(localhost:3306/alptium_dentistlocalhost)");
			final String hostAndDatabaseName=sc.next();
			
			System.out.println("Username: ");
			final String DBusername = sc.next();
			
			System.out.println("Password: ");
			final String DBpassword = sc.next();
					
			Connection kon = connection(hostAndDatabaseName, DBusername, DBpassword);
			
			System.out.println("========================WELCOME=======================");
			
			System.out.println("Please select option:\n(1) - Patient info and schedule \n(2) - Login to Information System Alptium Dentist ");
			int opt = sc.nextInt();
			
			if(opt == 1) {		
				for(;;) {
					System.out.println("Upisite broj zdravstvenog kartona ili exit za izlaz");
					String brk = sc.next();
					if(brk.equalsIgnoreCase("exit")) {
						System.out.println("Dovidjenja!");
						System.exit(1);
					} else {
						infoPatient(brk, kon);
					}
				}
			} else if(opt == 2) {
				if(login(kon) == true) {
					for(;;) {
						System.out.println("Upisite opciju ili exit za izlaz");
						System.out.println("A-ispis pacijenata ;C-Update pacijenta ; D-Izbrisi pacijenta; exit- za izlaz");
						String brk = sc.next();
						
							if(brk.equalsIgnoreCase("A")) {
								infoPatientlist(kon);
							} else if(brk.equalsIgnoreCase("C")) {
								createPatient(kon);
							} else if(brk.equalsIgnoreCase("D")) {
								deletePatient(kon);
							} else if(brk.equalsIgnoreCase("exit")){System.out.println("Dovidjenja!");System.exit(1);}

					}
							
				}
			
			}
			
			sc.close();
		}
	}
	
	//begin metod connection
	public static  Connection connection(String hostAndDatabaseName , String DBusername , String DBpassword) throws SQLException { 
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://"+hostAndDatabaseName+"?autoReconnect=true&useSSL=false", DBusername, DBpassword);
			System.out.println("---Successful connection to the database---");
			
			} catch(SQLException e) {
				System.out.println("---Unsuccessful connection to the database---");
				System.exit(1);
			}
	 	
		return myConn;
		
	}
	//end metoda konektujSe
	//====================
	//begin metoda infoPatient
	
	public static void infoPatient(String upn, Connection konek)throws SQLException {
		
			PreparedStatement stmt = null;
			ResultSet result = null;
			Connection myConn = konek;

		try {
			
			String query = "Select * From  `alptium_dentistlocalhost`.`patient` where UNIQUE_PERSONAL_NUMBER=" + upn;
			stmt = myConn.prepareStatement(query);
			result = stmt.executeQuery();
			
			if (!result.isBeforeFirst()) {    
			    System.out.println("No information"); 
			} 
			while (result.next()) {
				String lastName = result.getString("LAST_NAME");
				String firstName = result.getString("FIRST_NAME");
				String jmbg = result.getString("UNIQUE_PERSONAL_NUMBER");
				if(jmbg.equals(null)) {
					System.out.println("ne postojite u bazi");
				}
				
				System.out.println("Last name: " + lastName + "n/First name:" + firstName + "n/UPN: " + jmbg);
				
			}
			
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}
		//end metoda infoPatient
		//	============================================
		//begin metoda infoPatientlist
		
		public static void infoPatientlist(Connection konek)throws SQLException{
			
				PreparedStatement stmt = null;
				ResultSet rst = null;
				Connection myConn = konek;
				
			
			
			try {
				
				String query = "Select * From  `alptium_dentistlocalhost`.`patient`";
				
				stmt = myConn.prepareStatement(query);
				
				rst = stmt.executeQuery();
				
				
				if (!rst.isBeforeFirst() ) {    
				    System.out.println("Nema informacija"); 
				} 
				while (rst.next()) {
					String lastName = rst.getString("last_name");
					String firstName = rst.getString("first_name");
					String jmbg = rst.getString("jmbg");
					if(jmbg.equals(null)){System.out.println("ne postojite u bazi");}
					
					
					System.out.println("Prezime: "+lastName+" Ime:"+firstName+" Jmbg: "+jmbg+"Status");
					
				}	
				
			
					}catch (Exception exc) {
						exc.printStackTrace();
				}
					
				

			
			
				
			}
			//end metoda infoPatientlist
		//----------------------------------------------------------------------------------------------------------------------
		//begin metoda deletePatient
		
				public static void deletePatient(Connection konek)throws SQLException{
						Scanner input = new Scanner(System.in);
						PreparedStatement stmt = null;
						Connection myConn = konek;
						System.out.println("unesite jmbg pacijenta koga zelite da izbrisete");
						String in = input.nextLine();
						
					
					
					try {
						
						String query = "Delete From  `dentistlocalhost`.`patient` where jmbg=\""+in+" \"";
						
						stmt = myConn.prepareStatement(query);
						
						stmt.executeUpdate();
						
						
						System.out.println("Uspesno brisanje ");
					
							}catch (Exception exc) {
								exc.printStackTrace();
						}
							
					
					input.close();
					
						
					}
					//end metoda deletePatientlist
				//-------------------------------------------------------------------------------------------------------------
			
				//begin metoda createPatient
				
				public static void createPatient(Connection konek)throws SQLException{
						Connection myConn = konek;
						Scanner input = new Scanner(System.in);
						System.out.println("Unesite prezime");
						String last_name =input.next();
						System.out.println("Unesite ime");
						String first_name = input.next();
						System.out.println("Unesite email");
						String email = input.next();
						System.out.println("Unesite okupacija");
						String ocupation = input.next();
						System.out.println("Unesite jmbg");
						String jmbg = input.next();
						
						
						PreparedStatement stmt = null;
						
						
		
					try {
						
						String query = "INSERT INTO `dentistlocalhost`.`patient` (`last_name`, `first_name`, `email`, `ocupation`, `jmbg`) " +
								"VALUES ('"+last_name+"', '"+first_name+"', '"+email+"', '"+ocupation+"', '"+jmbg+"')";
						
						stmt = myConn.prepareStatement(query);
						
						stmt.executeUpdate();

							}catch (Exception exc) {
								exc.printStackTrace();
						}finally{
							System.out.println("Uspesno upisivanje ");
						}

					}
					//end metoda createPatient
				//---------------------------------------------------------------------------------------------------------------------------------
		//begin metoda login
		public static boolean login(Connection connect) throws SQLException {
			
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Input UPN");
			String upn = sc.next();
			System.out.println("Input PASSWORD");
			String password = sc.next();
			
			PreparedStatement stmt = null;
			ResultSet result = null;
			Connection myConn = connect;
			try {
				String query = "Select * From  `alptium_dentistlocalhost`.`dentist` where UNIQUE_PERSONAL_NUMBER=" + upn + " AND PASSWORD=" + password;
				stmt = myConn.prepareStatement(query);
				result = stmt.executeQuery();
				
				if (!result.isBeforeFirst()) {    
				    System.out.println("Login Failed, please contact master"); 
				} else if(result.next()) {
					if(result.getString("UNIQUE_PERSONAL_NUMBER").equals(upn) && result.getString("PASSWORD").equals(password)) {
						System.out.println("=======================================================");
						System.out.println("Welcome " + result.getString("FIRST_NAME"));
						return true;
					}
				}
			 
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
			System.out.println("UNSUCCESSFUL LOGIN!");
			System.out.println("========================GODBYE=========================");
			sc.close();
			return false;
			
			//end metoda login
		}
	}
	
															//end of class	
}
