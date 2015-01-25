package GUI;

/**
 * Controller buttons for movements
 */

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import actors.GameMaster;

public class ControllerPanel {
	
	private JPanel buttonPanel = new JPanel();
	private Label label=new Label("Click the field and use arrow keys to move.");
	private TextField textfield=new TextField();
	
	
	public void createButtons() {
		
		JButton north = new JButton("North");
		JButton west = new JButton("West");
		JButton east = new JButton("East");
		JButton south = new JButton("South");
		
	
		north.setActionCommand("N");
		north.addActionListener(GameMaster.getInstance());
		
		west.setActionCommand("W");
		west.addActionListener(GameMaster.getInstance());
		
		east.setActionCommand("E");
		east.addActionListener(GameMaster.getInstance());
		
		south.setActionCommand("S");
		south.addActionListener(GameMaster.getInstance());

		this.buttonPanel.setPreferredSize(new Dimension(800,100));
		this.buttonPanel.setLayout(null);
		this.buttonPanel.add(north);
		this.buttonPanel.add(west);
		this.buttonPanel.add(east);
		this.buttonPanel.add(south);
		this.buttonPanel.add(label);
		label.setBounds(450, 20, 345, 30);
		label.setFont(new Font("Arial",Font.BOLD, 12));
		north.setBounds(85, 10, 60, 30);
		west.setBounds(35, 40, 60, 30);
		east.setBounds(135, 40, 60, 30);
		south.setBounds(85, 70, 60, 30);
		
		this.buttonPanel.add(textfield);
		textfield.setBounds(450, 50, 345, 30);
        textfield.addKeyListener(GameMaster.getInstance());
	}
	
	public JComponent getControllerPanel() {
		return buttonPanel;
	}

	public TextField getTextField(){
		return textfield;
	}


}
