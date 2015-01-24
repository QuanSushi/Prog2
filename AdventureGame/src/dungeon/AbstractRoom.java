package dungeon;

public abstract class AbstractRoom {
	
	private String id, n, e, s, w;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

}
