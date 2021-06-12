package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class DatosTurno {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;
    private Double precio;
    private List<Servicio> servicios;

    public DatosTurno(LocalDate fecha, Double precio, List<Servicio> servicios) {
        this.fecha = fecha;
        this.precio = precio;
        this.servicios = servicios;
    }

    public DatosTurno() {

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
