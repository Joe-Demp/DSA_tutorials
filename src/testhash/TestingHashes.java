package testhash;

public class TestingHashes {

	public static void main(String[] args) {
		String myString = "java";
		int hashMyString = TestHashCode.polyHashCode(41, myString);
		System.out.println("The poly hashcode for java is: " + hashMyString);
		System.out.println("The compressed hashcode for java is: " + TestHashCode.compress(hashMyString));
		
		hashMyString = TestHashCode.cyclicHashCode(5, myString);
		System.out.println("\nThe cyclic hashcode for java is: " + hashMyString);
		
		hashMyString = TestHashCode.oldHashCode(myString);
		System.out.println("\nThe old hashcode for java is: " + hashMyString);
		
		myString = "avaj";
		hashMyString = TestHashCode.oldHashCode(myString);
		System.out.println("\nThe old hashcode for avaj is: " + hashMyString);
		
//		myString = "Joseph";
//		hashMyString = TestHashCode.polyHashCode(41, myString);
//		System.out.println("The hashcode for Joseph is: " + hashMyString);
//		System.out.println("The compressed hashcode for Joseph is: " + TestHashCode.compress(hashMyString));
	}

}
