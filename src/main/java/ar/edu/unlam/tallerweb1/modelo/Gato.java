package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String color;

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public Date getFechaNacimiento() {return fechaNacimiento;}

    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public String getColor(){return this.color;}

    public void setColor(String color) {this.color = color;}

    public Long getId() {
        return this.id;
    }
}
