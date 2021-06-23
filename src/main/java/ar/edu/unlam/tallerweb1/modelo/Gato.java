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


    public void setNombre(String silvestre) {
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
    }

    public void setColor(String negro) {
    }

    public Long getId() {
        return this.id;
    }
}
