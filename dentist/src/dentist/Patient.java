package dentist;

public class Patient {
	
	private String name;
	private String surname;
	private String jmbg;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private String address;
	public String city;
	private int phoneNumber;
	public void setCity(String city) {
		this.city = city;
	}

	private String occupation;
	
	public Patient(String name, String surname, String jmbg, int birthDay, int birthMonth, int birthYear, String address, String city, int phoneNumber, String occupation) {
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.occupation = occupation;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getJmbg() {
		return jmbg;
	}
	
	public int getBirthDay() {
		return birthDay;
	}
	
	public int getBirthMonth() {
		return birthMonth;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getOccupation() {
		return occupation;
	}
}
