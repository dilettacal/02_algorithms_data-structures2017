package data;
/**
 * 
 * 07.07.2017
 * Gender.java
 * package
 */
public enum Gender {
	MALE, FEMALE, OTHER;
	
	public static void print(){
		for(Gender el: Gender.values()){
			System.out.printf("%s \n", el);
		}
	}
	
	@Override
	public String toString(){
		String str = super.toString();
		//Konstante in der Form "Male" ausgegeben
		return str.substring(0, 1) + str.substring(1).toLowerCase();
	}


}
