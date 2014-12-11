package actors;

import java.io.Serializable;

import src.Singleton;

public class Player implements Serializable{

	private String position, direction;
	
	public Player() {
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}

	public void moveTo(String direction) {
		this.direction = direction;
	}
	
	

}
