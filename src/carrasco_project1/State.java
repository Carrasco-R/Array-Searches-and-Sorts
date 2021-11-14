/**
* Detailed description of the class:
* State.java class is intended to establish the State object with necessary fields.
* It includes getters and setters for all variables and includes a method to print information of the state
*
* @author Ricardo A. Carrasco
* @version 2/5/2021
*/
package carrasco_project1;

public class State {

	//Declaring variables
	public String name;
	public String capital;
	public String region;
	public double population;
	public double numCases;
	public double numDeaths;
	public double medianHouseholdIncome;
	public double crimeRate;
	
	//Object Constructor
	/**
	*Constructor for state object
	*/	
	public State(){
		
	}
	/**
	*Setter method for State variable
	* @param State string
	*/	
	public void setName(String State){
		this.name = State;
	}
	/**
	*Getter method for name variable
	* @return this.name
	*/
	public String getName(){
		return this.name;
	}
	/**
	*Setter method for Capital variable
	* @param Capital string
	*/
	public void setCapital(String Capital){
		this.capital = Capital;
	}
	/**
	*Getter method for Capital variable
	* @return this.capital
	*/
	public String getCapitol(){
		return this.capital;
	}
	/**
	*Setter method for Region variable
	* @param Region string
	*/
	public void setRegion(String Region){
		this.region = Region;
	}
	/**
	*Getter method for region variable
	* @return this.region
	*/
	public String getRegion(){
		return this.region;
	}
	/**
	*Setter method for population variable
	* @param double Population
	*/
	public void setPopulation(double Population){
		this.population = Population;
	}
	/**
	*Getter method for Population variable
	* @return this.population
	*/
	public double getPopulation(){
		return this.population;
	}
	/**
	*Setter method for Number of COVID19 cases variable
	* @param double NumCases
	*/
	public void setNumCases(double NumCases){
		this.numCases = NumCases;
	}
	/**
	*Getter method for numCases variable
	* @return this.numCases
	*/
	public double getNumCases(){
		return this.numCases;
	}
	/**
	*Setter method for number COVID19 deaths variable
	* @param double NumDeaths
	*/
	public void setNumDeaths(double NumDeaths){
		this.numDeaths = NumDeaths;
	}
	/**
	*Getter method for numDeaths variable
	* @return this.numDeaths
	*/
	public double getNumDeaths(){
		return this.numDeaths;
	}
	/**
	*Setter method for median household income variable
	* @param double MedianHouseholdIncome
	*/
	public void setMedianHouseholdIncome(double MedianHouseholdIncome){
		this.medianHouseholdIncome = MedianHouseholdIncome;
	}
	/**
	*Getter method for MedianHouseholdIncome variable
	* @return this.medianHouseholdIncome
	*/
	public double getMedianHouseholdIncome(){
		return this.medianHouseholdIncome;
	}
	/**
	*Setter method for Violent crime rate variable
	* @param double CrimeRate
	*/
	public void setCrimeRate(double CrimeRate){
		this.crimeRate = CrimeRate;
	}
	/**
	*Getter method for crimeRate variable
	* @return this.crimeRate
	*/
	public double getCrimeRate(){
		return this.crimeRate;
	}
	/**
	*Print method for state objects:
	*prints line of space-formatted info of state
	*/
	public void print(){
		System.out.printf("%-16s%-16.0f%-16.1f%-16.6f%-16.2f%-16.2f\n\n",this.getName(), this.getMedianHouseholdIncome(), this.getCrimeRate(),this.getNumDeaths() / this.getNumCases(), (this.getNumCases() / this.getPopulation()) * 100000.00, (this.getNumDeaths() / this.getPopulation()) * 100000.00);
	}
}
