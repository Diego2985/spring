package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.ServicioNoSeleccionado;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTurno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioTurnoImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("servicioTurnos")
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
    public void reservar(DatosTurno datosTurno) {
        if (datosTurno.getCategorias().isEmpty()) {
            throw new ServicioNoSeleccionado();
        }

//        Usuario usuario = repositorioUsuario.consultarUsuario();
        Turno turno = new Turno(datosTurno);
        repositorioTurno.reservar(turno);
    }
}
