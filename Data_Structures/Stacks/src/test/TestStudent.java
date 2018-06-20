package test;
import static org.junit.Assert.*;

import org.junit.Test;

import data.Student;

/**
 * 23.06.2017
 * TestStudent.java
 * package test
 */
public class TestStudent {
	Student s1 = new Student("Markus", "Mueller", "m", 5589, "Angewandte Informatik");
	@Test
	public void testGetter() {
		//gewuenschte Werte
		String desiredName = "Markus";
		String desiredSurname = "Mueller";
		String desiredGender = "m";
		int desiderdNr = 5589;
		String desiredCourse = "Angewandte Informatik";
		//Student-Object for testing
		
		assertEquals(s1.getPrename(), desiredName);
		assertEquals(s1.getSurname(), desiredSurname);
		assertEquals(s1.getGender(), desiredGender);
		assertEquals(s1.getMn(), desiderdNr);
		assertEquals(s1.getCourse(), desiredCourse);
	}
	
	@Test
	public void testSetter(){
		String newName = "Ted";
		String newSurname = "Mosby";
		String newCourse = "Medieninformatik";
		String newGender = "e";
		int newMn = 17;
		
		s1.setPrename(newName);
		s1.setSurname(newSurname);
		s1.setCourse(newCourse);
		s1.setMn(newMn);
		s1.setGender(newGender);
		
		assertEquals(s1.getPrename(), newName);
		assertEquals(s1.getSurname(), newSurname);
		assertEquals(s1.getGender(), newGender);
		assertEquals(s1.getMn(), newMn);
		assertEquals(s1.getCourse(), newCourse);
	}
	
	@Test
	public void testAusgabe(){
		String student = s1.toString();
		String test = "Markus, Mueller\nGeschlecht: m\nStudiengang: Angewandte Informatik"
				+ "\nMatrikelnummer: 5589";
		assertEquals(student,test);
	}
	

}
