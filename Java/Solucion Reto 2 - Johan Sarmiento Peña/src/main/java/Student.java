public class Student
{
	// Variables clase estudiante

	String names, lastNames, birthDate, institutionalEmail, personalEmail, academicProgram;

	long cellphoneNumber, phoneNumber;

	// Constructor

	public Student()
	{}

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
