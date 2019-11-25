//import java.io.IOException;


public class Main {
	public static void main(String[] args) throws Exception {
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
		
		new Metaweather (ville , jour);
		new Pmeteo (ville, jour);
		new Openweather(ville, jour);
		System.out.println("\n");
		

	}
}
