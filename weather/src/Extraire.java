

import org.json.JSONObject;
public class Extraire {
	private JSONObject j;
	private String [] tab;
	private int taille;
	
	public Extraire (Connexion res) {
		this.j = new JSONObject(res);
		this.tab =JSONObject.getNames(this.j);
		this.taille = j.length();
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public String [] getTab() {
		return this.tab;
	}
	
	public JSONObject getJ() {
		return this.j;
	}
	
	@Override
	public String toString() {
		int taille=this.getTaille();
		String [] tab=this.getTab();
		JSONObject j=this.getJ();
		String s = "";
		for (int i=0; i<taille; i++) {
			s=s+j.get(tab[i])+"\n";
		}
		return s;
	}
}