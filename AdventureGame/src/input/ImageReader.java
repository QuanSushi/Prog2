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
	
	public String getImgURL() {
		java.net.URL imageURL = ImageReader.class.getClassLoader().getResource("files/room.png");
		return imageURL.getPath();
	}
	
	public ImageIcon getImage() {
		
		ImageIcon image = new ImageIcon(getImgURL(), "test");
		return image;
	}

}
