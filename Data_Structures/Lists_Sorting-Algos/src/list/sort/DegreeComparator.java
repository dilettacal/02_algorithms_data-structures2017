package list.sort;

import data.Student;
/**
 * 08.07.2017
 * DegreeComparator.java
 * package list.sort
 * Class to compare Degree field in Student object
 */
public class DegreeComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		String d1 = o1.getDegree().toString();
		String d2 = o2.getDegree().toString();
		return d1.compareTo(d2);
	}

}
