package de.twist.basketballgameservice.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.twist.basketballgameservice.constants.IcsDefinitions;
import de.twist.basketballgameservice.helpers.datamapping.DataStringHelper;
import de.twist.basketballgameservice.models.CalendarGameEvent;


public class IcsDataReadout {
	
	public static List<CalendarGameEvent> getMappedIcsData(File file) {
		FileReader fileReader;
		List<CalendarGameEvent> allCalendarEvents = new ArrayList<>();

		try {
			fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			allCalendarEvents = getReadoutDataFromFile(br);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allCalendarEvents;
	}

	private static List<CalendarGameEvent> getReadoutDataFromFile(BufferedReader bufferedReader) throws IOException {
		String currentLine = "";
		boolean newEventSwitch = false;
		CalendarGameEvent calGameEvent = new CalendarGameEvent();
		List<CalendarGameEvent> allCalendarEventsList = new ArrayList<>();

		while ((currentLine = bufferedReader.readLine()) != null) {
			newEventSwitch = checkForNewEvent(newEventSwitch, currentLine);

			if (currentLine.equals(IcsDefinitions.BEGIN_VEVENT.value)) {
				calGameEvent= new CalendarGameEvent();
			} 
			else if (newEventSwitch && !currentLine.equals(IcsDefinitions.BEGIN_VEVENT.value)) {
				calGameEvent = DataStringHelper.mapIcsFileData(calGameEvent, currentLine);
			} 
			else if (currentLine.equals(IcsDefinitions.END_VEVENT.value)) {
				allCalendarEventsList.add(calGameEvent);
			}
		}

		return allCalendarEventsList;
	}

	/** checks if current file line related to new event*/
	private static boolean checkForNewEvent(boolean eventSwitch, String currentLine) {
		if(currentLine.equals(IcsDefinitions.BEGIN_VEVENT.value)) {
			eventSwitch=true;
		} else if(currentLine.equals(IcsDefinitions.END_VEVENT.value)){
			eventSwitch=false;
		}

		return eventSwitch;
	}
}
