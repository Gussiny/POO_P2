import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

//José Fausto Rodriguez Herrera A01634943
//Gustavo Alejandro Flores Cortes A01635151

public class PanelFinal extends JPanel{
	private JFileChooser fc = new JFileChooser();
	private File archivo;
	private JButton btFinish, btBack;
	private VentanaPrincipal vt;
	private String[] datosCalculados = new String[28];
	private String[] etiquetas = new String[] {"Nombre"
			,"RFC"
			,"Sueldo mensual"
			,"Ingreso anual"
			,"Aguinaldo"
			,"Aguinaldo excento"
			,"Aguinaldo gravado"
			,"Prima vacacional"
			,"Prima vacacional excenta"
			,"Prima vacacional gravada"
			,"Total ingresos gravados"
			,"Medicos y hospitales"
			,"Gastos funerarios"
			,"SGMM"
			,"Hipotecarios"
			,"Donativos"
			,"Subcuenta retiro"
			,"Transporte escolar"
			,"Nivel educativo"
			,"Maximo a deducir colegiatura"
			,"Colegiatura pagada"
			,"Total deducciones(sinretiro)"
			,"Deducciones permitidas"
			,"Monto ISR"
			,"Cuota fija"
			,"Porcentaje excedente"
			,"Pago excedente"
			,"Total a pagar"
	};

	public PanelFinal(VentanaPrincipal vt, String datosSeperados) {
		super();
		StringTokenizer st = new StringTokenizer(datosSeperados, ",");
		System.out.println(st.countTokens());
		int lugar = 0;
		while(st.hasMoreTokens()) {
			String niu = st.nextToken(); 
			datosCalculados[lugar] = niu;
			lugar++;
		}
		this.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.vt = vt;
		btBack = new JButton("ATRAS");
		btFinish = new JButton("EXPORTAR");


		btBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vt.cl.previous(vt.panelCont);
			}
		});
		btFinish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter fitro = new FileNameExtensionFilter("Archivo CSV ('.csv')", "csv");
				fc.setFileFilter(fitro);
				String ruta = "";
				String[] lines = datosCalculados;
				if(fc.showDialog(null, "Guardar como") == JFileChooser.APPROVE_OPTION) {
					archivo = fc.getSelectedFile();
					String texto;

					if(archivo.getName().endsWith("csv")) {
						ruta = archivo.getName();
						System.out.println(ruta);
						try {
							generarArchivo(archivo, lines);
						} catch (IOException e) {
							System.out.println("No se pudo escribir el archivo");
						}
					}else {
						ruta = (archivo.getName() +".csv");
						archivo = new File(fc.getSelectedFile()+".csv");
						System.out.println(ruta);
						try {
							generarArchivo(archivo, lines);
						} catch (IOException e) {
							System.out.println("No se pudo escribir el archivo");
						}
					}			
					limpiarInformacion();
				}
			}});

		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;	
		gbc.gridx = 0;
		int y = 0;

		System.out.println("-----------------------------");

		for(int i = 0; i<datosCalculados.length;i++) {
			if(i == datosCalculados.length/2) {
				gbc.gridx = 1;
				y = 0;
			}
			gbc.gridy = y;
			this.add(new JLabel(etiquetas[i] + " " + datosCalculados[i]),gbc);
			y+=1;
		}

		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridx = 0;

		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;

		if (!this.vt.archivo) {
			gbc.gridx = 0;
			gbc.gridy = y;
			this.add(btBack,gbc);
		}		

		gbc.gridx = 1;
		gbc.gridy = y;
		this.add(btFinish,gbc);
	}

	public void generarArchivo(File ruta, String[] texto) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(ruta));
		System.out.println(ruta);
		for(int i=0; i<etiquetas.length;i++) {
			pw.print(etiquetas[i] + ",");
		}
		pw.println();
		for(int i=0; i<texto.length; i++) {
			pw.print(texto[i] + ",");
		}
		pw.close();
		JOptionPane.showMessageDialog(null, "ARCHIVO CSV GENERADO CON EXITO");
	}

	public void limpiarInformacion() {
		vt.reiniciar();
	}
}
