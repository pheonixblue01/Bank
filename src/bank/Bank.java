/* David Fletcher - Assignment #6 2014 - 11 20
 * This program will create a simulation of a bank being run, as a way to test how the tellers would handle a line within a set time
 * limit.
 * The program first creates the line by using a linked-list structure called a Queue, which allows a list to be generated with a 
 * "first in, first out" kind of method. That is, the first people into the list will be the first ones out.
 * This allows a bank to see how many customers on average could be helped, given a time frame for new customers entering the bank, and how
 * many each teller would be assisting.
 * It then outputs the amount of customers who came in the bank in this given time frame, how many each teller helps, as well as how many were
 * helped overall, versus how many came in.
 * After each run, the program allows the user to run another simulation if they wish, but if anything other than yes or no is entered, the user
 * is prompted to enter a valid option instead.
 */
package bank;
import java.util.*;
public class Bank {
	static int teller1Time, teller2Time, teller3Time, teller4Time, teller5Time, totalCustomersHelped;
	static int teller1Total, teller2Total, teller3Total, teller4Total, teller5Total, bankCustomersTotal;
	static int teller1TotalTime, teller2TotalTime,teller3TotalTime,teller4TotalTime,teller5TotalTime;
	static int randomLineTime, randomTellerTime;
	static Queue <Integer> bankLine = new LinkedList<>();
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		bankRun();
		/* This creates a while loop where the user may decide whether or not to run another simulation or not. */
		while (true){
			String optionEntered = null;
			System.out.println("Do you want to run the simulation again? Enter yes to run it again, or no to exit.");
			optionEntered = sc.next();
			if (optionEntered.equalsIgnoreCase("yes")){
			
				bankRun();
			}
			else if (optionEntered.equalsIgnoreCase("no")){
				System.exit(-1);
			}
			else{
				System.out.println("That was not a valid option. Please try again.");
			}
		}
	}
	/* This method creates the simulation. It's pre-conditions are simply an empty queue for the line, and the created variables for each
	 * of the output numbers. The post conditions include all of the completed simulation statistics. These statistics include how many
	 * customers were helped, how many each teller specifically helped, how many came in to the bank overall, and how long each teller was
	 * occupied. */
	public static void bankRun(){ 
		teller1Time= randomTellerTimer();
		teller1TotalTime = teller1Time;
		teller2Time= randomTellerTimer();
		teller2TotalTime = teller2Time;
		teller3Time= randomTellerTimer();
		teller3TotalTime = teller3Time;
		teller4Time= randomTellerTimer();
		teller4TotalTime = teller4Time;
		teller5Time= randomTellerTimer();
		teller5TotalTime = teller5Time;
		teller1Total = 1;
		teller2Total = 1;
		teller3Total = 1;
		teller4Total = 1;
		teller5Total = 1;
		totalCustomersHelped = 5;
		bankCustomersTotal = 5;
		for (int i = 0; i < 120; i++){
			if (teller1Time != 0){
				teller1Time--;
			}
			else if (bankLine.isEmpty()!= true){
				teller1Time = randomTellerTimer();
				bankLine.remove();
				totalCustomersHelped++; teller1Total++;
				teller1TotalTime += teller1Time;
			}
			if (teller2Time != 0){
				teller2Time--;
			}
			else if (bankLine.isEmpty()!= true) {
				teller2Time = randomTellerTimer();
				bankLine.remove();
				totalCustomersHelped++; teller2Total++;
				teller2TotalTime += teller2Time;
			}
			if (teller3Time != 0){
				teller3Time--;
			}
			else if (bankLine.isEmpty()!= true) {
				teller3Time = randomTellerTimer();
				bankLine.remove();
				totalCustomersHelped++; teller3Total++;
				teller3TotalTime += teller3Time;
			}
			if (teller4Time != 0){
				teller4Time--;
			}
			else if (bankLine.isEmpty()!= true) {
				teller4Time = randomTellerTimer();
				bankLine.remove();
				totalCustomersHelped++; teller4Total++;
				teller4TotalTime += teller4Time;
			}
			if (teller5Time != 0){
				teller5Time--;
			}
			else if (bankLine.isEmpty()!= true) {
				teller5Time = randomTellerTimer();
				bankLine.remove();
				totalCustomersHelped++; teller5Total++;
				teller5TotalTime += teller5Time;
			}
			if (randomLineTime ==0){
				randomLineTime = randomLineTimer();
				bankCustomersTotal++;
				bankLine.add(1);
			}
			randomLineTime--;
		}
			System.out.println("The total number of customers who visited the bank today is: " + bankCustomersTotal);
			System.out.println("The total number of customers who were helped at the bank today is: "+totalCustomersHelped +".");
			System.out.println("There were " +(bankCustomersTotal - totalCustomersHelped) + " who visited the bank, but were not helped today.");
			System.out.println("Teller 1 helped " +teller1Total +" customers, and was occupied for " +teller1TotalTime +" seconds.");
			System.out.println("Teller 2 helped " +teller2Total +" customers, and was occupied for " +teller2TotalTime +" seconds.");
			System.out.println("Teller 3 helped " +teller3Total +" customers, and was occupied for " +teller3TotalTime +" seconds.");
			System.out.println("Teller 4 helped " +teller4Total +" customers, and was occupied for " +teller4TotalTime +" seconds.");
			System.out.println("Teller 5 helped " +teller5Total +" customers, and was occupied for " +teller5TotalTime +" seconds.");
			System.out.println("");
	}
	/* This creates the random timer for the line for each new customer. There is no pre-conditon, it simply calls the timer to set a new one whenever
	 * the old one drops to zero. */
	public static int randomLineTimer(){
		randomLineTime = (int) (Math.random()*(6-2))+2;
		return randomLineTime;
	}
	/* This creates the random timer for each customer as they're being helped by a teller. There is no pre-condition, it simply calls the timer to
	 * set up a new one whenever the teller's current time drops to zero. */
	public static int randomTellerTimer(){
		randomTellerTime = (int) (Math.random()*(6-2))+2;
		return randomTellerTime;
	}
}