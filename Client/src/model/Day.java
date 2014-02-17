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

	int startTimeH, startTimeM, endTimeH, endTimeM;
	String[] temp, in, checkIns, checkOuts;

	// Every day gets their line of information
	public Day(String dayText) {
		in = dayText.split("\\|");
	}
	public void fisk(){System.out.println("qweqweqewq");}

	public int getStartTimeH() {
		temp = in[1].split(".");
		return Integer.parseInt(temp[0]);
	}

	public int getStartTimeM() {
		temp = in[1].split(".");
		return Integer.parseInt(temp[2]);
	}

	public int getEndTimeH() {
		temp = in[2].split("\\.");
		return Integer.parseInt(temp[0]);
	}

	public int getEndTimeM() {
		temp = in[2].split(".");
		return endTimeM = Integer.parseInt(temp[1]);
	}

	public void addCheckIn() {
		// Needs time to set checkin

	}

	public void addCheckOut() {
		// Needs time to set checkout

	}

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
