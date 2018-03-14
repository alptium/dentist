package dentist;

public class Patient {
	
	private String name;
	private String surname;
	private String jmbg;
	private int birthDate;
	private String address;
	private String city;
	private int phoneNumber;
	private String occupation;
	
	public Patient(String name, String surname, String jmbg, int birthDate, String address, String city, int phoneNumber, String occupation) {
		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.birthDate = birthDate;
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
	
	public int getBirthDate() {
		return birthDate;
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
