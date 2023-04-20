  package ar.edu.unju.edm.model;
import java.time.LocalDate;

public class ProcesoFecha {
	private LocalDate fecha1;
	private LocalDate fecha2;
	private String mensaje1;
	private String mensaje2;

	public ProcesoFecha() {
		// TODO Auto-generated constructor stub
	}

	public ProcesoFecha(String fecha1, String fecha2, String mensaje1, String mensaje2) {
		super();
		this.fecha1 = LocalDate.parse(fecha1);
		this.fecha2 = LocalDate.parse(fecha2);
		this.mensaje1 = mensaje1;
		this.mensaje2 = mensaje2;
	}

	public LocalDate getFecha1() {
		return fecha1;
	}

	public void setFecha1(LocalDate fecha1) {
		this.fecha1 = fecha1;
	}

	public LocalDate getFecha2() {
		return fecha2;
	}

	public void setFecha2(LocalDate fecha2) {
		this.fecha2 = fecha2;
	}

	public String getMensaje1() {
		return mensaje1;
	}

	public void setMensaje1(String mensaje1) {
		this.mensaje1 = mensaje1;
	}

	public String getMensaje2() {
		return mensaje2;
	}

	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}
}