package actors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import GUI.MapPanel;
import dungeon.AbstractRoom;
import dungeon.Client;
import dungeon.MagicRoomEvent;

/**
 * This Class is the GameMaster.
 * The GameMaster observes the game and moves the Player, manages game rules etc.
 */

public class GameMaster extends Observable implements ActionListener, KeyListener {

	private static GameMaster instance;

	private GameMaster() {
	}

	public static GameMaster getInstance() {
		if (instance == null) {
			instance = new GameMaster();
		}

		return instance;
	}

	private Player player;
	private Vector<AbstractRoom> labyrinth;
	private AbstractRoom roomCache = null;

	/**
	 * Initiates the game. Sets player position to a random room.
	 */
	public void setGame(Vector<AbstractRoom> labyrinth) {
		if (this.labyrinth == null) {
			this.labyrinth = labyrinth;
		}
		if (this.player == null) {
			this.player = Player.getInstance();
			Random random = new Random();
			int r = random.nextInt((this.labyrinth.size()));
			r += 1;
			
			String s = String.valueOf(r);
			this.player.setPosition(s);	
			System.out.println("Player spawned in room: " + player.getPosition());
			
			this.addObserver(MapPanel.getInstance());
		}
	}
	
	/**
	 * Gets a room in the vector.
	 * @param i
	 * @return a specific room in the list at i
	 */
	public AbstractRoom getRoom(int i) {
		AbstractRoom room = this.labyrinth.elementAt(i);
		return room;
	}

	/**
	 * Takes parameter direction and player position. Checks if the room has a
	 * door at this direction. If yes, return true, if not, return false.
	 */
	public boolean checkMove(String target, String playerPos) {
		target = this.player.getDirection();
		playerPos = this.player.getPosition();
		AbstractRoom room = getPlayerRoom();

		switch (target) {
		case "N":
			if (room.getN().equals("0")) {
				return false;
			} else
				return true;
		case "E":
			if (room.getE().equals("0")) {
				return false;
			} else
				return true;
		case "S":
			if (room.getS().equals("0")) {
				return false;
			} else
				return true;
		case "W":
			if (room.getW().equals("0")) {
				return false;
			} else
				return true;
		default:
			return false;
		}

	}

	/**
	 * Checks if player is able to move to given direction. If true setPosition to room
	 * lying in this direction.
	 */
	public void movePlayer(String direction) {
		this.player.setDirection(direction);
		String enterRoom = "";
		AbstractRoom room = getPlayerRoom();
		if (checkMove(direction, this.player.getPosition())) {
			if (direction.equals(getMagicRoom().getId())) {
				roomCache = getRoom(player.getDirection());
				MagicRoomEvent.getInstance().quiz();
			}
			switch (direction) {
			case "N":
				enterRoom = room.getN();
				this.player.setPosition(enterRoom);
				String d = "N";
				setChanged();
				notifyObservers(d);
				break;
			case "E":
				enterRoom = room.getE();
				this.player.setPosition(enterRoom);
				String d1 = "E";
				setChanged();
				notifyObservers(d1);
				break;
			case "S":
				enterRoom = room.getS();
				this.player.setPosition(enterRoom);
				String d2 = "S";
				setChanged();
				notifyObservers(d2);
				break;
			case "W":
				enterRoom = room.getW();
				this.player.setPosition(enterRoom);
				String d3 = "W";
				setChanged();
				notifyObservers(d3);
				break;
			}
		} else
			System.out.println("You can not move in this direction!");
	}
	
	/**
	 * Searches for the magic room
	 * @return magic room
	 */
	public AbstractRoom getMagicRoom() {
		AbstractRoom room = null;
		for (int i = 0; i < this.labyrinth.size(); i++) {
			if (labyrinth.elementAt(i).getIsMagicRoom()) {
				room = labyrinth.elementAt(i);
			}
		}
		return room;
	}
	
	/**
	 * Searches for the room, where player is positioned.
	 * @return room where Id = player.getPosition()
	 */
	public AbstractRoom getPlayerRoom() {
		AbstractRoom room = null;
		for (int i = 0; i < this.labyrinth.size(); i++) {
			if ((this.labyrinth.elementAt(i)).getId()
					.equals(this.player.getPosition())) {
				room = this.labyrinth.elementAt(i);
				break;
			}
		}
		return room;
	}
	
	/**
	 * Searches for a specific room.
	 * @param ID
	 * @return room with Id == ID
	 */
	public AbstractRoom getRoom(String ID) {
		AbstractRoom room = null;
		for (int i = 0; i < this.labyrinth.size(); i++) {
			if ((this.labyrinth.elementAt(i)).getId().equals(ID)) {
				room = this.labyrinth.elementAt(i);
			}
		}
		return room;
	}
	
	/**
	 * Count rooms on y-axis
	 * @return integer
	 */
	public int countNorth() {
		int north = 1;
		
		for (int i = 0; i < labyrinth.size(); i++) {
			if (!labyrinth.elementAt(i).getN().equals("0")) {
				north++;
			}
		}
		System.out.println(north);
		return north;
	}
	
	/**
	 * Counts rooms on the x-axis
	 * @return integer
	 */
	public int countEast() {
		int east = 1;
		
		for (int i = 0; i < labyrinth.size(); i++) {
			if (!labyrinth.elementAt(i).getE().equals("0")) {
				east++;
			}
			
		}
		System.out.println(east);
		return east;
	}
	/**
	 * Handling button pressing.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Client.getInstance().checkLabyrinth() == true && player.getIsAbleToMove()) {
			if (e.getActionCommand().equals("N")) {
				movePlayer("N");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			} else if (e.getActionCommand().equals("W")) {
				movePlayer("W");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			} else if (e.getActionCommand().equals("S")) {
				movePlayer("S");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			} else if (e.getActionCommand().equals("E")) {
				movePlayer("E");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			}
		}else
			System.out.println("Not able to move yet!");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * handles movement with arrow keys
	 */
	@Override
	public void keyPressed(KeyEvent e) {
			}


	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if (Client.getInstance().checkLabyrinth() == true && player.getIsAbleToMove()) {
			if(key==e.VK_UP){
				System.out.println("North");
				movePlayer("N");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			}else if(key==e.VK_LEFT){
				System.out.println("West");
				movePlayer("W");}
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			else if(key==e.VK_RIGHT){
				System.out.println("East");
				movePlayer("E");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
					}
				}
			else if(key==e.VK_DOWN){
				System.out.println("South");
				movePlayer("S");}
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
				
		}else
			JOptionPane.showMessageDialog(null, "Not able to move yet!", null, JOptionPane.ERROR_MESSAGE);

	}

	public AbstractRoom getRoomCache() {
		return roomCache;
	}

	public void setRoomCache(AbstractRoom roomCache) {
		this.roomCache = roomCache;
	}

}
