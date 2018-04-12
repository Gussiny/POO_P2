import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

//José Fausto Rodriguez Herrera A01634943

public class PanelExtras extends JPanel{
	private TextFieldNumeros[] tfAdvertencias;
	private JLabel labelAdvertencia[];

	public PanelExtras() {
		super();
		this.setPreferredSize(new Dimension(350, 500));
		this.setBackground(Color.WHITE);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.tfAdvertencias = new TextFieldNumeros[3];
		this.labelAdvertencia = new JLabel[3];
		
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
		this.add(new JLabel("HIPOTECARIOS $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(this.tfAdvertencias[0],gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(this.labelAdvertencia[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(new JLabel("DONATIVOS $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(this.tfAdvertencias[1],gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(this.labelAdvertencia[1],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(new JLabel("APORTACIÓN RETIRO $"),gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(this.tfAdvertencias[2],gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(this.labelAdvertencia[2],gbc);
	}
}
