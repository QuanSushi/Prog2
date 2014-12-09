package dungeon;

import java.util.Vector;

public class Client {
	
	private AbstractFactory factory = null;
	Vector<Room> labyrinth = new Vector<Room>();
	
	public void setFactory(AbstractFactory factory) {
		System.out.println("setFactory()");						//delete this later
		this.factory = factory;
	}
	
	public void makeRoom() {
		if (this.factory != null) {
			System.out.println("makeRoom()");					//delete this later
			this.labyrinth.add((Room) this.factory.makeRoom());
		}
	}
	
}
