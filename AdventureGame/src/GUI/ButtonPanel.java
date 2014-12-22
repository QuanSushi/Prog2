
/**
longdo
*/
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import actors.GameMaster;
import actors.Player;

public class ButtonPanel {

	private JPanel buttonPanel;
	GameMaster gm=new GameMaster();
	Player player=new Player();
	private JButton north = new JButton("North");
	private JButton west = new JButton("West");
	 private JButton east = new JButton("East");
	private JButton south = new JButton("South");

	public void createButtons() {

		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.add(north);
		buttonPanel.add(west);
		buttonPanel.add(east);
		buttonPanel.add(south);
		north.setBounds(85, 435, 60, 30);
		west.setBounds(35, 465, 60, 30);
		east.setBounds(135, 465, 60, 30);
		south.setBounds(85, 495, 60, 30);
	}
	
	public void createButtonListeners(){
		this.north.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("N");
				String direction=player.getDirection();
				System.out.println(direction);
				gm.movePlayer(player.getDirection());
				}
		});
		
		this.west.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("W");
				gm.movePlayer(player.getDirection());
				}
		});
		
		this.east.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("E");
				gm.movePlayer(player.getDirection());
				}
		});
		
		this.south.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("S");
				gm.movePlayer(player.getDirection());
				}
		});
		
	}

	public JComponent getbuttonPanel() {
		return buttonPanel;
	}
}
