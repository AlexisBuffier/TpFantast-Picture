package entite;

public class Image {

	
	private String url;
	private String nom;
	
	
	public Image(String url, String nom) {
		this.url = url;
		this.nom = nom;
	}
	
	//////////////////// GETTER ////////////////////
	public String getUrl() {
		return url;
	}
	public String getNom() {
		return nom;
	}
	
	//////////////////// SETTER ////////////////////
	public void setUrl(String url) {
		this.url = url;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
