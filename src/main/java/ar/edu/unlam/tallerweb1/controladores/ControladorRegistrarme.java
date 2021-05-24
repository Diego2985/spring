package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ClavesNoCoinciden;
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
<<<<<<< HEAD
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorRegistrarme(ServicioUsuario servicioUsuario){
           this.servicioUsuario = servicioUsuario;
=======
    private final ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorRegistrarme(ServicioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
>>>>>>> d6e0646... modificacion de la vista home
    }

    @RequestMapping(path = "/me-registro", method = RequestMethod.GET)
    public ModelAndView irAPagina2(){
        ModelMap model =new ModelMap();
        model.put("registro", new DatosRegistro());
        return new ModelAndView("registro", model);
    }
    @RequestMapping(path = "/resgistrar", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute DatosRegistro datos){
        ModelMap model = new ModelMap();
        try {
            servicioUsuario.registrar(datos);
        } catch (UsuarioExistente e){
            return registroFallido(model, "usuario existente");
        } catch (ClavesNoCoinciden e){
            return registroFallido(model, "las claves no son iguales");
        }
        return registroExitoso(model);
    }

<<<<<<< HEAD
        private ModelAndView registroExitoso(ModelMap model) {
=======
    private ModelAndView registroExitoso(ModelMap model) {
>>>>>>> d6e0646... modificacion de la vista home
        model.put("registrado", true);
        return new ModelAndView("redirect:/login", model);
    }
    private ModelAndView registroFallido(ModelMap model, String usuario_existente) {
        model.put("registrado", false);
        model.put("mostrar", "Nuevo Usuario");
        model.put("registro", new DatosRegistro());
        model.put("error", usuario_existente);
        return new ModelAndView("registro", model);
    }
}
