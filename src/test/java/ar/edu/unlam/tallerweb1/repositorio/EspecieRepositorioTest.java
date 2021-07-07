package ar.edu.unlam.tallerweb1.repositorio;


import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Especie;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioEspecie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.assertThat;

public class EspecieRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioEspecie repositorio;

    @Test
    @Transactional
    @Rollback
    public void guardarUnGatoDeberiaPersistirlo(){
        Especie especie = givenExisteEspecie();
        Long id = whenSeGuardoUnaEspecie(especie);
        thenLoPuedoBuscarPorId(id);

    }

    private Especie givenExisteEspecie() {
        Especie especie = new Especie();
        especie.setNombre("gato");
        //especie.setFechaNacimiento(new Date(2019, Calendar.MARCH, 20));
        //especie.setColor("negro");
        return especie;
    }

    private Long whenSeGuardoUnaEspecie(Especie especie) {
        repositorio.guardarEspecie(especie);
        return especie.getId();
    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Especie especieBuscado = repositorio.buscarPor(id);
        assertThat(especieBuscado).isNotNull();
    }
}
