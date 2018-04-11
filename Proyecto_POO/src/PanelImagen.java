import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{

	private Image fondo;
	public PanelImagen() {
		super();
		this.setPreferredSize(new Dimension(600, 100));
		this.fondo = new ImageIcon("sat.png").getImage();
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.drawImage(this.fondo,0, 0, this.getWidth(),this.getHeight(), this);
		
	}
}
