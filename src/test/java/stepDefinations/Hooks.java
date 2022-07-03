package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//write a code that will give you place Id when, place id is null
		
		stepDefination sd = new stepDefination();
		
		if(stepDefination.placeId==null) {
			
		
		sd.add_place_payload("kate bush", "Frensch", "abra kadabr");
		sd.user_calls_with_post_https_request("AddPlaceAPI", "POST");
		sd.verify_if_place_id_created_maps_to_using("kate bush","GetPlaceAPI");
		}
		
	}

}
