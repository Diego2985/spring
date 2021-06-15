package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.excepciones.FechaNoSeleccionada;
import ar.edu.unlam.tallerweb1.excepciones.HoraNoSeleccionada;
import ar.edu.unlam.tallerweb1.excepciones.ServicioNoSeleccionado;
import ar.edu.unlam.tallerweb1.excepciones.TurnoExistente;
import ar.edu.unlam.tallerweb1.interfaces.ServicioTurno;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.interfaces.RepositorioTurno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
@EnableTransactionManagement
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

        if (datosTurno.getHoraSeleccionada().isEmpty()) {
            throw new HoraNoSeleccionada();
        }

        if (datosTurno.getServiciosSeleccionados() == null) {
            throw new ServicioNoSeleccionado();
        }

        Turno turnoExistente = repositorioTurno.consultarTurno(
                datosTurno.getFecha().toString(),
                datosTurno.getHoraSeleccionada()
        );

        if (turnoExistente != null) {
            throw new TurnoExistente();
        }

        Turno turno = new Turno(datosTurno);
        turno.setServicios(getServiciosSeleccionados(datosTurno.getServiciosSeleccionados()));
        repositorioTurno.reservar(turno);

        return turno;
    }

    @Override
    public List<Servicio> getServicios() {
        return repositorioTurno.getServicios();
    }

    @Override
    public List<String> getHorasDisponibles() {
        return repositorioTurno.getHorasDisponibles();
    }

    @Override
    public String getFechaDesde() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, 1);

        return dateFormat.format(calendar.getTime());
    }

    @Override
    public String getFechaHasta() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, 15);

        return dateFormat.format(calendar.getTime());
    }

    public List<Servicio> getServiciosSeleccionados(List<String> serviciosSeleccionados) {
        List<Servicio> servicios = new ArrayList<>();

        for (String idsServicio : serviciosSeleccionados) {
            Optional<Servicio> itemBuscado = repositorioTurno.findServicioById(idsServicio);
            itemBuscado.ifPresent(servicios::add);
        }

        return servicios;
    }
}
