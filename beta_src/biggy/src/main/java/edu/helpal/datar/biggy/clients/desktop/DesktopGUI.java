package edu.helpal.datar.biggy.clients.desktop;

import java.awt.Frame;

/**
 * DesktopGUI
 *
 */
public class DesktopGUI {
	public static void main(String[] args){
		Frame fr = new Frame("biggy DesktopGUI");
		fr.setSize(500, 400);
		fr.setLocation(300, 200);
		
		//JLabel jlbl = new JLabel("Choose your BDMS components:");
		//JLabel jlbl1 = new JLabel("HBase - Spark - D3");
				
		//fr.add(jlbl);
		//fr.add(jlbl1);
		
		fr.addWindowListener(new WinListener());
		
		fr.setVisible(true);
	}
}
