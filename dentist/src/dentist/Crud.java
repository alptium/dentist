package dentist;
//package crud;
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

public class Crud {

	public static void main(String[] args) throws SQLException {
		Scanner in = new Scanner(System.in);
		//uvod i konekcija
		/*System.out.println("Dobrodosli\nUpisite informacije za bazu podataka\nHostname:port/ime baze :");
		final String hostAndDatabaseName=in.next();*/
		System.out.println("Username: ");
		final String DBusername = in.next();
		System.out.println("Password: ");
		final String DBpassword = in.next();
		
		String url = "jdbc:mysql://localhost:3306/dentist";
		Connection kon = konektujSe( url , DBusername, DBpassword);		//promenjeno u URL
		
		//izbor
		
		System.out.println("Izaberite opciju 1 - Info o pacijentima ili raspored 2 - Login to ISDent ");
		int opt = in.nextInt();
		if(opt == 1) {		
			for(;;) {
				
				System.out.println("Upisite broj zdravstvenog kartona ili exit za izlaz");
				String brk = in.next();
				
				if(brk.equalsIgnoreCase("exit")) {
					System.out.println("Dovidjenja!");System.exit(1);
				} else {
					infoPatient(brk,kon);
				}
			}
			
		} else if(opt == 2) {
				/*if(login(kon) == true)*/ {
					for(;;) {
						
						System.out.println("Upisite opciju ili exit za izlaz");
						System.out.println("A-ispis pacijenata ;C-Update pacijenta ; D-Izbrisi pacijenta; exit- za izlaz");
						String brk = in.next();
						
						if(brk.equalsIgnoreCase("A")) {
							infoPatientlist(kon);
						} else if(brk.equalsIgnoreCase("C")) {
							createPatient(kon);
						} else if(brk.equalsIgnoreCase("D")) {
							deletePatient(kon);
						} else if(brk.equalsIgnoreCase("exit")) {
							System.out.println("Dovidjenja!");System.exit(1);
						}
						
					}
							
				}
		
		}
		
		in.close();
	}
	
	//begin metoda konektujSe
	public static  Connection konektujSe(String /*hostAndDatabaseName*/ url , String DBusername , String DBpassword) throws SQLException {		//promenjeno u URL
		
		Connection myConn = null;
		url = "jdbc:mysql://localhost:3306/dentist";  		// dodata URL da bi se rešio problem sa konekcijom
		try {
			myConn = DriverManager.getConnection(/*"jdbc:mysql://" + hostAndDatabaseName + "?autoReconnect=true&useSSL=false"*/ url ,DBusername,DBpassword);
			System.out.println("Uspešno povezivanje sa bazom");
		}
		catch(SQLException e) {
				System.out.println("Neuspešno povezivanje sa bazom");
				System.exit(1);
		}
	 	
		return myConn;	
		
	}
	
	//end metoda konektujSe
	//====================
	//begin metoda infoPatient
	
	public static void infoPatient(String umcn,Connection konek)throws SQLException {
		
			PreparedStatement stmt = null;
			ResultSet rst = null;
			Connection myConn = konek;
			
		try {
			String query = "Select * From  `dentist`.`patient` where jmbg=" + umcn;
			
			stmt = myConn.prepareStatement(query);
			
			rst = stmt.executeQuery();
			
			if (!rst.isBeforeFirst()) {    
			    System.out.println("Nema informacija"); 
			} 
			while (rst.next()) {
				String lastName = rst.getString("last_name");
				String firstName = rst.getString("first_name");
				String jmbg = rst.getString("jmbg");
				
				if(jmbg.equals(null)) {
					System.out.println("ne postojite u bazi");
				}
				
				System.out.println("Prezime: " + lastName + " Ime: " + firstName + " JMBG: " + jmbg + " Status");
				
			}	
			
		
		} catch(Exception exc) {
			exc.printStackTrace();
		}

	}
		//end metoda infoPatient
		//	============================================
	//====================
		//begin metoda infoPatientlist
		
		public static void infoPatientlist(Connection konek)throws SQLException{
			
				PreparedStatement stmt = null;
				ResultSet rst = null;
				Connection myConn = konek;
				
			
			
			try {
				
				String query = "Select * From  `dentist`.`patient`";
				
				stmt = myConn.prepareStatement(query);
				
				rst = stmt.executeQuery();
				
				
				if (!rst.isBeforeFirst() ) {    
				    System.out.println("Nema informacija"); 
				} 
				while (rst.next()) {
					String surname = rst.getString("surname");
					String name = rst.getString("name");
					String jmbg = rst.getString("jmbg");
					if(jmbg.equals(null)){System.out.println("ne postojite u bazi");}
					
					
					System.out.println("Prezime: " + surname + " Ime: " + name + " JMBG: " + jmbg + " Status");
					
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
						
						String query = "Delete From  `dentist`.`patient` where jmbg=\"" + in + " \"";
						
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
				
				public static void createPatient(Connection konek) throws SQLException {
					
						Connection myConn = konek;
						
					try (Scanner sc = new Scanner(System.in)) {
						
						System.out.println("Please enter patient's Name: ");
						String name = sc.next();
						
						/*System.out.println("Please enter patient's Surname: ");
						String surname = sc.next();
						
						System.out.println("Please enter patient's Birth Day: ");
						int birthDay = sc.nextInt();
						
						System.out.println("Please enter patient's Birth Month: ");
						int birthMonth = sc.nextInt();
						
						System.out.println("Please enter patient's Birth Year: ");
						int birthYear = sc.nextInt();
						
						System.out.println("Please enter patient's JMBG: ");
						String jmbg = sc.next();
						
						while (jmbg.length() != 13) {
							System.out.println("You entered wrong JMBG number!");
							System.out.println("Please try again.");
							jmbg = sc.next();
						}
							
						System.out.println("Enter patient's Address:");
						String address = sc.next();
						
						System.out.println("Enter patient's City:");
						String city = sc.next();
						
						System.out.println("Enter patient's Phone Number:");
						int phoneNumber = sc.nextInt();
						
						System.out.println("Enter patient's Occupation:");
						String occupation = sc.next();*/
						
						PreparedStatement stmt = null;
						
						try {
							
							String query = "INSERT INTO `dentist`.`patient` (`name`, `surname`, `birthDay`, `birthMonth`, `birthYear`,`jmbg`, `address`, `city`, `phoneNumber`, `occupation`) VALUES (name)"
									/*"VALUES ('" + name + "', '" + surname + "', '" + birthDay + "', '" + birthMonth + "', '" + birthYear + "', '" + jmbg + "', '" + address + "', '" + city + "', '" + phoneNumber + "', '" + occupation + "')"*/;
							
							stmt = myConn.prepareStatement(query);
							
							stmt.executeUpdate();
			
						} catch (Exception exc) {
									exc.printStackTrace();
						} finally {
								System.out.println("Uspesno upisivanje ");
						}
								
					}
				}
				
					//end metoda createPatient
				//---------------------------------------------------------------------------------------------------------------------------------
		//begin metoda login
				
		public static boolean login(Connection connect) throws SQLException {
			
			try (Scanner input = new Scanner(System.in)) {
				
				System.out.println("unesite jmbg");
				String in = input.next();
				
				PreparedStatement stmt = null;
				ResultSet rst = null;
				Connection myConn = connect;
				
				try {
					String query = "Select * From  `dentist`.`dentist` where jmbg=" + in; //preprravljen `dentistlocalhost` u `dentist`
					stmt = myConn.prepareStatement(query);
					rst = stmt.executeQuery();
					
					if (!rst.isBeforeFirst()) {    
					    System.out.println("Login Failed, please contact master"); 
					    
					} else if(rst.next()) {
						if(rst.getString("jmbg").equals(in)) {
							System.out.println("Welcome " + rst.getString("first_name"));
						} return true;
					}
				}
				
				catch (Exception exc) {
				exc.printStackTrace();
				}

				input.close();
				return false;
				//end metoda login
			}
		}
															//end of class	
}