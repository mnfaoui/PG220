
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Connexion {
	private String data;
	public String getData(){
		return this.data;
	}

	public Connexion(String url) throws Exception {
		StringBuffer reponseContent = new StringBuffer();
		URL Url = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
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
			this.data = reponseContent.toString();
			
			//System.out.println(data);
			
	}

}