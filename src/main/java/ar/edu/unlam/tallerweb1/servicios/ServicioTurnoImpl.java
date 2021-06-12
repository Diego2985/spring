package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.FechaNoSeleccionada;
import ar.edu.unlam.tallerweb1.excepciones.ServicioNoSeleccionado;
import ar.edu.unlam.tallerweb1.interfaces.ServicioTurno;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.interfaces.RepositorioTurno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicioTurnoImpl implements ServicioTurno {

    private RepositorioTurno repositorioTurno;
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioTurnoImpl(RepositorioTurno repositorioTurno, RepositorioUsuario repositorioUsuario) {
        this.repositorioTurno = repositorioTurno;
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Turno reservar(DatosTurno datosTurno) {
        if (datosTurno.getFecha() == null) {
            throw new FechaNoSeleccionada();
        }

        if (datosTurno.getServicios() == null) {
            throw new ServicioNoSeleccionado();
        }

        Turno turno = new Turno(datosTurno);
        repositorioTurno.reservar(turno);

        return turno;
    }

    @Override
    public List<Servicio> getServicios() {
        return repositorioTurno.getServicios();
    }
}
