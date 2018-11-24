package A2_Q2;

import java.util.PriorityQueue;

public class Student implements Comparable<Student> {
	private String name;
	private int age;
	private double GPA;
	
	public Student(String n, int a, double g) {
		name = n;
		age = a;
		setGPA(g);
	}
	
	/*Getters and setters*/
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void ageUp() {
		this.age++;
	}
	public void setGPA(double gpa) {
		this.GPA = gpa;
	}
	public double getGPA() {
		return GPA;
	}

	/**
	 * Takes in a student and compares it to the calling object by GPA
	 * @return 1 if the calling Student's GPA is higher than s's GPA <br>
	 * 		-1 if s's GPA is higher than the calling Student's 	<br>
	 * 		0 if they have the same GPA
	 */
	@Override
	public int compareTo(Student s) {
		if ( this.GPA < s.GPA )
			return -1;
		else if ( this.GPA > s.GPA )
			return 1;
		
		return 0;	//	GPAs are equal
	}
	
	@Override
	public String toString() {
		return new String( name + ", " + age + ", " + GPA );
	}
	
	public static void main(String[] args) {
//		Initialize PriorityQueue
		PriorityQueue<Student> pq = new PriorityQueue<Student>();
		pq.add( new Student( "Nataly Ware", 21, 4.0 ) );
		pq.add( new Student( "Mira Weiss", 19, 3.5 ) );
		pq.add( new Student( "Emilie Gibbs", 20, 3.2 ) );
		pq.add( new Student( "Lisa Boone", 22, 4.7 ) );
		pq.add( new Student( "Karsyn Terry", 20, 4.8 ) );
		pq.add( new Student( "Jeremy Schwartz",18, 4.6 ) );
		pq.add( new Student( "Aleah Gaines", 19, 4.1 ) );
		pq.add( new Student( "Arianna Reeves", 20, 3.9 ) );
		pq.add( new Student( "Walker Holloway",22, 3.8 ) );
		pq.add( new Student( "Adelyn Walter", 24, 4.95 ) );
		pq.add( new Student( "Damion Sanders", 25, 3.2 ) );
		pq.add( new Student( "Aimee Quinn", 21, 2.7 ) );
		
		System.out.println( "name, age, GPA" );
		while ( !pq.isEmpty() ) {
			System.out.println( pq.remove() );
		}
	}

}
