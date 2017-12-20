package gui;

import javax.swing.JFrame;

import centrourbano.CentroUrbano;
import centrourbano.Lotti;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame nuovo= new FrameLotto(new Lotti(), new CentroUrbano(), 30 ,56);
		nuovo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nuovo.setVisible(true);
	}

}
