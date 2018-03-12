package dentist;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Dentist app!");
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Do you want to add Doctor? (Y/N)");
			String a1= sc.next();
			
			if ( a1.equals("Y") || a1.equals("y")) {
				runDemoDoctor();
			}
			else if (a1.equals("N") || a1.equals("n")) {
				System.out.println("You will now enter program for add Patient.");
				runDemoPatient();
			}
			
		}
	}

}
	private static void runDemoDoctor() {
		
		System.out.println("Follow the instructions to add new Doctor:");
	
		try(Scanner sc = new Scanner(System.in)) {
				
			System.out.println("Please enter Name: ");
			String firstName = sc.next();
			
			System.out.println("Please enter Surname: ");
			String lastName = sc.next();
			
			System.out.println("Please enter Birth Date: ");
			int birthDate = sc.nextInt();
			
			System.out.println("Please enter Birth Month: ");
			int birthMonth = sc.nextInt();
			
			System.out.println("Please enter Birth Year: ");
			int birthYear = sc.nextInt();
			
			System.out.println("Please enter JMBG: ");
			long jmbg = sc.nextLong();
			
			Doctor doctor = new Doctor (firstName, lastName, birthDate, birthMonth, birthYear, jmbg);
			
			if (jmbg < 13 && jmbg > 13) {
				System.out.println("You entered wrong JMBG number!");
				System.out.println("Please try again.");
				long jmbg1 = sc.nextLong();
				
				if (jmbg < 13 && jmbg > 13) {
					System.out.println("You entered wrong JMBG number!");
					System.out.println("Please try again, you need to enter 13 numbers.");
					long jmbg2 = sc.nextLong();
				}
			}
				
			System.out.println("Please enter your Specialization:");
			String specialization = sc.next();
				
			System.out.println("Please enter your Licence ID:");
			int licenceID = sc.nextInt();
	}
		
		public static void runDemoPatient() {
			
			System.out.println("Follow the instructions to add new Patient:");
			
			try(Scanner sc = new Scanner(System.in)) {
				
				System.out.println("Please enter Name: ");
				String name = sc.next();
				
				System.out.println("Please enter Surname: ");
				String surname = sc.next();
				
				System.out.println("Please enter JMBG: ");
				String jmbg = sc.nextLong();
				
				System.out.println("Please enter Birth Date: ");
				String birthDate = sc.next()Int;
				
				System.out.println("Please enter Address: ");
				String address = sc.next();
				
				System.out.println("Please enter City: ");
				String city = sc.next();
				
				System.out.println("Please enter Phone Number: ");
				String phoneNumber = sc.nextInt();
				
				System.out.println("Please enter Occupation: ");
				String occupation = sc.next();
				
				Patient patient = new Patient (name, surname, jmbg, birthDate, address, city, phoneNumber, occupation);
				
				if (jmbg < 13 && jmbg > 13) {
					System.out.println("You entered wrong JMBG number!");
					System.out.println("Please try again.");
					long jmbg1 = sc.nextLong();
					
					if (jmbg < 13 && jmbg > 13) {
						System.out.println("You entered wrong JMBG number!");
						System.out.println("Please try again, you need to enter 13 numbers.");
						long jmbg2 = sc.nextLong();
				
			}
		}