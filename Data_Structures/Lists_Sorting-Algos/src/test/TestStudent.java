package test;
import static org.junit.Assert.*;

import org.junit.Test;

import data.Degree;
import data.Gender;
import data.Student;

/**
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 * 23.06.2017
 * TestStudent.java
 * package test
 */
public class TestStudent {
	Student s1 = new Student("Markus", "Mueller", Gender.MALE, Degree.BWL, 68796);
	@Test
	public void testGetter() {
		//gewuenschte Werte
		String desiredName = "Markus";
		String desiredSurname = "Mueller";
		Gender g = Gender.MALE;
		int desiderdNr = 68796;
		Degree d = Degree.BWL;
		//Student-Object for testing
		
		assertEquals(s1.getName(), desiredName);
		assertEquals(s1.getSurname(), desiredSurname);
		assertEquals(s1.getGender(), g);
		assertEquals(s1.getNumber(), desiderdNr);
		assertEquals(s1.getDegree(), d);
	}
	
	@Test
	public void testSetter(){
		String newName = "Ted";
		String newSurname = "Mosby";
		Degree newDegree = Degree.ELEKTROTECHNIK;
		Gender g = Gender.OTHER;
		int newMn = 17;
		
		s1.setName(newName);
		s1.setSurname(newSurname);
		s1.setDegree(newDegree);
		s1.setNumber(newMn);
		s1.setGender(g);
		
		assertEquals(s1.getName(), newName);
		assertEquals(s1.getSurname(), newSurname);
		assertEquals(s1.getGender(), g);
		assertEquals(s1.getNumber(), newMn);
		assertEquals(s1.getDegree(), newDegree);
		
	}
	
	@Test
	public void testAusgabe(){
		String student = s1.toString();
		String test = "Student: Markus, Mueller, Gender: Male, Degree Program: Bwl, Number: 68796";
		assertEquals(student,test);
	}
	

}
