package testunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gestionCalculatrice.OperAddition;
import gestionCalculatrice.OperDivision;
import gestionCalculatrice.OperMultiplication;
import gestionCalculatrice.OperSoustraction;


class CalculTest 
{

	@Test
	void testAddition()
	{
		OperAddition oa = new OperAddition();
		int a = 5 , b = 5 , res = 10;
		if ((oa.doOper(a, b)!= res)) 
		{
			fail("le calcul est fauX");
		}
	}
	
	@Test
	void testSoustraction()
	{
		OperSoustraction os = new OperSoustraction();
		int a = 5 , b = 5 , res = 0;
		if ((os.doOper(a, b)!= res)) 
		{
			fail("le calcul est fauX");
		}
	}
	
	@Test
	void testMultiplication()
	{
		OperMultiplication om = new OperMultiplication();
		int a = 5 , b = 5 , res = 25;
		if ((om.doOper(a, b)!= res)) 
		{
			fail("le calcul est fauX");
		}
	}
	
	@Test
	void testDivision()
	{
		OperDivision od = new OperDivision();
		int a = 5 , b = 5 , res = 1;
		if ((od.doOper(a, b)!= res)) 
		{
			fail("le calcul est fauX");
		}
	}

}
