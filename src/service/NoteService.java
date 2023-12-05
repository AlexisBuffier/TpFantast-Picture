package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.scene.paint.Color;

public class NoteService {

	
	public boolean validNote(String nomUser, String nomImage, int note) throws IOException
	{
		boolean noteExist = false;
		File fichier = new File("src/note.txt");

        List<String> lines = Files.readAllLines(Paths.get(fichier.toURI()));

        int index = -1;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(nomUser + ", " + nomImage)) {
                index = i;
                break;
            }
        }

        String noteUser = nomUser + ", " + nomImage + ", " + note;

        if (index != -1) {
            lines.set(index, noteUser);
            
            noteExist = true;
        } else {
            lines.add(noteUser);
        }

        Files.write(Paths.get(fichier.toURI()), lines);
        
        return noteExist;
	}
	
	public String getNoteUser(String nomUser, String nomImage) throws IOException
	{
		File fichier = new File("src/note.txt");

        List<String> lines = Files.readAllLines(Paths.get(fichier.toURI()));

        int index = -1;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(nomUser + ", " + nomImage)) {
            	String[] words = lines.get(i).split(",");
            	
            	String note = words[2].trim();
            	return note;
            }
        }
		
		return null;
	}
}
