package handong.edu.csee.java.Lab09; //Declare the package handong.edu.csee.java.lab09 including class Salesman.java

import java.util.Scanner; //Import the class Scanner in the package java.util

/**
 * This progam is making a SalesReporter using many method, constructor 
 * first i declared the private variable highestSales,averageSales, sales.. etc 
 * @author gichul
 *
 */
public class SalesReporter { // Declare the class SalesReporter

	private double highestSales; //Declare the highestSales to double type 
	private double averageSales; //Declare the averageSales to double type 


	private double sales;  //Declare the Sales to double type
	private int numOfSalesman; //Declare the numOfSalesman to int type
	private Salesman[] team; //Declare the Sales to array type

	/**
	 * this is constructor of SalesReporter, and input the number of salesman
	 */
	public SalesReporter() {  //Declare the constructor
		System.out.println("Enter number of salesman"); //print the statement on console
		Scanner myScanner = new Scanner(System.in); //reference variable to input data

		numOfSalesman = myScanner.nextInt(); //Input the number to numOfSalesman
		myScanner.skip("\\r\n"); // use this statement to delete the white spaces
	}

	/**
	 * This method is the main method and make the reference variable to get data 
	 * 
	 * @param argv is not used, all the input is only through the keyboard
	 */
	public static void main(String[] argv) { //Declare the main method

		SalesReporter myReporter = new SalesReporter(); //Declare the reference of the class SalesReporter
		myReporter.getData(); // Call the method getData, and this method let users input the Salesman's data
		myReporter.calculateAverageSales(); //Call the method that calculate the average of sales
		myReporter.highestSales(); // Implement the method that check the highest sales
		myReporter.printOutResults(); //Implement the method that print out the result
	}

	/**
	 * This method is getter of sales
	 * @return value of sales as double type
	 */
	public double getSales() { //Declare the getter of sales
		return sales; //return the value of sales
	}
	
	/**
	 * This method is setter of sales
	 * @param the value of sales
	 */
	public void setSales(double sales) { //Declare the setter of sales
		this.sales = sales; //set the sales
	}
	
	/**
	 * This method let user input the information of salesman as the number of salesman
	 */
	public void getData() {  //declare getData to input data into private information
		team = new Salesman[numOfSalesman]; 	//input the number Of Salesman into Salesman
		Scanner myScanner = new Scanner(System.in);  //reference variable to input data


		for(int i=0; i<numOfSalesman; i++) {   //repetition to get data from user

			System.out.println("Enter data for associate number"+(i+1));   // print the associate number of salesman on console

			System.out.println("Enter name:"); //to show the statement on console 
			String name = myScanner.nextLine(); //get data from user

			System.out.println("Enter Sales:"); //to show the statement on console 
			Double sales = myScanner.nextDouble();  //get data from user
			
			myScanner.skip("\\r\n");  //use this statement to remove the white spaces

			Salesman mySalesman = new Salesman(); //Declare the reference of the class Salesman

			mySalesman.setmName(name);	//input the data to setName(name)
			mySalesman.setSales(sales); //input the data to setSales(sales)

			team[i] = mySalesman; //input the number of salesman
			
		}


	}
	
	/**
	 * This method calculate the average of sales and store the value in the variable averageSales
	 */
	public void calculateAverageSales() { //Declare the method calculateAverageSales
		double sum=0; //Declare the double type variable sum, and initialize it to 0

		for(int i=0; i<team.length; i++) //Add all of sales by iteration
		{
			double sales= team[i].getSales(); //Declare the variable and store ith salesman's sales in the variable  
			sum=sum+sales; //Accumulate the value of sales 
		}
		averageSales = sum/team.length; // Addition of all sales devide by number of salesman
	}

	/**
	 * This method check who is man of highest sales, and store the highest sales in the variable highestSales
	 * It compare all the sales of members of array by using iteration
	 */
	public void highestSales() { //Declare the method highestSales
		
		for(int i=0; i<team.length-1;i++) { // compare all the sales of salesman by iteration
			if(team[i].getSales()<team[i+1].getSales()) { //compare i th salesman with (i+1) th salesman, and if (i+1)th salesman's sale is bigger
				highestSales=team[i+1].getSales(); // highest sales store the (i+1)th salesman's sales 
			}
		}
		
	}

	/**
	 * This method print out the result
	 * The result include the average, highest sales and salesman with highest sales, the other salesmen's data
	 */
	public void printOutResults() { //Declare the method printOutResult

		System.out.println("Average sales per associate is $" + averageSales); //Print out the averageSales
		System.out.println("Highest sales figure is $"+ highestSales); //Print out the highestSales
		
		System.out.println("The Highest sales guy:"); //Print out the highest salesman's data

		for(int i=0; i<team.length; i++) { //Check the highest salesman by using iteration

			if(team[i].getSales() == highestSales) {//If find the man with highest value
				System.out.println("Name : "+team[i].getmName()); //Print out name of the man
				System.out.println("Team : "+team[i].getSales()); //Print out sales of the man
			}
		}

		System.out.println("The Rest performed as follow: "); //Print out the rest performed data

		for(int i=0; i<team.length; i++) { //all the member(salesman) of Array print out by using iteration
			if(team[i].getSales() != highestSales) { //In condition excluding the men with highest sales
				System.out.println("Name : "+team[i].getmName()); //Print out the name of salesman
				System.out.println("Sales : "+team[i].getSales()); //Print out the sales of salesman
				
				double temp = averageSales - team[i].getSales(); // This variable stored subtraction ith salesman's sales from average
				if(temp>0) // If average is bigger than sales 
					System.out.println(Math.abs(temp)+ " below the average."); //Print out the sales with message "below the average"
				else if(temp<0) //If average is smaller than sales
					System.out.println(Math.abs(temp)+ " above the average."); //Print out the sales with message "above the average"
				else// If average is same with sales
					System.out.println("equivalent to the average."); //Print out the sales with message "equivalent to the average"
			}
		}
	}

}


/**
 * This class had salesman's constructor and getter and setter of its member.
 * 
 * @author gichul
 *
 */
class Salesman { //Declare the class Salesman

	private String mName; // Declare the string type variable mName, where salesmen's names are stored in
	private double sales; //Declare the double type variable sales, where sales are stored in

	/**
	 * This is constructor of the class Salesman
	 * The member of this is mName, salesman's name and sales, salesman's sales
	 */
	public Salesman() { //Declare the constructor of the class Salesman
		mName = ""; //mName is salesman's name and initialized to ""
		sales = 0; //sales is sales of salesman and initialized to 0 
	}

	/**
	 * This method is getter of mName
	 * @return mName, salesman's name
	 */
	public String getmName() { //Declare the getter of mName
		return mName; //return the mName
	}

	/**
	 * This method is setter of mName
	 * @param mName, salesman's name
	 */
	public void setmName(String mName) { //Declare the setter of mName
		this.mName = mName; // Set the mName
	}

	/**
	 * This method is getter of Sales
	 * @return Sales, sales of salesman
	 */
	public double getSales() { //Declare the getter of sales
		return sales; //Return the sales
	}

	/**
	 * This method is setter of Sales
	 * @param sales, sales of salesman
	 */
	public void setSales(double sales) { //Declare the setter of sales
		this.sales = sales; //set the sales
	}

}
