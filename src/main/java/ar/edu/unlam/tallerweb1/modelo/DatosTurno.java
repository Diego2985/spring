package ar.edu.unlam.tallerweb1.modelo;

import java.util.Calendar;
import java.util.List;

public class DatosTurno {

    private Calendar fecha;
    private Double precio;
    private List<Servicio> servicios;

    public DatosTurno(Calendar fecha, Double precio, List<Servicio> servicios) {
        this.fecha = fecha;
        this.precio = precio;
        this.servicios = servicios;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public List<Servicio> getCategorias() {
        return servicios;
    }
}
