package resourcesData;

public class ResouseUrl {

	// with this class, you have to create the object of this class wherever you
	// need to call these methods and then use it , and you also have to create all
	// these methods for the strings
	
	//But if you use ENUM class, you dont have to geenrate the methods again.

	String addPlaceAPI = "/maps/pi/place/add/json";
	String getPlaceAPI = "/maps/pi/place/get/json";
	String deletePlaceAPI = "/maps/pi/place/delete/json";

	public String getAddPlaceAPI() {
		return addPlaceAPI;
	}

	public String getGetPlaceAPI() {
		return getPlaceAPI;
	}

	public String getDeletePlaceAPI() {
		return deletePlaceAPI;
	}

}
