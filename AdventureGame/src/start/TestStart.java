package start;

/**
 * authors: Tran Anh Quan, Do Long
 * 
 * Gits: 
 * https://github.com/QuanSushi/Prog2
 * https://github.com/longdo93/Prog2
 * 
 * Java version: 1.7
 * Programm Version: 1.0
 * 
 * known bugs: infinite quiz when using arrow keys to move to magic room.
 */

import GUI.MainFrame;
import dungeon.Client;
import dungeon.Factory;
import dungeon.FactoryB;

public class TestStart {

	public static void main(String[] args) {
		
		Client c = Client.getInstance();
		c.setFactory(Factory.getInstance(), FactoryB.getInstance());
		c.setGameMaster();
		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);

	}

}
