package ar.edu.unlam.tallerweb1.persistencia;


import ar.edu.unlam.tallerweb1.SpringTest;


import ar.edu.unlam.tallerweb1.modelo.Gato;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

public class GatoPersistenceTest extends SpringTest {

    @Test @Transactional @Rollback
    public void quePuedaGuardarUnGato(){
        Gato gato = givenExisteGato();
        Long id = whenSeGuardoAlGato(gato);
        thenLoPuedoBuscarPorId(id);
    }

    private Gato givenExisteGato(){
        Gato gato = new Gato();
        gato.setNombre("Silvestre");
        gato.setFechaNacimiento(new Date(2019, Calendar.MARCH, 20));
        gato.setColor("negro");
        return gato;
    }

    private Long whenSeGuardoAlGato(Gato gato){
        session().save(gato);
        return gato.getId();
    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Gato gatoBuscado = session().get(Gato.class, id);
        assertThat(gatoBuscado).isNotNull();
    }
}
