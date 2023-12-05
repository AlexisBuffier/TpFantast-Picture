package service;

import java.util.HashMap;
import java.util.Map;

import entite.Image;

public class ImageService {

	Map<String, Image> imageList = new HashMap<>();
	
	public Map<String, Image> getimageList()
	{
	    Image imageBretagne = new Image("/assets/Bretagne.jpg", "Bretagne");
	    Image imageEspace 	= new Image("/assets/Espace.jpg", "Espace");
	    Image imageParis 	= new Image("/assets/Paris.jpg", "Paris");
	    
	    imageList.put(imageBretagne.getNom(), imageBretagne);
	    imageList.put(imageEspace.getNom(), imageEspace);
	    imageList.put(imageParis.getNom(), imageParis);
	    
	    return imageList;
	}
	
	public String getUrl(String currentImage)
	{
		try 
		{
	        for(Image image : imageList.values()) 
	        {
	            if(image.getNom().equals(currentImage)) 
	            {
	                return image.getUrl();
	            }
	        }
	    } catch (Exception e) 
		{
	        System.err.println("Erreur lors de la récupération de l'url : " + e.getMessage());
	    }
		return null;
	}
}
