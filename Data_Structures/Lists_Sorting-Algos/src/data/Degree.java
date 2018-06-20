package data;
/**
 * 07.07.2017
 * Degree.java
 * package
 */
public enum Degree { 
	
	INFORMATIK, 
	MEDIENINFORMATIK, 
	WIRTSCHAFTSINFORMATIK, 
	BWL, 
	VWL, 
	ELEKTROTECHNIK;
	
	/**
	 * Gibt Liste der m&oumlglichen Werte aus
	 */
	public static void print(){
		for(Degree d: Degree.values()){
			System.out.printf("%s \n", d);
		}
	}
	
	@Override
	public String toString(){
		String str = super.toString();
		return str.substring(0, 1) + str.substring(1).toLowerCase();
	}
}
