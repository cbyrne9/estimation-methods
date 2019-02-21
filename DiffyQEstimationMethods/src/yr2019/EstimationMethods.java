package yr2019;

import java.util.Scanner;

public class EstimationMethods {

	private static double yPrime;
	
	public static double function(double x, double y) {
		
		/* I didn't want to parse through a bunch of input
		 * in order to get the differential equation, so modify
		 * the statement below to match what the function is
		 * 
		 * NOTE: must be in the form y' = f(x,y)
		 */
		
		yPrime = 3 * x * x;
		
		/* In the statement above, always leave the double yPrime part
		 * and the semicolon alone when editing; only modify the stuff between them
		 * 
		 * Below i'll list some operations you can use
		 * 
		 * - add: a + b
		 * - subtract: a - b
		 * - multiply: a * b
		 * - divide: a / b
		 * - exponents: type Math.Pow(base,exponent)
		 * - trig functions: the form  Math.sin(a) 
		 * - square roots: Math.sqrt(a)
		 * - parentheses work as they do normally and can help a lot with grouping things 
		 */
		
		
		return yPrime;
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter initial X");
		double x = kboard.nextDouble();
		System.out.println("Please enter initial Y");
		double y = kboard.nextDouble();
		System.out.println("Please enter the target X");
		double targetX = kboard.nextDouble();
		System.out.println("Please enter your step size \"h\" "
				+ " If you'd like to use number of steps intead type 0");
		double h = kboard.nextDouble();
		int iterations;
		if (h == 0) {
			System.out.println("Please enter the number of steps you'd like");
			h = kboard.nextInt();
			iterations = (int) h;
			h = (targetX - x) / h;
		}
		else {
			iterations = (int) ((targetX - x) / h);
		}
		
		
		int method;
		
		do {
		
			System.out.println("Type 0 for Euler's method\nType 1 for improved Euler's method\nType 2 for the RK4 method");
			method = kboard.nextInt();
		
			//Euler's method
			if (method == 0) {
				for (int i = 0; i < iterations; i++) {
					y = y + h * function(x,y);
					x += h;
					if (iterations > 10)
						System.out.println(y);
					else if (i % (iterations / 10) == 0)
						System.out.println(y);
				}
			}
			//End of Euler's method
		
			//Improved Euler's
			else if (method == 1) {
				for (int i = 0; i < iterations; i++) {
					double slope1 = function(x,y);
					double slope2 = function(x + h, y + slope1 * h);
					double avgSlope = (slope1 + slope2) / 2;
					y = y + h * avgSlope;
					x += h;
					if (iterations > 10)
						System.out.println(y);
					else if (i % (iterations / 10) == 0)
						System.out.println(y);
				}
			}
			//End of Improved Euler's
		
			//RK4 method
			else if (method == 2) {
				for (int i = 0; i < iterations; i++) {
					double slope1 = function(x,y);
					double slope2 = function(x + h/2, y +  (h / 2) * slope1);
					double slope3 = function(x+ h / 2, y + (h / 2) * slope2);
					double slope4 = function(x + h, y + h * slope3);
					double avgSlope = (slope1 + 2 * slope2 + 2 * slope3 + slope4) / 6;
					y = y + h * avgSlope;
					x += h;
					if (iterations > 10)
						System.out.println(y);
					else if (i % (iterations / 10) == 0)
						System.out.println(y);
				}
			}
			//End of RK4 method
		
		} while (method != 0 && method != 1 && method != 2);
		
		System.out.println("Your final estimation with " + iterations + " steps of size " + h + " is:\n" + y + "\n");
		
	}

}
