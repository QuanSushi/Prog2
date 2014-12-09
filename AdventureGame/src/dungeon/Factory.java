package dungeon;

public class Factory extends AbstractFactory {

	@Override
	public AbstractRoom makeRoom() {
		return new Room(null);
	}

}
