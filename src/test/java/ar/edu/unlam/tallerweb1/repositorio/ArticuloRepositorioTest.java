package ar.edu.unlam.tallerweb1.repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Articulo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArticulo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

public class ArticuloRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioArticulo repositorio;

    @Test @Transactional
    @Rollback
    public void guardarUnArticuloDebePersistirlo(){
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
        repositorio.guardarArticulo(articulo);
        return articulo.getId();
    }

    private void thenLoBuscoPorId(Long id) {
        Articulo verArticulo = repositorio.verArticulo(id);
        assertThat(verArticulo).isNotNull();
    }
}
