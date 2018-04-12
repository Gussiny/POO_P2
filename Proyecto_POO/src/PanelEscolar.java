import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//José Fausto Rodriguez Herrera A01634943
//Gustavo Alejandro Flores Cortes A01635151

public class PanelEscolar extends JPanel implements ActionListener{
	private TextFieldNumeros[] tfAdvertencias;
	private JLabel labelAdvertencia[];
	private JRadioButton rbPreescolar,rbPrimaria, rbSecundaria, rbPreparatoria, rbSi, rbNo;
	private JLabel lbTe, lbGe, lbCo;
	private ButtonGroup bgGradoEsc;
	private JButton btNext, btBack;
	private VentanaPrincipal vt;
	
	public PanelEscolar(VentanaPrincipal vt) {
		super();
		this.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.vt = vt;
		btBack = new JButton("ATRAS");
		btNext = new JButton("SIGUIENTE");
		this.tfAdvertencias = new TextFieldNumeros[10];
		this.labelAdvertencia = new JLabel[10];
				
		for(int i = 0; i < tfAdvertencias.length ; i++) {
			this.labelAdvertencia[i] = new JLabel();
			this.tfAdvertencias[i] = new TextFieldNumeros(labelAdvertencia[i]);
			
		}
		
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(new JLabel("ESCOLAR"),gbc);
		
		
		this.rbSi = new JRadioButton("Si");
		this.rbNo = new JRadioButton("No");
		ButtonGroup bgSiNo = new ButtonGroup();
		bgSiNo.add(rbSi);
		bgSiNo.add(rbNo);
		
		this.rbPreescolar = new JRadioButton("Preescolar");
		this.rbPrimaria = new JRadioButton("Primaria");
		this.rbSecundaria = new JRadioButton("Secundaria");
		this.rbPreparatoria = new JRadioButton("Preparatoria");
		bgGradoEsc = new ButtonGroup();
		bgGradoEsc.add(rbPreescolar);
		bgGradoEsc.add(rbPrimaria);
		bgGradoEsc.add(rbSecundaria);
		bgGradoEsc.add(rbPreparatoria);
		this.rbNo.setSelected(true);
		this.rbSi.addActionListener(this);	
		this.rbNo.addActionListener(this);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.add(new JLabel("¿TIENE HIJOS?"),gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		this.add(rbSi,gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(rbNo,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		add(lbGe  = new JLabel("¿QUÉ GRADO ESCOLAR CURSA?"),gbc);
		this.lbGe.setVisible(false);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		add(rbPreescolar,gbc);
		this.rbPreescolar.setVisible(false);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		add(rbPrimaria,gbc);
		this.rbPrimaria.setVisible(false);
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(rbSecundaria,gbc);
		this.rbSecundaria.setVisible(false);
		gbc.gridx = 3;
		gbc.gridy = 4;
		add(rbPreparatoria,gbc);
		this.rbPreparatoria.setVisible(false);

		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 4;
		add(lbTe = new JLabel("¿CUÁNTO GASTA EN TRANSPORTE ESCOLAR?\n$"),gbc);
		this.lbTe.setVisible(false);

		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		add(tfAdvertencias[0],gbc);
		this.tfAdvertencias[0].setVisible(false);

		gbc.gridx = 1;
		gbc.gridy = 6;
		add(labelAdvertencia[0],gbc);
		this.labelAdvertencia[0].setVisible(false);

		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 4;
		add(lbCo = new JLabel("¿CUÁNTO HA PAGADO DE LA COLEGIATURA?\n$"),gbc);
		this.lbCo.setVisible(false);

		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		add(tfAdvertencias[1],gbc);
		this.tfAdvertencias[1].setVisible(false);

		gbc.gridx = 1;
		gbc.gridy = 8;
		add(labelAdvertencia[1],gbc);
		this.labelAdvertencia[1].setVisible(false);
		
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
					if(tfAdvertencias[0].getText().equals("")) {
						vt.datos[11] = "0.0";
					}else {
						vt.datos[11] = String.valueOf(Double.parseDouble(tfAdvertencias[0].getText()));
					}
					if(tfAdvertencias[1].getText().equals("")) {
						vt.datos[13] = "0.0";
					}else {
						vt.datos[13] = String.valueOf(Double.parseDouble(tfAdvertencias[1].getText()));
					}
					
					if(rbSi.isSelected()) {
						if(rbPreescolar.isSelected()) {
							vt.datos[12] = "Primaria";
						}else if(rbPrimaria.isSelected()) {
							vt.datos[12] = "Primaria";
						}else if(rbSecundaria.isSelected()) {
							vt.datos[12] = "Secundaria";
						}else if(rbPreparatoria.isSelected()) {
							vt.datos[12] = "Preparatoria";
						}
					}else if(rbNo.isSelected()) {
						vt.datos[11] = "0.0";
						vt.datos[12] = "Ninguno";
						vt.datos[13] = "0.0";
					}
					for(int i = 0; i < vt.datos.length;i++) {
						System.out.println(vt.datos[i]);
					}
					System.out.println(obtenerDatos());
					CalculadoraImpuestos impuestos = new CalculadoraImpuestos(obtenerDatos());
					System.out.println(impuestos.toString());
					PanelFinal pfnl = new PanelFinal(vt,impuestos.toString());
					vt.panelCont.add(pfnl,"5");
					vt.cl.next(vt.panelCont);	
				}

			}
		});

		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;

		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(btBack,gbc);

		gbc.gridx = 2;
		gbc.gridy = 11;
		this.add(btNext,gbc);
	}


	public String obtenerDatos() {
		String datosSeparados="";
		for(int i=0; i<vt.datos.length;i++){
			datosSeparados = datosSeparados + vt.datos[i]+ ",";
		}
		return datosSeparados;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.rbSi) {
			System.out.println("hola");
			this.lbTe.setVisible(true);
			this.tfAdvertencias[0].setVisible(true);
			this.labelAdvertencia[0].setVisible(true);
			this.lbGe.setVisible(true);
			this.tfAdvertencias[1].setVisible(true);
			this.labelAdvertencia[1].setVisible(true);
			this.lbCo.setVisible(true);
			this.rbPreescolar.setVisible(true);
			this.rbPrimaria.setSelected(true);
			this.rbPrimaria.setVisible(true);
			this.rbSecundaria.setVisible(true);
			this.rbPreparatoria.setVisible(true);
			this.revalidate();
			this.repaint();
		}else if(arg0.getSource() == this.rbNo) {
			this.lbTe.setVisible(false);
			this.tfAdvertencias[0].setVisible(false);
			this.tfAdvertencias[0].setText("");
			this.labelAdvertencia[0].setVisible(false);
			this.labelAdvertencia[0].setText("");
			this.lbGe.setVisible(false);
			
			this.tfAdvertencias[1].setVisible(false);
			this.tfAdvertencias[1].setText("");
			this.labelAdvertencia[1].setVisible(false);
			this.labelAdvertencia[1].setText("");
			this.lbCo.setVisible(false);

			bgGradoEsc.clearSelection();
			this.rbPreescolar.setVisible(false);
			this.rbPrimaria.setVisible(false);
			this.rbSecundaria.setVisible(false);
			this.rbPreparatoria.setVisible(false);
			this.revalidate();
			this.repaint();
		}
		
	}
}
