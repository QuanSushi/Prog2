package dungeon;

public class Room {
	
	private String id, n, e, s, w;
	
	public Room(String roomplan) {
		System.out.println("setRoom()");			//delete this later
		System.out.println("String.split(:)");		//delete this later
		String[] split = roomplan.split(":");		//delete this later
		this.id = split[0];
		this.n  = split[1];
		this.e  = split[2];
		this.s  = split[3];
		this.w  = split[4];
		System.out.println("setRoom() done");		//delete this later
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", n=" + n + ", e=" + e + ", s=" + s + ", w="
				+ w + "]";
	}

}