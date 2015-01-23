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

public class RoomReader {

	private Vector<String> vec = new Vector<String>();

	public RoomReader() {
		
	}
	
	private String getResources() {
		java.net.URL url = RoomReader.class.getClassLoader().getResource(
				"files/Raumaufbau.txt");
		System.out.println("RoomReader: Reading files/Raumaufbau.txt...");				//delete this line
		System.out.println(url.getPath());
		return url.getPath();
	}

	/**
	 * This method reads "Raumaufbau.txt" and builds a String for each row.
	 * Those Strings are added to a Vector.
	 * 
	 * @throws IOException
	 */
	private void readRoomPlan() throws IOException {
		FileReader fr = new FileReader(getResources());
		BufferedReader br = new BufferedReader(fr);
		String zeile = null;
		while ((zeile = br.readLine()) != null) {
			this.vec.addElement(zeile);
		}
		this.vec.remove(0); // removes "ID:n:e:s:w"
		br.close();
	}

	/**
	 * Method calls readRoomPlan()
	 * 
	 * @return method returns the vector with the build plan for each room.
	 */
	public Vector<String> getRoomPlans() {
		try {
			readRoomPlan();
			System.out.println("getRoomPlans()");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.vec;
	}

}
