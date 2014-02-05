// @author Andrew Gulla (100395486)
package ca.uoit.AndrewGulla.mycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ca.uoit.AndrewGulla.mycalculator.Calculations;
import ca.uoit.AndrewGulla.mycalculator.DivideByZero;

public class MainActivity extends Activity {
	
	private Double resultNum = 0.0;
	private String Display = "";
	
	//Initiates an instance of 'Calculations' which handles mathematics.
	private Calculations calculate = new Calculations();
	
	private EditText tView, rView;
	private boolean add, sub, div, mul = false;
	protected String savedNum;
	
	//Updates values
	private void updateTextField(){
		tView.setText(this.Display);
		rView.setText(this.resultNum.toString());
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);//Calls super method. Used for screen rotation
		setContentView(R.layout.activity_main);//Sets which XML to use as layout
		tView = (EditText) findViewById(R.id.enter);
		rView = (EditText) findViewById(R.id.answer);//uses ID's from XML
		
		
		//Creates a button referring to the buttons in the layout
		final Button button0 = (Button) findViewById(R.id.button0);
		button0.setOnClickListener(new View.OnClickListener(){//Allows button to listen for a click
			public void onClick(View v){
				Display += "0";
				updateTextField();//Adds a '0' to the display bar
			}
		});
		
		final Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "1";
				updateTextField();
			}
		});
		
		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "2";
				updateTextField();
			}
		});
		
		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "3";
				updateTextField();
			}
		});
		
		final Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "4";
				updateTextField();
			}
		});
		
		final Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "5";
				updateTextField();
			}
		});
		
		final Button button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "6";
				updateTextField();
			}
		});
		
		final Button button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "7";
				updateTextField();
			}
		});
		
		final Button button8 = (Button) findViewById(R.id.button8);
		button8.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "8";
				updateTextField();
			}
		});
		
		final Button button9 = (Button) findViewById(R.id.button9);
		button9.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				Display += "9";
				updateTextField();
			}
		});
		
		final Button buttonBack = (Button) findViewById(R.id.buttonBack);
		buttonBack.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				if(Display.length() > 0){ //If Backspace button is clicked, will remove one value from the display string
					Display = Display.substring(0, (Display.length() - 1));
				}
				
				updateTextField();
			}
		});
		
		final Button buttonClr = (Button) findViewById(R.id.buttonClr);
		buttonClr.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				savedNum = "";
				Display = "";
				mul = false;
				div = false;
				sub = false;
				add = false;
				
				resultNum = 0d;
				
				updateTextField();
			}
		});
		
		//The operation that is clicked is assigned a true value.
		//Other operations are assigned a false value so they dont run when being passed through 'operation' function
		final Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
		buttonMultiply.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Operation();
				mul = true;
				div = false;
				add = false;
				sub = false;
			}
		});
		
		final Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
		buttonDivide.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Operation();
				mul = false;
				div = true;
				add = false;
				sub = false;
			}
		});
		
		final Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
		buttonAdd.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Operation();
				mul = false;
				div = false;
				add = true;
				sub = false;
			}
		});
		
		final Button buttonSub = (Button) findViewById(R.id.buttonSub);
		buttonSub.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Operation();
				mul = false;
				div = false;
				add = false;
				sub = true;
			}
		});
		
		final Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
		buttonEqual.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Operation();
			}
		});
		
		final Button buttonDecimal = (Button) findViewById(R.id.buttonDecimal);
		buttonDecimal.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				if (Display.equals("")){
					Display = "0.";
				}
				else if (!Display.contains(".")){
					Display += ".";
				}
				
				updateTextField();
			}
		});
	}
	
	//creates an instance of DivideByZero class which handles a specific division error
	//If 'calculations' passes the error message through to operation function, it initiates the error message instance.
	protected void dividebyZero(){
		DivideByZero error = new DivideByZero(this, "Nice try...");
	}
	
	//By using boolean values. Click will determine which operation will be executed
	//Checks which operation was chosen through series of 'if' statements.
	private void Operation(){
		testDisplay();
		
		if (add){
			resultNum = calculate.add(Double.parseDouble(Display), resultNum);
		}
		else if (sub){
			resultNum = calculate.subtract(resultNum, Double.parseDouble(Display));
		}
		else if (mul){
			resultNum = calculate.multiply(resultNum, Double.parseDouble(Display));
		}
		else if (div){
			String divResult = calculate.divide(resultNum, Double.parseDouble(Display));
			if (divResult.equals("Nice try...")){
				//If string is retriever from 'Calculations' class, will pass to another function/class to throw an error
				dividebyZero();
			}
			else{
				resultNum = new Double(divResult);
			}
		}
		else{
			resultNum = new Double(Display);
		}
		
		Display = "";
		updateTextField();
	}
	
	private void testDisplay(){
		if (Display.equals("")){
			if (!mul && !div){
				Display = "0";
			}
			else{
				Display = "1";
			}
		}
	}
}
