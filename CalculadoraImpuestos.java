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
		persona.setSueldoMensual(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setAguinaldoRecibido(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setPrimaVacacionalRecibida(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setGastosMedicos(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setGastosFunerarios(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setGastosSGMM(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setGastosHipotecarios(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setDonativos(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setAportacionRetiro(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setTransporteEscolar(Double.parseDouble(campo));
		campo=st.nextToken();
		persona.setNivelEducativo(campo);
		campo=st.nextToken();
		persona.setColegiatura(Double.parseDouble(campo));
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
		linea+=deduccion.getTotalIngresosGravan()+",";
		linea+=persona.getGastosMedicos()+",";
		linea+=persona.getGastosFunerarios()+",";
		linea+=persona.getGastosSGMM()+",";
		linea+=persona.getGastosHipotecarios()+",";
		linea+=persona.getDonativos()+",";
		linea+=persona.getAportacionRetiro()+",";
		if(persona.getNivelEducativo()!=-1) {
			linea+=persona.getTransporteEscolar()+",";	
			linea+=gradoEducativo[persona.getNivelEducativo()]+",";
			linea+=deduccion.MAX_DEDUCCION_ESCOLAR[persona.getNivelEducativo()]+",";
		}
		else {
			linea+="0.0,";
			linea+="Ninguno,";
			linea+="0.0,";
		}
		linea+=persona.getColegiatura()+",";
		linea+=deduccion.getTotalDeduccionesSinRetiro()+",";
		linea+=deduccion.getDeduccionPermitidaDiezPC()+",";
		linea+=deduccion.getMontoISR()+",";
		linea+=deduccion.CUOTA_FIJA[deduccion.getNivelImpuestos()]+",";
		linea+=100*deduccion.PORCENTAJE_EXCEDENTE[deduccion.getNivelImpuestos()]+"%,";;
		linea+=deduccion.getPagoExcedente()+",";
		linea+=deduccion.getTotalAPagar();
		return linea;
	}
}
