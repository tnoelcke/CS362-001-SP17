package edu.osu.cs362;

import java.util.*;
import org.junit.Test;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	 public void addApptRand(){
		 Random r = new Random();
		 Appt test;
		 String name = null;
		 String desc;
		 int startHour;
		 int startMinute;
		 int startDay;
		 int startMonth;
		 int startYear;
		 ValuesGenerator rand = new ValuesGenerator();
		 boolean isValid;
		 GregorianCalendar cal = new GregorianCalendar();
		 boolean found = false;
		 
		 CalDay toTest = new CalDay(cal);
		 LinkedList<Appt> appts;
		 
		 
		 for(int i = 0; i < 100; i ++){	
			found = false;
			startHour = rand.getRandomIntBetween(r, -1, 24);
			startMinute = rand.getRandomIntBetween(r, -1, 60);
			startDay = rand.getRandomIntBetween(r, -1, 35);
			startMonth = rand.getRandomIntBetween(r, -1, 13);
			startYear = 2017;
			while(name == null){
				name = rand.getString(r);
			}
			desc = rand.getString(r);
			test = new Appt(startHour, startMinute, startDay, startMonth, startYear, name, desc);
			isValid = test.getValid();
			System.out.println(test.toString());
			toTest.addAppt(test);
			appts = toTest.getAppts(); 
			for(int j = 0; j < appts.size(); j ++) {
				if(appts.get(j).getTitle().equals(name) && isValid){
					found = true;
				}
			}
			System.out.println("i: " + i + "valid: " + isValid + " found: " + found);
			
			//if its valid check its been added.
			if(isValid){
				assertTrue(found);
			} else {
				assertFalse(found);
			}//checks it hasn't been added
		}

	 }
	
}
