package actors;

/**
 * this class is the player's hero.
 */

import java.util.Observable;

public class Player extends Observable {

	private static Player instance;

	private Player() {

	}

	public static Player getInstance() {
		if (instance == null) {
			instance = new Player();
		}

		return instance;
	}

	private String position = "1";
	private String direction;
	private Boolean isAbleToMove = false;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
		setChanged();
		notifyObservers(position);
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String posToString() {
		return "Player is in room: " + position + ".";
	}

	public Boolean getIsAbleToMove() {
		return isAbleToMove;
	}

	public void setIsAbleToMove(Boolean isAbleToMove) {
		this.isAbleToMove = isAbleToMove;
	}

}
