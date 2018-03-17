package dentist;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Dentist app!");
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Do you want to add Doctor? (Y/N)");
			String a1= sc.next().substring(0, 1);
			
			if ( a1.equalsIgnoreCase("Y") ) {
				runDemoDentist();
			}
			else if (a1.equalsIgnoreCase("N") ) {
				System.out.println("You will now enter program to add Patient.");
				runDemoPatient();
			}
			
		}
	}


	private static void runDemoDentist() {
	
		System.out.println("Follow the instructions to add new Dentist:");
	
		try(Scanner sc = new Scanner(System.in)) {
				
			
			System.out.println("Please enter dentist's Name: ");
			String firstName = sc.next();
			
			System.out.println("Please enter dentist's Surname: ");
			String lastName = sc.next();
			
			System.out.println("Please enter dentist's Birth Day: ");
			int birthDay = sc.nextInt();
			
			System.out.println("Please enter dentist's Birth Month: ");
			int birthMonth = sc.nextInt();
			
			System.out.println("Please enter dentist's Birth Year: ");
			int birthYear = sc.nextInt();
			
			System.out.println("Please enter dentist's JMBG: ");
			String jmbg = sc.next();
			int jmbgLength = jmbg.length();
			//attention, the personal number cant be long,int etc. because
			//in the case where the first number is 0 it it will return without it
			if (jmbgLength < 13 || jmbgLength > 13) {
				System.out.println("You entered wrong JMBG number!");
				System.out.println("Please try again.");
				String jmbg1 = sc.next();
				jmbg = jmbg1;
			}
				
			System.out.println("Please enter dentist's Specialization:");
			String specialization = sc.next();
				
			System.out.println("Please enter dentist's Licence ID:");
			int licenceID = sc.nextInt();
			
			Dentist dentist = new Dentist (firstName, lastName, birthDay, birthMonth, birthYear, jmbg, specialization, licenceID);
			
			System.out.println();
			System.out.println( dentist.getjmbg());
			System.out.println("zdravo ");
		}
	}
	
	private static void runDemoPatient() {
		
		try(Scanner sc = new Scanner(System.in)) {
		
			System.out.println("Please enter patient's Name: ");
			String name = sc.next();
			
			System.out.println("Please enter patient's Surname: ");
			String surname = sc.next();
			
			System.out.println("Please enter patient's Birth Day: ");
			int birthDay = sc.nextInt();
			
			System.out.println("Please enter patient's Birth Month: ");
			int birthMonth = sc.nextInt();
			
			System.out.println("Please enter patient's Birth Year: ");
			int birthYear = sc.nextInt();
			
			System.out.println("Please enter patient's JMBG: ");
			String jmbg = sc.next();
			int jmbgLength = jmbg.length();
			//attention, the personal number cant be long,int etc. because
			//in the case where the first number is 0 it it will return without it
			if (jmbgLength < 13 || jmbgLength > 13) {
				System.out.println("You entered wrong JMBG number!");
				System.out.println("Please try again.");
				String jmbg1 = sc.next();
				jmbg = jmbg1;
			}
				
			System.out.println("Enter patient's Address:");
			String address = sc.next();
			
			System.out.println("Enter patient's City:");
			String city = sc.next();
			
			System.out.println("Enter patient's Phone Number:");
			int phoneNumber = sc.nextInt();
			
			System.out.println("Enter patient's Occupation:");
			String occupation = sc.next();
			
		}
	}
}

