package list.sort;

import list.*;
/**
 * 
 * @param <T>
 * 08.07.2017
 * SelectionSort.java
 * package list.sort
 * Class implements sorting function based on selection sort algorithm.<br>
 * Works on all Comparator objects.
 */
public class SelectionSort<T> implements Sortable<T> {

	@Override
	public void sort(Listable<T> list, Comparator<T> comp) {
		int minimum;
		for (int i = 0; i < list.getSize(); ++i) {
			minimum = i;
			for (int e = i + 1; e < list.getSize(); ++e) {
				if (comp.compare(list.get(e), list.get(minimum)) < 0) {
					minimum = e;
				}
			}
			swap(list, i, minimum);
		}
		list.printAll();
	}
	
	private void swap(Listable<T> list, int i, int j) {
		T memorizedObject = list.get(i);
		list.set(i, list.get(j));
		list.set(j, memorizedObject);
	}



}
