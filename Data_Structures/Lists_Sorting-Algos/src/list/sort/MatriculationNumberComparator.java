package list.sort;

import data.Student;
/**
 * 
 * 08.07.2017
 * MatriculationNumberComparator.java
 * package list.sort
 * Class to compare number field in student objects
 */
public class MatriculationNumberComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getNumber() - o2.getNumber();
	}

}
