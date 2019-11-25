import org.json.JSONArray;
import org.json.JSONObject;

import affichage.Affichage;

public class Metaweather {
	private int woeid;
	private String s;
	private String t;
	private int [] tab;
	private String temps;
	public static int getWoeid(String chaine) throws Exception {

		
        JSONArray jsonArr = new JSONArray(chaine);

       
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
			int max = temp.getInt("max_temp");
			int min = temp.getInt("min_temp");
			tab[i]=(max+min)/2;
	  }
		return tab;
	}
	
	public String getTemps(String meteo , int jour){

		
		JSONObject jObject = new JSONObject(meteo);
		JSONArray results = jObject.getJSONArray("consolidated_weather");
		String temps = "";
		for (int i = 0; i < jour; i++) {
			JSONObject temp = results.getJSONObject(i);
			temps = temp.getString("weather_state_abbr");
	  }
		return temps;
	}
	
	public static void afficheJour(int jour) {
		System.out.print("              +");
		for (int i =0;i<jour;i++){
			System.out.print("--------+");
		}
		System.out.println("");
		System.out.print("              |");
		for (int i =0;i<jour;i++){
			System.out.print("   J+"+i+"  |");
		}
		System.out.println("");
		System.out.print("+-------------+");
		for (int i =0;i<jour;i++){
			System.out.print("--------+");
		}
	}
	public Metaweather(String ville,int jour) throws Exception {
		
		Connexion data = new Connexion("https://www.metaweather.com/api/location/search/?query="+ville);
		Extraire chaine = new Extraire(data);
		s=chaine.toString();
		woeid=getWoeid(s);
		Connexion meteo = new Connexion("https://www.metaweather.com/api/location/"+woeid);
		Extraire info = new Extraire(meteo);
		t=info.toString();	
		tab=getMeteo(t,jour);
		afficheJour(jour);
		temps=getTemps(t,jour);
		new Affichage(tab,jour,"Metaweather",temps);
		  
		}
}
