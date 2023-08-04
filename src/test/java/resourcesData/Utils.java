package resourcesData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification reqSpec; // when you put static, that variable is used across all the test cases
												// in the entire execution

	public RequestSpecification requestSpecification() throws IOException {

		if (reqSpec == null) {   //if not static, it wil make it null again

			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue()).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log)) // to log request into a file
					.addFilter(ResponseLoggingFilter.logResponseTo(log)) // log response to the file
					.setContentType(ContentType.JSON).build();
			return reqSpec;
		}
		return reqSpec;
	}

	public static String getGlobalValue() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/prerana/eclipse-workspace/Automation/src/test/java/resourcesData/global.properties");
		prop.load(fis);
		return prop.getProperty("baseURL");

	}
	
	public String getJsonPath(Response response , String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
