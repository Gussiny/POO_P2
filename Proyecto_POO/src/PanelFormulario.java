import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//José Fausto Rodriguez Herrera A01634943

public class PanelFormulario extends JPanel implements ActionListener{
	private TextFieldNumeros[] tfAdvertencias;
	private JTextField tfNombre, tfRFC;
	private JLabel labelAdvertencia[], labelRFC;
	private JRadioButton rbPrimaria, rbSecundaria, rbPreparatoria, rbSi, rbNo;
	
	private JLabel lbTe, lbGe;
	private ButtonGroup bgGradoEsc;
	public PanelFormulario() {
		super();
		this.setPreferredSize(new Dimension(350, 500));
		this.setBackground(Color.GRAY);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.tfAdvertencias = new TextFieldNumeros[10];
		this.labelAdvertencia = new JLabel[10];
		
		
		for(int i = 0; i < tfAdvertencias.length ; i++) {
			this.labelAdvertencia[i] = new JLabel();
			this.tfAdvertencias[i] = new TextFieldNumeros(labelAdvertencia[i]);
			
		}
		/*
		this.labelRFC = new JLabel("");
		this.labelRFC.setForeground(Color.RED);
		this.add(new JLabel("Nombre:"));
		this.tfNombre = new JTextField(30);
		this.add(tfNombre);
		
		this.add(new JLabel("RFC:"));
		this.tfRFC = new JTextField(20);
		this.tfRFC.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("adios");
				if(tfRFC.getText().length() > 13) {
					System.out.println("mas de 13");
					labelRFC.setText("El RFC solo debe contar con 13 numeros");
				}else {
					labelRFC.setText("");
				}
			}
		});
		this.add(tfRFC);
		this.add(labelRFC);
		
		gbc.gridx = 0;
		gbc.gridy = 0;	
		this.add(new JLabel("Sueldo mensual:"),gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(this.tfAdvertencias[0],gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(this.labelAdvertencia[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(new JLabel("Aguinaldo recibido:"),gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.tfAdvertencias[1],gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(this.labelAdvertencia[1],gbc);
		
		
		this.add(new JLabel("Prima vacacional recibida:"));
		this.add(this.tfAdvertencias[2]);
		this.add(this.labelAdvertencia[2]);
		
		
		this.add(new JLabel("D Medicos y Hospitalarios"));
		this.add(this.tfAdvertencias[3]);
		this.add(this.labelAdvertencia[3]);
		
		this.add(new JLabel("D Gastos Funerarios"));
		this.add(this.tfAdvertencias[4]);
		this.add(this.labelAdvertencia[4]);
		
		this.add(new JLabel("Seguro de Gastos Medicos Mayores (SGMM)"));
		this.add(this.tfAdvertencias[5]);
		this.add(this.labelAdvertencia[5]);
		
		
		this.add(new JLabel("Hipotecarios"));
		this.add(this.tfAdvertencias[6]);
		this.add(this.labelAdvertencia[6]);
		
		this.add(new JLabel("Donativos"));
		this.add(this.tfAdvertencias[7]);
		this.add(this.labelAdvertencia[7]);
		
		this.add(new JLabel("Aportación retiro"));
		this.add(this.tfAdvertencias[8]);
		this.add(this.labelAdvertencia[8]);
		
		*/
		this.rbSi = new JRadioButton("Si");
		this.rbNo = new JRadioButton("No");
		ButtonGroup bgSiNo = new ButtonGroup();
		bgSiNo.add(rbSi);
		bgSiNo.add(rbNo);
		
		this.rbPrimaria = new JRadioButton("Primaria");
		this.rbSecundaria = new JRadioButton("Secundaria");
		this.rbPreparatoria = new JRadioButton("Preparatoria");
		bgGradoEsc = new ButtonGroup();
		bgGradoEsc.add(rbPrimaria);
		bgGradoEsc.add(rbSecundaria);
		bgGradoEsc.add(rbPreparatoria);
		this.rbNo.setSelected(true);
		this.rbSi.addActionListener(this);	
		this.rbNo.addActionListener(this);
		this.add(rbSi);
		this.add(rbNo);
		add(lbTe = new JLabel("Transporte escolar")).setVisible(false);
		add(tfAdvertencias[5]).setVisible(false);
		add(labelAdvertencia[5]).setVisible(false);
		add(lbGe  = new JLabel("Grado escolar:")).setVisible(false);
		add(rbPrimaria).setVisible(false);
		add(rbSecundaria).setVisible(false);
		add(rbPreparatoria).setVisible(false);

	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == this.rbSi) {
			System.out.println("hola");
			this.lbTe.setVisible(true);
			this.tfAdvertencias[5].setVisible(true);
			this.labelAdvertencia[5].setVisible(true);
			this.lbGe.setVisible(true);
			this.rbPrimaria.setVisible(true);
			this.rbSecundaria.setVisible(true);
			this.rbPreparatoria.setVisible(true);
			this.revalidate();
			this.repaint();
		}else if(arg0.getSource() == this.rbNo) {
			this.lbTe.setVisible(false);
			this.tfAdvertencias[5].setVisible(false);
			this.tfAdvertencias[5].setText("");
			this.labelAdvertencia[5].setVisible(false);
			this.labelAdvertencia[5].setText("");
			this.lbGe.setVisible(false);

			bgGradoEsc.clearSelection();
			this.rbPrimaria.setVisible(false);
			this.rbSecundaria.setVisible(false);
			this.rbPreparatoria.setVisible(false);
			this.revalidate();
			this.repaint();
		}
	}
	

}
