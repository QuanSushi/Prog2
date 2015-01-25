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
			JOptionPane.showMessageDialog(null, "Bewege dich mit deinem Spieler im Raum und loese die Zaubersprueche",null, JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("show")){
			JOptionPane.showMessageDialog(null, "Adventure Game ver1.0 \n"
					+ "by \nLong Do: s0547270\nAnh Quan Tran: s0547269\n"
					+ "Git: https://github.com/QuanSushi/Prog2",null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}