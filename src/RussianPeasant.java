import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 * To implement the Russian Peasant's multiplication algorithm
 * 	and then time it
 * @author demps
 *
 */
public class RussianPeasant {
	private static final int MAX_ITs = 1000;
	/**
	 * Multiplies two numbers together by the Russian Peasant's algorithm<br>
	 * 	Only works for two positive numbers, or one positive one negative for now
	 * 
	 * @param a the first operand
	 * @param b the second operand
	 * @return a * b as calculated by the algorithm 
	 */
	public static long multiply(long a, long b) {
//		first make sure the numbers are in the right order
		if ((a > b && b > 0) || a < 0) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		
		if (a == 0 || b == 0) return 0;
		else {
	//		then do the algorithm, storing the intermediate results in a stack
			Stack<Long> myStack = new Stack<Long>();
			
			do {
				//	if the left operand is odd numbered, right operand for later
				if ((a % 2)== 1)
					myStack.push(b);
				
				a /= 2;
				b *= 2;
			} while( a > 1 || a < -1 );
			
	//		Now add up the saved numbers
	//		sum initialised to b since the loop above does not save it when a = 1
			long sum = b;
			while(!myStack.empty())
				sum += myStack.pop();
			
			return sum;
		}
	}
	
	public static long timeMultiply(long operand, int iterations) {
		long startTime = System.nanoTime();
		for (int i = 0; i < iterations; ++i)
			multiply(operand, operand);
		long endTime = System.nanoTime();
		
		return endTime - startTime;
	}

	public static void main(String[] args) {
		File f = new File("multiplyTimes.csv");
		FileWriter fStream = null;
		
		long testResult = -1;
		
		try {
			fStream = new FileWriter(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
//		start writing file
		try {
			fStream.write("n, t(n),\n");
			
//			numbers from 100 to 10000000 in multiples of 10 are passed to multiply
//			through the timing function
			for (int i = 100; i <= 10000000; i += 10) {
				testResult = timeMultiply(i, MAX_ITs);
				fStream.write(i + ", " + testResult + ",\n");
				System.out.println(i + ", " + testResult + ",\n");
			}
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			fStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
