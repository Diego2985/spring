package ar.edu.unlam.tallerweb1.interfaces;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface RepositorioTurno {

    Serializable reservar(Turno turno);

    List<Servicio> getServicios();

    List<String> getHorasDisponibles();

    Optional<Servicio> findServicioById(String idsServicio);

    Turno consultarTurno(String fecha, String hora);
}
