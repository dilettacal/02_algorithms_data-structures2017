package list;

import list.search.ElemToSearch;
import list.sort.Comparator;
/**
 * 
 * @param <T>
 * 08.07.2017
 * DoublyLinkedList.java
 * package list
 * 
 * Creation, use and management of doubly linked list objects
 */
public class DoublyLinkedList<T> implements Listable<T> {

	private Node head;
	private Node tail;
	private int counter = 0;

	/**
	 * 
	 * @author Diletta Calussi
	 * Matrikel-Nr. s0559842
	 * 08.07.2017
	 * DoublyLinkedList.java
	 * package list
	 * class Node
	 * For creation and use of list node elements
	 */
	class Node {
		T data;
		Node prev;
		Node next;
		/**Default constructor*/
		Node(){
			data = null;
			prev = next = null;
		}
		/**
		 * Parameter constructor<br>
		 * Crates a Node by data
		 * @param data Data to be stored in the node
		 */
		Node(T data){
			this.data = data;
			prev = next = null;
		}
		
		/**
		 * Parameter constructor<br>
		 * Allows creation of node by data and links to predecessor and successor
		 * @param data to be stored in
		 * @param prev link to predecessor
		 * @param next link to successor
		 */
		Node(T data, Node prev, Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		/**
		 * Setter for predecessor
		 * @param p node reference to predecessor
		 */
		void setPrevious(Node p){
			prev = p;
		}
		/**
		 * Getter for predecessor
		 * @return predecessor 
		 */
		Node getPrevious(){
			return prev;
		}
		/**
		 * Setter for successor
		 * @param p successor
		 */
		void setNext(Node p){
			next = p;
		}
		/**
		 * Getter for successor
		 * @return successor
		 */
		Node getNext(){
			return next;
		}
	}
	/**
	 * Default constructor sets head and tail to null<br>
	 * At the very beginning head and tail are connected to each other.
	 */
	public DoublyLinkedList(){
		head = null;
		tail = null;
		//Begin and End of the list are connected
//		head.next = tail;
//		tail.prev = head;
//		tail.next = tail;
	}

	@Override
	public void AddFirst(T data) {
		Node n = new Node(data);
		if(!isEmpty()){
			head.prev = n;
			n.next = head;
			head = n;
		}
		else {
			head = n;
			tail = n;
		}
		counter++;
	}


	@Override
	public void AddLast(T data) {
		Node p = new Node(data);
		if(!isEmpty()){
			p.prev = tail;
			tail.next = p;
			tail = p;
			counter++;
		}
		else {
			AddFirst(data);
		}
		
	}


	@Override
	public boolean isEmpty() {
		return (head == null);
	}


	@Override
	public void printElem(T data) {
		System.out.println("PrintElem function not implemented for this object!");
	}


	@Override
	public void printAll() {
		Node temp = head;
		if(!isEmpty()){
			System.out.println("************************");
			while(temp!=null){
				System.out.println(temp.data);
				temp = temp.next;
			}
			System.out.println("*************************");
		}
		
		
	}


	@Override
	public int getSize() {
		return (isEmpty()) ? 0 : counter;
	}




	@Override
	public void eraseList() {
		head = tail = null;
	}



	@Override
	public T get(int index) throws NullPointerException {
		int i;;
		if (index < 0 || index > getSize()) throw new NullPointerException("Index out of bounds!");
		else {
			int mitte = getSize()/2;
			if (index >= mitte){
				Node temp = tail;
				i = getSize();
				while(i != index){
					temp = temp.prev;
					i--;
				}
				return temp.data;
			} else {
				Node temp = head;
				i = 0;
				while(i != index){
					temp = temp.next;
					i++;
				}
				return temp.data;
			}
		}
		
	}


	@Override
	public void set(int i, T t) throws NullPointerException {
		int c;
		if(i < 0 || i > getSize()) throw new NullPointerException("Index out of bounds!");
		else{
			int mitte = getSize()/2;
			if(i >= mitte){
				Node temp = tail;
				c = getSize();
				while(c != i){
					temp = temp.prev;
					c--;
				}
				temp.data = t;
			} else{
				Node temp = head;
				c = 0;
				while(c!=i){
					temp = temp.next;
					c++;
				}
				temp.data = t;
			}
		}
		
	}


	@Override
	public void add(T data) {
		if(!isEmpty()){ //if list not empty hang it at the end
			AddLast(data);
		} else {
			AddFirst(data); //if list is empty hang it at the very begin
		}
	}

	@Override
	public void removeFirst() throws NullPointerException {
		if(!isEmpty()){
			//list contains more than one element
			if(head.next != tail || tail.prev != head){
				head = head.next;
			}
			//one element list
			else{
				head = tail = null; //list erased
			} 
		}
		else throw new NullPointerException("List is empty!");
		
	}

	@Override
	public void removeLast() throws NullPointerException {
		if(!isEmpty()){
			if(head.next != tail || tail.prev != head){
				Node n = tail.prev;
				tail = n;
				tail.next = null;
			} else {
				tail = head = null;
			}
		} else throw new NullPointerException("List is empty!");
	}

	@Override
	public T getFirst() throws NullPointerException {
		if(!isEmpty()) return head.data;
		else throw new NullPointerException("List is empty!");
	}

	@Override
	public T getLast() throws NullPointerException {
		if(!isEmpty()) return tail.data;
		else throw new NullPointerException("List is empty");
	}
	
	
	/*
	 * Not implemented functions
	 */

	@Override
	public void remove(T data) throws NullPointerException {
		System.out.println("Function not implemented for this object!");
		
	}


	@Override
	public Listable<T> sortBubble(Comparator<T> comparator) {
		System.out.println("Function not implemented!");
		return null;
	}


	@Override
	public Listable<T> sortSelection(Comparator<T> comparator) {
		System.out.println("Function not implemented!");
		return null;
	}

	@Override
	public int linSearch(Listable<T> list, T s, ElemToSearch el) {
		System.out.println("Function not implemented!");
		return -1;
	}
}
