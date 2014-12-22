package dungeon;

import java.util.Observable;

public class Room extends AbstractRoom {

	private String id, n, e, s, w;

	public String getId() {
		return id;
	}

	public String getN() {
		return n;
	}

	public String getE() {
		return e;
	}

	public String getS() {
		return s;
	}

	public String getW() {
		return w;
	}

	/*
	 * This is the constructor. It takes the String parameter and splits it at
	 * ":" resulting in getting the single attributes.
	 */
	public Room(String roomplan) {
		System.out.println("setRoom()"); // delete this later
		System.out.println("String.split(:)"); // delete this later
		String[] split = roomplan.split(":");
		this.id = split[0];
		this.n = split[1];
		this.e = split[2];
		this.s = split[3];
		this.w = split[4];
		System.out.println("setRoom() done"); // delete this later
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", n=" + n + ", e=" + e + ", s=" + s + ", w="
				+ w + "]";
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
