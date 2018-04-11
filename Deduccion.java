public class Deduccion {
	
	private Persona contribuyente; 
	
	public static final double LIM_INF[]= {
		0.01,	
		5952.85,
		50524.93,
		88793.05,
		103218.01,
		123580.21,
		249243.49,
		392841.97,
		750000.01,
		1000000.01,
		3000000.01
	};

	public static final double LIM_SUP[]={
		5952.84,
		50524.92,
		88793.04,
		103218.0,
		123580.2,
		249243.48,
		392841.96,
		750000.0,
		1000000.0,
		3000000.0
	};

	public static final double CUOTA_FIJA[]={
		0.00,
		114.29,
		2966.91,
		7130.48,
		9438.47,
		13087.37,
		39929.05,
		73703.41,
		180850.82,
		260850.81,
		940850.81
	};

	public static final double PORCENTAJE_EXCEDENTE[]={
		0.0192,
		0.0640,
		0.1088,
		0.1600,
		0.1792,
		0.2136,
		0.2352,
		0.3000,
		0.3200,
		0.3400,
		0.3500
	};
	
	public static final double MAX_DEDUCCION_ESCOLAR[]= {
			14200,
			12900,
			19900,
			24500
	};
	
	public static final double MAX_PRIMA_EXCENTA=1209;

	private int nivelImpuestos;
	

	private	double	ingresoAnual,
					aguinaldoExcento,
					aguinaldoGravado,
					primaExcenta,
					primaGravada,
					totalIngresosGravan,
					maxDeducible,
					deduccionEscolar,
					totalDeduccionesSinRetiro,
					deduccionPermitida,
					montoISR,
					pagoExcedente,
					totalAPagar;
	
	
	Deduccion(Persona contribuyente){
		setContribuyente(contribuyente);
		setIngresoAnual(this.contribuyente.getSueldoMensual()*12);
		if(this.contribuyente.getAguinaldoRecibido()>this.contribuyente.getSueldoMensual()/2) {
			setAguinaldoGravado(this.contribuyente.getAguinaldoRecibido()-this.contribuyente.getSueldoMensual()/2);
			setAguinaldoExcento(this.contribuyente.getAguinaldoRecibido()-aguinaldoGravado);
		}
		else {
			setAguinaldoExcento(this.contribuyente.getAguinaldoRecibido());
			setAguinaldoGravado(0.0);
		}
		if(this.contribuyente.getPrimaVacacionalRecibida()>MAX_PRIMA_EXCENTA) {
			setPrimaGravada(this.contribuyente.getPrimaVacacionalRecibida()-MAX_PRIMA_EXCENTA);
			setPrimaExcenta(MAX_PRIMA_EXCENTA);
		}
		else {
			setPrimaExcenta(this.contribuyente.getPrimaVacacionalRecibida());
			setPrimaGravada(0.0);
		}
		setTotalIngresosGravan(ingresoAnual+aguinaldoGravado+primaGravada);
		if(this.contribuyente.getNivelEducativo()!=-1) {
			if(this.contribuyente.getColegiatura()>MAX_DEDUCCION_ESCOLAR[this.contribuyente.getNivelEducativo()]) {
				setDeduccionEscolar(MAX_DEDUCCION_ESCOLAR[this.contribuyente.getNivelEducativo()]);
			}
			else {
				setDeduccionEscolar(this.contribuyente.getColegiatura());
			}
		}
		else {
			setDeduccionEscolar(0.0);
		}
		setTotalDeduccionesSinRetiro(this.contribuyente.getGastosMedicos()+this.contribuyente.getGastosFunerarios()+this.contribuyente.getGastosSGMM()+this.contribuyente.getGastosHipotecarios()+this.contribuyente.getDonativos()+this.deduccionEscolar+this.contribuyente.getTransporteEscolar());
		setDeduccionPermitida(this.totalDeduccionesSinRetiro,this.contribuyente.getAportacionRetiro());
		setMontoISR(this.totalIngresosGravan-this.deduccionPermitida);
		for(nivelImpuestos=0;nivelImpuestos<PORCENTAJE_EXCEDENTE.length && this.montoISR>LIM_SUP[nivelImpuestos];nivelImpuestos++);
		setPagoExcedente((this.montoISR-LIM_INF[nivelImpuestos])*PORCENTAJE_EXCEDENTE[nivelImpuestos]);
		setTotalAPagar(CUOTA_FIJA[nivelImpuestos]+pagoExcedente);
	}


	public Persona getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(Persona contribuyente) {
		this.contribuyente = contribuyente;
	}

	public double getIngresoAnual() {
		return ingresoAnual;
	}

	public void setIngresoAnual(Double ingresoAnual) {
		this.ingresoAnual = ingresoAnual;
	}

	public double getAguinaldoExcento() {
		return aguinaldoExcento;
	}

	public void setAguinaldoExcento(Double aguinaldoExcento) {
		this.aguinaldoExcento = aguinaldoExcento;
	}

	public double getAguinaldoGravado() {
		return aguinaldoGravado;
	}

	public void setAguinaldoGravado(Double aguinaldoGravado) {
		this.aguinaldoGravado = aguinaldoGravado;
	}

	public double getPrimaExcenta() {
		return primaExcenta;
	}

	public void setPrimaExcenta(Double primaExcenta) {
		this.primaExcenta = primaExcenta;
	}

	public double getPrimaGravada() {
		return primaGravada;
	}

	public void setPrimaGravada(Double primaGravada) {
		this.primaGravada = primaGravada;
	}

	public double getTotalIngresosGravan() {
		return totalIngresosGravan;
	}

	public void setTotalIngresosGravan(Double totalIngresosGravan) {
		this.totalIngresosGravan = totalIngresosGravan;
	}

	public double getMaxDeducible() {
		return maxDeducible;
	}

	public double getDeduccionEscolar() {
		return deduccionEscolar;
	}

	public void setDeduccionEscolar(Double deduccionEscolar) {
		this.deduccionEscolar = deduccionEscolar;
	}

	public int getNivelImpuestos() {
		return nivelImpuestos;
	}

	public void setNivelImpuestos(int nivelImpuestos) {
		this.nivelImpuestos = nivelImpuestos;
	}

	public double getTotalDeduccionesSinRetiro() {
		return totalDeduccionesSinRetiro;
	}

	public void setTotalDeduccionesSinRetiro(Double totalDeduccionesSinRetiro) {
		this.totalDeduccionesSinRetiro = totalDeduccionesSinRetiro;
	}

	public double getDeduccionPermitida() {
		return deduccionPermitida;
	}

	public void setDeduccionPermitida(double deduccion10,double deduccionSeguro) {
		double totalIngresosDiezPC=(this.ingresoAnual+this.contribuyente.getAguinaldoRecibido()+this.contribuyente.getPrimaVacacionalRecibida())/10;
		if(totalIngresosDiezPC<deduccion10) {
			this.deduccionPermitida=totalIngresosDiezPC;
					if(totalIngresosDiezPC<deduccionSeguro) {
						this.deduccionPermitida+=totalIngresosDiezPC;
					}
					else {
						this.deduccionPermitida+=deduccionSeguro;
					}
		}
		else {
			this.deduccionPermitida=deduccion10+deduccionSeguro;
		}
	}

	public double getMontoISR() {
		return montoISR;
	}

	public void setMontoISR(Double montoISR) {
		this.montoISR = montoISR;
	}

	public double getPagoExcedente() {
		return pagoExcedente;
	}

	public void setPagoExcedente(Double pagoExcedente) {
		this.pagoExcedente = pagoExcedente;
	}

	public double getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	public double getMaxDeducibleColegiatura() {
		return MAX_DEDUCCION_ESCOLAR[this.contribuyente.getNivelEducativo()];
	}
}
