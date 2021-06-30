package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.interfaces.RepositorioTurno;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.*;


public class RepositorioListadoTurnoTest extends SpringTest {

    @Autowired
    private RepositorioListadoTurno repositorioListadoTurno;
    @Autowired
    private RepositorioTurno repositorioTurno;

    @Test
    @Transactional
    @Rollback
    public void getListadoDeTurnos() {
        List<Turno> turnosReservados = givenTurnosReservados(new Date(), "10:00", getServicios(), 1500.0);

        List<Turno> turnosGuardados = whenGetListadoDeTurnos();

        thenTurnosReservados(turnosReservados, turnosGuardados);
    }

    private void thenTurnosReservados(List<Turno> turnosReservados, List<Turno> turnosGuardados) {
        assertThat(turnosGuardados).isNotNull();
        assertThat(turnosGuardados).hasSameSizeAs(turnosReservados);
    }

    private List<Turno> whenGetListadoDeTurnos() {
        return repositorioListadoTurno.getListadoDeTurnos();
    }

    private List<Turno> givenTurnosReservados(Date fecha, String hora, List<Servicio> servicios, Double precio) {
        DatosTurno datosTurno = new DatosTurno(fecha, precio, servicios);
        datosTurno.setHoraSeleccionada(hora);

        List<Turno> turnos = new ArrayList<>();
        turnos.add(new Turno(datosTurno));
        turnos.add(new Turno(datosTurno));
        turnos.add(new Turno(datosTurno));

        for (Turno turno : turnos) {
            repositorioTurno.reservar(turno);
        }

        return turnos;
    }

    private List<Servicio> getServicios() {
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio("Corte de pelo", 300.0));
        servicios.add(new Servicio("Corte de uñas", 100.0));
        servicios.add(new Servicio("Baño", 250.0));
        return servicios;
    }
}
