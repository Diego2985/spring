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

    private float precio;

    public Articulo(String tituloArticulo,String descripcion,float precio) {
        this.setTituloArticulo(tituloArticulo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
    }

    public Articulo() { };

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public float getPrecio() { return precio; }
    private void setPrecio(float precio) {
        this.precio=precio;
    }
    public String getDescripcion() { return descripcion; }
    private void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
    public String getTituloArticulo() { return tituloArticulo; }
    private void setTituloArticulo(String tituloArticulo) {
        this.tituloArticulo=tituloArticulo;
    }

}
