package stack;
/**
* 15.06.2017
 * Stack.java
 * package stack
 */
public class Stack<T> implements Stackable<T> {
	/*Datenfelder der Klasse Stack*/
	private Node head; //Anker-Knoten
	private int counter; //Kapazitaet

	/*Legt Knoten fest*/
	private class Node {
		T data; //Inhalt
		Node next; //Zeiger auf Nachfolger
	}

	@Override
	public void push(T data) {
		Node memorizedNode = head; //Zeiger auf head
		head = new Node(); //head zeigt auf den neuen Knoten
		head.data = data; //im neuen Knoten werden jetzt die Daten gespeichert
		head.next = memorizedNode; //voriges head ist jetzt Nachfolger 
		counter++;
	}

	@Override
	public T pop() throws NullPointerException {
		if (head == null) {
			throw new NullPointerException("Operation nicht ausfuehrbar. Stack ist leer!");
		}
		T retObj = head.data;
		head = head.next;
		counter--;
		return retObj;
	}

	@Override
	public T peek() throws NullPointerException {
		if (head == null) 
			throw new NullPointerException("Stack ist leer!");
		
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void clear() {
		head = null;
		counter = 0;
	}

	@Override
	public int size() {
		return counter;
	}
	
	/*Andere spezielle Methoden Aufgabe 5 (b)*/
	/**
     * Adds a value at a given index in the list
     *
     * @param value to be added in the list
     * @param index list position, where the new value has to be stored
     * @return true, if element at that given position has been successfully stored in
	 * @return false, if index is out of list bounds or if element cannot be stored
     */
    public boolean addAtIndex(T wert, int index) {
        if (index < 0 || counter < index) {
            System.out.println("Index out of range.");
            return false;
        }

        //Case: list empty
        if (index == 0) {
            push(wert);
            return true;

        } else { //all other cases
            Node temp = head;

            for (int i = 0; temp != null; i++) {
				//iteration is until the 
                if (i == index - 1) {
                    Node newNode = new Node();
                    newNode.data = wert;
                    newNode.next = temp.next;
                    temp.next = newNode;

                    counter++;
                    return true;
                }
                temp = temp.next;
            }
        }
        System.out.println("Index out of range.");
        return false;
    }
	
    
    /*Aufgabe 5 (c)*/
    /**
     * entfernt das letzte Element aus der List
     *
     * @return Wert des entfernten Elements
     * @throws NullPointerException wenn List leer
     */
    public T removeLast() throws NullPointerException {
        T elem;

        //Case 1: Empty list
        if (head == null) {
            throw new NullPointerException("List empty.");

        } else if (head.next == null) { //Case 2: list contains only an element
            elem = head.data; //saves data to be returned
            head = head.next;
            counter--;
            return elem;

        } else { //list contains other elements
            Node temp1 = head;
            Node temp2 = temp1.next;
			//iteration until temp2 reaches the last element in the list
            while (temp2.next != null) {
                temp1 = temp2;
                temp2 = temp2.next;
            }
            elem = temp2.data;
            temp1.next = null; // Alternative: temp2 = null
            counter--;
            return elem;
        }
    }

    /*Aufgabe 5 (c)*/
    /**
     * Entfernt ein Element an einem gegebenen Index index
     *
     * @param index Index im Stack, wo das Element entfernt sein soll
     * @return Wert entfernt
     * @throws NullPointerException falls Index nicht in Stack-Grenzen
     */
    public T removeAtIndex(int index) throws NullPointerException {

        //list empty
        if (head == null) {
            throw new NullPointerException("List empty.");
        }

        if (index < 0 || counter <= index) {
            throw new NullPointerException("Index out of bounds: " + index);
        }

      	//index is == 0, then remove first element
        if (index == 0) {
            return pop();

        } else if (index == counter - 1) { //if index at the end --> remove last element
            return removeLast();

        } else { //in all other cases iterate through the list
            Node temp1 = head;
			Node temp2 = temp1.next;
			int i =0;
			while(i!=index -1 && temp2 != null){
				if(index == index -1){
					T data = temp2.data;
					temp1.next = temp2.next;
					temp2 = null;
					counter--;
					System.out.println("This value has been removed: ");
					return data;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
        }
        throw new NullPointerException("Index out of bounds: " + index);
    }
	
	@Override
	public void print() {
		if(isEmpty()) System.out.println("Stack ist leer!");
		else{
			System.out.println("****************");
			System.out.println(this.getClass().getSimpleName()+ ":");
			Node temp = head;
			int size = size();
			for(int i = 0; i < size; i++){
				System.out.println((i+1)+ ". " + temp.data.getClass().getSimpleName());
				System.out.println(temp.data + "\n");
				temp = temp.next;
			}
			System.out.println("****************");
		}
		
	}

}
