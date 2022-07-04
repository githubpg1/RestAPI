package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resourcesData.ResourcesAPI;
import resourcesData.TestDataBuild;
import resourcesData.Utils;

@RunWith(Cucumber.class)
public class stepDefination extends Utils {

	RequestSpecification req;
	ResponseSpecification respec;
	Response res;
	JsonPath jp;
	TestDataBuild tdb = new TestDataBuild();
	static String placeId;

	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {

		/*
		 * pojo.MapAddPlace map = new pojo.MapAddPlace(); map.setAccuracy(50);
		 * map.setAddress("Nicy is always at home"); map.setLanguage("Hindi");
		 * map.setName("MOD Galaxy CITY"); map.setPhone_number("9999999123");
		 * map.setWebsite("www.justcookkt.com");
		 * 
		 * List<String> listType = new ArrayList<String>(); listType.add("shoe park");
		 * listType.add("water park"); map.setTypes(listType);
		 * 
		 * Location loc = new Location(); loc.setLat(-97.11777); loc.setLng(99.22981);
		 * map.setLocation(loc);
		 * 
		 */

		//respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		req = given().spec(requestSpecification()).body(tdb.addPlacePayload(name, language, address)).log().all();

	}

	@When("user calls {string} with {string} https request")
	public void user_calls_with_post_https_request(String APIName, String httpReq) {

		// constructor will be called with value of resource which you will pass
		ResourcesAPI resource = ResourcesAPI.valueOf(APIName); // values of will get the value of the method in enum

		if (httpReq.equalsIgnoreCase("POST"))
			res = req.when().post(resource.getResource());
		else if (httpReq.equalsIgnoreCase("GET"))
			res = req.when().get(resource.getResource());

	}

	@Then("the API called is success with status code {int}")
	public void the_api_called_is_success_with_status_code(Integer int1) {

		assertEquals(res.getStatusCode(), 200);

	}

	@Then("{string} in Response Body is {string}")
	public void in_response_body_is(String key, String value) {
		String strRes = res.asString();
		System.out.println("look look look , here is our json" + strRes);
		jp = new JsonPath(strRes);
		assertEquals(getJsonPath(res, key), value);
	}

	
	@Then("verify if place_Id created, maps to {string} using {string}")
	public void verify_if_place_id_created_maps_to_using(String name, String APIName) throws IOException {
		//ResourcesAPI resource = ResourcesAPI.valueOf(APIName);
		
		
		placeId=getJsonPath(res, "place_id");	
		
		req = given().spec(requestSpecification()).queryParam("place_id",placeId);
		
		user_calls_with_post_https_request(APIName,"GET");
		
		String nameOfPlace = getJsonPath(res, "name");
		assertEquals(nameOfPlace, name);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    req = given().spec(requestSpecification()).body(tdb.deletePlacePayload(placeId));

	    System.out.println("gor mater");

	    System.out.println("gor mater");

	}

}
