package dungeon;

import input.Reader;

import java.io.IOException;
import java.util.Vector;

/**
 * This class handles the event when the player should step into the magic room.
 * @author QS
 *
 */

public class MagicRoomEvent {
	
	private static MagicRoomEvent instance;
	Vector<String> questions;
	Vector<String> answers;
	
	private MagicRoomEvent() {
		
	}
	
	public static MagicRoomEvent getInstance() {
		if (instance == null) {
			instance = new MagicRoomEvent();
		}
		return instance;
	}
	
	private void setQandA() {
		Vector<String> cache;
		try {
			cache = Reader.getInstance().getQuestions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
