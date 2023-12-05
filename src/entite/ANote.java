package entite;

public class ANote {

	private int note;
	
	private Image image;
	private User user;
	
//////////CONSTRUCTEUR   //////////

	public ANote(int note, User user, Image image) {
		super();
		this.note = note;
		this.user = user;
		this.image = image;
	}
	
	
	//////////GETTER AND SETTER//////////
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image pic) {
		this.image = pic;
	}
}
