package ar.edu.unju.edm.controller;
import java.time.LocalDate;
import java.time.Period;
import java.time.Month;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.Persona;
@Controller
public class PersonaController {
@GetMapping	({"/","/persona"})
public ModelAndView cargarPersona() {
	Persona nuevaPersona=new Persona();
	ModelAndView modelAndView=new ModelAndView("persona");
	modelAndView.addObject("persona",nuevaPersona);
	return modelAndView;
}
@PostMapping("/datos-persona")
public ModelAndView guardarPersona(@ModelAttribute("persona") Persona datosPersona) {
	int edad = calcularEdad(datosPersona.getFechaNacimiento());
	String signo = obtenerSignoZodiaco(datosPersona.getFechaNacimiento());
	String estacion = obtenerEstacionAnio(datosPersona.getFechaNacimiento());
	ModelAndView modelAndView=new ModelAndView("datos-persona");
	modelAndView.addObject("persona",datosPersona);
	modelAndView.addObject("edad", edad);
	modelAndView.addObject("signo", signo);
	modelAndView.addObject("estacion", estacion);
	return modelAndView;
}
public int calcularEdad(LocalDate fechaNacimiento) {
	LocalDate fechaActual=LocalDate.now();
	Period periodo= Period.between(fechaNacimiento, fechaActual);

	return periodo.getYears();
}
public String obtenerSignoZodiaco(LocalDate fechaNacimiento) {
	int dia = fechaNacimiento.getDayOfMonth();
	int mes = fechaNacimiento.getMonthValue();
	String signo = "";

	if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 20)) {
		signo = "Aries";
	} else if ((mes == 4 && dia >= 21) || (mes == 5 && dia <= 20)) {
		signo = "Tauro";
	} else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
		signo = "Géminis";
	} else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 20)) {
		signo = "Cáncer";
	} else if ((mes == 7 && dia >= 21) || (mes == 8 && dia <= 20)) {
		signo = "Leo";
	} else if ((mes == 8 && dia >= 21) || (mes == 9 && dia <= 20)) {
		signo = "Virgo";
	} else if ((mes == 9 && dia >= 21) || (mes == 10 && dia <= 20)) {
		signo = "Libra";
	} else if ((mes == 10 && dia >= 21) || (mes == 11 && dia <= 20)) {
		signo = "Escorpio";
	} else if ((mes == 11 && dia >= 21) || (mes == 12 && dia <= 20)) {
		signo = "Sagitario";
	} else if ((mes == 12 && dia >= 21) || (mes == 1 && dia <= 20)) {
		signo = "Capricornio";
	} else if ((mes == 1 && dia >= 21) || (mes == 2 && dia <= 20)) {
		signo = "Acuario";
	} else if ((mes == 2 && dia >= 21) || (mes == 3 && dia <= 20)) {
		signo = "Piscis";
	}

	return signo;
}
public String obtenerEstacionAnio(LocalDate fechaNacimiento) {
	Month mes = fechaNacimiento.getMonth();
	String estacion = "";

	if (mes == Month.DECEMBER || mes == Month.JANUARY || mes == Month.FEBRUARY) {
		estacion = "Verano";
	} else if (mes == Month.MARCH || mes == Month.APRIL || mes == Month.MAY) {
		estacion = "Otoño";
	} else if (mes == Month.JUNE || mes == Month.JULY || mes == Month.AUGUST) {
		estacion = "Invierno";
	} else if (mes == Month.SEPTEMBER || mes == Month.OCTOBER || mes == Month.NOVEMBER) {
		estacion = "Primavera";
	}

	return estacion;
}
}
