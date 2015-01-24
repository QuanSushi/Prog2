package dungeon;

import input.Reader;

import java.io.IOException;
import java.util.Vector;

public class FactoryB extends AbstractFactory {
	
	private static FactoryB instance;
	
	private FactoryB() {
	}
	
	public static FactoryB getInstance() {
		if (instance == null) {
			instance = new FactoryB();
		}
		
		return instance;
	}

	Vector<String> roomplans = null; // this vector saves the blueprint for each room	
	/**
	 * This method returns a MagicRoom
	 */
	@Override
	public AbstractRoom makeRoom(int i) {
		return new MagicRoom(this.roomplans.elementAt(i));
	}

	/**
	 * Loads build plan
	 */
	@Override
	public void setRoomPlan() {
		if (roomplans == null) {
			try {
				this.roomplans = Reader.getInstance().getRoomPlans();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getRoomCount() {
		return 0;
	}

}
