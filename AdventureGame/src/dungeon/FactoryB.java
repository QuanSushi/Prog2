package dungeon;

import input.RoomReader;

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

	Vector<String> roomplans = null; // this vector saves the blueprint for each	
	
	@Override
	public AbstractRoom makeRoom(int i) {
		return new MagicRoom(this.roomplans.elementAt(i));
	}

	@Override
	public void setRoomPlan() {
		if (roomplans == null) {
			this.roomplans = RoomReader.getInstance().getRoomPlans();
		}
	}

	@Override
	public int getRoomCount() {
		return 0;
	}

}
