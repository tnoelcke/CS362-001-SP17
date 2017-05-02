package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	//tests the constructors and gettors
	@Test
	public void testConstructor(){
		//creates new object and gets some information about it to test
		GregorianCalendar cal = new GregorianCalendar();
		CalDay test = new CalDay(cal);
		boolean testTrue = test.isValid();
		int day = test.getDay();
		int year = test.getYear();
		int month = test.getMonth();
				
		//creats an empty object and see's if its valid.
		CalDay test2 = new CalDay();
		boolean testFalse = test2.isValid();

		
		//assertions
		assertFalse(testFalse);
		assertTrue(testTrue);
		assertEquals(cal.get(cal.DAY_OF_MONTH), day);
		assertEquals(cal.get(cal.MONTH), month);
		assertEquals(cal.get(cal.YEAR), year);
	}
	
	
	//tests AddAppt fucntion
	@Test
	public void testAddAppt(){
		GregorianCalendar cal = new GregorianCalendar();
		CalDay test = new CalDay(cal);
		Appt toAdd = new Appt(10, 26, 26, 4, 2017,"Test", "This is a test");
		Appt toAdd1 = new Appt(9, 26, 26, 4, 2017, "Test2","Second test");
		Appt toAdd2 = new Appt(11, 26, 26, 4, 2017, "test3","Third Test");
		Appt toAdd3 = new Appt(25, 26, 26, 4, 2017, "test4", "4th Test");		

		test.addAppt(toAdd);
		test.addAppt(toAdd1);
		test.addAppt(toAdd2);
		test.addAppt(toAdd3);
		int num = test.getSizeAppts();
		assertEquals(3, num);
	}

	//checks the toString Method
	@Test
	public void testToString(){
		//creats a new calDay and turns it to a string.
		GregorianCalendar cal = new GregorianCalendar();
		CalDay test = new CalDay(cal);
		Appt toAdd = new Appt(10, 26, 26, 4, 2017,"Test", "This is a test");
		Appt toAdd1 = new Appt(9, 26, 26, 4, 2017, "Test2","Second test");
		Appt toAdd2 = new Appt(11, 26, 26, 4, 2017, "test3","Third Test");
		test.addAppt(toAdd);
		test.addAppt(toAdd1);
		test.addAppt(toAdd2);
		String check = test.toString();
		
		//make sure the string is not null.
		assertNotNull(check);
		CalDay test2 = new CalDay();
		check = test2.toString();

	}

	@Test
	//tests get Appts and getting the appts through an itorator.
	public void testGetAppts(){
		GregorianCalendar cal = new GregorianCalendar();
		CalDay test = new CalDay(cal);
		Appt toAdd = new Appt(10, 26, 26, 4, 2017,"Test", "This is a test");
		Appt toAdd1 = new Appt(9, 26, 26, 4, 2017, "Test2","Second test");
		Appt toAdd2 = new Appt(11, 26, 26, 4, 2017, "test3","Third Test");
		test.addAppt(toAdd);
		test.addAppt(toAdd1);
		test.addAppt(toAdd2);

		LinkedList<Appt> appts = test.getAppts();
		int num = appts.size();
		assertEquals(3, num);
	
	}
	
	@Test
	public void testItorator() {
		GregorianCalendar cal = new GregorianCalendar();
		CalDay test1 = new CalDay();
		Iterator<?> toTest = test1.iterator();
		assertNull(toTest);

		CalDay test = new CalDay(cal);
		Appt toAdd = new Appt(10, 26, 26, 4, 2017,"Test", "This is a test");
		Appt toAdd1 = new Appt(9, 26, 26, 4, 2017, "Test2","Second test");
		Appt toAdd2 = new Appt(11, 26, 26, 4, 2017, "test3","Third Test");
		test.addAppt(toAdd);
		test.addAppt(toAdd1);
		test.addAppt(toAdd2);
		toTest = test.iterator();
		assertNotNull(toTest);


		 
	}
}	
