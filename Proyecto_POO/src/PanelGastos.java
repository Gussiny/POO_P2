import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelGastos extends JPanel{
	private TextFieldNumeros[] tfAdvertencias;
	private JLabel labelAdvertencia[];
	private PanelControles pc;
	private VentanaPrincipal vt;
	private JButton btNext, btBack;
	
	public PanelGastos(VentanaPrincipal vt, PanelControles pc) {
		super();
		//this.setPreferredSize(new Dimension(350, 500));
		this.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.vt = vt;
		this.pc = pc;
		btBack = new JButton("ATRAS");
		btNext = new JButton("SIGUIENTE");
		this.tfAdvertencias = new TextFieldNumeros[6];
		this.labelAdvertencia = new JLabel[6];
		
		for(int i = 0; i < tfAdvertencias.length ; i++) {
			this.labelAdvertencia[i] = new JLabel();
			this.tfAdvertencias[i] = new TextFieldNumeros(labelAdvertencia[i]);		
		}
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(new JLabel("GASTOS"),gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(new JLabel("MEDICOS Y HOSPITALARIOS $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.tfAdvertencias[0],gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.labelAdvertencia[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(new JLabel("FUNERARIOS $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(this.tfAdvertencias[1],gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(this.labelAdvertencia[1],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(new JLabel("SGMM $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(this.tfAdvertencias[2],gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(this.labelAdvertencia[2],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(new JLabel("HIPOTECARIOS $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(this.tfAdvertencias[3],gbc);
		gbc.gridx = 1;
		gbc.gridy = 8;
		this.add(this.labelAdvertencia[3],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(new JLabel("DONATIVOS $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(this.tfAdvertencias[4],gbc);
		gbc.gridx = 1;
		gbc.gridy = 10;
		this.add(this.labelAdvertencia[4],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(new JLabel("APORTACIÓN RETIRO $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 12;
		this.add(this.tfAdvertencias[5],gbc);
		gbc.gridx = 1;
		gbc.gridy = 12;
		this.add(this.labelAdvertencia[5],gbc);
		
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		
		this.btBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vt.cl.previous(vt.panelCont);
			}
		});

		this.btNext.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Boolean error = false;
				for(int i = 0; i < tfAdvertencias.length ; i++) {
					if(labelAdvertencia[i].getText() != "") {
						JOptionPane.showMessageDialog(null,"REVISE SUS DATOS INGRESADOS");
						error = true;
					}
				}
			
				if(!error) {
					obtenerDatos();
					for(int i = 0; i < vt.datos.length;i++) {
						System.out.println(vt.datos[i]);
					}
					vt.pc.setVisible(true);
					vt.cl.next(vt.panelCont);	
				}

			}
		});
		gbc.gridx = 0;
		gbc.gridy = 13;
		this.add(btBack,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 13;
		this.add(btNext,gbc);
	}
	
	public void obtenerDatos() {
		int d = 5;
		for(int i = 0; i < tfAdvertencias.length; i++) {
			if(tfAdvertencias[i].getText().equals("")) {
				vt.datos[d] = "0.0";
			}else {
				vt.datos[d] = String.valueOf(Double.parseDouble(tfAdvertencias[i].getText()));
			}
			d+=1;
		}
		/*
		vt.datos[5] = tfAdvertencias[0].getText();
		vt.datos[6] = tfAdvertencias[1].getText();
		vt.datos[7] = tfAdvertencias[2].getText();
		vt.datos[8] = tfAdvertencias[3].getText();
		vt.datos[9] = tfAdvertencias[4].getText();
		vt.datos[10] = tfAdvertencias[5].getText();
		*/
	}
	
	
}
