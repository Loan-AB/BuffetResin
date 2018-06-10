package gestionGalerie;

import java.io.File;
import java.io.FileFilter;

//cette classe permet de filtrer les types de fichiers que nous souhaitons en donnant leur extension
//Source : https://alvinalexander.com/blog/post/java/how-implement-java-filefilter-list-files-directory

public class FileFilterImage implements FileFilter{

	private final String[] okFileExtensions = new String[] {"jpg", "png", "jpeg"};

	  public boolean accept(File file)
	  {
	    for (String extension : okFileExtensions)
	    {
	      if (file.getName().toLowerCase().endsWith(extension))
	      {
	        return true;
	      }
	    }
	    return false;
	  }

}
