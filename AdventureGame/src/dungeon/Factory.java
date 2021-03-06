package dungeon;

import input.Reader;

import java.io.IOException;
import java.util.Vector;

public class Factory extends AbstractFactory {
	
	private static Factory instance;
	
	private Factory() {
	}
	
	public static Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		
		return instance;
	}

	Vector<String> roomplans = null; // this vector saves the blueprint for each
										// room

	/*
	 * This method returns a room with blueprint loaded from roomplans index i.
	 * 
	 * @see dungeon.AbstractFactory#makeRoom(int)
	 */
	@Override
	public AbstractRoom makeRoom(int i) {
		return new Room(roomplans.elementAt(i));
	}

	/*
	 * This method sets roomplans to the blueprints.
	 * 
	 * @see dungeon.AbstractFactory#setRoomPlan()
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

	/*
	 * This method counts the number of rooms to be made.
	 * 
	 * @see dungeon.AbstractFactory#getRoomCount()
	 */
	@Override
	public int getRoomCount() {
		return this.roomplans.size();
	}

}
