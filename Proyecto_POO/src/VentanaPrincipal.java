import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//José Fausto Rodriguez Herrera A01634943
//Gustavo Alejandro Flores Cortes A01635151


public class VentanaPrincipal extends JFrame{
	protected CardLayout cl = new CardLayout();
	protected JPanel panelCont = new JPanel();
	protected TextFieldNumeros[] tfAdvertencias;
	protected JLabel labelAdvertencia[];
	protected JLabel labelRFC;
	protected String[] datos;
	protected Boolean archivo = false;
	private PanelPrincipal pr;
	private PanelPersonal pe;
	private PanelGastos pg;
	private PanelEscolar pes;
	
	public VentanaPrincipal() {
		super("Proyecto POO");
		this.setBackground(Color.WHITE);
		setPreferredSize(new Dimension(600,550));
	
		datos = new String[14];
		pr = new PanelPrincipal(this);
		pe = new PanelPersonal(this);
		pg = new PanelGastos(this);
		pes = new PanelEscolar(this);
	
		panelCont.setLayout(cl);
		panelCont.add(pr, "1");
		panelCont.add(pe, "2");
		panelCont.add(pg, "3");
		panelCont.add(pes,"4");
		
		cl.show(panelCont, "1");
	
		this.add(new PanelImagen(), BorderLayout.NORTH);		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	
		this.add(panelCont);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void reiniciar() {
		nueva();	
		super.setVisible(false);
		super.dispose();
		
	}
	
	
	public static void main(String[] args) {
		nueva();
	}
	
	public static void nueva() {
		VentanaPrincipal miVentana = new VentanaPrincipal();
	}
	
}
