package dungeon;

public abstract class AbstractFactory {
	
	/*
	 * This method returns a room
	 */
	public abstract AbstractRoom makeRoom(int i);
	
	/*
	 * This method loads the blueprints for the rooms.
	 */
	public abstract void setRoomPlan();
	
	/*
	 * This method counts the number of rooms to be made.
	 */
	public abstract int getRoomCount();
}
