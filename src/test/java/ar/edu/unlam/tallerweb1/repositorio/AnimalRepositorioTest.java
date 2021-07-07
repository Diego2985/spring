package ar.edu.unlam.tallerweb1.repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Animal;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAnimal;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioAnimal repositorio;

    @Test @Transactional @Rollback
    public void guardarUnAnimalDeberiaPersitir(){
        Animal animal = givenExiteAnimal();
        Long id = whenGuardoUnAnimal(animal);
        thenQueSePuedaBuscarPorId(id);
    }

    private Animal givenExiteAnimal() {
        Animal animal = new Animal();
        animal.setMascota("Tom");
        animal.setFechaNacimiento(new Date(2019, Calendar.MARCH,20 ));
        animal.setColor("gris");
        return animal;
    }

    private Long whenGuardoUnAnimal(Animal animal) {
        repositorio.guardarAnimal(animal);
        return animal.getId();
    }

    private void thenQueSePuedaBuscarPorId(Long id) {
        Animal animalBuscado = repositorio.buscarPor(id);
        assertThat(animalBuscado).isNotNull();
    }
}
