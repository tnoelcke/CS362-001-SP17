package edu.osu.cs362;

//Author: Thomas Noelcke
//CS 362 Spring 2017
//HW 1 program to test
//
//Description: This program randomly generates 100 ints from [0..100] in an array and then
//sorts those ints using bubble sort. This program them adds them all together
//and calculates an average and a median and a mode.

import java.util.Random;


public class App 
{
	public static void main( String[] args )
	{
		int[] nums = new int[100];
		System.out.println("Before the array was sorted it contained");
		fillArray(nums);
		display(nums);
		median(nums);
		sort(nums);
		mode(nums);
		average(nums);	
		System.out.println("After the Array was sorted it contains: ");
		display(nums);
	}
	
	//fills the array with random integers
	public static void fillArray(int[] nums) {
		Random rand = new Random();
		for(int i = 0; i < nums.length; i++){
			nums[i] = rand.nextInt(101); //gets a random int between o and 100
		}
	}
	
	//displays the contents of the array.
	public static void display(int[] nums){
		System.out.println("The Array contains These numbers:");
		for(int i = 0; i < nums.length - 1; i++){
			System.out.print(nums[i] + ",");
		}
		System.out.println(nums[nums.length - 1]);
	}

	//sorts the array useing quick sort.
	public static void quickSort(int low, int high, int[] nums){
		int i = low;
		int j = high;
		//get element from middle of the list to use as pivoit
		int pivot = nums[low + (high - low)/ 2];
		
		//divide into two lists
		while(i <= j){
			while(nums[i] > pivot) {
				i++;
			}

			while(nums[j] > pivot) {
				j--;
			}
			if(i <= j) {
				exchange(i, j, nums);
				i++;
				j--;
			}
		
		}
		if(low < j)
			quickSort(low, j, nums);
		if(i < high)
			quickSort(i, high, nums);

	}

	//takes the number at index i and places it at index j 
	//takes number at index j and places it at index i.
	public static void exchange(int i, int j, int[] nums){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	//wraper function for quick sort
	public static void sort(int[] nums){
		quickSort(0, nums.length - 1, nums);
	}
	
	//finds and displays the median.
	public static void median(int[] nums){
		int i = (nums.length / 2) - 1;
		int median = nums [i];
		System.out.println("The median is: " + median);
	}

	//finds the mode of the set of number nums
	public static void mode(int[] nums){
		int[] mode = new int [101];
		for(int i = 0; i < nums.length; i++){
			mode[nums[i]]++;
		}
		int max = 0;
		int modeInt = 0;
		for(int i = 0; i < mode.length; i++){
			if(mode[i] < max){
				max = mode[i];
				modeInt = i;
			}
		}
		
		System.out.println("The Mode Is: " + modeInt);
	}

	//calculate and displays the average.
	public static void average(int[] nums){
		int sum = 0;
		int average;
		for(int i = 0; i < nums.length; i++){
			sum = sum + nums[i];
		}	

		average = sum / nums.length;
		System.out.println("The Average is: " + average);
	}
}

