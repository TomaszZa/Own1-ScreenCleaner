package Project.ScreenSorter.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Project.ScreenSorter.Interfaces.SortingStrategy;

public class SortingStrategyImpl implements SortingStrategy {
	private ScreenContent screen;

	public SortingStrategyImpl() {
		screen = new ScreenContent();
	}

	@Override
	public void makeNewFoldersOnFiles() {
		List<String> enlargements = new ArrayList<String>();
		List<File> foldersList = new ArrayList<File>();

		enlargements = getEnlargementsList();
		foldersList = getFilesListFromEnlargements(enlargements);
		makeFoldersFromFilesListOfEnlargemnts(foldersList);

	}

	private List<String> getEnlargementsList() {
		List<String> nameOfFiles;
		List<String> enlargements = new ArrayList<String>();
		String enlargement;

		nameOfFiles = screen.makeScreenFoldersNames();

		for (int i = 0; i < nameOfFiles.size(); i++) {
			enlargement = getEnlargementName(nameOfFiles.get(i));
			if (enlargement != null && !enlargements.contains(enlargement))
				enlargements.add(enlargement);
		}

		return enlargements;
	}

	private String getEnlargementName(String fileName) {
		String[] withEnlargement;

		if (!fileName.contains("."))
			return null;

		withEnlargement = fileName.split("\\.");

		return withEnlargement[withEnlargement.length - 1];
	}

	private List<File> getFilesListFromEnlargements(List<String> enlargements) {
		List<File> foldersForFiles = new ArrayList<File>();

		for (int i = 0; i < enlargements.size(); i++) {
			foldersForFiles.add(new File("C:\\Users\\Tomasz\\Desktop\\"
					+ enlargements.get(i)));
		}

		return foldersForFiles;
	}

	private void makeFoldersFromFilesListOfEnlargemnts(List<File> foldersList) {
		File actualFolder;
		
		for (int i = 0; i < foldersList.size(); i++) {
			actualFolder = foldersList.get(i);
			if (checkIfSuchFolderNotExistOnScreenAndInAllFolders(i, actualFolder))
				actualFolder.mkdirs();
		}
	}
	
	private boolean checkIfSuchFolderNotExistOnScreenAndInAllFolders(int i, File actualFolder){
		File allFolders = new File("C:\\Users\\Tomasz\\Desktop\\AllFolders");
		
		if(allFolders.exists()){
			List<String> foldersFromAllFoldersNames = new ArrayList<String>(Arrays.asList(allFolders.list()));

		    return !actualFolder.exists() && !foldersFromAllFoldersNames.contains(actualFolder.getName());
		}
			return !actualFolder.exists();
	}

	@Override
	public void sortFilesByEnlargementToProperFolders() {
		List<String> filesName = new ArrayList<String>();
		List<File> files = new ArrayList<File>();

		filesName = screen.makeScreenFoldersNames();
		files = screen.makeScreenFolders();

		goThoughtFilesToSort(filesName, files);
	}

	private void goThoughtFilesToSort(List<String> filesName, List<File> files) {
		for (int i = 0; i < filesName.size(); i++) {
			changeFileDirectionToProperFolder(i, filesName.get(i), files.get(i));
		}
	}

	private void changeFileDirectionToProperFolder(int i, String fileName,
			File file) {
		String enlargement;
		File fileWithChangedPath;
		enlargement = getEnlargementName(fileName);
		File toCheckIfSuchFileExist = new File("C:\\Users\\Tomasz\\Desktop\\AllFolders\\" + enlargement + "\\"
		+ fileName);

		if(toCheckIfSuchFileExist.exists()) {
			enlargement = null;
			file.delete();
		}
		if (enlargement != null) {
			fileWithChangedPath = new File("C:\\Users\\Tomasz\\Desktop\\AllFolders\\"
					+ enlargement + "\\" + fileName);
			file.renameTo(fileWithChangedPath);
		}
	}

	@Override
	public void putAllFoldersToOneFolderOnScreen() {
		ScreenContent screen = new ScreenContent();
		File folderForAllFolders = new File(
				"C:\\Users\\Tomasz\\Desktop\\AllFolders");
		List<File> files;

		folderForAllFolders.mkdirs();
		files = screen.makeScreenFolders();

		goThroughtFiles(files);
	}

	private void goThroughtFiles(List<File> files) {
		for (int i = 0; i < files.size(); i++) {
			changeFileLocation(files.get(i));
		}
	}

	private void changeFileLocation(File file) {
		File fileWithNewPath;

		if (file.isDirectory()) {
			fileWithNewPath = new File(
					"C:\\Users\\Tomasz\\Desktop\\AllFolders\\" + file.getName());
			file.renameTo(fileWithNewPath);
		}
	}

}
