package actors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dungeon.Client;
import dungeon.Room;

/*
 * This Class is the GameMaster.
 * The GameMaster observes the game and moves the Player, manages game rules etc.
 */
public class GameMaster implements ActionListener {

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
	private Vector<Room> labyrinth;

	/*
	 * Initiate the game.
	 */
	public void setGame(Vector<Room> labyrinth) {
		if (this.labyrinth == null) {
			this.labyrinth = labyrinth;
		}
		if (this.player == null) {
			this.player = Player.getInstance();
			System.out.println("Player created"); // delete this later
		}
	}

	/*
	 * Takes parameter direction and player position. Checks if the room has a
	 * door at this direction. If yes, return true, if not, return false.
	 */
	public boolean checkMove(String target, String playerPos) {
		target = this.player.getDirection();
		playerPos = this.player.getPosition();
		Room room = getPlayerRoom();

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

	/*
	 * Checks if player can move to given direction. If true setPosition to room
	 * lying in this direction.
	 */
	public void movePlayer(String direction) {
		this.player.setDirection(direction);
		String enterRoom = "";
		Room room = getPlayerRoom();
		System.out.println("checking move..."); // delete this later
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
			System.out.println("You can not move in this direction!");
	}

	private Room getPlayerRoom() {
		Room room = null;
		for (int i = 0; i < this.labyrinth.size(); i++) {
			if (this.labyrinth.elementAt(i).getId()
					.equals(this.player.getPosition())) {
				room = this.labyrinth.elementAt(i);
				break;
			}
		}

		return room;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Client.getInstance().checkLabyrinth() == true) {
			if (e.getActionCommand().equals("N")) {
				System.out.println("North");
				movePlayer("N");
			} else if (e.getActionCommand().equals("W")) {
				System.out.println("West");
				movePlayer("W");
			} else if (e.getActionCommand().equals("S")) {
				System.out.println("South");
				movePlayer("S");
			} else if (e.getActionCommand().equals("E")) {
				System.out.println("East");
				movePlayer("E");
			}
			
			System.out.println("You are now in room: " + this.player.getPosition()); // delete this later
			System.out.println(getPlayerRoom().toString()); 							// delete this later

		}else
			System.out.println("Please open map first!");

	}

}
