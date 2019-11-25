package affichage;
public class Affichage {
	
	
	public static void afficheJour(int jour) {
		
		System.out.print("              +");
		for (int i =0;i<jour;i++){
			System.out.print("-----------------------+");
		}
		
		System.out.println("");
		System.out.print("              |");
		for (int i =0;i<jour;i++){
			System.out.print("          J+"+i+"          |");
		}
		
		System.out.println("");
		System.out.print("+-------------+");
		for (int i =0;i<jour;i++){
			System.out.print("-----------------------+");
		}
		System.out.println("");
	}
	
	
	
	public static void afficheMeteo(String[] tab3,int jour, String website) {

		System.out.print("| "+website+" |");
		for (int i =0;i<jour;i++){
			/*if (tab3[i]>9) {
				System.out.print("   "+tab3[i]+"°  |");
			}
			else {
				System.out.print("   "+tab3[i]+"°   |");
			}*/
			System.out.print("  "+tab3[i]+"  |");
		}
		System.out.println("");
		System.out.print("+-------------+");
		for (int i =0;i<jour;i++){
			System.out.print("-----------------------+");
		}
		System.out.println("");
		
	}
	
}