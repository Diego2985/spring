package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Animal;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;


import java.util.Calendar;
import java.util.Date;

public class AnimalPersitenceTest extends SpringTest {
    
    @Test @Transactional @Rollback
    public void guardarUnAnimal(){
        Animal animal = givenExiteAnimal();
        Long id = whenGuardoUnAnimal(animal);
        thenLoBuscoPorId(id);
    }

    private Animal givenExiteAnimal() {
        Animal animal = new Animal();
        animal.setMascota("Tom");
        animal.setFechaNacimiento(new Date(2019, Calendar.MARCH, 20));
        animal.setColor("gris");
        return animal;
    }

    private Long whenGuardoUnAnimal(Animal animal) {
        session().save(animal);
        return animal.getId();
    }

    private void thenLoBuscoPorId(Long id) {
        Animal animalBuscado = session().get(Animal.class, id);
        assertThat(animalBuscado).isNotNull();
    }


}
