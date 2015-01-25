package GUI;

import input.ImageReader;

import javax.swing.JLabel;

public class MapTile extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * This method paints the label
	 * @param s which room (room, pl_room, magicRoom, pl_magicRoom)
	 */
	public void paint(String s) {
		this.setIcon(ImageReader.getInstance().getImage(s));
	}

}
