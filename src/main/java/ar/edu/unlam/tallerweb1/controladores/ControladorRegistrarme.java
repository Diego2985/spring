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


    private final ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorRegistrarme(ServicioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;

    }

    @RequestMapping(path = "/me-registro", method = RequestMethod.GET)
    public ModelAndView irAPagina2(){
        ModelMap model =new ModelMap();
        model.put("registro", new DatosRegistro());
        return new ModelAndView("formularioUsuario", model);
    }
    @RequestMapping(path = "/registrar", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute DatosRegistro datos){
        ModelMap model = new ModelMap();
        try {
            servicioUsuario.registrar(datos);
        } catch (UsuarioExistente e){
            return registroFallido(model, "usuario ya existente");
        } catch (ClavesNoCoinciden e){
            return registroFallido(model, "las claves no son iguales");
        }
        return registroExitoso(model);
    }




    private ModelAndView registroExitoso(ModelMap model) {

        model.put("registrado", true);
        return new ModelAndView("redirect:/login", model);
    }
    private ModelAndView registroFallido(ModelMap model, String usuario_existente) {
        model.put("registrado", true);
        model.put("mostrar", "Nuevo Usuario");
        model.put("redirect:/login", new DatosRegistro());
        model.put("error", usuario_existente);
        return new ModelAndView("formularioUsuario", model);
    }
}
