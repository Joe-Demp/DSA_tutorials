import java.util.Stack;

/**
 * To implement the Russian Peasant's multiplication algorithm
 * 	and then time it
 * @author demps
 *
 */
public class RussianPeasant {
	/**
	 * Multiplies two numbers together by the Russian Peasant's algorithm<br>
	 * 	Only works for two positive numbers for now
	 * 
	 * @param a the first operand, ideally the smaller of the two
	 * @param b the second operand, ideally the larger of the two
	 * @return a * b as calculated by the algorithm 
	 */
	public static long multiply(long a, long b) {
//		first make sure the numbers are in the right order
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		
//		then do the algorithm, storing the intermediate results in a stack
		Stack<Long> myStack = new Stack<Long>();
		
		do {
			//	if the left operand is odd numbered, right operand for later
			if ((a % 2)== 1)
				myStack.push(b);
			
			a /= 2;
			b *= 2;
		} while( a > 1 );
		
//		Now add up the saved numbers
//		sum initialised to b since the loop above does not save it when a = 1
		long sum = b;
		while(!myStack.empty())
			sum += myStack.pop();
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(multiply(237, 503));
	}

}
