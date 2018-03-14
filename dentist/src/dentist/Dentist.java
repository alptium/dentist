package dentist;

public class Dentist {
	
	private String firstName;
	private String lastName;
	private int birthDate;
	private int birthMounth;
	private int birthYear;
	private String jmbg;
	private String specialization;
	private int licenceID;
	
	public Dentist(String firstName, String lastName, int birthDate, int birthMounth, int birthYear, String jmbg, String specialization, int licenceID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.birthMounth = birthMounth;
		this.birthYear = birthYear;
		this.jmbg = jmbg;
		this.specialization = specialization;
		this.licenceID = licenceID;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getbirthDate() {
		return birthDate;
	}
	
	public int getbirthMounth() {
		return birthMounth;
	}
	
	public int getbirthYear() {
		return birthYear;
	}
	
	public String getjmbg() {
		return jmbg;
	}
	
	public String getspecialization() {
		return specialization;
	}
	
	public int getlicenceID() {
		return licenceID;
	}
}
