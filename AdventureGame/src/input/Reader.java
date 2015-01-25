package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * 
 * @author JQBS (Tran Anh Quan, Matrikelnr: s0547269) E-mail: me@quan-sushi.com
 * @version 1.0
 * @date 2014/11/20 - 21:29
 * @lastedited 2014/11/20 - 21:45
 * @java-version 1.7
 * @filename:
 * 
 *
 * 
 */

public class Reader {
	
	private static Reader instance;
	
	public static Reader getInstance() {
		if (instance == null) {
			instance = new Reader();
		}
		return instance;
	}

	private Reader() {
	}
	
	/**
	 * 
	 * @param s
	 * @return file path
	 */
	private String getResources(String s) {
		java.net.URL url = Reader.class.getClassLoader().getResource(s);
		return url.getPath();
	}

	/**
	 * This method reads "Raumaufbau.txt" and builds a String for each row.
	 * Those Strings are added to a Vector.
	 * 
	 * @throws IOException
	 */
	private Vector<String> readFile(String s) throws IOException {
		Vector<String> vec = new Vector<String>();
		FileReader fr = new FileReader(getResources(s));
		BufferedReader br = new BufferedReader(fr);
		String zeile = null;
		while ((zeile = br.readLine()) != null) {
			vec.addElement(zeile);
		}
		vec.remove(0); // removes "ID:n:e:s:w"
		br.close();
		return vec;
	}

	/**
	 * Method calls readRoomPlan()
	 * 
	 * @return method returns the vector with the build plan for each room.
	 * @throws IOException 
	 */
	public Vector<String> getRoomPlans() throws IOException {
		return readFile("files/Raumaufbau.txt");
	}
	
	/**
	 * 
	 * @return Strings with Questions and answers for the magic room.
	 * @throws IOException
	 */
	public Vector<String> getQuestions() throws IOException {
		return readFile("files/Fragen.txt");
	}

}
