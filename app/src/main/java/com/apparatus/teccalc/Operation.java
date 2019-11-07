package com.apparatus.teccalc;

public class Operation
{
	public long functionChooser(long operandA, long operandB, char function)
	{
		long output = 0L;
		
		switch(function)
		{
			case 'a':
				output = add(operandA, operandB);
				break;
				
			case 's':
				output = subtract(operandA, operandB);
				break;
				
			case 'm':
				output = multiply(operandA, operandB);
				break;
				
			case 'd':
				output = divide(operandA, operandB);
				break;
		}
		
		return output;
	}
	
	long add(long addendA, long addendB)
	{
		long sum = addendA + addendB;
		return sum;
	}
	
	long subtract(long minuend, long subtrahend)
	{
		long difference = minuend - subtrahend;
		return difference;
	}
	
	long multiply(long factorA, long factorB)
	{
		long product = factorA * factorB;
		return product;
	}
	
	long divide(long dividend, long divisor)
	{
		long quotient = dividend / divisor;
		return quotient;
	}
	
	public void compound()
	{
		
	}
	
	void root()
	{
		
	}
	
	void exponent()
	{
		
	}
}
