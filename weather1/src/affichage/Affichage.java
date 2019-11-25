package affichage;
public class Affichage {

	
	public static void afficheMeteo(int [] tab,int jour,String nom, String temps) {
		/*
		System.out.print("+-------------+");
		for (int i =0;i<jour;i++){
			System.out.print("--------+");
		}
		*/
		String ligne = "--------+";
		System.out.println("");
		System.out.print("| "+nom+" |");
		for (int i =0;i<jour;i++){
			if (tab[i]>9) {
				System.out.print("   "+tab[i]+"°  |");
			}
			else {
				System.out.print("   "+tab[i]+"°   |");
			}
		}
		System.out.println("");
		System.out.print("+-------------+");
		for (int i =0;i<jour;i++){
			System.out.print(ligne);
		}
		
	}
	public Affichage(int [] tab,int jour,String nom,String temps) {
		afficheMeteo(tab,jour,nom,temps);
	}
	
}