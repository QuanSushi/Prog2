package dungeon;

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

	@Override
	public AbstractRoom makeRoom(int i) {
		return new MagicRoom("test");
	}

	@Override
	public void setRoomPlan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRoomCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
