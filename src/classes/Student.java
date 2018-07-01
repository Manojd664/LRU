package classes;

public class Student {
	
	private int rollNo;
	private String name;
	private String address;
	private String dateOfBirth;
	
	public Student(int rollNo,String name,String address,String dataOfBirth)
	{
		this.rollNo=rollNo;
		this.name=name;
		this.address=address;
		this.dateOfBirth=dataOfBirth;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}

}
