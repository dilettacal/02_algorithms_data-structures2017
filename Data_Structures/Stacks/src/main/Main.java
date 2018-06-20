package main;

import java.util.Scanner;

import data.Student;
import stack.*;
/**
 * 15.06.2017
 * Main.java
 * package main
 * 
 * Die Klasse Main steuert das ganze Programm
 */
public class Main {
	//Variablen
	static int selection; //zur Steuerung der Auswahl
	static Stack<Student> studentStack = new Stack<>(); //angelegtes Stack
	static Scanner input = new Scanner(System.in); //zur Steuerung der User-Eingaben

	// Attribute zum Steuern der User-Eingaben bzgl. Stack-Operationen
	static final int PUSH = 1;
	static final int PEEK = 2;
	static final int POP = 3;
	static final int PRINT = 4;
	static final int PRINT_SIZE = 5;
	static final int CLEAR = 6;
	static final int ADD_INDEX = 7;
	static final int REMOVE_LAST = 8;
	static final int REMOVE_AT = 9;
	static final int EXIT = 0;

	// Auswaehlbare Studiengaenge
	static final int AI = 1;
	static final int WI = 2;
	static final int MI = 3;
	static final int GD = 4;
	static final int BWL = 5;

	// Gender-Eingaben
	static final int MALE = 1;
	static final int FEMALE = 2;
	static final int OTHER = 0;
	
	/**
	 * Main-Methode legt Programm-Start ferst
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Willkommen in der Studenten-Database!");
		startStack();
	}
	
	/**
	 * Methode startet Operationen auf den Stack
	 */
	public static void startStack() {
		showMenu();
	}

	/**
	 * Methode zur Anzeige der Menu-Eintraege
	 * 
	 */
	private static void showMenu() {
		System.out.println("Wie moechten Sie vorgehen?");
		System.out.println("Waehlen Sie bitte eine Option aus: \n");
		System.out.println("1 - Student der Database hinzufuegen"); // push-Operation
		System.out.println("2 - Anzeigen des letzt eingefuegten Studenten");// peek
		System.out.println("3 - Letzten Studenten entfernen"); // pop
		System.out.println("4 - Ausgabe der ganzen Database");// print
		System.out.println("5 - Ausgabe der Database-Kapazitaet");// kapazitaet
		System.out.println("6 - Database komplett loeschen"); // clear
		System.out.println("Diese Version bietet weiterhin folgende spezielle Funktionen zum Hinfuegen und Loeschen eines Elements: ");
		System.out.println("7 - Hinfuegen an einem bestimmten Index");
		System.out.println("8 - Loeschen das letzte Element im Stack");
		System.out.println("9 - Loeschen von einem bestimmten Index");
		System.out.println("0 - Programm verlassen");
		System.out.println("Ihre Auswahl: ");
		selection = input.nextInt();
		selectInput(selection);

	}
	
	/**
	 * Methode steuert User-Eingabe und f&uumlhrt die entsprechenden Operationen aus.
	 * @param input die Eingabe
	 */
	private static void selectInput(int input) {
		switch (input) {
		case PUSH:
			Student newStudi = null;
			try {
				newStudi = studentInput();
				studentStack.push(newStudi);
			} catch (IllegalArgumentException e) {
				System.out.println("Angabe fehlerhaft!");
				showMenu();
			}
			//Fall: push erfolgreich
			if (studentStack.peek() == newStudi && newStudi != null) {
				System.out.println("Sie haben einen Studi" + " erfolgreich angelegt\n");
			}
			showMenu();
		case PEEK:
			try {
				Student toShow = studentStack.peek();
				System.out.println("Letzter Student\n" + toShow + "\n");
			} catch (NullPointerException e) { //falls kein Student angelegt
				System.out.println(e.getMessage());
				System.out.println("Diese Auswahl kann jetzt nicht ausgefuehrt werden."
						+ "\nSie muessen mindestens einen Studenten anlegen.\n");
			}
			showMenu();
		case POP:
			try {
				System.out.println("Student " + studentStack.peek() + " wurde aus der Database entfernt.\n");
				studentStack.pop();
			} catch (NullPointerException e) { //falls stack leer
				System.out.println(e.getMessage() + "\n");
			}
			showMenu();
		case PRINT:
			System.out.println("Database: ");
			studentStack.print();
		case PRINT_SIZE:
			System.out.println("Database-Kapazitaet: " + studentStack.size());
			showMenu();
		case CLEAR:
			studentStack.clear();
			if (studentStack.isEmpty())
				System.out.println("Database erfolgreich geloescht!\n");
			showMenu();
		case ADD_INDEX:
			System.out.println("Bitte geben Sie einen gueltigen Index. Index soll zwischen 0 und " + (studentStack.size()-1) + " liegen");
			Scanner sc = new Scanner(System.in);
			int eingabe = sc.nextInt();
			if(eingabe > 0 && eingabe <= studentStack.size()){
				Student neu1 = studentInput();
				boolean added = studentStack.addAtIndex(neu1, eingabe);
				if(added) System.out.println("Student erfolgreich hinzugefuegt!");
			} else {
				System.out.println("Leider ist etwas schief gelaufen!");
			}
			showMenu();			
		case REMOVE_LAST:
			Student last = studentStack.removeLast();
			System.out.println("Sie haben folgenden Studenten erfolgreich entferntn: \n" + last);
			showMenu();			
		case REMOVE_AT:
			System.out.println("Bitte geben Sie einen gueltigen Index. Index soll zwischen 0 und " + (studentStack.size()-1) + " liegen");
			Scanner sc1 = new Scanner(System.in);
			int in1 = sc1.nextInt();
			if(in1 >=0 && in1 <= studentStack.size()){
				Student removed = new Student();
				try{
					removed = studentStack.removeAtIndex(in1);
					System.out.println("Sie haben folgenden Studenten erfolgreich entfernt:\n " + removed);
				} catch (NullPointerException e){
					System.out.println(e.getMessage());
				}
			} 
			showMenu();
		case EXIT:
			System.exit(1);
			break;
		default:
			System.out.println("Achtung! Auswahl nicht korrekt. " + "Versuchen Sie es nochmals");
			showMenu();
		}

	}
	/**
	 * Die Methode erlaubt das Anlegen eines Student-Objekts ueber die Konsole
	 * @return Student
	 * @throws IllegalArgumentException falls input fehlerhaft
	 */
	private static Student studentInput() throws IllegalArgumentException {

		System.out.print("Geben Sie bitte den Vornamen ein: \n");
		String vorname = input.next();
		System.out.print("\nGeben Sie bitte den Nachnamen ein: \n");
		String nachname = input.next();
		System.out.println("\nGeben Sie bitte Matrikelnummer ein: \n");
		String nummer = input.next();
		int matrikel = numberConverter(nummer);
		int g = -1; // gender
		String gender = ""; // gender to convert
		String c = ""; // course of study
		if (matrikel == -1) {
			throw new IllegalArgumentException("Eingabe fehlerhaft. Student wird nicht hingefuegt.");
		} else {
			System.out.println("Geben Sie jetzt bitte das Geschlecht an: \n");
			genderTypes();
			g = input.nextInt();
			gender = genderConverter(g);
			System.out.print("\nGeben Sie bitte den Studiengang ein: \n");
			courseTypes();
			int course = input.nextInt();
			c = courseConverter(course);
			Student student = new Student(vorname, nachname, gender, matrikel, c);
			return student;

		}
	}
	
	/**
	 * Anzeige der Gender-Auswahlmoeglichkeiten
	 */
	private static void genderTypes() {
		System.out.println("Bitte Eingabe wie folgt eingeben: ");
		System.out.println("Druecken Sie die Taste: " + "\n1: Maennlich " + "\n2: Weiblich" + "\n0: Sonstiges");
	}
	
	/**
	 * Anzeige der Auswahl der Studiengang-Auswahlmoeglichkeiten
	 */
	private static void courseTypes() {
		System.out.println(
				"Um einen der folgenden Studiengaenge auszuwaehlen," + " druecken Sie bitte die entsprechende Taste: ");
		System.out.print("1 - Angewandte Informatik\n" + "2 - Wirtschaftsinformatik\n" + "3 - Medieninformatik\n"
				+ "4 - Game Design\n" + "5 - BWL\n");
	}

	/**
	 * Wandelt eingegebene Zahl in das entsprechende Gender um
	 * @param i Zahl fuer gender
	 * @return String mit Genderart
	 * @throws IllegalArgumentException falls Eingabe fehlerhaft ist
	 */
	private static String genderConverter(int i) throws IllegalArgumentException {
		String gender = "";
		switch (i) {
		case (MALE):
			gender = "m";
			break;
		case (FEMALE):
			gender = "w";
			break;
		case (OTHER):
			gender = "s"; // Sonstiges
			break;
		default:
			if (gender == "")
				throw new IllegalArgumentException("Eingabe falsch! Student wird nicht hingefuegt!");
		}
		return gender;
	}

	/**
	 * Wandelt Matrikel-Nr in eine Zahl um
	 * @param s die Zahl als String
	 * @return Zahl als integer
	 * @throws NumberFormatException falls String nicht numerisch
	 */
	private static int numberConverter(String s) throws NumberFormatException {
		int number = 0;
		if (!s.matches("[0-9]+")) {
			return -1;
		} else {
			number = Integer.parseInt(s);
		}
		return number;
	}

	/**
	 * Wandelt Course-Nummer in die entsprechende Bezeichnung um
	 * @param i Course-Nummer 
	 * @return Kursnname als String
	 * @throws IllegalArgumentException falls Eingabe fehlerhaft 
	 */
	private static String courseConverter(int i) throws IllegalArgumentException {
		String course = "";
		switch (i) {
		case (AI):
			course = "Angewandte Informatik";
			break;
		case (WI):
			course = "Wirtschaftsinformatik";
			break;
		case (MI):
			course = "Medieninformatik";
			break;
		case (GD):
			course = "Game Design";
			break;
		case (BWL):
			course = "BWL";
			break;
		default:
			if (course == "")
				throw new IllegalArgumentException("Eingabe falsch! Student wird nicht eingefuegt.");
		}
		return course;
	}

}
