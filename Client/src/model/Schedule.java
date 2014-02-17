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
	//private Week selectedWeek;
	private File scheduleFile;
	private String line;
	private Calendar calendar = new GregorianCalendar();
	private String[] weekLines;
	private int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
	private int currentDay = calendar.get(Calendar.DAY_OF_WEEK); //Sunday 1, Monday 2, ... , Saturday 7
	private BufferedReader reader;
	private Boolean isCheckedIn;
	private HashMap<String, Day> weekMap = new HashMap<String, Day>();
	private String[] temp = new String[20];
	
	// lokal textfil för,

	
	//Should have the txtfile for 1 persons entire schedule
	public Schedule(/* txtFile from comm. File scheduleFile */) throws IOException {
		
		//this.scheduleFile = scheduleFile;
		
		//System.out.println(currentDay);
		
		
				
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
		
		System.out.println(getWeekMap(1).get("mon").getEndTimeH());

	}

	//Will return a Week object of the chosen week of the year
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
	int getPrevWeek() {
		return 0;
	}

	void checkin() {
		
	}

	void checkout() {

	}

	void modifySchedule() {

	}

	// void modifySchedule([]) {
	// }

}
