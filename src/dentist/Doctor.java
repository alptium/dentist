package dentist;

public class Doctor {
	
	private String firstName;
	private String lastName;
	private int birthDate;
	private int birthMounth;
	private int birthYear;
	private long jmbg;
	private String specialization;
	private int licenceID;
	
	public Doctor(String firstName, String lastName, int birthDate, int birthMounth, int birthYear, long jmbg, String specialization, int licenceID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.birthMounth = birthMounth;
		this.birthYear = birthYear;
		this.jmbg = jmbg;
		this.specialization = specialization;
		this.licenceID = licenceID;
	}
	
	public String getLastName() {
		return lastName;
}
}