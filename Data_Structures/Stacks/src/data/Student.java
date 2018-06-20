package data;
/**
 * 
 * 15.06.2017
 * Student.java
 * package data
 */
public class Student {
	/* Fields */
	private String prename;
	private String surname;
	private String gender;
	private String course;	
	private int mn;
	
	public Student(){
	}
	public Student(String prename, String surname,String g, int mn, String c) {
		this.prename = prename;
		this.surname = surname;
		this.course = c;
		this.gender = g;
		this.mn = mn;
	}
	/**
	 * Liefert Vornamen als String
	 * @return String-Darstellung des Vornamen
	 */
	public String getPrename() {
		return prename;
	}
	
	/**
	 * @param prename der Vorname, der einzusetzen ist
	 */
	public void setPrename(String prename) {
		this.prename = prename;
	}
	/**
	 * @return String-Darstellung des Nachnamen
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname der Nachname, der einzusetzen ist
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * Liefert Studiengang
	 * @return String-Darstellung des Studiengangs
	 */
	public String getCourse() {
		return course;
	}
	
	/**
	 * Setzt Studiengang ein
	 * @param course der Studiengang, der einzusetzen ist
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * 
	 * @return Geschlecht als String
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * Setzt Geschlecht ein
	 * @param gender das Geschlecht, das einzusetzen ist
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 
	 * @return die Matrikelnummer
	 */
	public int getMn() {
		return mn;
	}
	/**
	 * 
	 * @param mn die Matrikelnummer, die einzusetzen ist
	 */
	public void setMn(int mn) {
		this.mn = mn;
	}
	@Override
	public String toString() {
		return  prename + ", " + surname + "\nGeschlecht: " + gender
				+ "\nStudiengang: " + course + "\nMatrikelnummer: " + mn;
	}
	 
	
}


