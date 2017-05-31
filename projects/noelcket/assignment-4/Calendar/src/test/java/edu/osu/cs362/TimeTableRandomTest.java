package edu.osu.cs362;

import java.util.*;
import org.junit.Test;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void removeRandomTest(){
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

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 LinkedList<Appt> appts2 = new LinkedList<Appt>();
		LinkedList<Appt> appts3;
		//catch a few edge cases.
		 TimeTable calendar = new TimeTable();
		 appts3 = calendar.deleteAppt(null, null);
		 assertNull(appts3);
		 
		 
		 
		 for(int i = 0; i < 100; i++){	
			startHour = rand.getRandomIntBetween(r, -1, 24);
			startMinute = rand.getRandomIntBetween(r, -1, 60);
			startDay = rand.getRandomIntBetween(r, -1, 35);
			startMonth = rand.getRandomIntBetween(r, -1, 13);
			startYear = 2017;
			name = rand.getString(r);
			desc = rand.getString(r);
			test = new Appt(startHour, startMinute, startDay, startMonth, startYear, name, desc);
			appts.add(test);
			appts2.add(test);
		 }
		 
		 
		 Appt notInSet = new Appt(1, 1, 1, 1, 1, "not in set", "not in set");
	
		 
		 appts3 = calendar.deleteAppt(appts, notInSet);
		 assertNull(appts3);
		 appts3 = calendar.deleteAppt(appts, null);
		 assertNull(appts3);
		 calendar.deleteAppt(null, notInSet);
		 assertFalse(false);
		 int size = 0;
		 Appt toFind;
		 for(int i = 1; i < appts.size(); i++){
			 System.out.println(i);
			 size = appts.size();
			 toFind = appts2.get(i);
			 calendar.deleteAppt(appts, toFind);
			 if(appts2.get(i).getValid()){
				 assertEquals(size - 1, appts.size());
			 } else {
				 assertEquals(size, appts.size());
			 }
		 }
		 
		 
	 }


	
}
