package Project.ScreenSorter.Files;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SortingStrategyImplTest {

	@Test
	public void testShouldCreateFoldersOnFilesEveryKind() {
		SortingStrategyImpl sortingStrategy = new SortingStrategyImpl();
		ScreenContent screen = new ScreenContent();
		Integer sizeBeforeAddingFolder, sizeAfterAddingFolders;
		
		sizeBeforeAddingFolder = screen.makeScreenFoldersNames().size();
		sortingStrategy.makeNewFoldersOnFiles();
		sizeAfterAddingFolders = screen.makeScreenFoldersNames().size();

		assertNotEquals(sizeBeforeAddingFolder, sizeAfterAddingFolders);
	}

}
