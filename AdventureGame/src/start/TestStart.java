package start;

import GUI.MainFrame;
import dungeon.Client;
import dungeon.Factory;

public class TestStart {
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		Client c = new Client();
		c.setFactory(new Factory());
		c.setGameMaster();
		c.makeRoom();
		c.startGame();
	}

}
