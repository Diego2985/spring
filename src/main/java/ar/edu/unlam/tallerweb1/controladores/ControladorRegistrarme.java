package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioGato;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.UsuarioExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorRegistrarme {


    private final ServicioUsuario servicioUsuario;


    @Autowired
    public ControladorRegistrarme(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;


    }

    @RequestMapping(path = "/registro", method = RequestMethod.GET)
    public ModelAndView irARegistro() {
        ModelMap model = new ModelMap();
        model.put("registro", new DatosRegistro());
        return new ModelAndView("registro", model);
    }

    @RequestMapping(path = "/registro", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute DatosRegistro datos) {
        ModelMap model = new ModelMap();
        try {
            servicioUsuario.registrar(datos);
        } catch (UsuarioExistente e) {
            return registroFallido(model, "usuario ya existente");
        }
        return registroExitoso(model);
    }

    private ModelAndView registroExitoso(ModelMap model) {

        model.put("registrado", true);
        return new ModelAndView("login", model);
    }

    private ModelAndView registroFallido(ModelMap model, String usuario_existente) {
        model.put("registrado", true);
        model.put("mostrar", "Nuevo Usuario");
        model.put("redirect:/login", new DatosRegistro());
        model.put("error", usuario_existente);
        return new ModelAndView("registro", model);
    }
}
