// @author Andrew Gulla (100395486)
package ca.uoit.AndrewGulla.mycalculator;

//This class is specifically designed to only handle mathematic operations.
//Once boolean value passes through to determine operation, this class is called to retrieve the calculated value.
public class Calculations {
	
	public double multiply( double x, double y ){
		double product = x * y;
		return product;
	}
	public double add( double x, double y ){
		double sum = x + y;
		return sum;
	}
	public double subtract( double x, double y ){
		double difference = x - y;
		return difference;
	}
	//If trying to divide by zero, will return a string which triggers an error.
	public String divide( double x, double y ){
		if ( y == 0){
			return "Nice try...";
		}
		else{
			double q = x / y;
			String quotient = Double.toString(q);
			return quotient;
		}
	}
}