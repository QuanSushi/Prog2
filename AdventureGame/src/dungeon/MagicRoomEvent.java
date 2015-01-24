package dungeon;

import input.Reader;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import actors.Player;

/**
 * This class handles the event when the player should step into the magic room.
 * @author QS
 *
 */

public class MagicRoomEvent {
	
	private static MagicRoomEvent instance;
	Vector<String> questions = new Vector<String>();
	Vector<String> answers = new Vector<String>();
	
	private MagicRoomEvent() {
	}
	
	public static MagicRoomEvent getInstance() {
		if (instance == null) {
			instance = new MagicRoomEvent();
		}
		return instance;
	}
	
	/**
	 * This loads Fragen.txt and sets the questions and their answers.
	 */
	private void setQandA() {
		Vector<String> cache = null;
		try {
			cache = Reader.getInstance().getQuestions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < cache.size(); i++) {
			String[] split = cache.elementAt(i).split(":");
			this.questions.add(split[0]);
			this.answers.add(split[1].toLowerCase());
		}
		
	}
	
	/**
	 * This method makes the player unable to move on and starts the quiz.
	 * When the question has been answered, then the player is again able to move.
	 */
	public void quiz() {
		if (answers == null) {
			setQandA();
		}
		Player.getInstance().setIsAbleToMove(false);
		
		boolean quiz = true;
		Random r = new Random();
		int zahl = r.nextInt(questions.size());
		System.out.println(questions.elementAt(zahl));
		while (quiz) {
			/*pseudocode:
			* if (input.toLowerCase().equals(answers.elementAt(zahl)) {
			* System.out.println("Deine Antwort ist richtig!");
			* Player.getInstance().setIsAbleToMove(true);
			* quiz = true;
			*/
		}
		
	}
	
	

}
