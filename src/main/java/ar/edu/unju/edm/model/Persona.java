package ar.edu.unju.edm.model;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Persona {
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  
public Persona() {
	// TODO Auto-generated constructor stub
}

public Persona(String nombre, String apellido, String fechaNacimiento) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
  
  
}
