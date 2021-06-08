package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.ServicioNoSeleccionado;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorReservarTurno {

    private final ServicioTurno servicioTurno;

    @Autowired
    public ControladorReservarTurno(ServicioTurno servicioTurno) {
        this.servicioTurno = servicioTurno;
    }

    @RequestMapping(path = "/reservar-turno", method = RequestMethod.POST)
    public ModelAndView reservar(@ModelAttribute DatosTurno datosTurno) {
        ModelMap modelMap = new ModelMap();

        try {
            servicioTurno.reservar(datosTurno);
        } catch (ServicioNoSeleccionado e) {
            return reservaFallido(modelMap, "Servicio no seleccionado");
        }

        return reservaExitosa(modelMap);
    }

    private ModelAndView reservaFallido(ModelMap model , String causa) {
        model.put("error", causa);
        return new ModelAndView("reserva-turno-peluqueria", model);
    }

    private ModelAndView reservaExitosa(ModelMap model) {
        model.put("reservado", true);
        return new ModelAndView("redirect:/reserva-exitosa", model);
    }
}
