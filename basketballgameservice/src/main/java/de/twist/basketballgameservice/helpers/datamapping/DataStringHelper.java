package de.twist.basketballgameservice.helpers.datamapping;

import java.util.Date;
import java.util.List;

import de.twist.basketballgameservice.constants.IcsDefinitions;
import de.twist.basketballgameservice.constants.StringFormatDefinitions;
import de.twist.basketballgameservice.helpers.date.StringDateHelper;
import de.twist.basketballgameservice.helpers.stringformatting.StringFormatHelper;
import de.twist.basketballgameservice.models.CalendarGameEvent;
import de.twist.basketballgameservice.models.submodels.Location;



public class DataStringHelper {

	public static CalendarGameEvent mapIcsFileData(CalendarGameEvent calGameEvent, String currentIcsLine) {
		String icsDefinition = currentIcsLine.split(StringFormatDefinitions.DOUBLE_POINT.value)[0];
		String icsDefinitionData = currentIcsLine.split(StringFormatDefinitions.DOUBLE_POINT.value).length > 1 ? 
				currentIcsLine.split(StringFormatDefinitions.DOUBLE_POINT.value)[1] : StringFormatDefinitions.EMPTY_STRING.value;
		Date date;

		if(icsDefinition.equals(IcsDefinitions.DTSTAMP.value)) {
			date = StringDateHelper.getDateFromString(icsDefinitionData);
			calGameEvent.setLastDataUpdate(date);
		} else if(icsDefinition.equals(IcsDefinitions.DTSTART.value)) {
			date = StringDateHelper.getDateFromString(icsDefinitionData);
			boolean isGamePlayed = date.before(new Date());

			calGameEvent.setStartGameDate(date);
			calGameEvent.setGamePlayed(isGamePlayed);
		} else if(icsDefinition.equals(IcsDefinitions.DTEND.value)) {
			date = StringDateHelper.getDateFromString(icsDefinitionData);
			calGameEvent.setEndGameDate(date);
		} else if(icsDefinition.equals(IcsDefinitions.SUMMARY.value)) {
			List<String> teamsList = StringFormatHelper.getHomeAndGuestTeamList(icsDefinitionData);
			calGameEvent.setHomeTeam(teamsList.getFirst());
			calGameEvent.setGuestTeam(teamsList.getLast());
		} else if(icsDefinition.equals(IcsDefinitions.LOCATION.value)) {
			List<String> locationDataList = StringFormatHelper.getLocationDataList(icsDefinitionData);
			Location location = new Location();
			location.setStreet(locationDataList.getFirst());
			location.setZipCode(locationDataList.get(1));
			location.setCity(locationDataList.getLast());

			calGameEvent.setLocation(location);
		} else if(icsDefinition.equals(IcsDefinitions.UID.value)) {
			calGameEvent.setGameId(Long.parseLong(icsDefinitionData));
		}

		return calGameEvent;
	}

	public static void objectDataOutput(CalendarGameEvent calGameEvent) {
		System.out.println("\n----------------------------------------------------");
		System.out.println(calGameEvent.getGameId());
		System.out.println("lastUpdate: - " + calGameEvent.getLastDataUpdate());
		System.out.println(" gameStart: - " + calGameEvent.getStartGameDate());
		System.out.println("   gameEnd: - " + calGameEvent.getEndGameDate() + "\n");
		System.out.println(" Home: " + calGameEvent.getHomeTeam() + "\nGuest: " + calGameEvent.getGuestTeam());
		System.out.println("\nLocation:");
		Location loc = calGameEvent.getLocation();
		System.out.println(" street - " + calGameEvent.getGuestTeam());
		System.out.println("    zip - " + loc.getZipCode());
		System.out.println("   city - " + loc.getCity());
		System.out.println("----------------------------------------------------\n");
	}
}
