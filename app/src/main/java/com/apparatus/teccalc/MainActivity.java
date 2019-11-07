package com.apparatus.teccalc;

import android.app.*;
import android.os.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	//These will be the number variables
	long amountA = 0L;
	long amountB = 0L;
	long amountC = 0L;
	
	//We will need to display the numbers
	//as text so we will need a string
	String amount = "";
	
	//This variable will store each number
	//when it's button is pressed
	long number = -1L;
	
	//Here we will get all the GUI
	//Variables setup
	
	//Number Buttons
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	
	//Math Function Buttons
	Button add;
	Button subtract;
	Button multiply;
	Button divide;
	
	//Calculation and Utility Buttons
	Button equals;
	Button clear;
	Button delete;
	Button point;
	
	//Textview variable
	TextView outputNumber;
	
	//These variables are responsible
	//for keeping track of what is happening
	
	//character variables
	char function; //tracks the current math operation
	char operator; //also tracks the current math operation
	char chosenOperator;	//This will keep track of what operator
							//was pressed until we press the equals button.
	char tracker;  //tracks anything I tell it too
	
	//boolean variables
	boolean compound; 	//Tracks whether we want to
						//add another calculation to
						//the current one
	boolean midCalc;	//This tracks whether or not we
						//have pressed an arithmetic
						//operator button.
	boolean preCalc;	//This tracks whether or not we
						//have pressed the equals button
	boolean cleared;	//This boolean is responsible for
						//tracking when we want to clear
						//the textview.
						
	//END OF CLASS VARIABLE DECLARATIONS
						
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		//This removes the title bar at the top
		//of the app
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		//This hides the notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		//We start everything by creating
		//an instance of the core class.
		//ALWAYS PUT THIS BELOW THE 
		//setContentView() FUNCTION!!!!
		core calculator = new core();
		
		//Initialize and instance of the
		//operation class
		//Operation calculate = new Operation();
		
		//END OF ONCREATE FUNCTION
    }//END OF ONCREATE FUNCTION
	
	class core implements View.OnClickListener
	{
		//Initialize and instance of the
		//operation class
		Operation calculate = new Operation();
		
		core()
		{
			//Initializing Utility Variables
			tracker = '@';
			function = '@';
			operator = '@';
			chosenOperator = '@';
			
			compound = false;
			midCalc = false;
			preCalc = false;
			cleared = true;
			
			init();
			
			//END OF CONSTRUCTOR
		}//End of core constructor
		
		void init(){
			//This funtion will initialize
			//The working parts of the graphical
			//user interface
			
			//These are the number buttons
			one = (Button) findViewById(R.id.one);
			two = (Button) findViewById(R.id.two);
			three = (Button) findViewById(R.id.three);
			four = (Button) findViewById(R.id.four);
			five = (Button) findViewById(R.id.five);
			six = (Button) findViewById(R.id.six);
			seven = (Button) findViewById(R.id.seven);
			eight = (Button) findViewById(R.id.eight);
			nine = (Button) findViewById(R.id.nine);
			zero = (Button) findViewById(R.id.zero);
			
			//These are the arithmetic operator
			//buttons
			add = (Button) findViewById(R.id.add);
			subtract = (Button) findViewById(R.id.subtract);
			multiply = (Button) findViewById(R.id.multiply);
			divide = (Button) findViewById(R.id.divide);
			
			//These are the utility buttons
			//equals = (Button) findViewById(R.id.equals);
			clear = (Button) findViewById(R.id.clear);
			delete = (Button) findViewById(R.id.delete);
			equals = (Button) findViewById(R.id.equals);
			point = (Button) findViewById(R.id.point);
			
			//This is our textview that will
			//output all of our calculations
			outputNumber = (TextView) findViewById(R.id.outputNumber);
			
			//Next are the listener declarations
			//We'll start with the number buttons
			one.setOnClickListener(this);
			two.setOnClickListener(this);
			three.setOnClickListener(this);
			four.setOnClickListener(this);
			five.setOnClickListener(this);
			six.setOnClickListener(this);
			seven.setOnClickListener(this);
			eight.setOnClickListener(this);
			nine.setOnClickListener(this);
			zero.setOnClickListener(this);
			
			//Next are the arithmetic operator
			//buttons.
			add.setOnClickListener(this);
			subtract.setOnClickListener(this);
			multiply.setOnClickListener(this);
			divide.setOnClickListener(this);
			
			//Finally we have the listeners
			//for the utility and funciton buttons
			equals.setOnClickListener(this);
			clear.setOnClickListener(this);
			delete.setOnClickListener(this);
			point.setOnClickListener(this);
			
			//Initializing TextView
			outputNumber.setText("0");
			
		}//End of init function
		
		@Override
		public void onClick(View display)
		{
			//We will be using a switch statement
			//To deal with all the buttons in a
			//organized fashion.
			switch(display.getId())
			{
				//Number Buttons
				case R.id.one:
					number = 1L;
					break;
					
				case R.id.two:
					number = 2L;
					break;
					
				case R.id.three:
					number = 3L;
					break;
					
				case R.id.four:
					number = 4L;
					break;
					
				case R.id.five:
					number = 5L;
					break;
					
				case R.id.six:
					number = 6L;
					break;
					
				case R.id.seven:
					number = 7L;
					break;
					
				case R.id.eight:
					number = 8L;
					break;
					
				case R.id.nine:
					number = 9L;
					break;
					
				case R.id.zero:
					number = 0L;
					break;
					
				//Arithmetic Operator Buttons
				case R.id.add:
					operator = 'a';
					break;
					
				case R.id.subtract:
					operator = 's';
					break;
					
				case R.id.multiply:
					operator = 'm';
					break;
					
				case R.id.divide:
					operator = 'd';
					break;
					
				//Utility and Function Buttons
				case R.id.delete:
					function = 'd';
					break;
					
				case R.id.clear:
					function = 'c';
					break;
					
				case R.id.equals:
					function = 'e';
					break;
					
				case R.id.point:
					function = 'p';
					break;
			}//End of switch statement
			
			if(number != -1L)
			{
				amountB = (amountB * 10) + number;
			}
			
			update();
		}//End of OnClick function
		
		//We will use this function to
		//manage the control flow of the 
		//program.
		void update()
		{
			if(preCalc == true && number != -1L)
			{
				preCalc = false;
			}
			//This if checks if a function
			//button has been pressed
			if(function != '@')
			{
				calculatorFunction(function);
			}
			
			//This checks if a arithmetic
			//operation button has been pressed
			else if(operator != '@')
			{
				if(preCalc)
				{
					amountA = amountC;
					amountB = 0L;
					number = -1L;
					amount = "";
					midCalc = true;
					chosenOperator = operator;
					showOperator(operator);
				}
				
				else if(chosenOperator != '@')
				{
					amount = "";
					number = -1L;
					operator = '@';
				}//End of operator-switch-check if
				
				else{
					if(midCalc == false)
					{
						amountA = amountB;
						amountB = 0L;
						number = -1L;
						amount = "";
						midCalc = true;
						chosenOperator = operator;
						showOperator(operator);
					}//End of midcalc if
				}//End of operator else
			}//End of main operator else if
			
			else{
				showNumber(amountB);
			}//End of regular case else
			
			number = -1L;
		}//END OF UPDATE FUNCTION
		
		//We will use this function to display
		//our numbers on the screen.
		void showNumber(long showMe)
		{
			amount = String.valueOf(showMe);
			outputNumber.setText(amount);
		}//END OF SHOWNUMBER FUNCTION
		
		void delete(long reduceMe)
		{
				if(reduceMe == 0L)
				{
					clearAll();
				}
				
				else
				{
					reduceMe = reduceMe / 10L;
					if(reduceMe == 0L)
					{
						clearAll();
					}
					amountB = reduceMe;
					showNumber(amountB);
					function = '@';
					number = -1L;
				}
		}//End of delete function
		
		void clearAll()
		{
			outputNumber.setText("0");
			number = -1L;
			amountA = 0L;
			amountB = 0L;
			amount = "";
			operator = '@';
			function = '@';
			midCalc = false;
			chosenOperator = '@';
		}//End of clearall function
		
		void finalCalculation()
		{
			if(chosenOperator != '@')
			{
				preCalc = true;
				amountC = calculate.functionChooser(amountA, amountB, chosenOperator);
				clearAll();
				showNumber(amountC);
			}
		}
		
		void showOperator(char showThis)
		{
			switch(showThis)
			{
				case 'a':
					outputNumber.setText("+");
					break;
					
				case 's':
					outputNumber.setText("-");
					break;
					
				case 'm':
					outputNumber.setText("*");
					break;
					
				case 'd':
					outputNumber.setText("/");
					break;
			}
			
			operator = '@';
			
		}//End of showOperator function
		
		void calculatorFunction(char doThis)
		{
			switch(doThis)
			{
				case 'c':
					clearAll();
					break;
					
				case 'd':
					delete(amountB);
					break;
					
				case 'e':
					finalCalculation();
					break;
					
			}//End of switch statement
		}//End of calculatorFunction function
	}//End of class core
}//End of class MainActivity
