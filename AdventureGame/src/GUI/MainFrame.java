package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import GUI.MenuItemFactory;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * Sizing and centering app frame.
		 */
		setSize(800, 600);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);
		
		createMenuBar();
		buttonpanel.createButtons();
		getContentPane().add(buttonpanel.getbuttonPanel());
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		menuFile.add(MenuItemFactory.createMenuItem("Open...", 'o', "file_open"));
		menuFile.add(MenuItemFactory.createMenuItem("Save...",'s', "file_save"));
		menuFile.add(MenuItemFactory.createMenuItem("Quit...",'q', "file_close"));
		
		menuBar.add(menuFile);
		setJMenuBar(menuBar);
	}

}
