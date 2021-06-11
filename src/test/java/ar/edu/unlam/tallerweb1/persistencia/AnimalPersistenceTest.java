package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Animal;

import org.junit.Test;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class AnimalPersistenceTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void QueSePuedaGuardarUnAnimal(){
        Animal animal = givenExisteAnimal(); //preparacion
        Long id = whenGuardoAnimal(animal); //ejecucion
        thenLoPuedoBuscarPorId(id);        //Constatacion

    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Animal animalBuscado = session().get(Animal.class, id);
        assertThat(animalBuscado).isNotNull();
    }

    private Long whenGuardoAnimal(Animal animal) {
        session().save(animal); //save lo que hace es intentar guardar el animal en la sesion, para que luego eso guardado se comunique con la base de datos  y nos retorna el id del animal.
        return animal.getId();
    }

    private Animal givenExisteAnimal() {
        Animal animal = new Animal();
        animal.setEdad("2 anios"); // fecha
        animal.setEspecie("gato");// relacion
        animal.setNombreMascota("Silvestre");

        return animal;
    }
}
