import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//José Fausto Rodriguez Herrera A01634943
//Gustavo Alejandro Flores Cortes A01635151

public class PanelPersonal extends JPanel{
	protected JTextField tfNombre, tfRFC;
	protected JLabel labelRFC;
	private VentanaPrincipal vt;
	private TextFieldNumeros[] tfAdvertencias;
	private JLabel labelAdvertencia[];
	private JButton btNext, btBack;
	
	public PanelPersonal(VentanaPrincipal vt) {
		super();
		setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.vt = vt;
		btBack = new JButton("ATRAS");
		btNext = new JButton("SIGUIENTE");		
		this.tfAdvertencias = new TextFieldNumeros[3];
		this.labelAdvertencia = new JLabel[3];
				
		for(int i = 0; i < tfAdvertencias.length ; i++) {
			this.labelAdvertencia[i] = new JLabel();
			this.tfAdvertencias[i] = new TextFieldNumeros(labelAdvertencia[i]);		
		}
			
		this.labelRFC = new JLabel("");
		this.labelRFC.setForeground(Color.RED);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(new JLabel("DATOS PERSONALES"),gbc);
		JLabel lblNombre = new JLabel("NOMBRE:");
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(lblNombre, gbc);
		
		this.tfNombre = new JTextField(30);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		this.add(tfNombre,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		this.add(new JLabel("RFC:"), gbc);
		
		this.tfRFC = new JTextField(20);
		this.tfRFC.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(tfRFC.getText().length() < 10) {
					//System.out.println("mas de 13");
					labelRFC.setText("El RFC solo debe contar minimo con 10 digitos");
				}else {
					labelRFC.setText("");
				}
			}
		});
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(tfRFC,gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(labelRFC,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(new JLabel("SUELDO MENSUAL $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(this.tfAdvertencias[0],gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(this.labelAdvertencia[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(new JLabel("AGUINALDO RECIBIDO $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(this.tfAdvertencias[1],gbc);
		gbc.gridx = 1;
		gbc.gridy = 8;
		this.add(this.labelAdvertencia[1],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(new JLabel("PRIMA VACACIONAL $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(this.tfAdvertencias[2],gbc);
		gbc.gridx = 1;
		gbc.gridy = 10;
		this.add(this.labelAdvertencia[2],gbc);
		
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
				if(labelRFC.getText() != "") {
					JOptionPane.showMessageDialog(null, "REVISA EL RFC");
					error = true;
				}
				if(tfNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "INGRESE SU NOMBRE","ERROR",JOptionPane.ERROR_MESSAGE);
					error = true;
				}
				
				if(tfRFC.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "INGRESE SU RFC","ERROR",JOptionPane.ERROR_MESSAGE);
					error = true;
				}
				
				if(!error) {
					obtenerDatos();
					for(int i = 0; i < vt.datos.length;i++) {
						System.out.println(vt.datos[i]);
					}
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
		
		gbc.gridx = 1;
		gbc.gridy = 11;
		this.add(btNext,gbc);
	}

	
	public void obtenerDatos() {
		vt.datos[0] = tfNombre.getText();
		vt.datos[1] = tfRFC.getText();
		int d = 2;
		for(int i = 0; i < tfAdvertencias.length; i++) {
			if(tfAdvertencias[i].getText().equals("")) {
				vt.datos[d] = "0.0";
			}else {
				vt.datos[d] =String.valueOf(Double.parseDouble(tfAdvertencias[i].getText()));
			}
			d+=1;
		}
		
	}
	
}
