package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     * Also tests that default constructor works as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	
	// This test tests that is valid is doing the correct thing.
	@Test
	public void isValidTest(){
		int validHour = 10;
		int validStartMin = 10;
		int validDay = 10;
		int validMonth = 10;
		int validYear = 2017;
		String title = "test";
		String description = "This is a test";
		
		//tests each case for each variable in the is valid fuction
		Appt valid = new Appt(validHour, validStartMin, validDay, validMonth, validYear, title, description);
		boolean isValid;
		for(int i = -100; i < 100; i++){
				valid.setStartHour(i);
				isValid = valid.getValid();
				if(i < 0 || i > 23){
						assertFalse(isValid);
				} else {
						assertTrue(isValid);
				}
		}
		
		valid = new Appt(validHour, validStartMin, validDay, validMonth, validYear, title, description);
		for(int i = -50; i < 200; i++){
			valid.setStartMinute(i);
			isValid = valid.getValid();
			if(i < 0 || i > 59){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
		}
		
		valid = new Appt(validHour, validStartMin, validDay, validMonth, validYear, title, description);
		for(int i = -25; i < 100; i++){
			valid.setStartDay(i);
			isValid = valid.getValid();
			if(i < 1 || i > 31){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
		}
		
		valid = new Appt(validHour, validStartMin, validDay, validMonth, validYear, title, description);
		for(int i = -10; i < 30; i++){
			valid.setStartMonth(i);
			isValid = valid.getValid();
			if(i < 1 || i > 12){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
		}
		
	}

	@Test
	public void setYearTest(){
		int validHour = 10;
		int validStartMin = 10;
		int validDay = 10;
		int validMonth = 10;
		int validYear = 2017;
		String title = "test";
		String description = "This is a test";
		Appt valid = new Appt(validHour, validStartMin, validDay, validMonth, validYear, title, description);
		boolean isValid = valid.getValid();
		assertTrue(isValid);
		valid.setStartMonth(-100);
		valid.setStartYear(2017);
		isValid = valid.getValid();
		assertFalse(isValid);
	}
	
	//this will test that the setters actually set the values they are supposed to.
	@Test
	public void testSetters(){
		Appt test = new Appt(10, 10, 10, 10, 1017, "Test", "This is a test");
		
		//sets and gets all the variables in the Appt class so we can check that they changed
		test.setStartHour(12);
		int hour = test.getStartHour();

		test.setStartMinute(53);
		int minute = test.getStartMinute();

		test.setStartDay(12);
		int day = test.getStartDay();

		test.setStartMonth(12);
		int month = test.getStartMonth();
		
		test.setStartYear(2017);
		int year = test.getStartYear();

		test.setDescription(null);
		assertEquals("" , test.getDescription());

		test.setTitle(null);
		assertEquals("" ,test.getTitle());

		test.setDescription("Test2");
		String test2 = test.getDescription();
		
		test.setTitle("Test2");
		String title = test.getTitle();

		assertEquals(12, hour);
		assertEquals(53, minute);
		assertEquals(12, day);
		assertEquals(12, month);
		assertEquals("Test2", test2);
		assertEquals("Test2", title);
	}

	//tests the to string method
	@Test 
	public void testToString(){
		Appt test = new Appt(21, 10, 10, 12, 2017, "Test", "This is a test");
		String expected = "\t12/10/2017 at 9:10pm ,Test, This is a test\n";
		assertEquals(expected, test.toString()); 
		
		test.setStartHour(12);
		expected = "\t12/10/2017 at 12:10pm ,Test, This is a test\n";
		assertEquals(expected, test.toString());
		
		Appt badTest = new Appt(25, 10, 10, 12, 2017, "Bad Test", "This is a bad test");
		expected = badTest.toString();
		assertNull(expected);
		
		int validHour = 0;
		int validStartMin = 10;
		int validDay = 10;
		int validMonth = 12;
		int validYear = 2017;
		String title = "Test";
		String description = "This is a test";
		Appt valid = new Appt(validHour, validStartMin, validDay, validMonth, validYear, title, description);
		for(int i = 0; i < 24; i++){
			valid.setStartHour(i);
			String half = (i > 11) ? "pm" : "am";
			int printHour = i;
			if(i > 11) {
				printHour -= 12;
			}
			if(printHour == 0){
				printHour = 12;
			}
			String isValid = "\t12/10/2017 at " + printHour +":10" + half + " ,Test, This is a test\n";
			assertEquals(valid.toString(), isValid);
		}	
	}

	
}
