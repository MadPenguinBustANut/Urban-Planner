package exec;

import centrourbano.CentroUrbano;
import gui.FrameLotto;
import gui.StartFrame;

public class Tester {

	public static void main(String[] args) {
		CentroUrbano a = new CentroUrbano();
		FrameLotto te = new FrameLotto(a.lista[0][0].lista[0][0], a);
		StartFrame io = new StartFrame(a);
	}

}
