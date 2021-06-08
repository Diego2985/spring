package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar fecha;
    private Double precio;
    @OneToMany
    @JoinColumn(name = "fk_turno")
    private List<Servicio> servicios;
    private TurnoEstado estado;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Turno(Calendar fecha, Double precio, List<Servicio> servicios) {
        this.fecha = fecha;
        this.precio = precio;
        this.servicios = servicios;
    }

    public Turno() {}

    public Turno(DatosTurno datosTurno) {
        this.fecha = datosTurno.getFecha();
        this.precio = datosTurno.getPrecio();
        this.servicios = datosTurno.getCategorias();
        this.estado = TurnoEstado.PENDIENTE;
    }
}
