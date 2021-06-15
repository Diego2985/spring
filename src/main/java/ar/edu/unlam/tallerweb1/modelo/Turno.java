package ar.edu.unlam.tallerweb1.modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha;
    private Double precio;
    private String hora;
    @OneToMany
    @JoinColumn(name = "fk_turno")
    private List<Servicio> servicios;
    @Enumerated(EnumType.STRING)
    private TurnoEstado estado;
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Usuario usuario;

    public Turno(Date fecha, Double precio, List<Servicio> servicios) {
        this.fecha = fecha;
        this.precio = precio;
        this.servicios = servicios;
    }

    public Turno() {}

    public Turno(DatosTurno datosTurno) {
        this.fecha = datosTurno.getFecha();
        this.hora = datosTurno.getHoraSeleccionada();
        this.estado = TurnoEstado.PENDIENTE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public TurnoEstado getEstado() {
        return estado;
    }

    public void setEstado(TurnoEstado estado) {
        this.estado = estado;
    }

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
}
