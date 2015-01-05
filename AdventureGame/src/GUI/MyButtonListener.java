package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

class MyButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("north")) {
			System.out.println("North");
		}else if (e.getActionCommand().equals("west")) {
			System.out.println("West");
		}else if (e.getActionCommand().equals("south")) {
			System.out.println("South");
		}else if (e.getActionCommand().equals("east")) {
			System.out.println("East");
		}
		
	}
	
	
	
}