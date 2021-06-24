package ar.edu.unlam.tallerweb1.repositorio;


import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Gato;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioGato;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class GatoRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioGato repositorio;

    @Test
    @Transactional
    @Rollback
    public void guardarUnGatoDeberiaPersistirlo(){
        Gato gato = givenExisteGato();
        Long id = whenSeGuardoGato(gato);
        thenLoPuedoBuscarPorId(id);

    }

    private Gato givenExisteGato() {
        Gato gato = new Gato();
        gato.setNombre("Silvestre");
        gato.setFechaNacimiento(new Date(2019, Calendar.MARCH, 20));
        gato.setColor("negro");
        return gato;
    }

    private Long whenSeGuardoGato(Gato gato) {
        repositorio.guardarGato(gato);
        return gato.getId();
    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Gato gatoBuscado = repositorio.buscarPor(id);
        assertThat(gatoBuscado).isNotNull();
    }
}
