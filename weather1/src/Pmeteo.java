import org.json.JSONObject;

import affichage.Affichage;

public class Pmeteo {
	private String s;
	private int [] tab;


	public static int[] getMeteo(String meteo , int jour){
		
			int[] tab = new int[jour];
			for (int i = 0; i < jour; i++) {
				JSONObject jObject = new JSONObject(meteo);
				JSONObject results = jObject.getJSONObject("fcst_day_"+i);
		
				int max = results.getInt("tmax");
				int min = results.getInt("tmin");
				
				tab[i]=(max+min)/2;
		   }
		 	return tab;
		 }
	
	public Pmeteo(String ville,int jour) throws Exception {
		
		Connexion data = new Connexion("https://www.prevision-meteo.ch/services/json/"+ville);
		Extraire chaine = new Extraire(data);
		s=chaine.toString();
		tab=getMeteo(s,jour);
		//new Affichage(tab,jour,"P-Meteo    ");
		  
		}
}