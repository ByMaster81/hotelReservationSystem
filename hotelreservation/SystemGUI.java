package hotelreservation;
import java.awt.Color;

import javax.swing.JFrame;
public class SystemGUI {
		public static void main(String[] args) {
			frame menu =new frame();
			menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			menu.setSize(1200,650);
			menu.setResizable(false);
			menu.setVisible(true);
			menu.getContentPane().setBackground(Color.DARK_GRAY);
		}

}