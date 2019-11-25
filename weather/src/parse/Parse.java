
package parse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Parse {
public static int getWoeid(String output) {

		
        JSONArray jsonArr = new JSONArray(output);

       
        JSONObject ville = jsonArr.getJSONObject(0);
            
        int number = ville.getInt("woeid");

        //System.out.println("woeid :" + number);
            
        
        return number;
        
    }




public static String[] getMeteo(String meteo , int jour){
	JSONObject jObject = new JSONObject(meteo);
	JSONArray results = jObject.getJSONArray("consolidated_weather");
	String[] tab = new String[jour];
	int[] tab_temp = new int[jour];
	int[] tab_hum = new int[jour];
	float[] tab_wind = new float[jour];	
	for (int i = 0; i < jour; i++) {
		JSONObject day = results.getJSONObject(i);
		
		int max = day.getInt("max_temp");
		int min = day.getInt("min_temp");
		int hum = day.getInt("humidity");
		int wind = day.getInt("wind_speed");
		
		tab_temp[i] = (max+min)/2;
		tab_hum[i] = hum;
		tab_wind[i] = wind;
		
		tab[i]="" + tab_temp[i]+"°" + "   "+ tab_hum[i] + "%" + "   " + tab_wind[i] + "km/h";
		
		
  }
	return tab;
}

public static String[] getMeteo2(String meteo , int jour){

	String[] tab = new String[jour];
	int[] tab_temp = new int[jour];
	int[] tab_hum = new int[jour];
	float[] tab_wind = new float[jour];	
	
	for (int i = 0; i < jour; i++) {
		JSONObject jObject = new JSONObject(meteo);
		JSONObject results = jObject.getJSONObject("fcst_day_"+i);
		JSONObject cc = jObject.getJSONObject("current_condition");
		
		int wind = cc.getInt("wnd_spd");
		int hum = cc.getInt("humidity");
		int max = results.getInt("tmax");
		int min = results.getInt("tmin");
		
		tab_temp[i] = (max+min)/2;
		tab_hum[i] = hum;
		tab_wind[i] = wind;
		
		tab[i]="" + tab_temp[i]+"°" + "   "+ tab_hum[i] + "%" + "   " + tab_wind[i] + "km/h";
		
  }
	return tab;
}
	  

public static String[] getMeteo3(String meteo , int jour){

	JSONObject jObject = new JSONObject(meteo);
	JSONArray liste = jObject.getJSONArray("list");
	String[] tab = new String[jour];
	int[] tab_temp = new int[jour];
	int[] tab_hum = new int[jour];
	float[] tab_wind = new float[jour];
	
	for (int i = 0; i < jour; i++) {
		JSONObject day = liste.getJSONObject(i);
		JSONObject temp = day.getJSONObject("temp");
		

		int humidity = day.getInt("humidity");
		int max = temp.getInt("max");
		int min = temp.getInt("min");
		float wind = day.getInt("speed");
		
		int k = 273;
		tab_temp[i] = (max+min)/2 -k;
		tab_hum[i] = humidity;
		tab_wind[i] = wind;
		
		tab[i]="" + tab_temp[i]+"°" + "   "+ tab_hum[i] + "%" + "   " + tab_wind[i] + "km/h";
  }
	return tab;
}


}
