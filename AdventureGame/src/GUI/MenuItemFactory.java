package GUI;

import javax.swing.JMenuItem;

public class MenuItemFactory {
	
	public static JMenuItem createMenuItem(String label, char mnemonic, String actionCommand) {
		JMenuItem menuItem = new JMenuItem(label);
		menuItem.setActionCommand(actionCommand);
		menuItem.setMnemonic(mnemonic);
		menuItem.addActionListener(MyButtonListener.getInstance());
		return menuItem;
	}

}
