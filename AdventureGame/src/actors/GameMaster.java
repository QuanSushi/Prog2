package actors;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import GUI.ControllerPanel;
import GUI.MapPanel;
import dungeon.AbstractRoom;
import dungeon.Client;
import dungeon.MagicRoomEvent;
import dungeon.Room;

/**
 * This Class is the GameMaster.
 * The GameMaster observes the game and moves the Player, manages game rules etc.
 */

public class GameMaster implements ActionListener, KeyListener{

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

	/**
	 * Initiates the game. Sets player position to a random room.
	 */
	public void setGame(Vector<AbstractRoom> labyrinth) {
		if (this.labyrinth == null) {
			this.labyrinth = labyrinth;
		}
		if (this.player == null) {
			this.player = Player.getInstance();
			int r = 1+ (int) Math.random()*this.labyrinth.size();
			String s = String.valueOf(r);
			this.player.setPosition(s);	
			JOptionPane.showMessageDialog(null,"Player spawned in room: " + player.getPosition(), null, JOptionPane.INFORMATION_MESSAGE);
			this.player.addObserver(MapPanel.getInstance());
		}
	}
	
	/**
	 * 
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
			switch (direction) {
			case "N":
				enterRoom = room.getN();
				break;
			case "E":
				enterRoom = room.getE();
				break;
			case "S":
				enterRoom = room.getS();
				break;
			case "W":
				enterRoom = room.getW();
				break;
			}
			this.player.setPosition(enterRoom);
		} else
			JOptionPane.showMessageDialog(null, "You can not move in this direction!", null, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * 
	 * @return room where the player is currently staying.
	 */
	private AbstractRoom getPlayerRoom() {
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
	 * 
	 * @param ID
	 * @return room with the specific ID
	 */
	private AbstractRoom getRoom(String ID) {
		AbstractRoom room = null;
		for (int i = 0; i < this.labyrinth.size(); i++) {
			if ((this.labyrinth.elementAt(i)).getId().equals(ID)) {
				room = this.labyrinth.elementAt(i);
			}
		}
		return room;
	}
	
	public AbstractRoom getMagicRoom(){
		AbstractRoom magicroom=null;
		for (int i = 0; i < this.labyrinth.size(); i++) {
			if((this.labyrinth.elementAt(i).getIsMagicRoom())){
				magicroom=this.labyrinth.elementAt(i);
			}
			
		}
		return magicroom;
	}
	
	public int countNorth() {
		int north = 0;
		
		for (int i = 0; i < labyrinth.size(); i++) {
			if (!labyrinth.elementAt(i).getN().equals("0")) {
				north++;
			}
		}
		
		return north;
	}
	
	public int countEast() {
		int east = 0;
		
		for (int i = 0; i < labyrinth.size(); i++) {
			if (!labyrinth.elementAt(i).getE().equals("0")) {
				east++;
			}
		}
		
		return east;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Client.getInstance().checkLabyrinth() == true && player.getIsAbleToMove()) {
			if (e.getActionCommand().equals("N")) {
				System.out.println("North");
				movePlayer("N");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			} else if (e.getActionCommand().equals("W")) {
				System.out.println("West");
				movePlayer("W");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			} else if (e.getActionCommand().equals("S")) {
				System.out.println("South");
				movePlayer("S");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			} else if (e.getActionCommand().equals("E")) {
				System.out.println("East");
				movePlayer("E");
				if ( getRoom(player.getPosition()).getIsMagicRoom()) {
					MagicRoomEvent.getInstance().quiz();
				}
			}
			
			System.out.println(getPlayerRoom().toString()); 							// delete this later
		}else
			System.out.println("Not able to move yet!");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if (Client.getInstance().checkLabyrinth() == true && player.getIsAbleToMove()) {
		if(key==e.VK_UP){
			System.out.println("North");
			movePlayer("N");
		}else if(key==e.VK_LEFT){
			System.out.println("West");
			movePlayer("W");}
		else if(key==e.VK_RIGHT){
			System.out.println("East");
			movePlayer("E");
			}
		else if(key==e.VK_DOWN){
			System.out.println("South");
			movePlayer("S");}
		else{
			JOptionPane.showMessageDialog(null, "Bitte benutze die Pfeiltasten", null, JOptionPane.ERROR_MESSAGE);
			
		}
		
		System.out.println(getPlayerRoom().toString()); 
		if ( getRoom(player.getPosition()).getIsMagicRoom()) {
			MagicRoomEvent.getInstance().quiz();
		}
		}else
			
			System.out.println("Not able to move yet!");
		

		}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
