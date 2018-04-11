
public class Persona {
	private String	nombre,
					rfc;
	
	private int nivelEducativo;
	
	private double	sueldoMensual,
					aguinaldoRecibido,
					primaVacacionalRecibida,
					gastosMedicos,
					gastosFunerarios,
					gastosSGMM,
					gastosHipotecarios,
					donativos,
					aportacionRetiro,
					transporteEscolar,
					colegiatura;
	
	public Persona(){
		
		
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public double getSueldoMensual() {
		return sueldoMensual;
	}


	public void setSueldoMensual(double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}


	public double getAguinaldoRecibido() {
		return aguinaldoRecibido;
	}


	public void setAguinaldoRecibido(double aguinaldoRecibido) {
		this.aguinaldoRecibido = aguinaldoRecibido;
	}


	public double getPrimaVacacionalRecibida() {
		return primaVacacionalRecibida;
	}


	public void setPrimaVacacionalRecibida(double primaVacacionalRecibida) {
		this.primaVacacionalRecibida = primaVacacionalRecibida;
	}


	public double getGastosMedicos() {
		return gastosMedicos;
	}


	public void setGastosMedicos(double gastosMedicos) {
		this.gastosMedicos = gastosMedicos;
	}


	public double getGastosFunerarios() {
		return gastosFunerarios;
	}


	public void setGastosFunerarios(double gastosFunerarios) {
		this.gastosFunerarios = gastosFunerarios;
	}


	public double getGastosSGMM() {
		return gastosSGMM;
	}


	public void setGastosSGMM(double gastosSGMM) {
		this.gastosSGMM = gastosSGMM;
	}


	public double getGastosHipotecarios() {
		return gastosHipotecarios;
	}


	public void setGastosHipotecarios(double gastosHipotecarios) {
		this.gastosHipotecarios = gastosHipotecarios;
	}


	public double getDonativos() {
		return donativos;
	}


	public void setDonativos(double donativos) {
		this.donativos = donativos;
	}


	public double getAportacionRetiro() {
		return aportacionRetiro;
	}


	public void setAportacionRetiro(double aportacionRetiro) {
		this.aportacionRetiro = aportacionRetiro;
	}


	public double getTransporteEscolar() {
		return transporteEscolar;
	}


	public void setTransporteEscolar(double transporteEscolar) {
		this.transporteEscolar = transporteEscolar;
	}

	public int getNivelEducativo() {
		return nivelEducativo;
	}

	public void setNivelEducativo(String nivelEducativo) {
		String niveles[]= {"Preescolar","Primaria","Secundaria","Preparatoria"};
		this.nivelEducativo=-1;
		for(int i=0;i<niveles.length;i++) {
			if(niveles[i].equalsIgnoreCase(nivelEducativo)) {
				this.nivelEducativo=i;
			}
		}
	}

	public double getColegiatura() {
		return colegiatura;
	}


	public void setColegiatura(double colegiatura) {
		this.colegiatura = colegiatura;
	}
	
	
}
