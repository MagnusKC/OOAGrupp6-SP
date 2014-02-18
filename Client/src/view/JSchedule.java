/**
 * Visual representation of the data that makes up the Schedule.
 * 
 * @author David Stromner & Magnus Källten
 * @version 2013-02-07
 */

package view;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import model.Schedule;

public class JSchedule implements Observer {
	Schedule schedule;
	private Calendar calendar = new GregorianCalendar();
	private int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);

	public JSchedule(Schedule schedule) throws IOException {
		this.schedule = schedule;
		//initPanels();
	}

	/**
	 * @param o
	 * @param arg
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Schedule)
			this.schedule = (Schedule) arg;

	}

	public void initPanels() {

	}
}