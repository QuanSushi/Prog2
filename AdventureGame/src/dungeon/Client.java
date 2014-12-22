package dungeon;

import java.util.Vector;

import actors.GameMaster;

public class Client {
	
	private AbstractFactory factory = null;
	private GameMaster gm;
	
	Vector<Room> labyrinth = new Vector<Room>();				//list for generated rooms
	
	public void setFactory(AbstractFactory factory) {
		System.out.println("setFactory()");						//delete this later
		this.factory = factory;
	}
	
	public void setGameMaster() {
		if (this.gm == null) {
			System.out.println("setGameMaster()");			//delete this later
			this.gm = new GameMaster();
		}
	}
	
	public void makeRoom() {
		if (this.factory != null) {
			System.out.println("makeRoom()");					//delete this later
			this.factory.setRoomPlan();
			for (int i = 0; i < this.factory.getRoomCount(); i++) {
				this.labyrinth.add((Room) this.factory.makeRoom(i));
				System.out.println(labyrinth.elementAt(i).toString()); //delete this later
			}
			
		}
	}
	
	public void startGame() {
		this.gm.setGame(this.labyrinth);
	}
	
	
	
}
