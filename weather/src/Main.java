import affichage.*;
import connection.*;
import parse.*;

public class Main {
	public static void main(String[] args) {
		String ville="";
		int jour=1;
		for(int i=0; i < args.length; i++) {
			if(i==1){
				ville=args[1];
			}
			else {
				if(args[i].equals("-j")){
					i++;
					jour= Integer.parseInt(args[i])+1;
				}
			}
		}	
		String[] tab1= new String[jour];
		String[] tab2= new String[jour];
		String[] tab3= new String[jour];
		
		StringBuffer output = Connexion.setWoeid(ville);
		String line = output.toString();
		int number = Parse.getWoeid(line);
		
		StringBuffer meteo1 = Connexion.setMeteo(number);
		String the1 = meteo1.toString();
		tab1= Parse.getMeteo(the1,jour);
		
		StringBuffer meteo2 = Connexion.setMeteo2(ville);
		String the2 = meteo2.toString();
		tab2= Parse.getMeteo2(the2,jour);
		
		StringBuffer meteo3 = Connexion.setMeteo3(ville);
		String the3 = meteo3.toString();
		tab3= Parse.getMeteo3(the3,jour);
		
		Affichage.afficheJour(jour);
		Affichage.afficheMeteo(tab1,jour,"MetaWeather");
		Affichage.afficheMeteo(tab2,jour,"P-Meteo    ");
		Affichage.afficheMeteo(tab3,jour,"OW Weather ");
		System.out.println("\n");
		
		
	
	}
}
