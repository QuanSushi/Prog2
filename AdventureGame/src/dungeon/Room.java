package dungeon;

public class Room extends AbstractRoom {

	private String id, n, e, s, w;
	private boolean isMagicRoom = false;

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
		String[] split = roomplan.split(":");
		this.id = split[0];
		this.n = split[1];
		this.e = split[2];
		this.s = split[3];
		this.w = split[4];
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", n=" + n + ", e=" + e + ", s=" + s + ", w="
				+ w + "]";
	}

	public boolean isMagicRoom() {
		return isMagicRoom;
	}

	public void setMagicRoom(boolean isMagicRoom) {
		this.isMagicRoom = isMagicRoom;
	}

}
