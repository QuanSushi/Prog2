package dungeon;

import input.RoomReader;

import java.util.Observable;
import java.util.Vector;

public class Factory extends AbstractFactory {

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
			RoomReader rr = new RoomReader();
			this.roomplans = rr.getRoomPlans();
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
