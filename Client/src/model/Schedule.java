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
	private Calendar calendar;
	private int currentWeek;
	private int currentDay; //Sunday 1, Monday 2, ... , Saturday 7
	private BufferedReader reader;
	//private Boolean isCheckedIn;
	//private HashMap<String, Day> weekMap; //HashMap
	//private String[] temp; //temporary string array
	private Day[] weekArray; //Sunday 1, Monday 2, ... , Saturday 7
	
	/**
	 * @throws IOException
	 */
	public Schedule(/* object from comm. Obj scheduleStringObj */) throws IOException {
		
		calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(Calendar.MONDAY); // Works as intended ! MONDAY (2) is now the first day of the week and affects WEEK_OF_YEAR
		currentWeek  = calendar.get(Calendar.WEEK_OF_YEAR); //Since "DAY_OF_WEEK" makes Sunday day 1, I'm wondering how it handles weeks. Does a new week happen on a sunday?
		currentDay = calendar.get(Calendar.DAY_OF_WEEK);
		//weekMap = new HashMap<String, Day>();
		
		
		System.out.println("Week:" + currentWeek + " Day:" + currentDay + " Hour:" + calendar.get(Calendar.HOUR) + " Minute:" + calendar.get(Calendar.MINUTE) + " Seconds:" + calendar.get(Calendar.SECOND));
		
		
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
		
	}

	
	//Will return a Week object of the chosen week of the year
	/**
	 * @param chosenWeek The number of the week you'd like to get. (1-52)
	 * @return Returns a HashMap containing a Day object for every day of the chosen week. The keys are the first 3 letters of the week day.
	 * @throws IOException
	 */
	/*
	//Gör om till en Day array för calendar [1-7] ?
	public HashMap<String, Day> getWeekMap(int chosenWeek) throws IOException {
		int i = 1;
		Boolean rightWeek = false;
		
		//Not sure if the reader actually reads the file here or if this section of code just compiles
		while ((line = reader.readLine()) != null && i<7) {
			//System.out.println(line);
			if (line.length() == 1 && Integer.parseInt(line) == chosenWeek) {
				rightWeek = true;
				line = reader.readLine(); //Ugly solution
			}
			else if(rightWeek){
				temp = line.split("\\|");
				weekMap.put(temp[0], new Day(line));
				i++;
			}
		}
		return weekMap;
	}
	*/
	
	/**
	 * @param chosenWeek The number of the week you'd like to get. (1-52)
	 * @return Returns a Day array containing a Day object for every day of the chosen week. Sunday = 1, Monday = 2, ..., Saturday = 6
	 * @throws IOException
	 */
	public Day[] getWeekArray(int chosenWeek) throws IOException {
		int i = 1;
		Boolean rightWeek = false;
		
		//Not sure if the reader actually reads the file here or if this section of code just compiles
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
	 * @param chosenDay 1-7 Sunday - Saturday
	 * @return selected day
	 * @throws IOException 
	 */
	public Day getDay(int chosenDay) throws IOException{
		
		Day[] days = getWeekArray(currentWeek);
		
		return days[chosenDay];
	}
/*
	Week getNextWeek() {
		return week;
	}
*/

	//Skall kunna köras utan inparameter med hjälp av calendar get current day och tid
	void checkin() {
		//calendar.get(Calendar.HOUR);
		//calendar.get(Calendar.MINUTE);
		
		
	}

	//Skall kunna köras utan inparameter med hjälp av calendar get current day och tid
	void checkout() {

	}

	//Vet ej vad denna skall göra
	void modifySchedule() {

	}

	//void modifySchedule([]) {
	//}

}
