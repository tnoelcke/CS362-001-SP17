package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	@Test
	//tests the function that sets up a new Time Table
	public void testApptRange(){
		TimeTable test = new TimeTable();
		LinkedList<Appt> appts = new LinkedList<Appt>();
		Appt one = new Appt(10, 10, 10, 12, 2017, "test 1", "This is the first test appointment");
		Appt two = new Appt(11, 11, 11, 12, 2017, "Test 2", "second test");
		Appt three = new Appt(12, 12, 12, 12, 2017, "Test 3", "Third test");
		Appt four = new Appt(26, 12, 12, 12, 2017, "Bad test", "bad Test");
		GregorianCalendar start = new GregorianCalendar(2017,12, 9);
		GregorianCalendar end = new GregorianCalendar(2017, 12, 13);
		appts.add(one);
		appts.add(two);
		appts.add(three);
		appts.add(four);
		LinkedList<CalDay> result = test.getApptRange(appts, start, end);
		assertEquals(4, result.size());
			
	}

	//tests if the selected item is deleted from the time table.
	@Test
	public void testDelete(){
		TimeTable test = new TimeTable();	
		LinkedList<Appt> appts;
		appts = test.deleteAppt(null, null);
		assertNull(appts);
		appts = new LinkedList<Appt>();

		Appt one = new Appt(10, 10, 10, 12, 2017, "test 1", "This is the first test appointment");
		Appt two = new Appt(11, 11, 11, 12, 2017, "Test 2", "second test");
		Appt three = new Appt(12, 12, 12, 12, 2017, "Test 3", "Third test");
		GregorianCalendar start = new GregorianCalendar(2017,12, 9);
		GregorianCalendar end = new GregorianCalendar(2017, 12, 13);
		appts.add(one);
		appts.add(two);
		appts.add(three);
		LinkedList<CalDay> result = test.getApptRange(appts, start, end);
		appts = test.deleteAppt(appts, one);
		assertEquals(2, appts.size());
		Appt defunct = new Appt(45, 10, 15, 26, 2017, "Dont use", "This is a bad Appt");
		LinkedList<Appt> badDelete = new LinkedList<Appt>();
		badDelete = test.deleteAppt(appts, defunct);
		assertNull(badDelete);
		badDelete = test.deleteAppt(appts, one);
		assertNull(badDelete);
	} 
}
