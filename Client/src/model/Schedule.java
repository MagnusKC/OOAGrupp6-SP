/**
 * Write a description of class Schedule here.
 * 
 * @author Magnus Källten
 * @version 2013-02-15
 */

//

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Schedule {
	private String line /*, scheduleString*/;
	private Calendar calendar;
	private int currentWeek;
	private int currentDay; //Sunday 1, Monday 2, ... , Saturday 7
	private BufferedReader reader;
	//private Boolean isCheckedIn;
	private HashMap<String, Day> weekMap;
	private String[] temp;
	
	/**
	 * @throws IOException
	 */
	public Schedule(/* string from comm. File scheduleString */) throws IOException {
		
		calendar = new GregorianCalendar();
		currentWeek  = calendar.get(Calendar.WEEK_OF_YEAR);
		currentDay = calendar.get(Calendar.DAY_OF_WEEK);
		weekMap = new HashMap<String, Day>();
		
		System.out.println("Week:" + currentWeek + " Day:" + currentDay);
		
		try  { 
			reader = new BufferedReader(new FileReader(
					"/home/magnusk/workspace/Projekt-SP/OOAGrupp6-SP/schema1.txt"));
					//Will be replaced by txtfile from constructor: scheduleFile
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	//Will return a Week object of the chosen week of the year
	/**
	 * @param chosenWeek
	 * @return Returns a HashMap containing a Day object for every day of the chosen week. The keys are the first 3 letters of the week day.
	 * @throws IOException
	 */
	public HashMap<String, Day> getWeekMap(int chosenWeek) throws IOException {
		int i = 0;
		Boolean rightWeek = false;
		
		//Not sure if the reader actually reads the file here or if this section of code just compiles
		while ((line = reader.readLine()) != null && i<7) {
			//System.out.println(line);
			if (line.length() == 1 && Integer.parseInt(line) == chosenWeek) {
				rightWeek = true;
				line = reader.readLine(); //Ugly solution
			}
			if(rightWeek){
				temp = line.split("\\|");
				weekMap.put(temp[0], new Day(line));
				i++;
			}
		}
		return weekMap;
	}
/*
	Week getNextWeek() {
		return week;
	}
*/

	void checkin() {
		
	}

	void checkout() {

	}

	void modifySchedule() {

	}

	// void modifySchedule([]) {
	// }

}
