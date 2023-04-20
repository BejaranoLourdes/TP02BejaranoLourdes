package ar.edu.unju.edm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.edm.model.ProcesoString;

@Controller
public class ProcesoStringController {
	@GetMapping("/procesoString")
	public ModelAndView cargarProcesoString() {
		ProcesoString nuevoProcesoString = new ProcesoString();

		ModelAndView modelAndView = new ModelAndView("procesoString");
		modelAndView.addObject("procesoString", nuevoProcesoString);

		return modelAndView;
	}

	@PostMapping("/stringResultado")
	public ModelAndView guardarProcString(@ModelAttribute("procesoString") ProcesoString stringProc) {
		stringProc.setCadenaInvertida(invertirCadena(stringProc.getCadena()));
		stringProc.setMensaje1(determinarLongitud(stringProc.getCadena()));
		stringProc.setMensaje2(contarPalabras(stringProc.getCadena()));

		ModelAndView modelAndView = new ModelAndView("stringResultado");
		modelAndView.addObject("procesoString", stringProc);

		return modelAndView;
	}

	public String determinarLongitud(String cadena) {
		int longitud = cadena.length();
		int numVocales = 0;

		for (int i = 0; i < longitud; i++) {
			char letra = cadena.charAt(i);
			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
				numVocales++;
			}
		}

		return "La cadena tiene " + longitud + " caracteres y " + numVocales + " vocales. ";
	}

	public String invertirCadena(String cadena) {
		cadena = cadena.replaceAll("\\s", "");
		StringBuilder sb = new StringBuilder(cadena);

		return sb.reverse().toString();
	}

	public String contarPalabras(String cadena) {
		String[] palabras = cadena.trim().split("\\s+");

		return "La cadena tiene " + palabras.length + " palabras. ";

	}
}
