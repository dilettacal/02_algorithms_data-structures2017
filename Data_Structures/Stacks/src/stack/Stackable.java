package stack;
/**
 * Interface for stacks
	* 15.06.2017
 * Stackable.java
 * package stack
 */
public interface Stackable<T> {
	
	/**
     * Puts an element on top of the stack
     *
     * @param data The element
     */
	void push(T data);
	
	/**
     * Returns the top element of the list with removing it
     *
     * @return The top element
     */
	T pop();

	/**
     * Returns the top element of the stack without removing it
     *
     * @return The top element
     */
	T peek();
	
	/**
     * Checks if the list is empty
     *
     * @return true = list is empty, false = list is not empty
     */
	boolean isEmpty();
	
	/**
     * Empties the stack
     */
	void clear();
	
	/**
     * Returns the size of the stack
     *
     * @return The size of the stack
     */
	int size();
	
	 /**
     * Prints the complete stack to the console
     */
	void print();
}
