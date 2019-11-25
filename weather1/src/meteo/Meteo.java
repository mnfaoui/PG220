package meteo;

public class Meteo {
	private void setMeteo(jsonData meteo) {

        Meteo[] tMeteo = new Meteo[this.nbJours];
    	Meteo meteo = new Meteo(temperature, windSpeed, humidity);
    	tMeteo[0] = meteo ;
        
        for (int i = 1; i < this.nbJours; i++) {
        	
        	JSONObject day = jsonData.getJSONObject(i);
        	

        	int temperatureMax = day.getInt("tmax");
        	int temperatureMin = day.getInt("tmin");
        	temperature = (temperatureMax + temperatureMin) / 2 ;
        	
        	meteo = new Meteo(temperatureMax, -1, -1);   // choix de tmax comme temperature
        	        	
        	tMeteo[i] = meteo ;     	
			
		}
        
        this.meteo = tMeteo;
        
	}
}
