package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dungeon.Client;

class MyButtonListener implements ActionListener {

	private static MyButtonListener instance;

	private MyButtonListener() {

	}

	public static MyButtonListener getInstance() {
		if (instance == null) {
			instance = new MyButtonListener();
		}
		return instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("open_map")) {
			Client.getInstance().makeRoom();
			Client.getInstance().startGame();
		}

	}

}