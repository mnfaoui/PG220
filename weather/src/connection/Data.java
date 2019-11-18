package connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Data {

		// http://localhost:8080/RESTfulExample/json/product/get
		public static StringBuffer setWoeid(String ville) {
			StringBuffer reponseContent = new StringBuffer();
		  try {

			URL url = new URL("https://www.metaweather.com/api/location/search/?query="+ville);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(connection.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				reponseContent.append(output);
			}
			connection.disconnect();
			
			
			
			

		  } catch (MalformedURLException e) {

			e.printStackTrace();
			

		  } catch (IOException e) {

			e.printStackTrace();
			

		  }
		  return reponseContent;
		}

		public static StringBuffer setMeteo(int woeid) {
			StringBuffer reponseContent = new StringBuffer();
		  try {

			URL url = new URL("https://www.metaweather.com/api/location/"+woeid);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(connection.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
				reponseContent.append(output);
			}
			connection.disconnect();
			
			
			
			

		  } catch (MalformedURLException e) {

			e.printStackTrace();
			

		  } catch (IOException e) {

			e.printStackTrace();
			

		  }
		  return reponseContent;
		}
		
		
}
		


