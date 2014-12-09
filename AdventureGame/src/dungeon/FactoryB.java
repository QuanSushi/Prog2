package dungeon;

public class FactoryB extends AbstractFactory {

	@Override
	public AbstractRoom makeRoom() {
		return new MagicRoom();
	}

}
