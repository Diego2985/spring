package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tituloArticulo;

    private String descripcion;

    private Double precio;

    public Articulo(String tituloArticulo,String descripcion,Double precio) {
        this.setTituloArticulo(tituloArticulo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
    }

    public Articulo() { }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) {
        this.precio=precio;
    }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
    public String getTituloArticulo() { return tituloArticulo; }
    public void setTituloArticulo(String tituloArticulo) {
        this.tituloArticulo=tituloArticulo;
    }

}
