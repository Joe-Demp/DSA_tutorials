package filecounter;

import java.io.File;

import stack.ListStack;

public class StackFileCounter extends FileCounter {
	public static int countFiles(String directory) {
//		TODO fill in this method
		return -1;
	}
	
	/**
	 * Returns a count of all of the files of a given type in a given directory and all of its sub-directories
	 * 
	 * @param directory a String representing the path of the directory you would like to count in
	 * @param fileType a String representing the type of file being counted e.g. ".java" or ".txt"
	 * @return the number of files of type fileType in directory and all of its sub-directories
	 */
	public static int countFiles(String directory, String fileType) {
		int count = 0;
		ListStack<String> folders = new ListStack<String>();
		File currentFolder, currentFile;
		String [] fileList;
		String currentFolderPath, currentFilePath;
		
//		First push directory onto the stack
		folders.push( directory );
		
		while ( !folders.empty() ) {
//			pop the top directory from folders
//			create a list of the files in the popped directory
			currentFolderPath = folders.pop();
			currentFolder = new File( currentFolderPath );
			fileList = currentFolder.list();
			
//			iterate through the list
//			if it's the right file, add to count, if it's a directory add to the stack
			for ( String s : fileList ) {
				currentFilePath = new String( currentFolderPath + "\\" + s );
				currentFile = new File( currentFilePath );
				
				if ( currentFile.isDirectory() ) {
					folders.push( currentFilePath );
				}
				else if ( currentFile.isFile() ) {
					if ( currentFilePath.endsWith( fileType ) )
						count++;
				}
			}	//	end inner for
		}	//	end outer while
		
		return count;
	}

	public static void main(String[] args) {
		int x;
		
		x = countFiles( "C:\\Users\\demps\\Desktop\\cf-tester", new String("java"));
		System.out.println("Count java = " + x + "\n");
		x = countFiles( "C:\\Users\\demps\\Desktop\\cf-tester", new String("txt"));
		System.out.println("Count txt = " + x);
	}

}
