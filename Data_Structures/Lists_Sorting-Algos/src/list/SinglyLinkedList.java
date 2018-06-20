package list;

import list.search.ElemToSearch;
import list.search.LinearSearch;
import list.search.Searchable;
import list.sort.*;
/**
 * @param <T>
 * 08.07.2017
 * SinglyLinkedList.java
 * package list
 * Classe to manage singly linked list objects
 */
public class SinglyLinkedList<T> implements Listable<T> {
	//Field
	private Node head;
	
	/**
	 * 
	 * @author Diletta Calussi
	 * Matrikel-Nr. s0559842
	 * 08.07.2017
	 * SinglyLinkedList.java
	 * package list
	 * Class node to store element in the list
	 */
	class Node {
		T data;
		Node next;
		/**
		 * COnstructor
		 */
		Node(){
			data = null;
			next = null;
		}
		/**
		 * Creates a node with a value data
		 * @param data the node value
		 */
		Node(T data){
			this.data = data;
			next = null;
		}
	}
	
	/**
	 * Default constructor
	 */
	public SinglyLinkedList(){
		head = null;
	}	
	

	@Override
	public void AddFirst(T data) {
		Node toAdd = new Node(data);
		//toAdd.data = data;
		if(head!=null){
			toAdd.next = head;
			head = toAdd;
		}
		else {
			head = toAdd;
			toAdd.next = null;
		}
		
	}

	@Override
	public void AddLast(T data) {
		Node toAdd = new Node(data);
		
		if(head == null) head = toAdd;
		else {
			Node start = head;
			while(start.next != null){
				start = start.next;
			}
			start.next = toAdd;
		}
		
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void printElem(T data) {
		if(isEmpty())System.out.println("List is empty!");

		Node temp = head;
		while(temp != null){
			if(temp.data == data){
				System.out.println("Element found: " + temp.data);
				break;
			}
			temp = temp.next;
			if(temp == null){
				System.out.println("Element not in list!");
			}
		}		
		
	}

	@Override
	public void printAll() {
		Node start = head;
		if(!isEmpty()){
			System.out.println("********************************");
			System.out.println("List content: ");
			while(start!= null){
				System.out.println(start.data);
				start = start.next;
			}
			System.out.println("********************************");
		} else {
			System.out.println("[ Empty list ]");
		}
	}

	@Override
	public int getSize() {
		if(isEmpty()) return 0;
		int counter = 0;		
		Node start = head;
		while(start!= null){			
			start = start.next;
			counter++;
		} 
		return counter;
	}

	@Override
	public void remove(T data)throws NullPointerException {
		Node toRemove = new Node();
		toRemove.data = data;
		if(!isEmpty()){
			Node temp1 = head;
			Node temp2 = temp1.next;
			while(temp2 != null){
				if(temp2.data == toRemove.data){
					temp1.next = temp2.next;
					System.out.print("Element removed: " + toRemove.data);
					break;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			if(temp2 == null) throw new NullPointerException("Element not in the list");
		}
		else{
			throw new NullPointerException("List is empty!");
		}
			
		
 	}

	@Override
	public void eraseList() {
		if(head == null) System.out.println("List already empty!");
		else {
			head = null;
			System.out.println("List completely erased!");
		}
	}

	
	@Override
	public T get(int index) {
		Node start = head;
		int i = 0;
		if(index < 0 || index > this.getSize()) 
			throw new NullPointerException("Index out of list bounds");
		if(!isEmpty()){
			while(i!=index){
				start = start.next;
				i++;
			}
			return start.data;
		} 
		throw new NullPointerException("List is empty!");
	}

	@Override
	public void set(int i, T t)throws NullPointerException {
		if(i < 0 || i > this.getSize()) throw new NullPointerException("List is empty!");
		Node temp = head;
		if(!isEmpty()){
			for (int e = 0; e < i; e++){
				temp = temp.next;
			}
			temp.data = t;
		}
		else throw new NullPointerException("List is empty!");
	}

	@Override

	public void add(T data) {

		Node node = new Node();
		node.data = data;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}


	@Override
	public Listable<T> sortBubble(Comparator<T> comparator) {
		Listable<T> list = this;
		Sortable<T> sorting = new BubbleSort<T>();
		sorting.sort(list, comparator);
		return list;
	}


	@Override
	public Listable<T> sortSelection(Comparator<T> comparator) {
		Listable<T> list = this;
		Sortable<T> sorting = new SelectionSort<T>();
		sorting.sort(list, comparator);
		return list;
	}


	@Override
	public void removeFirst() throws NullPointerException {
		if(!isEmpty()){
			head = head.next;
		} else throw new NullPointerException("List is empty!");
		
	}


	@Override
	public void removeLast() throws NullPointerException {
		if(!isEmpty()){
			Node temp = head;
			Node temp1 = temp.next;
			while(temp1.next != null){
				temp = temp.next;
				temp1 = temp1.next;
			}
			temp.next = null;
		} else throw new NullPointerException("List is empty");
		
	}


	@Override
	public T getFirst() throws NullPointerException {
		if(!isEmpty())	return head.data;
		else throw new NullPointerException("List is empty!");
	}


	@Override
	public T getLast() throws NullPointerException {
		if(!isEmpty()){
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			return temp.data;
		} else throw new NullPointerException("List is empty!");
	}


	@Override
	public int linSearch(Listable <T> list, T s, ElemToSearch el) {
		Searchable<T>  search = new LinearSearch<T> ();
		int index = search.linearSearch(list, s, el);
		return index;
	}

	

}
