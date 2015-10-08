package Project.ScreenSorter.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScreenContent {
	File screen = new File("C:\\Users\\Tomasz\\Desktop"); //jak zrobic z pulpitu ?
	
	public List<File> makeScreenFolders(){
		return new ArrayList<File>(Arrays.asList(screen.listFiles()));
	}
	
	public List<String> makeScreenFoldersNames(){
		return new ArrayList<String>(Arrays.asList(screen.list()));
	}
	
}
