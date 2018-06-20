package data;

public class Student {
	//Data field
	private String name, surname;
	private Gender gender;
	private Degree degree;
	private int number;
	
	/**
	 * Default-Konstruktor
	 */
	public Student(){
		name = surname = "";
		gender = null;
		degree = null;
		number = -1;
	}
	
	/**
	 * 
	 * @param name
	 * @param surname
	 * @param gender
	 * @param degree
	 * @param number
	 */
	public Student(String name, String surname, Gender gender, Degree degree, int number){
		this.name = name; 
		this.surname = surname;
		this.gender = gender;
		this.degree = degree;
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the degree
	 */
	public Degree getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student: " + name + ", " + surname + ", Gender: " + gender + ", Degree Program: " + degree
				+ ", Number: " + number;
	}
	
	
	
}
