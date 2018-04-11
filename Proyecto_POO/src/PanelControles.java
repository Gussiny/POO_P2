import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelControles extends JPanel {
	protected JButton btNext, btBack, btFinish;
	private VentanaPrincipal vt;
	private PanelPersonal pp;
	private PanelGastos pg;
	private PanelEscolar pe;
	public PanelControles (VentanaPrincipal vt, PanelPersonal pp, PanelGastos pg, PanelEscolar pe) {
		super();
		this.vt = vt;
		this.pe = pe;
		this.pp = pp;
		this.pg = pg;
		this.setLayout(new GridLayout());
		this.setPreferredSize(new Dimension(350, 35));
		btBack = new JButton("ATRAS");
		btNext = new JButton("SIGUIENTE");
		/*
		btBack.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vt.cl.previous(vt.panelCont);	
				
			}
		});
		
		btNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vt.cl.next(vt.panelCont);				
			}
		});
		*/
		
		this.add(this.btBack);
		this.add(this.btNext);
		
		
	}
	
	public void accionesPersonalNext() {
		Boolean error = false;
		for(int i = 0; i < 4 ; i++) {
			if(vt.labelAdvertencia[i].getText() != "") {
				JOptionPane.showMessageDialog(null,"REVISE SUS DATOS INGRESADOS");
				error = true;
			}
		}
		if(pp.labelRFC.getText() != "") {
			JOptionPane.showMessageDialog(null, "REVISA EL RFC");
			error = true;
		}
		if(pp.tfNombre.getText() == "") {
			JOptionPane.showMessageDialog(null, "INGRESE SU NOMBRE");
			error = true;
		}
		
		if(!error) {
			vt.datos[0] = pp.tfNombre.getText();
			vt.datos[1] = pp.tfRFC.getText();
			vt.datos[2] = vt.tfAdvertencias[0].getText();
			vt.datos[3] = vt.tfAdvertencias[1].getText();
			vt.datos[4] = vt.tfAdvertencias[2].getText();
			for(int i = 0; i < vt.datos.length;i++) {
				System.out.println(vt.datos[i]);
			}
			vt.pc.setVisible(true);
			vt.cl.next(vt.panelCont);
		}
	}
	

	public void accionesGastosBack() {
		
	}
	
	public void accionesGastosNext() {
		Boolean error = false;
		for(int i = 0; i < vt.tfAdvertencias.length ; i++) {
			if(vt.labelAdvertencia[i].getText() != "") {
				JOptionPane.showMessageDialog(null,"REVISE SUS DATOS INGRESADOS");
				error = true;
			}
		}

		if(!error) {
			obtenerDatos();
			for(int i = 0; i < vt.datos.length;i++) {
				System.out.println(vt.datos[i]);
			}
			vt.cl.next(vt.panelCont);	
		}

	}
	
	
	public void obtenerDatos() {
	}
}
