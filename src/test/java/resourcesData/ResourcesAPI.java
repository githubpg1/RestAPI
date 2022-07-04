/**
 * 
 */
package resourcesData;

/**
 * @author prerana 
 * 		   ENUM IS A SPECIAL CLASS IN JAVA WHICH HAS COLLECTION OF
 *         METHODS OR CONSTANTS EASY TO USE. DONT HAVE TO CREATE METHODS AGAIN
 *         AND AGAIN
 */
public enum ResourcesAPI {

	AddPlaceAPI("/maps/api/place/add/json"), GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");

	private String resource;
	// constructor is created with a class. since the argument of the methods above
	// is the same, so we can create a single constructor with a single argument
	ResourcesAPI(String resource) {
		
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}

}
