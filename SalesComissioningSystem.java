
package SalesComission;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 */
public class SalesComissioningSystem {

	private static int i;

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		double [] ts;  //initializing  total sales(ts) variable. 
		try {

			 //creating a Scanner object to read the input from the file.
			Scanner scan = new Scanner(System.in);
				
				//printing out the title and the file title name.
				 System.out.println("$$$____ Sales Commissioning System ____$$$");
				 System.out.println("\t");
				 System.out.println("Uploading sales data from “M:\\data\\salesData.txt” file.\r\n");
				 		
				 
				 

				// using file path to read the input text file.
			String filePath = "salesDATA.txt";
			// create  a FileReader  to read the file
			FileReader read = new FileReader(filePath);
			//create a scanner object to read the FileReader.
			Scanner sc = new Scanner(read);

			
			int no_of_salesmans = 4; //initializing the variable no_of_salesman and creating an array to store the total sales.
			//creating an array to store the items_sold
			int[] items_sold = new int [no_of_salesmans];
			//creating an array to store total sales(ts).
			ts =new double[no_of_salesmans];
			

			//creating an array for total sales and items sold within a loop. 
			for(int i = 0; i< no_of_salesmans; i++) {

				ts[i] = 0;
				items_sold[i] = 0;
			}
			//initializing the value for salesman(sm).
			int sm = -1; 

			// continues looping while this is another line to read.
			while (sc.hasNextLine()) {
				// reds the next line from the input file and removes the white spaces.
				String line = sc.nextLine().trim();

				// line starts with salesman.
				if (line.startsWith("Salesman")) {
					// take the last character and converts  it into an  integer and subtracts 1 to get the array values.
					sm = Integer.parseInt(line.substring(line.length()-1))-1;


				}
				// sm is greater than equal to 0.
				if (sm >= 0) {
					
					// divides the values into multiple arrays which is easier to read. 
					String[] Array = line.split(" "); 

					// the values are divided into 3 like (item,value,quantity).
					if (Array.length == 3) {
						// obtaining the value.
						double value = Double.valueOf(Array[1]); 
						//obtaining the quantity.
						double quantity = Double.valueOf(Array[2]); 
						// calculating the ts equation.
						ts[sm] += (value * quantity);
						items_sold[sm] += 1;

					}
				}

			}


			// for loop representing i starts from 0 to 4 which is the number of salesman.
			for (int i = 0; i < no_of_salesmans; i++)
			{ 
				// Create a string representing the name as "Salesman" with the incremented index (i + 1).
				String name = "Salesmans " + (i + 1);
				// calculating the total sales(ts) with value * quantity.
				System.out.println("Total Sales for "+ name +" is: "+ ts[i] + "QR");




			}
			//creating a space between lines.
			System.out.println("\t");

			// initializing variables (base_pay,commission,commison1,commission2,percent).
			double base_pay = 70.0;
			double commission = 0;
			double commission1 = 0.11;
			double commission2 = 0.15;
			int percent = 0;
			//printing out enter the reward amount.
			System.out.print("Please Enter the Last Week’s Reward Amount (in QR): " );
			 //initializing the variable reward_amount.
			int Reward_Amount = 0;
			// the user enters  the reward amount and store it in Reward_Amount variable.
			Reward_Amount = scan.nextInt(); 

				System.out.println("\t");
				
				// Calculating  total sales(ts) and earnings based of given values.
			for(int i = 0; i<=3; i++) { 
                
				//checks the items sold according to each salesman.
				if(items_sold[i] >= no_of_salesmans ) { 
					//equation for commission.
					commission = commission2 * ts[i];

					percent = 15;
				}
				else {

					commission = commission1 * ts[i];
					percent = 11;
				}


				double earnings = base_pay + commission + Reward_Amount;
				//printing out total earnings.
				System.out.println("Net Earnings (with " + percent +"% commission) for Salesman " + (i+1) + " is: " + earnings + " QR" );
				
			}







			//closing scanner function.
			sc.close();		



		} 
		//catch exception
		catch (NumberFormatException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}









