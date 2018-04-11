import java.util.StringTokenizer;

import javax.swing.JTextField;

public class CalculadoraImpuestos {
	
	private Persona persona;
	
	private Deduccion deduccion;
	
	public static final String gradoEducativo[]={
		"Preescolar",
		"Primaria",
		"Secundaria",
		"Preparatoria"
	};
	
	
	public CalculadoraImpuestos(String linea) {
		persona=new Persona();
		StringTokenizer st=new StringTokenizer(linea, ",");
		String campo=st.nextToken();
		persona.setNombre(campo);
		campo=st.nextToken();
		persona.setRfc(campo);
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setSueldoMensual(0.0);
		}
		else {
			persona.setSueldoMensual(Double.parseDouble(campo));
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
		persona.setAguinaldoRecibido(Double.parseDouble(campo));
		}
		else {
			persona.setAguinaldoRecibido(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setPrimaVacacionalRecibida(Double.parseDouble(campo));
		}
		else {
			persona.setPrimaVacacionalRecibida(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setGastosMedicos(Double.parseDouble(campo));
		}
		else {
			persona.setGastosMedicos(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setGastosFunerarios(Double.parseDouble(campo));
		}
		else {
			persona.setGastosFunerarios(0.0);	
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setGastosSGMM(Double.parseDouble(campo));
		}
		else {
			persona.setGastosSGMM(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setGastosHipotecarios(Double.parseDouble(campo));
		}
		else {
			persona.setGastosHipotecarios(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")){
			persona.setDonativos(Double.parseDouble(campo));
		}
		else {
			persona.setDonativos(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setAportacionRetiro(Double.parseDouble(campo));
		}
		else {
			persona.setAportacionRetiro(0.0);
		}
		campo=st.nextToken();
		if(!campo.equals("")) {
			persona.setTransporteEscolar(Double.parseDouble(campo));
		}
		else {
			persona.setTransporteEscolar(0.0);
		}
		campo=st.nextToken();
		persona.setNivelEducativo(campo);
		if(!campo.equals("")) {
			persona.setColegiatura(Double.parseDouble(campo));
		}
		else {
			persona.setColegiatura(0.0);
		}
		campo=st.nextToken();
		deduccion=new Deduccion(persona);
	}
	
	public String toString() {
		String linea="";
		linea+=persona.getNombre()+",";
		linea+=persona.getRfc()+",";
		linea+=persona.getSueldoMensual()+",";
		linea+=deduccion.getIngresoAnual()+",";
		linea+=persona.getAguinaldoRecibido()+",";
		linea+=deduccion.getAguinaldoExcento()+",";
		linea+=deduccion.getAguinaldoGravado()+",";
		linea+=persona.getPrimaVacacionalRecibida()+",";
		linea+=deduccion.getPrimaExcenta()+",";
		linea+=deduccion.getPrimaGravada()+",";
		linea+=deduccion.getTotalIngresosGravan();
		linea+=persona.getGastosMedicos()+",";
		linea+=persona.getGastosFunerarios()+",";
		linea+=persona.getGastosSGMM()+",";
		linea+=persona.getGastosHipotecarios()+",";
		linea+=persona.getDonativos()+",";
		linea+=persona.getAportacionRetiro()+",";
		linea+=persona.getTransporteEscolar()+",";
		linea+=gradoEducativo[persona.getNivelEducativo()]+",";
		linea+=deduccion.MAX_DEDUCCION_ESCOLAR[persona.getNivelEducativo()]+",";
		linea+=persona.getColegiatura()+",";
		linea+=deduccion.getTotalDeduccionesSinRetiro()+",";
		linea+=deduccion.getDeduccionPermitidaDiezPC()+",";
		linea+=deduccion.getMontoISR()+",";
		linea+=deduccion.CUOTA_FIJA[deduccion.getNivelImpuestos()]+",";
		linea+=deduccion.PORCENTAJE_EXCEDENTE[deduccion.getNivelImpuestos()]+",";;
		linea+=deduccion.getPagoExcedente()+",";
		linea+=deduccion.getTotalAPagar();
		return linea;
	}
}
