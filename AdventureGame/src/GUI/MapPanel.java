package GUI;

import input.ImageReader;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel {
	
	private static MapPanel instance;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	public static MapPanel getInstance() {
		if (instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}
	
	JPanel mapPanel = new JPanel();
	
	private MapPanel() {
		mapPanel.setBackground(Color.BLACK);
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridx = 9;
		gbc.gridy = 7;
		
		mapPanel.setLayout(gb);
		createJLabels();
		setIcons();
		System.out.println(labels.get(6).toString());
		
		
	}
	
	public JPanel getMapPanel(){
		return mapPanel;
		
	}
	
	private void createJLabels() {
		for (int i = 0; i < (9*7); i++) {
			labels.add(new JLabel());
		}
	}
	
	private void setIcons() {
		for (int i = 0; i < (9*7); i++) {
			labels.get(i).setIcon(ImageReader.getInstance().getImage());
		}
	}
	
	
}
