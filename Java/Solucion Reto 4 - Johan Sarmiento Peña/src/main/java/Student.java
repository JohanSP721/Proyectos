import java.io.Serializable;

public class Student implements Serializable
{
	// Variables clase estudiante

	private String names;
	private String lastNames;
	private String birthDate;
	private String institutionalEmail;
	private String personalEmail;
	private String academicProgram;


	private long cellphoneNumber;
	private long phoneNumber;

	// Constructor

	public Student()
	{}

	public Student(String names, String lastNames, String birthDate, String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber)
	{
		this.names = names;
		this.lastNames = lastNames;
		this.birthDate = birthDate;
		this.institutionalEmail = institutionalEmail;
		this.personalEmail = personalEmail;
		this.academicProgram = academicProgram;
		this.cellphoneNumber = cellphoneNumber;
		this.phoneNumber = phoneNumber;
	}

	// Getters

	public String getNames()
	{
		return names;
	}

	public String getLastNames()
	{
		return lastNames;
	}

	public String getBirthDate()
	{
		return birthDate;
	}

	public String getInstitutionalEmail()
	{
		return institutionalEmail;
	}

	public String getPersonalEmail()
	{
		return personalEmail;
	}

	public String getAcademicProgram()
	{
		return academicProgram;
	}

	public long getCellphoneNumber()
	{
		return cellphoneNumber;
	}

	public long getPhoneNumber()
	{
		return phoneNumber;
	}

	// Setters

	public void setNames(String names)
	{
		this.names = names;
	}

	public void setLastNames(String lastNames)
	{
		this.lastNames = lastNames;
	}

	public void setBirthDate(String birthDate)
	{
		this.birthDate = birthDate;
	}

	public void setInstitutionalEmail(String institutionalEmail)
	{
		this.institutionalEmail = institutionalEmail;
	}

	public void setPersonalEmail(String personalEmail)
	{
		this.personalEmail = personalEmail;
	}

	public void setAcademicProgram(String academicProgram)
	{
		this.academicProgram = academicProgram;
	}

	public void setCellphoneNumber(long cellphoneNumber)
	{
		this.cellphoneNumber = cellphoneNumber;
	}

	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
