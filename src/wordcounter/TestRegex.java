package wordcounter;

public class TestRegex {
	public static final String testString = new String("But who has any right to find fault with a man who chooses" 
			+ "to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"
			+ " Stacy's");
	
	public static final String regEx = "('s)|[,?]";

	public static void main(String[] args) {
		System.out.println(testString);
		
		System.out.println("\n" + testString.replaceAll(regEx, " "));
	}

}
