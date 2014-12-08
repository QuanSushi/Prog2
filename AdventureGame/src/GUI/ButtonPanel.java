/**
longdo
*/
package GUI;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ButtonPanel {

	private JPanel buttonPanel;

	public void createButtons() {

		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		JButton b1 = new JButton("North");
		JButton b2 = new JButton("West");
		JButton b3 = new JButton("East");
		JButton b4 = new JButton("South");
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		b1.setBounds(85, 435, 60, 30);
		b2.setBounds(35, 465, 60, 30);
		b3.setBounds(135, 465, 60, 30);
		b4.setBounds(85, 495, 60, 30);
	}

	public JComponent getbuttonPanel() {
		return buttonPanel;
	}

}