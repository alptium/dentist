package dentist;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Dentist app!");
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Do you want to add Doctor? (Y/N)");
			String a1= sc.next();
			
			if ( a1.equals("Y") || a1.equals("y")) {
				runDemoDentist();
			}
			else if (a1.equals("N") || a1.equals("n")) {
				System.out.println("You will now enter program for add Patient.");
				//runDemoPatient();
			}
			
		}
	}


	private static void runDemoDentist() {
	
		System.out.println("Follow the instructions to add new Dentist:");
	
		try(Scanner sc = new Scanner(System.in)) {
				
			
			System.out.println("Please enter your firstname: ");
			String firstName = sc.next();
			
			System.out.println("Please enter your lastname: ");
			String lastName = sc.next();
			
			System.out.println("Please enter your birth date: ");
			int birthDate = sc.nextInt();
			
			System.out.println("Please enter your birth mounth: ");
			int birthMounth = sc.nextInt();
			
			System.out.println("Please enter your birth year: ");
			int birthYear = sc.nextInt();
			
			System.out.println("Please enter your JMBG: ");
			long jmbg = sc.nextLong();
			//attention, the personal number cant be long,int etc. because
			//in the case where the first number is 0 it it will return without it
			if (jmbg < 13 && jmbg > 13) {
				System.out.println("You entered wrong JMBG number!");
				System.out.println("Please try again.");
				long jmbg1 = sc.nextLong();
				
				if (jmbg < 13 && jmbg > 13) {
					System.out.println("You entered wrong JMBG number again!");
					System.out.println("Please try again, you need to enter 13 numbers.");
					long jmbg2 = sc.nextLong();
				}
			}
				
			System.out.println("Please enter your specialization:");
			String specialization = sc.next();
				
			System.out.println("Please enter your licence ID:");
			int licenceID = sc.nextInt();
			
			Dentist dentist = new Dentist (firstName, lastName, birthDate,birthMounth, birthYear, jmbg, specialization, licenceID);
			
			System.out.println();
			System.out.println( dentist.getfirstName());
		}
	}
}
