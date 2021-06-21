package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.converter.EnumConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Embeddable
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private Double precio;
    private String hora;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Servicio> servicios;
    @Column(name = "estado_turno")
    @Convert(converter = EnumConverter.class)
    private TurnoEstado estado;

    @Transient
    private String serviciosSeleccionados = "";

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
        precio = 0.0;
        servicios.forEach(item -> {
            if (item != null) {
                precio += item.getPrecio();
            }
        });

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

    public String getHora() {
        return hora;
    }

    public String getServiciosSeleccionados() {
        servicios.forEach(item -> serviciosSeleccionados += item.getNombre() + ", ");
        return serviciosSeleccionados;
    }
}
