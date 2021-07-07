package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Articulo;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ArticuloPersistenceTest extends SpringTest {

    @Test @Transactional @Rollback
    public void guardarUnArticulo(){
        Articulo articulo = givenExisteArticulo();
        Long id = whenGuardoArticulo(articulo);
        thenLoBuscoPorId(id);
    }
    private Articulo givenExisteArticulo() {
        Articulo articulo = new Articulo();
        articulo.setTituloArticulo("disfraz");
        articulo.setDescripcion("superman");
        articulo.setPrecio(1500.00);
        return articulo;
    }
    private Long whenGuardoArticulo(Articulo articulo) {
        session().save(articulo);
        return articulo.getId();
    }

    private void thenLoBuscoPorId(Long id) {
        Articulo articuloBuscado = session().get(Articulo.class, id);
        assertThat(articuloBuscado).isNotNull();
    }
    private List<Articulo> getArticulos(){
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo("disfraz", "superman", 1500.00));
        articulos.add(new Articulo("disfraz", "pirata", 1200.00));
        articulos.add(new Articulo("enterizo", "pijama", 2400.00));
        articulos.add(new Articulo("chaleco", "chaleco militar", 3000.00));
        return articulos;
    }
}
