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

public class Day {
	Boolean checkedIn;
	int startTimeH, startTimeM, endTimeH, endTimeM;
	String[] temp, in, checkIns, checkOuts;
	String wholeDay;

	// Every day gets their line of information
	/**
	 * @param dayText a string line with the selected days information
	 */
	public Day(String dayText) {
		wholeDay = dayText;
		in = dayText.split("\\|");
		checkedIn = false;
	}

	/**
	 * @return The start hour the selected day
	 */
	public int getStartTimeH() {
		temp = in[1].split(".");
		return Integer.parseInt(temp[0]);
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

	/**
	 * @param hour The hour of which you pressed checkIn
	 * @param minute The minute of which you pressed checkIn
	 */
	public void addCheckIn(int hour, int minute) {
		if(!checkedIn){
			checkedIn = true;
			//skriver tiden till schematexten
		}

	}

	/**
	 * @param hour The hour of which you pressed checkOut
	 * @param minute The minute of which you pressed checkOut
	 */
	public void addCheckOut(int hour, int minute) {
		if(checkedIn){
			checkedIn = false;
			//ska skriver tiden till schematexten
		}
	}

	//Ändra till tiderna efter starttid|stoptid, 
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
