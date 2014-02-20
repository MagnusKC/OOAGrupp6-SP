/**
 * Write a description of class Schedule here.
 * 
 * @author Magnus Källten
 * @version 2013-02-15
 */

//

package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Schedule {
	private String line/*, scheduleString*/;
	private Calendar cal;
	private int currentWeek;
	private int currentDay; //Sunday 1, Monday 2, ... , Saturday 7
	private BufferedReader reader;
	public Boolean isCheckedIn;
	//private Boolean isCheckedIn;
	//private HashMap<String, Day> weekMap; //HashMap
	//private String[] temp; //temporary string array
	public Day[] weekArray; //Sunday 1, Monday 2, ... , Saturday 7
	public int[] checkInsOuts;
	
	/**
	 * @throws IOException
	 */
	public Schedule(/* object from comm. Obj scheduleStringObj */) throws IOException {
		
		weekArray = new Day[8];
		cal = new GregorianCalendar();
		cal.setFirstDayOfWeek(Calendar.MONDAY); // Works as intended ! MONDAY (2) is now the first day of the week and affects WEEK_OF_YEAR
		currentWeek  = cal.get(Calendar.WEEK_OF_YEAR); //Since "DAY_OF_WEEK" makes Sunday day 1, I'm wondering how it handles weeks. Does a new week happen on a sunday?
		currentDay = cal.get(Calendar.DAY_OF_WEEK);
		isCheckedIn = false;		
		
		System.out.println("Week:" + currentWeek + " Day:" + currentDay + " Hour:" + cal.get(Calendar.HOUR_OF_DAY) + " Minute:" + cal.get(Calendar.MINUTE) + " Seconds:" + cal.get(Calendar.SECOND));
				
		try  { 
			reader = new BufferedReader(new FileReader(
					"schema1.txt"));
					//Will be replaced by txtfile from constructor: scheduleFile
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		weekArray = getWeekArray(currentWeek);
		System.out.println(weekArray[1].in[1]);
	}

	/**
	 * @param chosenWeek The number of the week you'd like to get. (1-52)
	 * @return Returns a Day array containing a Day object for every day of the chosen week. Sunday = 1, Monday = 2, ..., Saturday = 6
	 * @throws IOException
	 */
	public Day[] getWeekArray(int chosenWeek) throws IOException {
		int i = 1;
		Boolean rightWeek = false;
		
		while ((line = reader.readLine()) != null && i<7) {
			//System.out.println(line);
			if (line.length() == 1 && Integer.parseInt(line) == chosenWeek) {
				rightWeek = true;
				line = reader.readLine(); //Ugly solution
			}
			if(rightWeek){
				weekArray[i+1] = new Day(line);
				i++;
			}
		}
		return weekArray;
	}
	
	/**
	 * Adds the time of the checkin to the correct string
	 */
	//Kopplas till actionhandler?
	//Kolla förra dagens isCheckedIn? (Kräver boolean i Day)
	public void checkIn() {
		if(!weekArray[currentDay].isCheckedIn || !weekArray[getYesterday()].isCheckedIn){
			isCheckedIn = true;
			weekArray[currentDay].wholeDay += ("|"+cal.get(Calendar.HOUR_OF_DAY)+"."+cal.get(Calendar.MINUTE));
		}
		
	}
	/**
	 * Adds the time of the checkout to the correct string
	 */
	//Kolla förra dagens isCheckedIn? (Kräver boolean i Day)
	public void checkOut() {
		if(weekArray[currentDay].isCheckedIn || weekArray[getYesterday()].isCheckedIn){
			isCheckedIn = false;
			weekArray[currentDay].wholeDay += ("|"+cal.get(Calendar.HOUR_OF_DAY)+"."+cal.get(Calendar.MINUTE));
		}
	}
	/**
	 * @param chosenDay
	 * @return An int array with the times of check ins(1) and check outs(2), with the check in first and check out second. [1,2,1,2,1,2...]
	 * Is not yett made for over night check ins//Är fel, vill ha dagen innan, calendar.YESTERDAY?
	 */
	
	
	private int getYesterday(){
		if(currentDay == 1){
			return 7;
		}
		return currentDay-1;
	}

	//Skall kunna köras utan inparameter med hjälp av cal get current day och tid
	void checkin() {
		//cal.get(Calendar.HOUR);
		//cal.get(Calendar.MINUTE);
		
		
	}

	//Skall kunna köras utan inparameter med hjälp av cal get current day och tid
	void checkout() {

	}

	//Vet ej vad denna skall göra
	void modifySchedule() {

	}

	//void modifySchedule([]) {
	//}

}
