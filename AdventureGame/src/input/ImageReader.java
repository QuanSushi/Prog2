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
		java.net.URL imageURL = ImageReader.class.getClass().getResource("files/room.png");
		System.out.println("get path..."); //delete this later
		System.out.println(imageURL.getPath());
		return imageURL.getPath();
	}
	
	public ImageIcon getImage() {
		
		ImageIcon image = new ImageIcon(getImgURL(), "test");
		return image;
	}

}
