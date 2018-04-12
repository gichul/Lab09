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
	public void getData() { 
		team = new Salesman[numOfSalesman]; 
		Scanner myScanner = new Scanner(System.in); 


		for(int i=0; i<numOfSalesman; i++) { 

			System.out.println("Enter data for associate number"+(i+1)); 

			System.out.println("Enter name:"); 
			String name = myScanner.nextLine(); 

			System.out.println("Enter Sales:");
			Double sales = myScanner.nextDouble(); 
			
			myScanner.skip("\\r\n"); 

			Salesman mySalesman = new Salesman(); 

			mySalesman.setmName(name);	
			mySalesman.setSales(sales); 

			team[i] = mySalesman;
			
		}


	}
	
	/**
	 * This method calculate the average of sales and store the value in the variable averageSales
	 */
	public void calculateAverageSales() {
		double sum=0; 

		for(int i=0; i<team.length; i++) 
		{
			double sales= team[i].getSales(); 
			sum=sum+sales; 
		}
		averageSales = sum/team.length; 
	}


	public void highestSales() { 
		
		for(int i=0; i<team.length-1;i++) { 
			if(team[i].getSales()<team[i+1].getSales()) { 
				highestSales=team[i+1].getSales(); 
			}
		}
		
	}

	
	
	
	public void printOutResults() { 

		System.out.println("Average sales per associate is $" + averageSales); //Print out the averageSales
		System.out.println("Highest sales figure is $"+ highestSales); //Print out the highestSales
		
		System.out.println("The Highest sales guy:"); //Print out the highest salesman's data

		for(int i=0; i<team.length; i++) { 
			
			if(team[i].getSales() == highestSales) {
				System.out.println("Name : "+team[i].getmName()); 
				System.out.println("Team : "+team[i].getSales()); 
			}
		}

		System.out.println("The Rest performed as follow: ");
		
		for(int i=0; i<team.length; i++) { 
			if(team[i].getSales() != highestSales) {
				System.out.println("Name : "+team[i].getmName()); 
				System.out.println("Sales : "+team[i].getSales()); 
				
				double temp = averageSales - team[i].getSales();
				if(temp>0) 
					System.out.println(Math.abs(temp)+ " below the average."); 
				else if(temp<0) 
					System.out.println(Math.abs(temp)+ " above the average."); 
				else
					System.out.println("equivalent to the average."); 
			}
		}
	}

}



class Salesman { //Declare the class Salesman

	private String mName; 
	private double sales; 
	

	public Salesman() {
		   mName = ""; 
		   sales = 0;
	}
	

	public String getmName() { 
		return mName; 
	}
	

	
	public void setmName(String mName) { 
		this.mName = mName; 
	}


	public double getSales() { 
		return sales; 
	}


	public void setSales(double sales) { 
		this.sales = sales; 
	}

}