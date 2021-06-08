package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTurnoImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioDefault;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ControladorReservarTurnoTest extends SpringTest {

    private final Usuario USUARIO = usuario("juan@mail.com", "password2345");
    private final Calendar fecha = Calendar.getInstance();

    private final ControladorRegistrarme controladorRegistro = new ControladorRegistrarme(new ServicioUsuarioDefault());

    private final RepositorioUsuarioImpl repositorioUsuario = new RepositorioUsuarioImpl(sessionFactory);
    private final RepositorioTurnoImpl repositorioTurno = new RepositorioTurnoImpl(sessionFactory);
    private final ServicioTurnoImpl servicioTurno = new ServicioTurnoImpl(repositorioTurno, repositorioUsuario);
    private final ControladorReservarTurno controladorReservarTurno = new ControladorReservarTurno(servicioTurno);

    private ModelAndView modelAndView;

    @Test
    public void reservarTurno() {
        givenUsuarioRegistrado(USUARIO);

        whenReservarTurno(fecha, getServicios(), 1500.0);

        thenElTurnoSeSeReservaConExito();
    }

    @Test
    public void servicioNoSeleccionado() {
        givenServiciosCargados();

        whenReservarTurno(fecha, Collections.emptyList(), 1500.0);

        thenFallaReservarTurno("Servicio no seleccionado");
    }

    private void givenServiciosCargados() {

    }

    private void givenUsuarioRegistrado(Usuario usuario) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setEmail(usuario.getEmail());
        datosRegistro.setPassword(usuario.getPassword());
        datosRegistro.setRepitePassword(usuario.getPassword());
        controladorRegistro.registrar(datosRegistro);
    }

    private void whenReservarTurno(Calendar fecha, List<Servicio> servicios, Double precio) {
        DatosTurno datosTurno = new DatosTurno(fecha, precio, servicios);
        modelAndView = controladorReservarTurno.reservar(datosTurno);
    }

    private void thenElTurnoSeSeReservaConExito() {
        assertThat(modelAndView.getModel().get("reservado")).isEqualTo(Boolean.TRUE);
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/reserva-exitosa");
    }

    private void thenFallaReservarTurno(String mensaje) {
        Assertions.assertThat(modelAndView.getModel().get("error")).isEqualTo(mensaje);
        Assertions.assertThat(modelAndView.getViewName()).isEqualTo("reserva-turno-peluqueria");
    }

    private List<Servicio> getServicios() {
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio("Corte de pelo", 300.0));
        servicios.add(new Servicio("Corte de uñas", 100.0));
        servicios.add(new Servicio("Baño", 250.0));
        return servicios;
    }

    private Usuario usuario(String email, String password) {
        return new Usuario(email, password);
    }
}
