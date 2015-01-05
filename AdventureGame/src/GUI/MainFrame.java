package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import actors.GameMaster;

public class MainFrame extends JFrame {
	
	private GameMaster bl = null;

	public MainFrame(GameMaster gm) {
		this.bl = gm;
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setSize(800, 600);				//sizing app frame
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);		//centering app frame

		createMenuBar();
		JPanel bp = createButtons();
		getContentPane().add(bp);
		
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuFile2 = new JMenu("Figure");
		JMenu menuFile3 = new JMenu("Help");
		JMenu menuFile4 = new JMenu("Author");
		
		menuFile.add(MenuItemFactory.createMenuItem("Open...", 'o', "file_open"));
		menuFile.add(MenuItemFactory.createMenuItem("Save...", 's', "file_save"));
		menuFile.add(MenuItemFactory.createMenuItem("Quit...", 'q', "file_close"));
		menuFile2.add(MenuItemFactory.createMenuItem("Open...", 'o', "figure_open"));
		
		menuBar.add(menuFile);
		menuBar.add(menuFile2);
		menuBar.add(menuFile3);
		menuBar.add(menuFile4);
		setJMenuBar(menuBar);
	}

	private JPanel createButtons() {
		
		JPanel buttonPanel = new JPanel();
		
		JButton north = new JButton("North");
		north.setActionCommand("north");
		north.addActionListener(this.bl);
		JButton west = new JButton("West");
		west.setActionCommand("west");
		west.addActionListener(this.bl);
		JButton east = new JButton("East");
		east.setActionCommand("east");
		east.addActionListener(this.bl);
		JButton south = new JButton("South");
		south.setActionCommand("south");
		south.addActionListener(this.bl);

		buttonPanel.setLayout(null);
		buttonPanel.add(north);
		buttonPanel.add(west);
		buttonPanel.add(east);
		buttonPanel.add(south);
		north.setBounds(85, 435, 60, 30);
		west.setBounds(35, 465, 60, 30);
		east.setBounds(135, 465, 60, 30);
		south.setBounds(85, 495, 60, 30);
		
		return buttonPanel;
	}

}
