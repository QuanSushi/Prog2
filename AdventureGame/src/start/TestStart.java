package start;

import GUI.MainFrame;
import dungeon.Client;
import dungeon.Factory;

public class TestStart {
	
	public static void main(String[] args) {
		Client c = new Client();
		c.setFactory(new Factory());
		c.setGameMaster();
		c.makeRoom();
		c.setMainFrame();
		c.startGame();
	}

}
