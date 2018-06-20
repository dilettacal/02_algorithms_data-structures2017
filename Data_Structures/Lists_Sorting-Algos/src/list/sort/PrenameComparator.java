package list.sort;

import data.Student;
/**
 * 08.07.2017
 * PrenameComparator.java
 * package list.sort
 * Class to compare prename field in student objects
 */
public class PrenameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getName() == null && o2.getName() == null) {
			return 0;
		} else if (o1.getName() == null) {
			return 1;
		} else if (o2.getName() == null) {
			return -1;
		}
		return o1.getName().compareTo(o2.getName());
	}

}
