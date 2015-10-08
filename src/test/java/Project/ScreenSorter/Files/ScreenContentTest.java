package Project.ScreenSorter.Files;

import java.io.File;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;


public class ScreenContentTest extends TestCase {
	//dodac tworzenie pliku 
    @Test
	public void testShouldReturnAllFilesNamesOnCreen(){
		ScreenContent screen = new ScreenContent();
		List<String> filesNameList;
		File tempFile = new File("C:\\Users\\Tomasz\\Desktop\\cos.jpg");
		
		try {
		tempFile.createNewFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		filesNameList = screen.makeScreenFoldersNames();

		assertFalse(filesNameList.isEmpty());
		assertTrue(filesNameList.contains("cos.jpg"));
		tempFile.delete();
	}
    
    @Test
    public void testShouldReturnAllFilesOnScreen(){
    	ScreenContent screen = new ScreenContent();
    	List<File> filesList;
    	File tempFile = new File("C:\\Users\\Tomasz\\Desktop\\cos.jpg");
    	
    	try {
    		tempFile.createNewFile();
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    		
    	filesList = screen.makeScreenFolders();

    	assertTrue(filesList.contains(tempFile));
    	tempFile.delete();
    }
}
