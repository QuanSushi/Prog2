package input;

import javax.swing.ImageIcon;

public class ImageReader {
	
	private static ImageReader instance;
	
	private ImageReader() {
		
	}
	
	public static ImageReader getInstance() {
		if (instance == null) {
			instance = new ImageReader();
		}
		return instance;
	}
	
	private ImageIcon image;
	
	/*
	 * loads imagefile
	 */
	public String getImgURL(String url) {
		java.net.URL imageURL = ImageReader.class.getClassLoader().getResource(url);
		return imageURL.getPath();
	}
	
	/*
	 * This method returns image file.
	 * String s sets the desired image to be returned.
	 */
	public ImageIcon getImage(String s) {
		String url = "files/room.png"; //default
		if (s.equals("room")) {
			url = "files/room.png";
		}else if (s.equals("magicRoom")) {
			url = "files/magic_room.png";
		}else if (s.equals("pl_room")) {
			url = "files/room_pl.png";
		}else if (s.equals("pl_magicRoom")) {
			url = "files/magic_room_pl.png";
		}//else use default
		
		ImageIcon image = new ImageIcon(getImgURL(url), "test");
		return image;
	}

}
