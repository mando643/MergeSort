
public class Student 
{
	private String firstName;
	private String lastName;
	private String birthday;
	private String major;
	private double gpa;
	
	public Student(String firstName, String lastName, String birthday, String major, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.major = major;
		this.gpa = gpa;
	}
	
	public int hashCode() {
		int total = 0;
		
		for (int i = 0; i < firstName.length(); i++) {
			total *= 7;
			total += firstName.toUpperCase().charAt(i);
		}
		
		return total;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Student)) {
			return false;
		}
		
		Student otherStudent = (Student)o;
		if (otherStudent.firstName.equalsIgnoreCase(this.firstName)) {
			return true;
		} else {
			return false;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
