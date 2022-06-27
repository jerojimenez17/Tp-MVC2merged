package models;

public class TicketEmpleado extends Ticket {

	private String resultado;

	public static final String RESULTADO_EXITO = "EXITO";
	public static final String RESULTADO_FRACASO = "FRACASO";
	public static final String RESULTADO_SIN_RESULTADO = "SIN RESULTADO";

	public TicketEmpleado() {
		super();
		resultado = RESULTADO_SIN_RESULTADO;
	}
	public void setResultado(String r) {
		this.resultado=r;
	}

	public String getResultado() {
		return resultado;
	}

	@Override
	public String toString() {
		return super.toString() + "\nResultado: " + getResultado();
	}
	public void setResultadoExito() {
		this.resultado=RESULTADO_EXITO;
		this.setEstadoFinalizado();
		
	}
}
