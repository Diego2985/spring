package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Cliente cliente;

    @Column(nullable = false) //no puede estar vacio edad, especie y nombre de la mascota
    private String edad;

    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private String nombreMascota;

    public void setEdad(String edad) { this.edad = edad;
    }

    public void setEspecie(String especie) { this.especie = especie;
    }

    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota;
    }

    public Long getId() {
        return id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setCliente(Cliente cliente) {
    }
}
