package resourcesData;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.MapAddPlace;

public class TestDataBuild {
	
	public MapAddPlace addPlacePayload(String name, String language, String address) {
		

		MapAddPlace map = new MapAddPlace();
		map.setAccuracy(50);
//		map.setAddress("Nicy is always at home");
//		map.setLanguage("Hindi");
//		map.setName("MOD Galaxy CITY");
		map.setAddress(address);
		map.setLanguage(language);
		map.setName(name);
		map.setPhone_number("9999999123");
		map.setWebsite("www.justcookkt.com");

		List<String> listType = new ArrayList<String>();
		listType.add("shoe park");
		listType.add("water park");
		map.setTypes(listType);

		Location loc = new Location();
		loc.setLat(-97.11777);
		loc.setLng(99.22981);
		map.setLocation(loc);

		return map;
	}

	public String deletePlacePayload (String placeId) {
		
		return "{\n"
				+ "    \"place_id\":\""+placeId+"\"\n"
				+ "}\n"
				+ "";
		
	}
}
