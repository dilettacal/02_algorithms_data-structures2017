package list.sort;

import data.Gender;

/**
 * 
 * 07.07.2017
 * GenderComparator.java
 * package list.sort
 * Class to compare gender field in student objects
 */
public class GenderComparator implements Comparator <Gender>{

	@Override
	public int compare(Gender o1, Gender o2) {
		return o1.compareTo(o2);
	}
	

}
