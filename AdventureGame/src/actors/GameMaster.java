package actors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import dungeon.Room;

/*
 * This Class is the GameMaster.
 * The GameMaster observes the game and moves the Player, manages game rules etc.
 */
public class GameMaster implements ActionListener {
	private Player player;
	private Vector<Room> labyrinth;

	public GameMaster() {
	}

	/*
	 * Initiate the game.
	 */
	public void setGame(Vector<Room> labyrinth) {
		if (this.labyrinth == null) {
			this.labyrinth = labyrinth;
		}
		if (this.player == null) {
			this.player = new Player();
			System.out.println("Player created");	 		//delete this later
		}
	}

	/*
	 * Takes parameter direction and player position. Checks if the room has a
	 * door at this direction. If yes, return true, if not, return false.
	 */
	public boolean checkMove(String target, String playerPos) {
		target = this.player.getDirection();
		playerPos = this.player.getPosition();
		int i = Integer.parseInt(playerPos); // get index of room where the
											 // player is located at
		Room room = this.labyrinth.elementAt(i - 1);

		switch (target) {
		case "N":
			if (room.getN().contains("0")) {
				return false;
			} else
				return true;
		case "E":
			if (room.getE().contains("0")) {
				return false;
			} else
				return true;
		case "S":
			if (room.getS().contains("0")) {
				return false;
			} else
				return true;
		case "W":
			if (room.getW().contains("0")) {
				return false;
			} else
				return true;
		default:
			return false;
		}

	}

	/*
	 * Checks if player can move to give direction. If true setPosition to
	 * direction
	 */
	public void movePlayer(String direction) {
		this.player.setDirection(direction);
		int i = Integer.parseInt(this.player.getPosition()); 	// get index of
																// room where
																// the player is
																// located at
		String enterRoom = "";
		Room room = this.labyrinth.elementAt(i - 1);
		System.out.println(room.toString());				//delete this later
		System.out.println("checking move...");				//delete this later
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("north")) {
			System.out.println("North");
			movePlayer("N");
		}else if (e.getActionCommand().equals("west")) {
			System.out.println("West");
			movePlayer("W");
		}else if (e.getActionCommand().equals("south")) {
			System.out.println("South");
			movePlayer("S");
		}else if (e.getActionCommand().equals("east")) {
			System.out.println("East");
			movePlayer("E");
		}
		System.out.println("You are now in room: " + this.player.getPosition());
		
	}

}
