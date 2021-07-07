package ar.edu.unlam.tallerweb1.persistencia;


import ar.edu.unlam.tallerweb1.SpringTest;


import ar.edu.unlam.tallerweb1.modelo.Especie;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;



import static org.assertj.core.api.Assertions.*;

public class EspeciePersistenceTest extends SpringTest {

    @Test @Transactional @Rollback
    public void quePuedaGuardarUnaEspecie(){
        Especie especie = givenExisteEspecie();
        Long id = whenSeGuardoUnaEspecie(especie);
        thenLoPuedoBuscarPorId(id);
    }

    private Especie givenExisteEspecie(){
        Especie especie = new Especie();
        especie.setNombre("gato");
        //especie.setFechaNacimiento(new Date(2019, Calendar.MARCH, 20));
        //especie.setColor("negro");
        return especie;
    }

    private Long whenSeGuardoUnaEspecie(Especie especie){
        session().save(especie);
        return especie.getId();
    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Especie especieBuscado = session().get(Especie.class, id);
        assertThat(especieBuscado).isNotNull();
    }
}
