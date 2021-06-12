package ar.edu.unlam.tallerweb1.interfaces;

import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.Turno;

import java.util.List;

public interface ServicioTurno {
    Turno reservar(DatosTurno datosTurno);

    List<Servicio> getServicios();
}
