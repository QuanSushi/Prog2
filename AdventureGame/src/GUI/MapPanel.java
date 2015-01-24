package GUI;

import input.ImageReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actors.GameMaster;
import actors.Player;
import dungeon.Room;

public class MapPanel implements Observer {
	
	private static MapPanel instance;
	
	static final int X = 9;
	static final int Y = 7;
	
	Vector<Room> roomCache = null;
	
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
	}
	

	@Override
	public void update(Observable player, Object position) {
		//pseudocode:
		//find Room with ID == player.position and setIcon(ImageReader.getInstance().getImage());
		System.out.println("Player now in room: " + Player.getInstance().getPosition());
	}
	

}
