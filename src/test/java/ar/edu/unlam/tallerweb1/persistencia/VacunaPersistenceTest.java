package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Vacuna;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioVacuna;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

public class VacunaPersistenceTest  extends SpringTest {

    @Autowired
    private RepositorioVacuna repositorio;

    @Test
    @Transactional
    @Rollback
    public void QueSePuedaGuardarVacuna() {
        Vacuna vacuna = givenExisteVacuna(); //preparacion
        Long id = whenGuardoVacuna(vacuna); //ejecucion
        thenLoPuedoBuscarPorId(id);        //Constatacion

    }
    private Vacuna givenExisteVacuna() {
       Vacuna vacuna = new Vacuna();
       vacuna.setNombre("Rabia");
       return vacuna;

    }
    private Long whenGuardoVacuna(Vacuna vacuna) {
        repositorio.guardar(vacuna);
        return vacuna.getId();
    }
    private void thenLoPuedoBuscarPorId(Long id) {
        Vacuna vacunaBuscada = session().get(Vacuna.class, id);
        assertThat(vacunaBuscada).isNotNull();
    }

}
