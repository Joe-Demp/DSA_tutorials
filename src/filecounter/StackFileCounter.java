package filecounter;

import java.io.File;

import stack.ListStack;

public class StackFileCounter extends FileCounter {
	public static int countFiles(String directory) {
//		TODO fill in this method
		return -1;
	}
	
	public static int countFiles(String directory, String fileType) {
		int count = 0;
		ListStack<String> folders = new ListStack<String>();
		File currentFolder, currentFile;
		String [] fileList;
		
//		First push directory onto the stack
		folders.push( directory );
		
		while ( !folders.empty() ) {
//			pop the top directory from folders
//			create a list of the files in the popped directory
			currentFolder = new File( folders.pop() );
			fileList = currentFolder.list();
			
//			iterate through the list
//			if it's the right file, add to count, if it's a directory add to the stack
			for ( String s : fileList ) {
				currentFile = new File( s );
				
				if ( currentFile.isDirectory() )
					folders.push( s );
				else if ( currentFile.isFile() && s.endsWith( fileType ) )
					count++;
			}	//	end inner for
		}	//	end outer while
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
