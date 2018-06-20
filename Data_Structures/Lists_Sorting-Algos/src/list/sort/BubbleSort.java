package list.sort;

import list.Listable;
/**
 * @param <T>
 * 08.07.2017
 * BubbleSort.java
 * package list.sort
 * Class implements Bubble Sort searching algorithm
 */
public class BubbleSort<T> implements Sortable<T>{

	@Override
	public void sort(Listable<T> list, Comparator<T> compare) {
		int size = list.getSize();
		for (int i = 1;  i < size; ++i) {
			for (int e = 0; e < size -i; ++e) {
				T g1 = list.get(e);
				T g2 = list.get(e+1);
				int c = compare.compare(g1, g2);
				if (c > 0) {
					swap(list, e, e+1);
				}
			}
		}
		list.printAll();
	}
	
	/*swapping method */
	private void swap(Listable<T> list, int i, int j) {
		T memorizedObject = list.get(i);
		list.set(i, list.get(j));
		list.set(j, memorizedObject);
	}
}
