package list.sort;

import data.Student;
/**
 * 08.07.2017
 * NameComparator.java
 * package list.sort
 * Class to compare name field in student objects
 */
public class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getSurname() == null && o2.getSurname() == null) {
			return 0;
		} else if (o1.getSurname() == null) {
			return 1;
		} else if (o2.getSurname() == null) {
			return -1;
		}
		return o1.getSurname().compareTo(o2.getSurname());
	}

	

}
