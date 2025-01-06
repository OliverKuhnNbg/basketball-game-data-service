package de.twist.basketballgameservice.helpers.stringformatting;

import java.util.ArrayList;
import java.util.List;

import de.twist.basketballgameservice.constants.StringFormatDefinitions;


public class StringFormatHelper {

	public static List<String> getHomeAndGuestTeamList(String dataString) {
		String data = dataString.split(StringFormatDefinitions.COMMA.value)[0];
		data = replaceBackSlash(data);
		List<String> teamsList = new ArrayList<String>();

		if(data.split("-").length > 1) {
			teamsList.add(data.split("-")[0]);
			teamsList.add(data.split("-")[1]);
		}

		return teamsList;
	}

	public static List<String> getLocationDataList(String dataString) {
		List<String> locationDataList = new ArrayList<String>();
		String[] dataArray = dataString.split(StringFormatDefinitions.COMMA.value);
		if(dataArray.length > 2) {
			String street = replaceBackSlash(dataArray[0].trim());
			String zipCode = replaceBackSlash(dataArray[1].trim());
			String city = dataArray[2].trim();
			locationDataList.add(street);
			locationDataList.add(zipCode);
			locationDataList.add(city);
		}

		return locationDataList;
	}
	
	private static String replaceBackSlash(String string) {
		return string.replace(StringFormatDefinitions.BACK_SLASH.value, StringFormatDefinitions.EMPTY_STRING.value);
	}
}
