package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

    @Controller
    public class ControladorArticulo {

        @Autowired
        private final ServicioArticulo servicioArticulo;
        @Autowired
        public ControladorArticulo(ServicioArticulo servicioArticulo) {
            this.servicioArticulo = servicioArticulo;
        }

        @RequestMapping("/detalleArticulo")
        public ModelAndView irADetalleArticulo() {

            return new ModelAndView("detalleArticulo");
        }
    }
