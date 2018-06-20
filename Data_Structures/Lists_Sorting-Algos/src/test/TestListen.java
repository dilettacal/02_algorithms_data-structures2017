package test;

import data.Degree;
import data.Gender;
import data.Student;
import list.*;
import list.Listable;
import list.search.ElemToSearch;
import list.sort.Comparator;
import list.sort.DegreeComparator;
import list.sort.MatriculationNumberComparator;
import list.sort.NameComparator;
import list.sort.PrenameComparator;

public class TestListen {

	public static void main(String[] args) {
	
		executeList();
	}
	
	public static <T> void executeList() {
		Listable<Student> sList = new SinglyLinkedList<>();
		System.out.println("Class: " + sList.getClass().getSimpleName());
		
		Student s1 = new Student("Ted", "Mosby", Gender.MALE, Degree.ELEKTROTECHNIK, 63486);
		Student s2 = new Student("Donald", "Duck", Gender.MALE, Degree.INFORMATIK, 63862);
		Student s3 = new Student("Marie", "Mountain", Gender.FEMALE, Degree.BWL, 563960);
		Student s4 = new Student("Hannah", "Fort", Gender.OTHER, Degree.VWL, 578742);
		Student s5 = new Student("Mark", "Mosty", Gender.MALE, Degree.MEDIENINFORMATIK, 63487);
		Student s6 = new Student("Clint", "Eastwood", Gender.MALE, Degree.WIRTSCHAFTSINFORMATIK, 675839);
		Student s7 = new Student("Minnie", "Pitt", Gender.OTHER, Degree.ELEKTROTECHNIK, 686867);
		Student s8 = new Student("Arthur", "Dot", Gender.MALE, Degree.INFORMATIK, 683483);
		Student s9 = new Student("Marc", "Monty", Gender.MALE, Degree.INFORMATIK, 683866);
		Student s10 = new Student("Martina", "Conti", Gender.FEMALE, Degree.BWL, 6868);
		Student s11 = new Student("Robert", "Santis", Gender.MALE, Degree.WIRTSCHAFTSINFORMATIK, 86477);
		System.out.println(sList.isEmpty());
		System.out.println(sList.getSize());
		sList.AddFirst(s1);
		sList.AddFirst(s2);
		sList.AddLast(s3);
		sList.AddFirst(s4);
		sList.AddLast(s5);
		sList.AddFirst(s6);
		sList.AddLast(s7);
		sList.AddLast(s8);
		sList.AddFirst(s10);
		sList.AddLast(s9);
		sList.AddLast(s11);
		System.out.println(sList.getSize());
		sList.printAll();
		System.out.println(sList.isEmpty());
		System.out.println();
		sList.printElem(s1);
		sList.printElem(new Student("Markus", "Lorenz", Gender.FEMALE, Degree.ELEKTROTECHNIK, 86468));
		Student s12 = new Student("John", "Smith", Gender.MALE, Degree.VWL, 57648);
		sList.set(1, s12);
		sList.printAll();
		System.out.println("Remove at index:");
		sList.remove(s1);
		sList.printAll();
		System.out.println("Sort based on prename: ");
		Comparator <Student> p = new PrenameComparator();
		sList.sortBubble(p);
		System.out.println();
		System.out.println("Sort based on name: ");
		Comparator <Student> s = new NameComparator();
		sList.sortSelection(s);
		System.out.println();
		System.out.println("Sort based on number: ");
		Comparator <Student> n = new MatriculationNumberComparator();
		sList.sortSelection(n);
		System.out.println();
		System.out.println("Sort based on number: ");
		sList.sortBubble(n);
		System.out.println();
		System.out.println("Sort based on degree: ");
		Comparator<Student> d = new DegreeComparator();
		sList.sortBubble(d);
		System.out.println(sList.get(1));
		System.out.println(sList.getFirst());
		sList.removeFirst();
		sList.printAll();
		Listable<Student> dList = new DoublyLinkedList<>();
		System.out.println(dList.getClass().getSimpleName() + " size: " + sList.getSize());
		try{
			System.out.println(dList.getLast());
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		try{
			dList.removeLast();
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
		dList.printAll();
		Student trial = new Student("Minnie", null, null, null, -1);
		dList.linSearch(dList, trial, ElemToSearch.NAME);
	}
}
