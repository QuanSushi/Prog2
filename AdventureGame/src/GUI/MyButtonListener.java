package GUI;

/**
 * This class handles menu bar items.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import actors.Player;
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
	
	private boolean roomaufbau = false;
	
	/**
	 * Actionlistener for menu bar items.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("open_map") && roomaufbau == false) {
			Client.getInstance().makeRoom();
			Client.getInstance().startGame();
			MapPanel.getInstance().initSpawn();
			MainFrame.getInstance().addMapPanel();
			this.roomaufbau = true;
		}
		if (e.getActionCommand().equals("figure_open") && roomaufbau == true) {
			MapPanel.getInstance().drawMap();
			Player.getInstance().setIsAbleToMove(true);
		}
		if(e.getActionCommand().equals("descr")){
			JOptionPane.showMessageDialog(null, "Bewege dich mit deinem Spieler im Raum und löse die Zaubersprüche",null, JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("show")){
			JOptionPane.showMessageDialog(null, "Long Do: s0547270\nQuan Tran Anh: s0547269",null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}