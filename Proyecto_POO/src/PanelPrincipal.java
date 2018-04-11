import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	private JFileChooser fc = new JFileChooser();
	private File archivo;
	private JButton btAbrir, btNuevo;
	private VentanaPrincipal vt;

	public PanelPrincipal( VentanaPrincipal vt) {
		super();
		this.vt = vt;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		//this.setPreferredSize(new Dimension(350, 30));
		this.btAbrir = new JButton("Abrir archivo");	
		this.btAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int opcion = fc.showOpenDialog(PanelPrincipal.this);
				if (opcion == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fc.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    //ManejadorDeDatos md = new ManejadorDeDatos(selectedFile, Destino)
				    vt.archivo = true;
				    vt.cl.show(vt.panelCont, "5");
				}
			}
		
		}); 
		
		this.btNuevo = new JButton("Nuevo");
		this.btNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vt.archivo = false;
				vt.cl.next(vt.panelCont);
				vt.pc.setVisible(true);
			}
		});
		
		gbc.gridwidth = 4;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(new JLabel("Puede abrir un archivo con la información o crear uno nuevo"),gbc);
		
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(btAbrir,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(btNuevo,gbc);
		
	}
	
	public void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		
	}
}
