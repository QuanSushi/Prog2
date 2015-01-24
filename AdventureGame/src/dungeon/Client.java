package dungeon;

import java.util.Random;
import java.util.Vector;

import actors.GameMaster;

public class Client {
	
	private static Client instance;
	private Client() {
		
	}
	private boolean makeRoomDone = false;
	
	public static Client getInstance() {
		if (instance == null) {
			instance = new Client();
		}
		
		return instance;
	}
	
	private AbstractFactory factory = null;
	private AbstractFactory factoryB = null;
	private GameMaster gm = null;
	
	Vector<AbstractRoom> labyrinth = new Vector();				//list for generated rooms
	
	public void setFactory(AbstractFactory factory, AbstractFactory factoryB) {
		if (this.factory == null && this.factoryB == null) {
			this.factory = factory;
			this.factoryB = factoryB;
		}
	}
	
	
	
	public void setGameMaster() {
		if (this.gm == null) {
			this.gm = GameMaster.getInstance();
		}
	}
	
	public void makeRoom() {
		if ((this.factory != null) && (this.makeRoomDone == false)) {
			System.out.println("makeRoom()");					//delete this later
			this.factory.setRoomPlan();
			for (int i = 0; i < this.factory.getRoomCount(); i++) {
				this.labyrinth.add((Room) this.factory.makeRoom(i));
			}
			this.makeRoomDone = true;
		}
		
			Random random = new Random();
			int r = random.nextInt(this.labyrinth.size());
			this.factoryB.setRoomPlan();
			this.labyrinth.set(r, (MagicRoom) this.factoryB.makeRoom(r));
			System.out.println("MagicRoom is room: " + r);
			

	}
	
	public void startGame() {
		this.gm.setGame(this.labyrinth);
	}
	
	public boolean checkLabyrinth() {
		if (this.labyrinth.size() > 1) {
			return true;
		}else
			return false;
	}
	
}
