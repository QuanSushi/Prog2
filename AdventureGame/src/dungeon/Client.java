package dungeon;

import java.util.Vector;

import GUI.MainFrame;
import actors.GameMaster;

public class Client {
	
	private AbstractFactory factory = null;
	private GameMaster gm = null;
	private MainFrame mf = null;
	
	Vector<Room> labyrinth = new Vector<Room>();				//list for generated rooms
	
	public void setMainFrame() {
		if (this.mf == null && this.gm != null) {
			this.mf = new MainFrame(this.gm);
			this.mf.setVisible(true);
			System.out.println(this.gm.toString());				//delete later
		}
	}
	
	public void setFactory(AbstractFactory factory) {
		System.out.println("setFactory()");						//delete this later
		if (this.factory == null) {
			this.factory = factory;
		}
	}
	
	public void setGameMaster() {
		if (this.gm == null) {
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
