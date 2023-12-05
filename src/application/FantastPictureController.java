package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import entite.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import service.ImageService;
import service.NoteService;
import service.UserService;

public class FantastPictureController implements Initializable {

	@FXML
    private ImageView imageView;

    @FXML
    private Label labelNom;

    @FXML
    private Label labelMdp;

    @FXML
    private ListView<String> listImage;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputMdp;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelNote;

    @FXML
    private TextField inputNote;

    @FXML
    private Button buttonNote;
    
    @FXML
    private Label labelCnxx;
    
    @FXML
    private Label labelAddNote;
    
    ImageService imageService = new ImageService();
    
    UserService userService = new UserService();
    
    NoteService noteService = new NoteService();
    
    String currentImage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Map<String, entite.Image> imageList = imageService.getimageList();
		
		Map<String, entite.User> userList = userService.getUserList();
		
		for (String KeyImage : imageList.keySet())
		{
			listImage.getItems().add(KeyImage);
		}
		
		listImage.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				currentImage = listImage.getSelectionModel().getSelectedItem();
				
				String url = imageService.getUrl(currentImage);
				
				Image image = new Image(url);
				imageView.setImage(image);
			}
		});
	}
	
	public void logIn()
	{
		try 
		{
			String nom = inputName.getText();
			String mdp = inputMdp.getText();
			
			//User userConnecte = new User(nom, mdp);
			User userConnecte = userService.log(nom, mdp);
			
			if(userConnecte instanceof User)
			{
				displayCnxx(true, nom);
			}
			else
			{
				displayCnxx(false, nom);
			}
		} catch (Exception e) 
		{
	        System.err.println("Erreur lors de la connexion : " + e.getMessage());
	    }
	}
	
	public void displayCnxx(Boolean etat, String nom) throws IOException
	{
		if(etat.equals(true))
		{
			labelNote.setVisible(true);
			inputNote.setVisible(true);
			buttonNote.setVisible(true);
			
			labelCnxx.setTextFill(Color.GREEN);
			labelCnxx.setText("Utilisateur " + nom + " connecté !");
			labelCnxx.setVisible(true);
			
			getNote();
		}
		else
		{
			labelNote.setVisible(false);
			inputNote.setVisible(false);
			buttonNote.setVisible(false);
			
			inputName.setText("");
			inputMdp.setText("");
			
			labelCnxx.setTextFill(Color.RED);
			labelCnxx.setText("Prenom ou mot de passe incorrect !");
			labelCnxx.setVisible(true);
		}
	}
	
	public void addNote() throws IOException
	{
		try {
			String nomUser = inputName.getText();
			String nomImage = listImage.getSelectionModel().selectedItemProperty().getValue();
			int note = Integer.valueOf(inputNote.getText());
			
			if (note < 0 || note > 20) {
            	
				labelAddNote.setTextFill(Color.RED);
				labelAddNote.setText("La note doit être comprise entre 0 et 20");
				labelAddNote.setVisible(true);
                throw new IllegalArgumentException("La note doit être comprise entre 0 et 20");         
            }
	
			Boolean noteExist = noteService.validNote(nomUser, nomImage, note);
			
			labelAddNote.setTextFill(Color.GREEN);
			
			if(noteExist)
			{
				labelAddNote.setText("Note modifiée !");
			}
			else
			{
				labelAddNote.setText("Note ajoutée !");
			}
			
			labelAddNote.setVisible(true);
			
		} catch (NumberFormatException e) {
        	
			labelAddNote.setTextFill(Color.RED);
			labelAddNote.setText("Veuillez entrer des nombres !");
			labelAddNote.setVisible(true);
        	
        }
	} 
	
	public void getNote() throws IOException
	{
		String nomUser = inputName.getText();
		String nomImage = listImage.getSelectionModel().selectedItemProperty().getValue();
		
		String note = noteService.getNoteUser(nomUser, nomImage);
		
		inputNote.setText(note);
	}
}
