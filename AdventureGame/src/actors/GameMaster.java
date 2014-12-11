package actors;

import java.util.Observable;
import java.util.Vector;

import dungeon.Room;

/*
 * This Class is the GameMaster.
 * The GameMaster observes the game and moves the Player, manages game rules etc.
 */
public class GameMaster extends Observable {

	Player player;
	Vector<Room> labyrinth;

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
		}
	}

	/*
	 * Takes parameter direction and player position. Checks if the room has a
	 * door at this direction. If yes, return true, if not, return false.
	 */
	public boolean checkMove(String direction, String playerPos) {
		direction = player.getDirection();
		playerPos = player.getPosition();
		int i = Integer.parseInt(playerPos);			//get index of room where the player is located at
		Room room = this.labyrinth.elementAt(i - 1);
		
		switch (direction) {
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
	 * Checks if player can move to give direction.
	 * If true setPosition to direction
	 */
	public void movePlayer(String direction) {
		int i = Integer.parseInt(this.player.getPosition());	//get index of room where the player is located at
		String enterRoom = "";
		Room room = this.labyrinth.elementAt(i - 1);
		if ( checkMove(direction, player.getPosition()) ) {
			switch (direction) {
				case "N":  enterRoom = room.getN();
					break;
				case "E":  enterRoom = room.getE();
					break;
				case "S":  enterRoom = room.getS();
					break;
				case "W":  enterRoom = room.getW();
					break;
			}
			player.setPosition(enterRoom);
		}else
			System.out.println("You can not move in this direction!");
	}

}
