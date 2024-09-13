/*
Program name: ConstructionCosts
Description: Program to calculate the costs of constructing a data center
@Alex Thach
@1.8.0_422
255-001
*/
import java.util.Scanner;



public class ConstructionCosts{
	public static void main(String[] args){
		
		//Initialized constant variables
		final int MIN = 100_000;
		final int MAX = 10_000_000;
		final int SMALL_SERVER_CAP= 5000;
		final int MED_SERVER_CAP = 10000;
		final int LARGE_SERVER_CAP = 50000;
		final double SMALL_SERVER_COST = 25000;
		final double MED_SERVER_COST = 40000;
		final double LARGE_SERVER_COST = 125000;
		
		//Initialized variables
		boolean solarPanelsReal;
		String incInp = "Incorrect Input";
		String solarPanels;
		String repeat;
		int a;
		int f;
		int totClients;
		int remClients;
		int clientChoice;
		int largeServAmt;
		int medServAmt;
		int smallServAmt;
		double materials = 0;
		double wages = 0;
		double totalCosts = 0;
		double solarCosts = 0;
		double serverCosts = 0;
		
		//Scanner object declared
		Scanner input = new Scanner(System.in);
		

		//While true loop that ends if only the user decides not to continue
		while(true){
			//Variables are set to 0 at the beginning incase if the program is looped back
			largeServAmt = 0;
			medServAmt = 0;
			smallServAmt = 0;
			solarCosts = 0;
			
			//Prompts user to input data centers square footage and assigns the input to a
			System.out.println("Enter the data centers square footage:");
			a = input.nextInt();
			input.nextLine().trim();
			
			//Prompts user to input the amount of stories the building will have and assign the input to f
			System.out.println("Enter the number of stories:");
			f = input.nextInt();
			input.nextLine().trim();
		
			//Prompts user to either generate a random number of clients or to input it in themselves, 1 = random , 2 = self input
			System.out.println("Would you like to randomly generate a number of clients (1) or enter it yourself (2)?");
			clientChoice = input.nextInt();
			input.nextLine().trim();
			
			//If the client chooses 1 then a random number is generated between 100,000 and 10,000,000
			if(clientChoice == 1){
				totClients =(int) (Math.random() * (MAX - MIN + 1)) + MIN;
				System.out.println(totClients);
			}
			//If the client chooses 2 then the user inputs their own total clients
			else if(clientChoice == 2){
			
				System.out.println("Enter a number of clients between 100,000 and 10,000,000:");
				totClients = input.nextInt();
				input.nextLine().trim();
				//If the user inputs less than 100,000 and greater than 10,000,000 it would restart the loop and it would print "incorrect input" before.
				if(totClients < 100_000 || totClients > 10_000_000){
					System.out.println(incInp);
					continue;
				}
			}
			//If the user decides to input not 1 or 2 the loop restarts and outputs "incorrect input" before
			else{
				System.out.println(incInp);
				continue;
			}
		
			//Prompts the user to respond with yes or no if solar panels will be used
			System.out.println("Will solar panels be used?");
			solarPanels = input.nextLine().toLowerCase();
		
			//If user responds with yes then solarCosts will be calculated along with materials and wages, boolean variable solarPanelReal will be set to true
			if(solarPanels.equals("yes")){
				solarCosts = (15 * a);
				materials = (30 * f * a);
				wages = (100 * Math.sqrt(a));
				solarPanelsReal = true;
			}
			//If user responds with no then solarCosts will not be calculated, but materials and wages will be, and boolean variable solarPanelReal will be set to false
			else if(solarPanels.equals("no")){
				materials = (30 * f * a);
				wages = (100 * Math.sqrt(a));
				solarPanelsReal = false;
			}
			//If user does not respond with yes or no the loop restarts and will print "incorrect input" before
			else{	
				System.out.println(incInp);
				continue;
			}
			//LargeServAmt is calculated
			largeServAmt = totClients / LARGE_SERVER_CAP;
			remClients = totClients % LARGE_SERVER_CAP;
			
			
			//MedServAmt is calculated if remClients > 0 , also possibly smallServAmt if the conditions are met
			if(remClients > 0){
				if(remClients <= 5000){
					smallServAmt++;
				}else{
					medServAmt = remClients / MED_SERVER_CAP;
					remClients =  remClients %  MED_SERVER_CAP;
					if(remClients > 0 && remClients <= 5000){
						smallServAmt++;
					}else if(remClients > 5000){
						medServAmt++;
					}
				}
			}


			
			
			
			//ServerCosts are calculated with (server size amount * server size cost) + (server size amount * server size cost) + (server size amount * server size cost)
			serverCosts = (largeServAmt  * LARGE_SERVER_COST) + (medServAmt * MED_SERVER_COST) + (smallServAmt * SMALL_SERVER_COST);
			
			//If solarPanelsReal = true than totalCosts would include solarCosts, if not then it wont
			if(solarPanelsReal ==  true){
				totalCosts = materials + wages + serverCosts + solarCosts;
			}
			else{
				totalCosts = materials + wages + serverCosts;
			}
			
			//Prints out the cost for the data center and the amount of servers needed by size
			System.out.printf("Your data center will cost" + " " + "$%,.2f" + "\n", totalCosts);
			System.out.printf("To serve" + " " + "%,d" + " " + "clients this data center will need:" + "\n" , totClients);
			System.out.println(largeServAmt + " " + "large server(s)");
			
			//Prints medium server amount
			if(medServAmt != 0){
				System.out.println(medServAmt + " " + "medium server(s)");
			}
			//Prints small server amount
			if(smallServAmt != 0){
				System.out.println(smallServAmt + " " + "small server(s)");
			}
			
			
			
			//Prompts the user if they would like to keep calculating, they must respond with yes, and any other answer would end the loop.
			System.out.println("Would you like to calculate the cost of another data center? Enter yes to continue");
			repeat = input.nextLine().trim();
			if(repeat.equals("yes")){
				continue;
			}
			else{
				break;
			}
			
			
		}
		
		
	}
}