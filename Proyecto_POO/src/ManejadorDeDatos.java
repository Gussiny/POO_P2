import java.awt.Panel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

//José Fausto Rodriguez Herrera A01634943
//Gustavo Alejandro Flores Cortes A01635151

public class ManejadorDeDatos {

	private BufferedReader bf;
	private PrintWriter pw;
	
	public ManejadorDeDatos(String Origen,String Destino) throws FileNotFoundException,IOException {
		String linea;
		bf=new BufferedReader(new FileReader(Origen));
		pw=new PrintWriter(new FileWriter(Destino));
		pw.println("Nombre,"
				+ "RFC,"
				+ "Sueldo mensual,"
				+ "Ingreso anual,"
				+ "Aguinaldo,"
				+ "Aguinaldo exento,"
				+ "Aguinaldo gravado,"
				+ "Prima vacacional,"
				+ "Prima vacacional excenta,"
				+ "Prima vacacional gravada,"
				+ "Total ingresos gravan,"
				+ "Medicos y hospitales,"
				+ "Gastos funerarios,"
				+ "SGMM,"
				+ "Hipotecarios,"
				+ "Donativos,"
				+ "Subcuenta retiro,"
				+ "Transporte escolar,"
				+ "Nivel educativo,"
				+ "Maximo a deducir colegiatura,"
				+ "Colegiatura pagada,"
				+ "Total deducciones (sin retiro),"
				+ "Deduccion permitida 10%,"
				+ "Monto ISR,"
				+ "Cuota fija,"
				+ "Porcentaje excedente,"
				+ "Pago excedente,"
				+ "Total a pagar");
		while((linea=bf.readLine())!=null) {
			pw.println(new CalculadoraImpuestos(linea));
		}
		bf.close();
		pw.close();
		JOptionPane.showMessageDialog(null, "Archivo Guardado Satisfactoriamente", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
