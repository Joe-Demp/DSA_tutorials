/**
 * 
 */
package filecounter;

import java.io.File;

/**
 * @author demps
 *
 */
public class RecFileCounter extends FileCounter {
	
	/**
	 * Counts all the files in a given directory
	 * @param directory a string indicating a directory on you computer
	 * @return the number of files in the given directory
	 */
	public static int countFiles(String directory) {
		//	TODO find out if there is a way to get this method to call countFiles(String, String)
		//		perhaps passing an empty String as fileType?
		return -1;
	}
	
	/**
	 * Counts all the files of a given type in a given directory
	 * @param directory a string indicating a directory on you computer
	 * @param fileType a string giving the extension of the file type you're looking for<br>
	 * 	e.g. "*.java" for java source files
	 * @return the number of files of type fileType in directory
	 */
	public static int countFiles(String directory, String fileType) {
		//	TODO fill in this method
		int count = 0;
		
		//	take the input directory and create a File object
		//	then generate a list of the files in the directory
		File thisDirectory = new File( directory );
		String [] dirList = thisDirectory.list();
		
		//	iterate through the list, counting files 
		//		and further investigating directories
		for( String fString : dirList ) {
			//	TODO check if this works: might not create a File object out of the fString (this is just the file name, might need to add on path)
			File myFile = new File( directory + "/" + fString );
			if ( myFile.isFile() ) {
				//	TODO check if it's the correct type
				//		then increment count
				count++;
			} 
			else if ( myFile.isDirectory() ) {
				//	construct a new string to pass to countFiles, recursive call
				//	Note: fString is the name of the directory only
//				TODO remove this
//				String subDirectory = new String(directory + "/" + fString);
				
				//	add the result of the call to count
				count += countFiles( myFile.getPath(), fileType );
			}	//	end if
			
//			DEBUG
//			System.out.println( fString );
		}	//	end for
		
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x;
		x = countFiles( "C:/Users/demps/Desktop/cf-tester", new String());
		
		System.out.println("Count = " + x);
	}

}
