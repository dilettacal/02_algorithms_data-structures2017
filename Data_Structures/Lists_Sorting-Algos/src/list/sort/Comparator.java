package list.sort;
/**
 * @param <T>
 * 08.07.2017
 * Comparator.java
 * package list.sort
 * Interface allows comparison among object of generical type
 */
public interface Comparator<T> {
	/**
	 * Returns comparison value
	 * @param o1 first object to be compared
	 * @param o2 secondo object to be compared
	 * @return comparison value
	 */
	int compare(T o1, T o2);
}
