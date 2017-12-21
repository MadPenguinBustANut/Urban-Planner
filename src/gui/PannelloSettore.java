package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PannelloSettore extends JPanel {
	private static final long serialVersionUID = 1L;

	private int x = 30;
	private int y = 60;

	private int weight = 300;
	private int height = 100;
	private int settX = 0;
	private int settY = 0;
	private FrameModifica rifer;
	boolean[][] arrayB = new boolean[2][3];
	boolean tr = false;
	
	
	public PannelloSettore (FrameModifica e) {
		super();
		Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "Effettua la selezione");
        this.setBorder(title);
		this.setToolTipText("Effettua la selezione");
		addMouseListener(new Posizione());
		rifer = e;
	}
	
	/**
	 * Disegna sei rettangoli rappresentanti i sei settori che è possibile selezionare
	 * */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 2; i++) {
				g2.drawRect(20+(weight*j), 20+(height*i), weight, height);
				if(arrayB[i][j] == true) {
					g2.setColor(Color.YELLOW);
					g2.fillRect(21+(weight*j), 21+(height*i), weight-2, height-2);
					g2.setColor(Color.BLACK);
			}
		}	
	}
}
	/**
	 * Salva la posizione del settore su cui si clicca e al Click lo evidenzia
	 * */
	class Posizione implements MouseListener{

		public void mouseClicked(MouseEvent e) {

			if(tr) {
				tr = false;
			}
			else tr = true;
			
			int a = e.getX();
			int b = e.getY();
			
			if (a > 20 && a < 20 +(weight*3) && b > 20 && b < 20+(height*2)) {
				settX = a/(20 + weight);
				settY = b/(20 + height);

				System.out.println("X="+a+" Y="+b);	
				System.out.println("settX="+settX+" settY="+settY);
				
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 2; j++) {
						arrayB[j][i] = false;
					}
				}
				rifer.settX = settY;
				rifer.settY = settX;
				arrayB[settY][settX] = true;
				repaint();
				}
			}
		

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

		



