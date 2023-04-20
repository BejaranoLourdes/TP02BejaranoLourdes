package ar.edu.unju.edm.controller;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.ProcesoFecha;

@Controller
public class ProcesoFechaController {
	@GetMapping({"/procesoFecha"})
	public ModelAndView cargarProcesoFecha() {
		ProcesoFecha nuevoProcFecha = new ProcesoFecha();

		ModelAndView modelAndView = new ModelAndView("procesoFecha");
		modelAndView.addObject("procesoFecha", nuevoProcFecha);

		return modelAndView;
	}

	@PostMapping("/fechaProcesada")
	public ModelAndView guardarProcFecha(@ModelAttribute("procesoFecha") ProcesoFecha fechaProc) {
		fechaProc.setMensaje1(compararFechas(fechaProc.getFecha1(), fechaProc.getFecha2()));
		fechaProc.setMensaje2(mostrarTiempoTranscurridoDesde(fechaProc.getFecha1(), fechaProc.getFecha2()));

		ModelAndView modelAndView = new ModelAndView("fechaProcesada");
		modelAndView.addObject("procesoFecha", fechaProc);

		return modelAndView;
	}

	public String compararFechas(LocalDate fecha1, LocalDate fecha2) {
		int resultado = fecha1.compareTo(fecha2);

		if (resultado < 0) {
			return "fecha1 " + fecha1 + " es anterior a fecha2 " + fecha2;
		} else if (resultado > 0) {
			return "fecha1 " + fecha1 + " es posterior a fecha2 " + fecha2;
		} else {
			return "fecha1 " + fecha1 + " es igual a fecha2 " + fecha2;
		}
	}

	public String mostrarTiempoTranscurridoDesde(LocalDate fecha1, LocalDate fecha2) {
		LocalDate fechaMenor, fechaMayor;

		if (fecha1.isBefore(fecha2)) {
			fechaMenor = fecha1;
			fechaMayor = fecha2;
		} else {
			fechaMenor = fecha2;
			fechaMayor = fecha1;
		}

		Period periodo = Period.between(fechaMenor, fechaMayor);
		int año= periodo.getYears();
		int mes= periodo.getMonths();
		int dia= periodo.getDays();
		String resultado = "El tiempo transcurrido es de: "+ año+" años, " + mes +" meses y " + dia +" días entre "+fechaMenor+" y  "+fechaMayor;
		 return resultado;
		 
	}
}