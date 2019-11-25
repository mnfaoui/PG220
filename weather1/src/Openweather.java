import org.json.JSONObject;

public class Openweather {
	//http://api.openweathermap.org/data/2.5/forecast?q=Sydney&appid=c4fcfeacd0200367c5ed717c08b989f3
		private String s;
		private int [] tab;

		public static String getDay(String chaine, int nbjour) {
			return chaine;
			
		}
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

		public Openweather(String ville,int jour) throws Exception {
	
			Connexion data = new Connexion("http://api.openweathermap.org/data/2.5/forecast?q="+ville+"&appid=c4fcfeacd0200367c5ed717c08b989f3");
			Extraire chaine = new Extraire(data);
			s=chaine.toString();
			System.out.println(s);
			//tab=getMeteo(s,jour);
			//new Affichage(tab,jour,"P-Meteo");
	  
		}
}

