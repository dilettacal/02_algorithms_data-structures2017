package list.search;

import data.Degree;
import data.Student;
import list.Listable;

/**
 * 
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 * @param <T>
 * 08.07.2017
 * LinearSearch.java
 * package list.search
 * 
 * Class to sequentially search for Element in the lists of this project
 */
public class LinearSearch<T> implements Searchable<T>{

	@Override
	public int linearSearch(Listable<T> list, T s, ElemToSearch el) {
		int length = list.getSize();
		int index = -1;
		for (int i = 0; i < length; i++){			
			if(s instanceof Student){
				Student temp = (Student)list.get(i);
				Student temp2 = (Student) s;
				String s1; Degree d1; int i1;
				String s2; Degree d2; int i2;
				switch(el){
				case NAME:
					 s1 = temp.getName();
					 s2 = temp2.getName();
					 if(s1.equalsIgnoreCase(s2))
						 index = i;
						 break;
				case SURNAME:
					s1 = temp.getSurname();
					s2 = temp2.getSurname();
					if(s1.equalsIgnoreCase(s2)) 
						index = i;
					break;
				case DEGREE:
					d1 = temp.getDegree();
					d2 = temp2.getDegree();
					if(d1.equals(d2)) index = i;
					break;
				case NUMBER:
					i1 = temp.getNumber();
					i2 = temp2.getNumber();
					if(i1 == i2) index = i;
					break;
				default: 
					throw new IllegalArgumentException("Input does not match with the possibile search criteria!");
				}
			}
		}
		return index;
	}


	
	
}
