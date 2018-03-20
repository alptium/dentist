package dentist;

public class Dentist {
	
	private String firstName;
	private String lastName;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private String jmbg;
	private String specialization;
	private int licenceID;
	
	public Dentist(String firstName, String lastName, int birthDay, int birthMonth, int birthYear, String jmbg, String specialization, int licenceID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.jmbg = jmbg;
		this.specialization = specialization;
		this.licenceID = licenceID;
	}
	
	public String getfirstName() {
		return firstName;
	}
	

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getbirthDate() {
		return birthDay;
	}
	
	public int getbirthMonth() {
		return birthMonth;
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
