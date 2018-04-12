import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//José Fausto Rodriguez Herrera A01634943


public class VentanaPrincipal extends JFrame{
	protected CardLayout cl = new CardLayout();
	protected JPanel panelCont = new JPanel();
	protected PanelControles pc;
	protected TextFieldNumeros[] tfAdvertencias;
	protected JLabel labelAdvertencia[];
	protected JLabel labelRFC;
	protected String[] datos;
	protected Boolean archivo = false;
	public VentanaPrincipal() {
		super("Proyecto POO");
		this.setBackground(Color.WHITE);
		setPreferredSize(new Dimension(600,550));
		
		this.tfAdvertencias = new TextFieldNumeros[3];
		this.labelAdvertencia = new JLabel[3];
				
		for(int i = 0; i < tfAdvertencias.length ; i++) {
			this.labelAdvertencia[i] = new JLabel();
			this.tfAdvertencias[i] = new TextFieldNumeros(labelAdvertencia[i]);		
		}
	
		datos = new String[14];
		//PanelFinal pfnl = new PanelFinal(this);
		PanelPrincipal pr = new PanelPrincipal(this);
		//PanelFormulario pf = new PanelFormulario();
		PanelPersonal pe = new PanelPersonal(this);
		PanelGastos pg = new PanelGastos(this,pc);
		PanelEscolar pes = new PanelEscolar(this);
		pc = new PanelControles(this,pe,pg,pes);
	
		//PanelExtras px = new PanelExtras();
		panelCont.setLayout(cl);
		panelCont.add(pr, "1");
		panelCont.add(pe, "2");
		panelCont.add(pg, "3");
		panelCont.add(pes,"4");
		

		cl.show(panelCont, "1");
	
		this.add(new PanelImagen(), BorderLayout.NORTH);
		//pc.setVisible(false);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	
		this.add(panelCont);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void removerListeners() {
		if(pc.btBack.getActionListeners().length > 0) {
			for(ActionListener a : pc.btBack.getActionListeners()) {
				pc.btBack.removeActionListener(a);
			}
		}
		if(pc.btNext.getActionListeners().length > 0) {
			for(ActionListener a : pc.btNext.getActionListeners()) {
				pc.btNext.removeActionListener(a);
			}
		}
		
	}
	
	public static void main(String[] args) {
		VentanaPrincipal miVentana = new VentanaPrincipal();
	}
}
