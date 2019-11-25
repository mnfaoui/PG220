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




public static int[] getMeteo(String meteo , int jour){
	JSONObject jObject = new JSONObject(meteo);
	JSONArray results = jObject.getJSONArray("consolidated_weather");
	int[] tab = new int[jour];
	for (int i = 0; i < jour; i++) {
		JSONObject temp = results.getJSONObject(i);
		int tem = temp.getInt("the_temp");
		tab[i]=tem;
  }
	return tab;
}
	  


}
