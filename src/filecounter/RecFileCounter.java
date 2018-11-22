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
		//	Note: passing an empty string to this method will count all files
		//		since an empty string to the String.endsWith() method always returns true
		return countFiles(directory, "");
	}
	
	/**
	 * Counts all the files of a given type in a given directory
	 * @param directory a string indicating a directory on you computer
	 * @param fileType a string giving the extension of the file type you're looking for<br>
	 * 	e.g. "*.java" for java source files
	 * @return the number of files of type fileType in directory
	 */
	public static int countFiles(String directory, String fileType) {
		int count = 0;
		//	TODO elaborate on this check; add checking for invalid fileType Strings
		if ( !(fileType.isEmpty() || fileType.startsWith(".")) )		//	Formats the fileType to a proper extension e.g. .java or .txt
			fileType = "." + fileType;
		
		//	take the input directory and create a File object
		//	then generate a list of the files in the directory
		File thisDirectory = new File( directory );
		String [] dirList = thisDirectory.list();
		
		//	iterate through the list, counting files 
		//		and further investigating directories
		for( String fString : dirList ) {
			File myFile = new File( directory + "/" + fString );
			if ( myFile.isFile() ) {
				//	TODO check if it's the correct type
				//		then increment count
				if ( fString.endsWith(fileType) ) {
//					System.out.println("Block entered");
					count++;
				}
			} 
			else if ( myFile.isDirectory() ) {
				//	inspect this new directory (passing it as a String to the function (not a file))
				//	add the result of the call to count
				count += countFiles( myFile.getPath(), fileType );
			}	//	end if
		
//			DEBUG
//			System.out.println(fString);
			
		}	//	end for
		
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x;
		x = countFiles( "C:/Users/demps/Desktop/cf-tester", new String("java"));
		System.out.println("\nCount java = " + x);
		x = countFiles( "C:/Users/demps/Desktop/cf-tester", new String("txt"));
		System.out.println("Count txt = " + x);
		
		x = countFiles( "C:/Users/demps/Desktop/cf-tester");
		System.out.println("Count = " + x);
	}

}
