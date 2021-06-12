package ar.edu.unlam.tallerweb1.interfaces;

import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;

import java.io.Serializable;
import java.util.List;

public interface RepositorioTurno {

    Serializable reservar(Turno turno);

    List<Servicio> getServicios();
}
