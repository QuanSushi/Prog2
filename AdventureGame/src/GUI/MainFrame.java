package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(800, 600);				//sizing app frame
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);		//centering app frame

		createMenuBar();
		ControllerPanel controller = new ControllerPanel();
		controller.createButtons();
		
		getContentPane().add(controller.getControllerPanel());
		
		/*
		//test		
		JInternalFrame inFrame1 = new JInternalFrame("Dokument 1", true, true, true, true);
		inFrame1.setSize(200,200);
		inFrame1.setLocation(0, 0);
		inFrame1.show();
		
		getContentPane().add(inFrame1);
		*/

		
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuFile2 = new JMenu("Figure");
		JMenu menuFile3 = new JMenu("Help");
		JMenu menuFile4 = new JMenu("Author");
		
		menuFile.add(MenuItemFactory.createMenuItem("Open Raumaufbau.txt...", 'o', "open_map"));
		menuFile.add(MenuItemFactory.createMenuItem("Save...", 's', "file_save"));
		menuFile.add(MenuItemFactory.createMenuItem("Quit...", 'q', "file_close"));
		menuFile2.add(MenuItemFactory.createMenuItem("Open...", 'o', "figure_open"));
		
		menuBar.add(menuFile);
		menuBar.add(menuFile2);
		menuBar.add(menuFile3);
		menuBar.add(menuFile4);
		setJMenuBar(menuBar);
	}
	
}
