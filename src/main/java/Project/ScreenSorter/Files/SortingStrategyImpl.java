package Project.ScreenSorter.Files;

import java.io.File;
import java.util.ArrayList;
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
		List<File> filesList = new ArrayList<File>();

		enlargements = getEnlargementsList();
		filesList = getFilesListFromEnlargements(enlargements);
		makeFoldersFromFilesListOfEnlargemnts(filesList);

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
		
		withEnlargement = fileName.split("\\.");  //nie dziala
		
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
	
	private void makeFoldersFromFilesListOfEnlargemnts(List<File> filesList) {
		for(int i = 0; i < filesList.size(); i++){
			if(!filesList.get(i).exists())
				filesList.get(i).mkdirs();
		}
	}




	@Override
	public void sortFilesByEnlargement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void replaceFileToTheFolder() {
		// TODO Auto-generated method stub

	}

}
