package Project.ScreenSorter.Files;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.Theory;
//run one test at one time
public class SortingStrategyImplTest {

	@Test
	@Ignore
	public void testShouldCreateFoldersOnFilesEveryKind() {
		SortingStrategyImpl sortingStrategy = new SortingStrategyImpl();
		ScreenContent screen = new ScreenContent();
		Integer sizeBeforeAddingFolder, sizeAfterAddingFolders;
		
		sizeBeforeAddingFolder = screen.makeScreenFoldersNames().size();
		sortingStrategy.makeNewFoldersOnFiles();
		sizeAfterAddingFolders = screen.makeScreenFoldersNames().size();

		assertNotEquals(sizeBeforeAddingFolder, sizeAfterAddingFolders);
	}
	// jak nie przechodzi assercaj nie robi nic za nia
	
	@Test
	public void testShouldMakeFolderAndAddAllOtherFoldersToIt(){
		SortingStrategyImpl sortingStrategy = new SortingStrategyImpl();
		File folderWithAllFolders = new File("C:\\Users\\Tomasz\\Desktop\\AllFolders");
		
		sortingStrategy.makeNewFoldersOnFiles();
		sortingStrategy.putAllFoldersToOneFolderOnScreen();
		sortingStrategy.sortFilesByEnlargementToProperFolders();
		
		assertTrue(folderWithAllFolders.exists());
		assertTrue(folderWithAllFolders.listFiles().length != 0);
		
	}

}
