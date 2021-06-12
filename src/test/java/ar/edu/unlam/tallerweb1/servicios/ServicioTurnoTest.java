package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.excepciones.FechaNoSeleccionada;
import ar.edu.unlam.tallerweb1.excepciones.ServicioNoSeleccionado;
import ar.edu.unlam.tallerweb1.interfaces.ServicioTurno;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ServicioTurnoTest extends SpringTest {

    @Autowired
    private ServicioTurno servicioTurno;

    private final LocalDate fecha = LocalDate.now();
    private DatosTurno datosTurno;
    private Turno turnoRegistrado;

    @Test
    @Transactional
    @Rollback
    public void reservarTurno() {
        givenDatosTurno(fecha, getServicios(), 1500.0);

        whenReservarTurno();

        thenElturnoSeReservaConExito();
    }

    @Test(expected = FechaNoSeleccionada.class)
    public void reservarTurnoFallaPorFechaNoSeleccionado() {
        givenDatosTurno(null, getServicios(), 1500.0);

        whenReservarTurno();

        thenLaReservaFalla();
    }

    @Test(expected = ServicioNoSeleccionado.class)
    public void reservarTurnoFallaPorServicioNoSeleccionado() {
        givenDatosTurno(fecha, null, 1500.0);

        whenReservarTurno();

        thenLaReservaFalla();
    }

    private void thenLaReservaFalla() {}

    private void givenDatosTurno(LocalDate fecha, List<Servicio> servicios, Double precio) {
        datosTurno = new DatosTurno(fecha, precio, servicios);
    }

    private void whenReservarTurno() {
        turnoRegistrado = servicioTurno.reservar(datosTurno);
    }

    private void thenElturnoSeReservaConExito() {
        assertThat(turnoRegistrado).isNotNull();
    }

    private List<Servicio> getServicios() {
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio("Corte de pelo", 300.0));
        servicios.add(new Servicio("Corte de uñas", 100.0));
        servicios.add(new Servicio("Baño", 250.0));
        return servicios;
    }
}
