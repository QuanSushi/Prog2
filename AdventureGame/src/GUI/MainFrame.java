package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	private static MainFrame instance;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		ControllerPanel controller = new ControllerPanel();
		
		this.setTitle("Maze Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(765, 595);				//sizing app frame
		this.setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);		//centering app frame
		this.setBackground(Color.BLACK);
		this.getContentPane().setLayout(new BorderLayout());
	
		createMenuBar();
		controller.createButtons();
		getContentPane().add(controller.getControllerPanel(),BorderLayout.PAGE_END);

		
	}
	/**
	 * this method adds MapPanel to MainFrame after game has been loaded
	 */
	public void addMapPanel() {
		this.getContentPane().add(MapPanel.getInstance().getMapPanel());
		this.validate();
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
