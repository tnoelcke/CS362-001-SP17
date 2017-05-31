package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;
import java.lang.*;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
     */
	 //@Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =10;//System.currentTimeMillis();
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
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
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing...");
	 }
	 
	 @Test
	 public void isValidRand() throws Throwable{
		 int validNum = 10;
		 Random rn = new Random();
		 int r;
		 Appt appt;
		 boolean isValid = true;
		 //tests 1000 random values for startHour between -100 and 100
		 for(int i = 0; i < 1000; i++){
			r = rn.nextInt(200) - 100;
			appt = new Appt(r, validNum, validNum, validNum, 2017, "Test", "THis is a test");
			isValid = appt.getValid();
			if(r < 0 || r > 23){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
			
			appt = new Appt(validNum, r, validNum, validNum, 2017, "Test", "THis is a test");
			isValid = appt.getValid();
			if(r < 0 || r > 59){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
			
			appt = new Appt(validNum, validNum, r, validNum, 2017, "Test", "THis is a test");
			isValid = appt.getValid();
			if(r < 1 || r > 31){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
			
			appt = new Appt( validNum, validNum, validNum, r, 2017, "Test", "THis is a test");
			isValid = appt.getValid();
			if(r < 1 || r > 12){
				assertFalse(isValid);
			} else {
				assertTrue(isValid);
			}
		 }
	 }
	 
	 
	 @Test
	 public void descriptionRand(){
		 int validNum = 10;
		 String name = "test";
		 Random r = new Random();
		 ValuesGenerator rand = new ValuesGenerator();
		 Appt test = new Appt(validNum, validNum, validNum, validNum, validNum, name, "");
		 String toSet;
		 String actual;
		 
		 for(int i = 0; i < 100; i++){
			toSet = rand.getString(r);
			test.setDescription(toSet);
			actual = test.getDescription();
			if(toSet != null){
				assertEquals(toSet, actual);
			} else {
				assertEquals("", actual);
			}
		 }
		 
		 
		 
	 }

}
