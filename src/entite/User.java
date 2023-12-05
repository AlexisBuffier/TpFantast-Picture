package entite;

public class User {

	private String prenom;
	private String mdp;
	
	
	public User(String prenom, String mdp) {
		this.prenom = prenom;
		this.mdp = mdp;
	}
	
	//////////////////// GETTER ////////////////////
	public String getPrenom() {
		return prenom;
	}
	public String getMdp() {
		return mdp;
	}

	//////////////////// SETTER ////////////////////
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
