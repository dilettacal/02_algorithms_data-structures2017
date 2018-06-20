package list;

import list.search.ElemToSearch;
import list.sort.Comparator;


/**
 * @param <T>
 * 07.07.2017
 * Listable.java
 * package list
 * 
 * Interface for Listable Objects
 */
public interface Listable<T>  {
	
	static final int NAME = 0;
	static final int SURNAME = 1;
	static final int NUMBER = 2;
	static final int DEGREE = 3;
	/**
	 * Adds an element at the beginning of the list
	 * @param data the element to be added in
	 */
	void AddFirst(T data);
	
	/**
	 * Adds an element at the end of the list
	 * @param data the element to be added
	 */
	void AddLast (T data);
	/**
	 * Removes first element in the list
	 * @throws NullPointerException if list is empty
	 */
	void removeFirst() throws NullPointerException;
	/**
	 * Removes last element in the list
	 * @throws NullPointerException if list is empty
	 */
	void removeLast() throws NullPointerException;
	
	/**
	 * Returns first element in the list
	 * @return first element
	 * @throws NullPointerException if list is empty
	 */
	T getFirst() throws NullPointerException;
	
	/**
	 * Returns last element in the list
	 * @return last element
	 * @throws NullPointerException if list is emtpy
	 */
	T getLast() throws NullPointerException;
	
	/**
	 * Checks if list is empty
	 * @return true if list is empty
	 */
	boolean isEmpty();
	
	/**
	 * Prints a certain node value in the list
	 * @param data to printed out
	 */
	void printElem(T data);
	
	/**
	 * Prints all the list
	 */
	void printAll();
	
	/**
	 * Returns list capacity
	 * @return number of element in the list
	 */
	int getSize();
	
	/**
	 * Removes a certain value from the list.<br>
	 * Prints an error message, if element is not to be found.
	 * @param data the element to be removed 
	 * @throws NullPointerException if list is empty
	 */
	void remove(T data) throws NullPointerException;
	
	/**
	 * Erases the list and all its content
	 */
	void eraseList();
	
	
	/**
	 * Sorts list using Bubble Sort algorithm
	 * @param comparator comparison types
	 * @return sorted list
	 */
	Listable<T> sortBubble(Comparator<T> comparator);
	
	/**
	 * Sorts the list using Selection Sort algorithm
	 * @param comparator comparison types
	 * @return sorted list
	 */
	Listable<T> sortSelection(Comparator<T> comparator);
	
	/**
	 * Returns element stored at a valid index of the list
	 * @param index to be searched
	 * @return element stored at index
	 * @throws NullPointerException if list is empty or if element is not to be found
	 */
	T get(int index) throws NullPointerException;
	/**
	 * Overwrite function. Changes value of a certain node in the list.
	 * @param i index to be searched
	 * @param t value which overwrites old data
	 * @throws NullPointerException if list is empty or if index out of list bounds
	 */
	void set(int i, T t)throws NullPointerException;
	
	/**
	 * Adds an element at the first free place
	 * @param data to be added
	 */
	void add(T data);
	
	/**
	 * Searches a list based on a particular object field
	 * @param list to be searched out
	 * @param s the object
	 * @param el the reference to the field of that object
	 * @return index (>0) or -1 if element not in the list
	 */
	int linSearch(Listable <T> list, T s, ElemToSearch el);
	
	
}
