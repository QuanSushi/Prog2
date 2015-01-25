package GUI;

/**
 * This class handles menu bar items.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
	
	/**
	 * Actionlistener for menu bar items.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("open_map")) {
			Client.getInstance().makeRoom();
			Client.getInstance().startGame();
			MapPanel.getInstance().initSpawn();
			MainFrame.getInstance().addMapPanel();
		}
		if(e.getActionCommand().equals("descr")){
			JOptionPane.showMessageDialog(null, "Bewege dich mit deinem Spieler im Raum und löse die Zaubersprüche",null, JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("show")){
			JOptionPane.showMessageDialog(null, "Long Do: s0547270\nQuan",null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}