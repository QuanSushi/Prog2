package GUI;

import input.ImageReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dungeon.Room;
import actors.GameMaster;

public class MapPanel {
	
	private static MapPanel instance;
	
	static final int X = 9;
	static final int Y = 7;
	
	ArrayList<JLabel> labels = new ArrayList<JLabel>();
	
	public static MapPanel getInstance() {
		if (instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}
	
	JPanel mapPanel = new JPanel(new GridLayout(Y, X));
	
	private MapPanel() {
		mapPanel.setBackground(Color.BLACK);
		mapPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		mapPanel.setPreferredSize(new Dimension(765, 595));
		
		createJLabels();
		
	}
	
	public JPanel getMapPanel(){
		return mapPanel;
		
	}
	
	private void createJLabels() {
		for (int i = 0; i < (9*7); i++) {
			JLabel label = new JLabel();
			label.setBorder(BorderFactory.createLineBorder(Color.white));
			this.labels.add(label);
			this.mapPanel.add(label);
			
		}
	}
	
	public void drawMap() {
		/*
		Vector<Room> roomCache = null;
		if (GameMaster.getInstance().getLabyrinth() != null) {
		 roomCache= GameMaster.getInstance().getLabyrinth();
		}
		labels.get(0).setIcon(ImageReader.getInstance().getImage());
		for (int room = 0; room < roomCache.size(); room++) {
			if (!roomCache.elementAt(room).getN().equals("0")) {
				//labels.get(room - 9).setIcon(ImageReader.getInstance().getImage());
			}
			if (!roomCache.elementAt(room).getE().equals("0")) {
				labels.get(room + 1).setIcon(ImageReader.getInstance().getImage());
			}
			if (!roomCache.elementAt(room).getS().equals("0")) {
				//labels.get(room +9).setIcon(ImageReader.getInstance().getImage());
			}
			if (!roomCache.elementAt(room).getW().equals("0")) {
				labels.get(room - 1).setIcon(ImageReader.getInstance().getImage());
			}
		}
		*/
		
		Vector<Room> roomCache = null;
		if (GameMaster.getInstance().getLabyrinth() != null) {
		 roomCache= GameMaster.getInstance().getLabyrinth();
		}
		labels.get(0).setIcon(ImageReader.getInstance().getImage());
		int roomY = 0;
		int roomX = 0;
		for (int i = 0; i < roomCache.size(); i++) {
			roomX = i;
			if (!roomCache.elementAt(i).getS().equals("0")) {
				labels.get(roomX + 9).setIcon(ImageReader.getInstance().getImage());
				roomX += 9;
			if (!roomCache.elementAt(i).getE().equals("0")) {
				labels.get(roomX + 1).setIcon(ImageReader.getInstance().getImage());
			}

			}
			
		}

	}
	

}
