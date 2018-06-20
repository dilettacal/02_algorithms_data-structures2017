package list.sort;

import list.Listable;
/**
 * @param <T>
 * 08.07.2017
 * Sortable.java
 * package list.sort
 * Interface for using sorting functions for Listable objects
 */
public interface Sortable<T> {
	static final int BUBBLE_SORT = 0;
	static final int SELECTSORT = 1;
	void sort(Listable<T> list, Comparator<T> compare);
}
