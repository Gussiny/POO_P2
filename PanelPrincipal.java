import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

//José Fausto Rodriguez Herrera A01634943

public class PanelPrincipal extends JPanel{
	private JFileChooser fc = new JFileChooser();
	private File archivo;
	private JButton btAbrir, btNuevo;
	private VentanaPrincipal vt;
	

	public PanelPrincipal( VentanaPrincipal vt) {
		super();
		this.vt = vt;
		fc.setFileFilter(new FileNameExtensionFilter("Archivo CSV ('.csv')", "csv"));
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
				    String opciones[]={"Guardar en la misma ruta","Elegir otra ruta"};
				    File Destino=new File(selectedFile.getParent()+"\\Salida.csv");
					if(JOptionPane.showOptionDialog(PanelPrincipal.this, "Elegir una ruta de guardado", "Guardar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, 0)==1) {
						if(JFileChooser.APPROVE_OPTION==fc.showSaveDialog(PanelPrincipal.this)) {
							Destino = fc.getSelectedFile();
						}
					}
					if(!(Destino.getAbsolutePath().substring(Destino.getAbsolutePath().length()-5,Destino.getAbsolutePath().length()-1).equals(".csv"))) {
						Destino=new File(Destino.getAbsolutePath()+".csv");
					}
					try {
						ManejadorDeDatos md = new ManejadorDeDatos(selectedFile.getAbsolutePath(), Destino.getAbsolutePath());
					} catch (FileNotFoundException e) {
				    	JOptionPane.showMessageDialog(PanelPrincipal.this, "Archivo a abrir no encontrado", "Error de archivo", JOptionPane.WARNING_MESSAGE);
					}
				    catch(IOException e) {
				    	JOptionPane.showMessageDialog(PanelPrincipal.this, "Verifique que el archivo no se encuentre abierto por otro programa", "No se puede abrir el archivo", JOptionPane.WARNING_MESSAGE);
				    }
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
