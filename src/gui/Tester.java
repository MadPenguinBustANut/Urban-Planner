package gui;

import java.awt.Point;

import javax.swing.JFrame;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point uno = new Point (30, 40);
		Point due = new Point (70, 30);
		FrameLotto nuovo= new FrameLotto(new Lotti(), new CentroUrbano(), uno, due);
		nuovo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nuovo.setVisible(true);
	}

}
