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
				System.out.println("You will now enter program for add Patient.");
				//runDemoPatient();
			}
			
		}
	}


	private static void runDemoDentist() {
	
		System.out.println("Follow the instructions to add new Dentist:");
	
		try(Scanner sc = new Scanner(System.in)) {
				
			
			System.out.println("Please enter your first name: ");
			String firstName = sc.next();
			
			System.out.println("Please enter your last name: ");
			String lastName = sc.next();
			
			System.out.println("Please enter your birth date: ");
			int birthDate = sc.nextInt();
			
			System.out.println("Please enter your birth mounth: ");
			int birthMounth = sc.nextInt();
			
			System.out.println("Please enter your birth year: ");
			int birthYear = sc.nextInt();
			
			System.out.println("Please enter your JMBG: ");
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
				
			System.out.println("Please enter your specialization:");
			String specialization = sc.next();
				
			System.out.println("Please enter your licence ID:");
			int licenceID = sc.nextInt();
			
			Dentist dentist = new Dentist (firstName, lastName, birthDate,birthMounth, birthYear, jmbg, specialization, licenceID);
			
			System.out.println();
			System.out.println( dentist.getjmbg());
		}
	}
}
