package dentist;

import java.util.*;
import java.io.IOException;
import java.sql.*;
/**
 * @author Djordje Milosevic 
 * @team alptuim/dentist
 * CRUD - 
 * Create(Kreira podatke)
 * Read	 (Cita podatke)
 * Update(Unosi podatke)
 * Delete(Brise podatke)
 * localhost:3306/alptium_dentistlocalhost
 **/

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		

			System.out.println("------- Welcome! -------\nPlease enter your local database login informations.");
			
			System.out.println("\n1.Input your host, port and the database name: example(localhost:3306/alptium_dentistlocalhost)");
			final String hostAndDatabaseName=sc.next();
			
			System.out.println("Username: ");
			final String DBusername = sc.next();
			
			System.out.println("Password: ");
			final String DBpassword = sc.next();
			
			System.out.println("\nConnecting...\n");
					
			Connection connection = connection(hostAndDatabaseName, DBusername, DBpassword);
			
			System.out.println("========================WELCOME==========================");
			
			System.out.println("Please select option:\n(1) - Patient info and schedule \n(2) - Login to Information System Alptium Dentist ");
			
			int opt = sc.nextInt();
			
			if(opt == 1) {		
				for(;;) {
					System.out.println("Enter the patient's UPN(JMBG) or E to exit the program:");
					String patientUpn = sc.next();
					if(patientUpn.equalsIgnoreCase("E")) {
						System.out.println("========================GODBYE=========================");
						System.exit(1);
					} else {
						infoPatient(patientUpn, connection);
					}
				}
			 } else if(opt == 2) {	
					if(login(connection)) {
						String brk;
						
						do { 
							
						 brk = sc.nextLine();
						 System.out.println("------------------------------------------------------");
							System.out.println("Please select option: ");
							System.out.println("A - List of all patients \nC - Create a new patient \nD - Delete the patient \nE - Exit the program");
							
						 if(brk.equalsIgnoreCase("A")) {
								infoPatientlist(connection);
							} else if(brk.equalsIgnoreCase("C")) {
								createPatient(connection);					//TODO: Testirati zasto nece da radi
							} else if(brk.equalsIgnoreCase("D")) {
								deletePatient(connection);					
							} else if(brk.equalsIgnoreCase("E")) {
								System.out.println("========================GODBYE=========================");
								System.exit(1);
							}
						
							//TODO: dodati iz ERD preostale 
							
						} while(!brk.equalsIgnoreCase("E"));				
						sc.close();
					}
			}
	}
	
	
	//begin metod connection
	public static  Connection connection(String hostAndDatabaseName , String DBusername , String DBpassword) throws SQLException { 
		Connection myConn = null;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://" + hostAndDatabaseName + "?autoReconnect=true&useSSL=false", DBusername, DBpassword);
			System.out.println("---Successful connection to the database--- \n");
			
			} catch(SQLException e) {
				System.out.println("---Unsuccessful connection to the database---");
				System.exit(1);
			}
	 	
		return myConn;
		
	}
	//end metoda konektujSe
	//======================================================================================================================================================
	//begin metoda infoPatient
	
	public static void infoPatient(String upn, Connection konek) throws SQLException {
		
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
				String bloodType = result.getString("BLOOD_TYPE");
				
				//TODO: Uneti ostale podatke za prikazivanje
				
				if(jmbg.equals(null)) {
					System.out.println("Patient does not exist");
				}
				
				System.out.println("Last name: " + lastName + "\nFirst name: " + firstName + "\nUPN: " + jmbg);
				System.out.println("Blood type: " + bloodType + "\n");
			}
			
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}
	
		//end metoda infoPatient
		//======================================================================================================================================================
		//begin metoda infoPatientlist
		
		public static void infoPatientlist(Connection konek)throws SQLException{
			
				PreparedStatement stmt = null;
				ResultSet result = null;
				Connection myConn = konek;
				
			try {
				String query = "Select * From  `alptium_dentistlocalhost`.`patient`";
				
				stmt = myConn.prepareStatement(query);
				
				result = stmt.executeQuery();
				
				if (!result.isBeforeFirst()) {    
				    System.out.println("No information"); 
				}
				while (result.next()) {
					String lastName = result.getString("LAST_NAME");
					String firstName = result.getString("FIRST_NAME");
					String jmbg = result.getString("UNIQE_PERSONAL_NUMBER");
					
					if(jmbg.equals(null)) {
						System.out.println("ne postojite u bazi");
					}
					
					System.out.println("Prezime: " + lastName + " Ime:" + firstName + " Jmbg: " + jmbg); 	//TODO: Dopuniti podatke za prikaz 
					
				}
				
				} catch (Exception exc) {
					exc.printStackTrace();
				}

			}
		
		//end metoda infoPatientlist
		//======================================================================================================================================================
		//begin metoda deletePatient
		
		public static void deletePatient(Connection konek) throws SQLException {
			
			try (Scanner input = new Scanner(System.in)) {
				
				PreparedStatement stmt = null;
				Connection myConn = konek;
				
				System.out.println("Enter UPN(JMBG) patient's you want to delete");
				String upnDeletePatient = input.nextLine();
				
				String query = "DELETE FROM `alptium_dentistlocalhost`.`patient` WHERE `UNIQUE_PERSONAL_NUMBER` = " + "'" + upnDeletePatient + "'";
				stmt = myConn.prepareStatement(query);
				stmt.executeUpdate();
				System.out.println("Successful deleting ");
						
				
			}
		}
		
		//end metoda deletePatientlist
		//======================================================================================================================================================
		//begin metoda createPatient
				
		public static void createPatient(Connection konek) throws SQLException {
				
				try(Scanner sc = new Scanner(System.in)) {
					
					System.out.println("\nEnter last name: ");
					String lastName =sc.next();
					
					System.out.println("Enter first name: ");
					String firstName = sc.next();
					
					System.out.println("Enter birth date: (yyyy-mm-dd) ");
					String birthDate = sc.next();
					
					System.out.println("Enter UPN (JMBG): ");
					String upn = sc.next();
					
					System.out.println("Enter blood type: ");
					String bloodType = sc.next();
					
					System.out.println("Enter city: ");
					String city = sc.next();
					
					System.out.println("Enter adress: ");
					String adress = sc.next();
					
					System.out.println("Enter phone number: ");
					String phoneNumber = sc.next();
					
					Connection myConn = konek;
					PreparedStatement stmt = null;
					
					try {
					String query = "INSERT INTO `alptium_dentistlocalhost`.`patient` (`LAST_NAME`, `FIRST_NAME`, `DATE_BIRTH`, `UNIQUE_PERSONAL_NUMBER`, `BLOOD_TYPE`, `CITY`, `ADRESS`, `PHONE_NUMBER`) " +
							"VALUES ('" + lastName + "', '" + firstName + "', '" + birthDate + "', '" + upn + "', '" + bloodType + "', '" + city + "', '" + "', '" + adress + "', '" + "', '" + phoneNumber + "')";
					stmt = myConn.prepareStatement(query);
					stmt.executeUpdate();

					} catch (Exception exc) {
						exc.printStackTrace();
					} finally {
						System.out.println("\nSuccessful creation");
						
					}
				}
			}
		
		//end metoda createPatient
		//======================================================================================================================================================
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
				
					String query = "Select * From  `alptium_dentistlocalhost`.`dentist` where UNIQUE_PERSONAL_NUMBER=" + upn + " AND PASSWORD=" +password;
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
					
				
				System.out.println("UNSUCCESSFUL LOGIN!");
				System.out.println("========================GODBYE=========================");
				
				return false;
				
				//end metoda login
					}
					return false;
			}
		}
															//end of class	
}
