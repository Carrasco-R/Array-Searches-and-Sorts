package carrasco_project1;

import java.util.Scanner;
import java.io.*;
import java.math.*;
/**
* COP 3530: Project 1 – Array Searches and Sorts
* Project1 class facilitates main portion of project, prompts user for csv file, reads file, and then prompts user with options menu which enables user to sort StatesArray or search statesArray for a certain state.
* @author Ricardo A Carrasco
* @version 2/5/2021
*/
public class Project1 {
	/**
	* readStates method takes in a fileName, creates a stateArray and uses a scanner to parse data into the State object array
	* @param String fileName
	* @return StateArray[] with 50 states
	*/
	private static State[] readStates(String fileName) {
		Scanner fscnr;
		String templn;
		int throwawayNum;
		int numRecords = 0;
		State[] stateArray = new State[50];
		try {
			fscnr = new Scanner(new File(fileName));
			templn = fscnr.nextLine();
			
			while(fscnr.hasNextLine()){
				templn = fscnr.nextLine();
				Scanner Sscnr = new Scanner(templn).useDelimiter(",");
				stateArray[numRecords] = new State();
				stateArray[numRecords].setName(Sscnr.next());
				stateArray[numRecords].setCapital(Sscnr.next());
				stateArray[numRecords].setRegion(Sscnr.next());
				throwawayNum = Sscnr.nextInt();
				stateArray[numRecords].setPopulation(Sscnr.nextDouble());
				stateArray[numRecords].setNumCases(Sscnr.nextDouble());
				stateArray[numRecords].setNumDeaths(Sscnr.nextDouble());
				stateArray[numRecords].setMedianHouseholdIncome(Sscnr.nextDouble());
				stateArray[numRecords].setCrimeRate(Sscnr.nextDouble());
				numRecords++;
			}
			System.out.println("\nThere were " + numRecords + " records read.");
			fscnr.close();	
		}
		catch(IOException e){
			System.out.println("Could not find file");
		}
		return stateArray;
		
		
	}
	/**
	* bubbleSort method takes in statesArray and sorts it using bubble sort method and return the array with states sorted alphabetically
	* @param State[] statesArray
	* @param int num
	*/
	private static void bubbleSort(State[] statesArray, int num) {
		for(int outer = 0; outer < num - 1; outer++) {
			for(int inner = num - 1; inner > outer; inner--) {
				if((statesArray[inner].getName().compareToIgnoreCase(statesArray[inner - 1].getName())) < 0) {
					State temp = statesArray[inner];
					statesArray[inner] = statesArray[inner -1];
					statesArray[inner - 1] = temp; 
				}
			}
		}
		
	}
	/**
	* selectionSort takes in statesArray and number of elements in array, sorts State[] using selection sort based on Case fatility rate ascendingly
	* @param State[] statesArray
	* @param int n
	*/
	private static void selectionSort(State[] statesArray, int n) {
		for(int outer = 0; outer < n - 1; outer++) {
			int lowest = outer;
			for(int inner = outer + 1; inner < n; inner++) {
				if(Math.min((statesArray[inner].getNumDeaths() / statesArray[inner].getNumCases()),(statesArray[lowest].getNumDeaths() / statesArray[lowest].getNumCases())) == (statesArray[inner].getNumDeaths() / statesArray[inner].getNumCases()) ) {
					lowest = inner;
				}
			}
			if(lowest != outer) {
				State temp = statesArray[lowest];
				statesArray[lowest] = statesArray[outer];
				statesArray[outer] = temp;
			}
		}
	}
	/**
	* insertionSort takes in statesArray and number of elements, sorts using insertion sort by median household income ascendingly
	* @param State[] statesArray
	* @param int num
	*/
	private static void insertionSort(State[] statesArray, int num) {
		int inner;
		int outer;
		for(outer = 1; outer < num; outer++) {
			State temp = statesArray[outer];
			inner = outer - 1;
			while(inner >= 0 && statesArray[inner].getMedianHouseholdIncome() > temp.getMedianHouseholdIncome()) {
				statesArray[inner + 1] = statesArray[inner];
				inner--;
			}
			statesArray[inner + 1] = temp;
		}
		
	}
	/**
	* binarySearch method takes in statesArray, the users input for state to be searched, and number of elements
	* @param State[] statesArray
	* @param String userStateChoice
	* @param int num
	*/
	private static void binarySearch(State[] statesArray, String userStateChoice, int num) {
		int lowerBound = 0;
		int upperBound =  num - 1;
		int mid;
		while(lowerBound <= upperBound) {
			mid = (lowerBound + upperBound) / 2;
			if(statesArray[mid].getName().equalsIgnoreCase(userStateChoice)) {
				System.out.printf("\n%-16s%-16s","Name:",statesArray[mid].getName());
				System.out.printf("\n%-16s%-16.0f","MHI:",statesArray[mid].getMedianHouseholdIncome());
				System.out.printf("\n%-16s%-16.1f","VCR:",statesArray[mid].getCrimeRate());
				System.out.printf("\n%-16s%-16.6f","CFR:",statesArray[mid].getNumDeaths() / statesArray[mid].getNumCases());
				System.out.printf("\n%-16s%-16.2f","Case Rate:",(statesArray[mid].getNumCases() / statesArray[mid].getPopulation())*100000.00);
				System.out.printf("\n%-16s%-16.2f\n\n","Death Rate",(statesArray[mid].getNumDeaths() / statesArray[mid].getPopulation())*100000.00);
				return; //FOUND IT
			}
			else if(statesArray[mid].getName().compareToIgnoreCase(userStateChoice) > 0) {
				upperBound = mid - 1;
			}
			else {
				lowerBound = mid + 1;
			}
		}
		System.out.println("\nError: State not found.\n");
		return; //DIDNT FIND
	}
	/**
	* sequentialSearch method takes in statesArray, the users state choice, and number of elements
	* @param State[] statesArray
	* @param String userStateChoice
	* @param int i
	*/
	private static void sequentialSearch(State[] statesArray, String userStateChoice, int i) {
		int j = 0;
		while(j < i) {
			if(statesArray[j].getName().equalsIgnoreCase(userStateChoice)) {
				break;
			}
			j++;
		}
		if(j == i) {
			System.out.println("\nError: State not found.\n");
			return;
		}
		else {
			System.out.printf("\n%-16s%-16s","Name:",statesArray[j].getName());
			System.out.printf("\n%-16s%-16.0f","MHI:",statesArray[j].getMedianHouseholdIncome());
			System.out.printf("\n%-16s%-16.1f","VCR:",statesArray[j].getCrimeRate());
			System.out.printf("\n%-16s%-16.6f","CFR:",statesArray[j].getNumDeaths() / statesArray[j].getNumCases());
			System.out.printf("\n%-16s%-16.2f","Case Rate:",(statesArray[j].getNumCases() / statesArray[j].getPopulation())*100000.00);
			System.out.printf("\n%-16s%-16.2f\n\n","Death Rate",(statesArray[j].getNumDeaths() / statesArray[j].getPopulation())*100000.00);
			return;
		}
	}
	/**
	* main method starts program and prompts user for file to read, once it reads file it prompts the user with a menu with choices 1 - 7
	* 1: prints info for all states
	* 2: sorts states alphabetically
	* 3: sorts states based on CFR
	* 4: sorts based on median household income 
	* 5. searches for state
	* 	-If sorted alphabetically, searches using binary search
	* 	-if not, sequential search is used
	* 6. spearmans rho
	* 7. quit
	*/
	public static void main(String[] args){
		Scanner scnr = new Scanner(System.in);
		String fileName;
		String userStateChoice;
		int userChoice = 1;
		boolean quit = false;
		boolean nameSorted = false;
		int tempNum = -1;
		
		//Intro
		System.out.println("COP3530 Project 1");
		System.out.println("Instructor: Xudong Liu\n");
		System.out.println("Array Searches and Sorts");
		System.out.print("Enter the file name: ");
		
		fileName = scnr.next();
		State[] StatesArray = readStates(fileName);
		
		//Prompts Menu which repeats
		while(quit == false) {
			System.out.println("1. Print a States report");
			System.out.println("2. Sort by Name");
			System.out.println("3. Sort by Case Fatality Rate");
			System.out.println("4. Sort by Median Household Income");
			System.out.println("5. Find and print a given State");
			System.out.println("6. Print Spearman’s rho matrix");
			System.out.println("7. Quit");
			//Input validation
			do {
				tempNum++;
				if(tempNum == 0){
					System.out.print("Enter your choice: ");
				}
				else if(tempNum > 0) {
					System.out.print("Invalid choice enter 1-6:");
				}
			    while (!scnr.hasNextInt()) {
			        System.out.print("Invalid choice enter 1-6:");
			        scnr.next();
			    }
			    userChoice = scnr.nextInt();
			} while(userChoice < 1 || userChoice > 7);	
			tempNum = -1;
			//Switch case to handle user option
			switch(userChoice) {
				case 1:
					System.out.println("Name\t\tMHI\t\tVCR\t\tCFR\t\tCase Rate\tDeath Rate");
					System.out.println("------------------------------------------------------------------------------------------");
					for(int i = 0; i < 50; i++ ){
						StatesArray[i].print();
					}
					break;
				case 2:
					bubbleSort(StatesArray, 50);
					System.out.println("\nStates sorted by name.\n");
					nameSorted = true;
					break;
				case 3:
					selectionSort(StatesArray, 50);
					System.out.println("\nStates sorted by COVID-19 Case Fatality Rate.\n");
					nameSorted = false;
					break;
				case 4:
					insertionSort(StatesArray, 50);
					System.out.println(userChoice);
					nameSorted = false;
					break;
				case 5:
					System.out.println("Enter state name: ");
					scnr.nextLine();
					userStateChoice = scnr.nextLine();
					if(nameSorted == true) {
						//Binary Search
						System.out.println("\nBinary search");
						binarySearch(StatesArray, userStateChoice, 50);
					}
					else {
						//Sequential Search
						System.out.println("\nSequential search");
						sequentialSearch(StatesArray, userStateChoice, 50);
					}
					break;
				case 6:
					System.out.println(userChoice);
					break;
				case 7:
					System.out.println("Have a good day!");
					quit = true;
					break;
					
			}
		}
	}
}