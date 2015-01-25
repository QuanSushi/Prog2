package GUI;

/**
 * This class creates map tiles for the GUI
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import actors.GameMaster;
import actors.Player;
import dungeon.AbstractRoom;

public class MapPanel implements Observer {

	private static MapPanel instance;

	private int X;
	private int Y;
	private int yCoordinate;
	private int xCoordinate;
	private MapTile currentTile;
	private MapTile previousTile;

	public static MapPanel getInstance() {
		if (instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}

	private JPanel mapPanel;
	private MapTile map[][];

	private MapPanel() {
		this.setY(GameMaster.getInstance().countNorth() * 2);
		this.setX(GameMaster.getInstance().countEast() * 2);
		this.map = new MapTile[getY()][getX()];
		this.mapPanel = new JPanel(new GridLayout(getY(), getX()));
		mapPanel.setBackground(Color.BLACK);
		mapPanel.setPreferredSize(new Dimension(765, 595));

		createJLabels();
		System.out.println("labels created");
	}

	public JPanel getMapPanel() {
		return mapPanel;

	}

	/**
	 * creates JLabels for the map tiles
	 */
	private void createJLabels() {
		for (int y = 0; y < this.getY(); y++) {
			for (int x = 0; x < this.getX(); x++) {
				MapTile label = new MapTile();
				map[y][x] = label;
				mapPanel.add(map[y][x]);
			}
		}
	}

	/**
	 * init drawing and settings
	 */
	public void initSpawn() {
		setyCoordinate(getY() / 2);
		setxCoordinate(getX() / 2);
		setCurrentTile(map[yCoordinate][xCoordinate]);
		getCurrentTile().paint("room");
	}

	/**
	 * this method draws the surrounding map tiles and the player. If neighbour
	 * room exists: paint, if this room is magic room: paint as magic room.
	 */
	public void drawMap() {
		AbstractRoom cache = GameMaster.getInstance().getRoom(
				Player.getInstance().getPosition());
		if (cache.getIsMagicRoom()) {
			getCurrentTile().paint("pl_magicRoom");
		} else
			getCurrentTile().paint("pl_room");

		if (!cache.getN().equals("0")) {
			if (GameMaster.getInstance().getRoom(cache.getN()).getIsMagicRoom()) {
				map[yCoordinate - 1][xCoordinate].paint("magicRoom");
			} else
				map[yCoordinate - 1][xCoordinate].paint("room");
		}

		if (!cache.getS().equals("0")) {
			if (GameMaster.getInstance().getRoom(cache.getS()).getIsMagicRoom()) {
				map[yCoordinate + 1][xCoordinate].paint("magicRoom");
			} else
				map[yCoordinate + 1][xCoordinate].paint("room");
		}

		if (!cache.getE().equals("0")) {
			if (GameMaster.getInstance().getRoom(cache.getE()).getIsMagicRoom()) {
				map[yCoordinate][xCoordinate + 1].paint("magicRoom");
			} else
				map[yCoordinate][xCoordinate + 1].paint("room");
		}

		if (!cache.getW().equals("0")) {
			if (GameMaster.getInstance().getRoom(cache.getW()).getIsMagicRoom()) {
				map[yCoordinate][xCoordinate - 1].paint("magicRoom");
			} else
				map[yCoordinate][xCoordinate - 1].paint("room");
		}
		

	}

	/**
	 * Updates playerposition in the GUI and paints tiles.
	 */
	@Override
	public void update(Observable GM, Object enterRoom) {
		
		getCurrentTile().paint("room");

		if (enterRoom.equals("N")) {
			yCoordinate += -1;
		}
		if (enterRoom.equals("S")) {
			yCoordinate += 1;
		}
		if (enterRoom.equals("E")) {
			xCoordinate += 1;
		}
		if (enterRoom.equals("W")) {
			xCoordinate += -1;
		}
		setCurrentTile(map[yCoordinate][xCoordinate]);
		drawMap();
		System.out.println("Player now in room: "
				+ Player.getInstance().getPosition());
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public MapTile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(MapTile mapTile) {
		this.currentTile = mapTile;
	}

	public MapTile getPreviousTile() {
		return previousTile;
	}

	public void setPreviousTile(MapTile previousTile) {
		this.previousTile = previousTile;
	}

}
