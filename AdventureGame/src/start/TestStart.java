package start;

import GUI.MainFrame;
import dungeon.Client;
import dungeon.Factory;
import dungeon.FactoryB;

public class TestStart {

	public static void main(String[] args) {
		
		Client c = Client.getInstance();
		c.setFactory(Factory.getInstance(), FactoryB.getInstance());
		c.setGameMaster();
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
	}

}
