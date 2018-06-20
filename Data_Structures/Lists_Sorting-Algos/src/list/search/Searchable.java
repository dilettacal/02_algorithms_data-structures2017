package list.search;

import list.Listable;
/**
 * 
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 * @param <T>
 * 08.07.2017
 * Searchable.java
 * package list.search
 * Interface for sequential search in the lists of this project.
 */
public interface Searchable<T> {
	/**
	 * Searches sequentially for the field based on el of the object Student s
	 * @param list where the search takes place
	 * @param s Student, whose field el is searched for
	 * @param el sets the field to be searched in the list
	 * @return index ( >= 0), if element in the list or -1, if not.
	 */
	int linearSearch(Listable <T> list, T s, ElemToSearch el);
	

}
