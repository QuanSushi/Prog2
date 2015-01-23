package start;

import input.ImageReader;
import GUI.MainFrame;
import dungeon.Client;
import dungeon.Factory;

public class TestStart {

	public static void main(String[] args) {
		System.out.println(ImageReader.getInstance().getImgURL());
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		Client c = Client.getInstance();
		c.setFactory(Factory.getInstance());
		c.setGameMaster();
		
	}

}
