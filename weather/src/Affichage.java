public class Affichage {
	public static void afficheMeteo(int [] tab,int jour,String nom) {
		/*
		System.out.print("+-------------+");
		for (int i =0;i<jour;i++){
			System.out.print("--------+");
		}
		*/
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
			System.out.print("--------+");
		}
		
	}
	public Affichage(int [] tab,int jour,String nom) {
		afficheMeteo(tab,jour,nom);
	}
	
}