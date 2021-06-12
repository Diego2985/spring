package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ControladorReservarTurnoTest extends SpringTest {

    @Autowired
    private ControladorReservarTurno controladorReservarTurno;
    @Autowired
    private ControladorRegistrarme controladorRegistrarme;

    private final Usuario USUARIO = usuario("juan@mail.com", "password2345");
    private final LocalDate fecha = LocalDate.now();
    private ModelAndView modelAndView;

    @Test
    @Transactional
    @Rollback
    public void reservarTurno() {
        givenUsuarioRegistrado(USUARIO);

        whenReservarTurno(fecha, getServicios(), 1500.0);

        thenElTurnoSeSeReservaConExito();
    }

    @Test
    public void servicioNoSeleccionado() {
        givenServiciosCargados();

        whenReservarTurno(fecha, null, 1500.0);

        thenFallaReservarTurno("Servicio no seleccionado");
    }

    @Test
    public void fechaNoSeleccionado() {
        givenServiciosCargados();

        whenReservarTurno(null, null, 1500.0);

        thenFallaReservarTurno("Fecha no seleccionada");
    }

    private void givenServiciosCargados() {

    }

    private void givenUsuarioRegistrado(Usuario usuario) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setEmail(usuario.getEmail());
        datosRegistro.setPassword(usuario.getPassword());
        datosRegistro.setRepitePassword(usuario.getPassword());
        controladorRegistrarme.registrar(datosRegistro);
    }

    private void whenReservarTurno(LocalDate fecha, List<Servicio> servicios, Double precio) {
        DatosTurno datosTurno = new DatosTurno(fecha, precio, servicios);
        modelAndView = controladorReservarTurno.reservar(datosTurno);
    }

    private void thenElTurnoSeSeReservaConExito() {
        assertThat(modelAndView.getModel().get("reservado")).isEqualTo(Boolean.TRUE);
        assertThat(modelAndView.getViewName()).isEqualTo("reserva-exitosa");
    }

    private void thenFallaReservarTurno(String mensaje) {
        Assertions.assertThat(modelAndView.getModel().get("error")).isEqualTo(mensaje);
        Assertions.assertThat(modelAndView.getViewName()).isEqualTo("reservar-turno");
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
