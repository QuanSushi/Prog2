package dungeon;

/**
 * This class is the magic room.
 * @author QS
 *
 */

public class MagicRoom extends AbstractRoom {

	private String id, n, e, s, w;
	private boolean isMagicRoom = true;

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
	public MagicRoom(String roomplan) {
		String[] split = roomplan.split(":");
		this.id = split[0];
		this.n = split[1];
		this.e = split[2];
		this.s = split[3];
		this.w = split[4];
	}

	@Override
	public String toString() {
		return "MagicRoom [id=" + id + ", n=" + n + ", e=" + e + ", s=" + s + ", w="
				+ w + "]";
	}

	public boolean getIsMagicRoom() {
		return isMagicRoom;
	}

	public void setIsMagicRoom(boolean isMagicRoom) {
		this.isMagicRoom = isMagicRoom;
	}

}
