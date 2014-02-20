/**
 * Write a description of class Day here.
 * 
 * @author Magnus Källten
 * @version 2013-02-15
 */

/*
 Schema uppbyggnad

 Object f�r varje dag, h�ller reda p� n�dv�ndig information.

 Object lagras i n�ngon form av lista eller tree set.

 */

//To do: Time management, so that you can set time '0800' for example, aswell as get
//		 

package model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Day {
	Calendar cal = new GregorianCalendar();
	Boolean isCheckedIn;
	int startTimeH, startTimeM, endTimeH, endTimeM;
	public String[] temp, checkIns, checkOuts;
	public String[] in = new String[100];
	public String wholeDay;
	public int[] checkInsOuts;

	// Every day gets their line of information
	/**
	 * @param dayText a string line with the selected days information
	 */
	public Day(String dayText) {
		wholeDay = dayText;
		in = dayText.split("(\\.)|(\\|)");
		isCheckedIn = false;
		
		for(int i=0; i<in.length; i++){ //Ska skapa en int array av in
			
			
		}
	}

	/**
	 * @return The start hour the selected day
	 */
	public int getStartTimeH() {
		return 0;
		/*temp = in[1].split(".");
		return Integer.parseInt(temp[0]);*/
	}

	/**
	 * @return The start minute the selected day
	 */
	public int getStartTimeM() {
		temp = in[1].split(".");
		return Integer.parseInt(temp[2]);
	}

	/**
	 * @return The end hour the selected day
	 */
	public int getEndTimeH() {
		temp = in[2].split("\\.");
		return Integer.parseInt(temp[0]);
	}

	/**
	 * @return The start minute the selected day
	 */
	public int getEndTimeM() {
		temp = in[2].split(".");
		return endTimeM = Integer.parseInt(temp[1]);
	}

	public int[] getCheckInsOuts(){
		temp = Arrays.copyOfRange(in, 2, in.length);
		//temp = temp.split(".");
		checkInsOuts = new int[temp.length];
		
		//checkInsOuts = weekArray[chosenDay].in;
		return checkInsOuts;
	}
	//Ändra till tiderna efter starttid|stoptid. Onödiga metoder?
	public String[] getCheckIns() {
		
		return checkIns;
	}

	public String[] getCheckOuts() {
		return checkOuts;
	}

	// Admin method
	public void setStartTime() {

	}

	// Admin method
	public void setEndTime() {

	}
}
