package main;
import java.util.InputMismatchException;
import java.util.Scanner;

import data.Degree;
import data.Gender;
import data.Student;
import list.DoublyLinkedList;
import list.Listable;
import list.SinglyLinkedList;
import list.search.ElemToSearch;
import list.sort.BubbleSort;
import list.sort.Comparator;
import list.sort.DegreeComparator;
import list.sort.MatriculationNumberComparator;
import list.sort.NameComparator;
import list.sort.PrenameComparator;
import list.sort.SelectionSort;
import list.sort.Sortable;
import test.TestListen;
/**
 * 
 * @author Diletta Calussi
 * Matrikel-Nr. s0559842
 * 08.07.2017
 * Main.java
 * package main
 * User interaction class
 */
public class Main {
	static int selection; //user input
	static Listable <Student> studList; //List to be used 
	static int selected_list = -1; 
	static Scanner input = new Scanner(System.in);
	static Scanner secondary_input = new Scanner(System.in);
	static boolean isValid = false;
	static Student stud = null;
	static String choice = "";
	static Sortable<Student> sort; //sorting type
	
	/*Operation management*/
	static final int ADD_FCT = 1; //AddFirst, AddLast
	static final int REMOVE_FCT = 2; //RemoveFirst, RemoveLast
	static final int ELEM_MANAGE = 3; //Print, overwrite, removeElement, get
	static final int SEARCH_FCT = 4; //Search function --> name, prename, degree, matr
	static final int SORT_FCT = 5; //Sort functions --> BubbleSort/SelectionSort
	static final int PRINT_LIST = 6; //printALL
	static final int GET_SIZE = 7;
	static final int EXIT = 0;
	
	/*Extended selection options*/
	static final int SLL = 1; //Singly-Linked-List
	static final int DLL = 2; //DOubly-Linked-List
	
	static final int BBS = 1; //BubbleSort
	static final int SLS = 2; //SelectionSort
	
	static final int ADD_FIRST = 1;
	static final int ADD_LAST = 2;
	
	static final int REMOVE_FIRST = 1;
	static final int REMOVE_LAST = 2;
	
	static final int PRINT_ELEM =1; //Prints one element
	static final int REMOVE_ELEM = 2;
	static final int OVERWRITE = 3;
//	static final int GET_FROM_INDEX = 4;
	
	static final int BY_NAME = 1;
	static final int BY_SURNAME = 2;
	static final int BY_DEGREE = 3; //show the 4 possibilities
	static final int BY_NR = 4;
	
	//Degree course choice
	static final int INF = 1;
	static final int MI = 2;
	static final int WI = 3;
	static final int BWL = 4;
	static final int VWL = 5;
	static final int ET = 6;
	
	/**
	 * Starts the program
	 * @param args none
	 */
	public static void main(String[] args) {
		
		System.out.println("Willkommen in der Studenten-Database!");
		startList();
		
	}
	/**
	 * Starts the list database<br>
	 * The method allows the user to select the list type to use.
	 */
	private static void startList(){
		System.out.println("Which kind of database do you want to use?"
				+ "\n1-Singly Linked List\n2- Doubly Linked List");
		selected_list = input.nextInt();
		switch(selected_list){
		case 1: 
			System.out.println("Your choice is Singly Linked List"); 
			studList = new SinglyLinkedList<>();
			break;
		case 2: 
			System.out.println("Your choice is Doubly Linked List"); 
			studList = new DoublyLinkedList<>();
			break;
		default:
			if(selected_list != 1 || selected_list != 2){
				selected_list = -1;
				System.out.println("Please select the right list from the menu");
				startList();
			}
		}
		showMenu();
	}
	
	/**
	 * Shows the menu entries. The user can switch among the different program possibilities.
	 */
	private static void showMenu(){		
		System.out.println("How do you want to proceed?\n "
				+ "Please click on the number to select your option\n");
		System.out.println("1 - Add one element");
		System.out.println("2 - Remove one element");
		System.out.println("3 - Manage elements in the list");
		System.out.println("4 - Search for elments");
		System.out.println("5 - Sort elements");
		System.out.println("6 - Print the list");
		System.out.println("7 - Get the list size");
		System.out.println("0 - Exit the program");
		selection = input.nextInt();
		
		switch(selection){
		//general adding function - opens a under menu for selecting between addFirst or addLast
		case ADD_FCT:
			System.out.print("Add an element. Please create a student object.\n");
			stud = createStudent();
			int adding = 0;
			while(isValid == false){
				try{
					adding = addFct();
					isValid = true;
					break;
				} catch (InputMismatchException e){
					System.out.println(e.getMessage());
					isValid = false;
				}
			}
			
			if(isValid){
				switch(adding){
				case ADD_FIRST: studList.AddFirst(stud);
				showMenu();
				break;
				case ADD_LAST: studList.AddLast(stud); 
				showMenu();
				break;
				}
			}
			
			break;
			//Remove function - opens an undermenu for selecting removeFirst or removeLast methods
		case REMOVE_FCT:
			System.out.print("Remove an element. Please press 1 - Remove at ");
			selection = input.nextInt();
			while (selection != 1 || selection != 2){
				System.out.println("Number format invalid. Please try again");
				selection = input.nextInt();
			}
			switch(selection){
			case REMOVE_FIRST: 
				studList.removeFirst(); 
				break;
			case REMOVE_LAST: 
				studList.removeLast(); 
				break;
			default: showMenu();
			}
			//function to manage the elements (get,set,print ...)
		case ELEM_MANAGE:
			int manager = elemManager();
			int size = studList.getSize();
			switch(manager){
			
			case PRINT_ELEM:			
				System.out.println("Please select one index. This should be in range 0 - " + size);
				selection = secondary_input.nextInt();
				while(selection < 0 || selection > size){
					System.out.println("Index out of bounds!");
					System.out.println("Try again!");
					selection = secondary_input.nextInt();				
				}
				Student s = studList.get(selection);
				studList.printElem(s);
				showMenu();
				break;
			case REMOVE_ELEM:
				System.out.println("Please select one index. This should be in range 0 - " + size);
				selection = secondary_input.nextInt();
				while(selection < 0 || selection > size){
					System.out.println("Index out of bounds!");
					System.out.println("Try again!");
					selection = secondary_input.nextInt();				
				}
				Student s1 = studList.get(selection);
				studList.remove(s1);
				showMenu();
				break;
			case OVERWRITE:
				System.out.println("Please create a new student");
				Student s2 = createStudent();
				System.out.println("Please select one index. This should be in range 0 - " + size);
				selection = secondary_input.nextInt();
				while(selection < 0 || selection > size){
					System.out.println("Index out of bounds!");
					System.out.println("Try again!");
					selection = secondary_input.nextInt();				
				}
				studList.set(selection, s2);
				showMenu();
				break;
			}
			//Search selection - open an undermenu to select the field by which search is realised
		case SEARCH_FCT:
			System.out.println("Search for an element. How do you want to search the elment?");
			System.out.println("Please select: "
					+ "\n 1 - By prename "
					+ "\n 2 - By surname"
					+ "\n 3 - By Degree "
					+ "\n 4 - By Matriculation number\n");
			selection = input.nextInt();
			while(selection < 1 || selection > 4){
				System.out.println("Input not valid. Try again: \n");
				selection = input.nextInt();
			}
			Student search = new Student();
			switch(selection){
			case BY_NAME: 
				ElemToSearch n = ElemToSearch.NAME;
				System.out.println("Please insert the prename you are looking for: \n");
				choice = secondary_input.next();
				search.setName(choice);
				int index = studList.linSearch(studList, search, n);
				if(index != -1){
					System.out.println("Student found at index " +index);
				} else {
					System.out.println("Student not in the list!");
				}
				showMenu();
				break;
				
			case BY_SURNAME:
				ElemToSearch s = ElemToSearch.SURNAME;
				System.out.println("Please insert the surname you are looking for: \n");
				choice = secondary_input.next();
				search.setSurname(choice);
				int index1 = studList.linSearch(studList, search, s);
				if(index1 != -1){
					System.out.println("Student found at index " +index1);
				} else {
					System.out.println("Student not in the list!");
				}
				showMenu();
				break;
			case BY_DEGREE:
				ElemToSearch d = ElemToSearch.DEGREE;
				System.out.println("Please insert degree program. Press: \n 1 - Informatik"
						+ "\n 2 - Medieninformatik \n 3 - Wirtschaftsinformatik \n 4 - BWL \n 5 - VWL \n 6 - Elektrotechnik\n");
				int dg = secondary_input.nextInt();
				Degree deg = integerToDegree(dg);
				search.setDegree(deg);
				int index4 = studList.linSearch(studList, search, d);
				if(index4 != -1){
					System.out.println("Student found at index " +index4);
				} else {
					System.out.println("Student not in the list!");
				}
				showMenu();
				break;
			case BY_NR:
				ElemToSearch nr = ElemToSearch.NUMBER;
				System.out.println("Please insert the matriculation number you are looking for: \n");
				int num = secondary_input.nextInt();
				search.setNumber(num);
				int index2 = studList.linSearch(studList, search, nr);
				if(index2 != -1){
					System.out.println("Student found at index " +index2);
				} else {
					System.out.println("Student not in the list!");
				}
				showMenu();
				break;
			}
			//sort function
		case SORT_FCT:
			int sortFunc = 0;
			System.out.println("Please choose between 1 - BubbleSort or 2 - SelectionSort");
			int s = input.nextInt();
			if(s!= 1 && s!=2){
				System.out.println("Input not valid. Try again\n");
				s = input.nextInt();
			}
			switch(s){
			case BBS:
				sort = new BubbleSort<>();
				sortFunc = BBS;
				break;
			case SLS:
				sort = new SelectionSort<>();
				sortFunc = SLS;
				break;
			}
			System.out.println("How do you want to sort elements? \n");
			System.out.println("1 - By name");
			System.out.println("2 - By surname");
			System.out.println("3 - By Degree");
			System.out.println("4 - By MatrNumber");
			s = input.nextInt();
			String sel = String.valueOf(s);
			while(!sel.matches("[1-4]")){
				System.out.println("Input invalid. Try again\n");
				s = input.nextInt();
				sel = String.valueOf(s);
			}
			switch(s){
			case BY_NAME:
				Comparator<Student> name = new PrenameComparator();
				if(sortFunc == 1) studList.sortBubble(name);
				else studList.sortSelection(name);
				studList.printAll();
				break;
			case BY_SURNAME:
				Comparator<Student> surname = new NameComparator();
				if(sortFunc == 1) studList.sortBubble(surname);
				else studList.sortSelection(surname);
				studList.printAll();
				break;
				
			case BY_DEGREE:
				Comparator<Student> deg = new DegreeComparator();
				if(sortFunc == BBS) studList.sortBubble(deg);
				else studList.sortSelection(deg);
				studList.printAll();
				break;
			case BY_NR:
				Comparator<Student> num = new MatriculationNumberComparator();
				if(sortFunc == BBS) studList.sortBubble(num);
				else studList.sortSelection(num);
				studList.printAll();
				break;
			default: showMenu();
			}
			//printAll
		case PRINT_LIST: 
			System.out.print("Print the list content\n");
			studList.printAll();
			showMenu();
			break;
			//getSize()
		case GET_SIZE: 
			System.out.println(studList.getSize()); 
			showMenu();
		break;
		//leave the program
		case EXIT: 
			System.out.println("You are exiting the program!");
			System.out.println("******************************1"
					+ "");
			System.out.println("Standard tests: ");
			TestListen.executeList();
			System.exit(1); //leave the program completely
			break;	
		}
		
	}
	
	/**
	 * Menu to manage elements in the list
	 * @return selected entry
	 * @throws InputMismatchException if input does not match input criteria (integer in range)
	 */
	private static int elemManager() throws InputMismatchException {
		System.out.print(" List element management. Possible options: \n");
		System.out.println("1 - Print one element of the list");
		System.out.println("2 - Remove one particular element");
		System.out.println("3 - Overwrite existing element");
		selection = secondary_input.nextInt();
		String sel = String.valueOf(selection);
		while (!sel.matches("[1-3]")){
			System.out.println("Input not valid. Try again!");
			selection = secondary_input.nextInt();
			sel = String.valueOf(selection);
		}
		return selection;
	}
	/**
	 * Creates a student object
	 * @return the created student
	 * @throws InputMismatchException if field inputs do not fit the criteria
	 */
	private static Student createStudent() throws InputMismatchException{
		String prename, surname;
		int nummer = 0, g, d;
		Gender gender = null;
		Degree degree = null;
		
		System.out.print("Please insert prename: \n");
		prename = input.next();
		while(!onlyLetter(prename)) {
			System.out.println("String format not valid. Try again.");
			prename = input.next();
		}
		
		System.out.print("Please insert surname: \n");
		surname = input.next();
		while (!onlyLetter(surname)) {
			System.out.println("String format not valid. Try again.");
			surname = input.next();
		}
		
		System.out.println("Please insert matriculation number: \n");
		String val = input.next();
		while (!val.matches("[1-9]+")) {
			System.out.println("Only integers admitted. Try again: \n");
			val = input.next();
		}
		
		nummer = Integer.parseInt(val);
		System.out.println("Please insert gender. Press 1 - Male, 2- Female, 3 - Other");
		g = input.nextInt();
		while (isValid == false) {
			try {
				gender = integerToGender(g);
				isValid = true;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				g = input.nextInt();
			}
			
		}
		isValid = false;
		
		
		System.out.println("Please insert degree program. Press: \n 1 - Informatik"
				+ "\n 2 - Medieninformatik \n 3 - Wirtschaftsinformatik \n 4 - BWL \n 5 - VWL \n 6 - Elektrotechnik");
		d = input.nextInt();
		while (isValid == false) {
			try {
				degree = integerToDegree(d);
				isValid = true;
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				g = input.nextInt();
			}
			
		}
		isValid = false;
		
		Student s = new Student(prename,surname,gender,degree,nummer);
		return s;

	}
		
	/**
	 * Checks if a string only contains letters (prename, surname)
	 * @param s the string to be checked
	 * @return true if string literal
	 */
	private static boolean onlyLetter (String s){
		return s.matches("[a-zA-Z]+");
	}
	
	/**
	 * Converts a selected integer to the corresponding Degree 
	 * @param d the integer to be converted
	 * @return the degree
	 * @throws InputMismatchException if integer not in right range
	 */
	private static Degree integerToDegree(int d) throws InputMismatchException {
		switch(d){
		case INF: return Degree.INFORMATIK;
		case MI: return Degree.MEDIENINFORMATIK;
		case WI: return Degree.WIRTSCHAFTSINFORMATIK;
		case BWL: return Degree.BWL;
		case VWL: return Degree.VWL;
		case ET: return Degree.ELEKTROTECHNIK;
		default:
			throw new InputMismatchException("Please insert the correct number");
		}
	}
	
	/**
	 * Menu for selecting the add method
	 * @return input as an integer
	 * @throws InputMismatchException if integer not in range
	 */
	private static int addFct() throws InputMismatchException{
		System.out.println("Please select"
				+ "\n1 - Add at the begin of the list "
				+ "\n2 - Add at the end of the list");
		int choice = secondary_input.nextInt();
		if(choice != 1 && choice != 2) throw new InputMismatchException("Number not valid. Try again");
		return choice;		
	}
	
	/**
	 * Converts an input integer to a gender
	 * @param g the integer to be converted
	 * @return the corresponding gender
	 * @throws InputMismatchException if integer not in right range
	 */
	private static Gender integerToGender(int g) throws InputMismatchException{
		switch(g){
		case 1: return Gender.MALE;
		case 2: return Gender.FEMALE; 
		case 3: return Gender.OTHER; 
		default:
			throw new InputMismatchException("Number invalid. Plaese only press the above listed numbers");
		
	}
}
}
