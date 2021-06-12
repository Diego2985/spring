package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.excepciones.FechaNoSeleccionada;
import ar.edu.unlam.tallerweb1.excepciones.ServicioNoSeleccionado;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.interfaces.ServicioTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorReservarTurno {

    private final ServicioTurno servicioTurno;

    @Autowired
    public ControladorReservarTurno(ServicioTurno servicioTurno) {
        this.servicioTurno = servicioTurno;
    }

    @RequestMapping(path="/reservar-turno")
    public ModelAndView irAReservarTurno() {
        ModelMap modelo = new ModelMap();

        List<Servicio> servicios = servicioTurno.getServicios();
        DatosTurno turno = new DatosTurno();
        turno.setServicios(servicios);

        modelo.put("turno", turno);

        return new ModelAndView("reservar-turno", modelo);
    }

    @RequestMapping(path = "/reservar-turno", method = RequestMethod.POST)
    public ModelAndView reservar(@ModelAttribute("turno") DatosTurno datosTurno) {
        ModelMap modelMap = new ModelMap();

        try {
            servicioTurno.reservar(datosTurno);
        } catch (FechaNoSeleccionada e) {
            return reservaFallida(modelMap, "Fecha no seleccionada");
        } catch (ServicioNoSeleccionado e) {
            return reservaFallida(modelMap, "Servicio no seleccionado");
        }

        return reservaExitosa(modelMap);
    }

    private ModelAndView reservaFallida(ModelMap model , String causa) {
        List<Servicio> servicios = servicioTurno.getServicios();
        DatosTurno turno = new DatosTurno();
        turno.setServicios(servicios);

        model.put("turno", turno);
        model.put("error", causa);

        return new ModelAndView("reservar-turno", model);
    }

    private ModelAndView reservaExitosa(ModelMap model) {
        model.put("reservado", true);
        return new ModelAndView("reserva-exitosa", model);
    }
}
