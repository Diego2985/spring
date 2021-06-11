package ar.edu.unlam.tallerweb1.repositorio;

import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Animal;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAnimal;


import org.junit.Test;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

public class AnimalRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioAnimal repositorio;

    @Test @Transactional @Rollback
    public void guardarUnAnimalDeberiaPersistir(){
        Animal animal = givenExisteAnimal();
        Long id = whenGuardoAnimal(animal);
        thenLoPuedoBuscarPorId(id);
    }
    private Animal givenExisteAnimal() {
        Animal animal = new Animal();
        animal.setEdad("2 anios");
        animal.setEspecie("gato");
        animal.setNombreMascota("Silvestre");
        return animal;
    }
    private Long whenGuardoAnimal(Animal animal) {

        repositorio.guardar(animal);
        return animal.getId();
    }
    private void thenLoPuedoBuscarPorId(Long id) {
        Animal animalBuscado = repositorio.buscarPor(id);
        assertThat(animalBuscado).isNotNull();
    }

    @Test @Transactional @Rollback
    public void poderBuscarAnimalPorSuNombre(){
        Animal animal1 = givenExisteAnimal("Silvestre");
        Animal animal2 = givenExisteAnimal("Chatran");
        //Long id = whenGuardoAnimal(animal);
        Animal animalBuscado = whenLoPuedoBuscarPorNombre(animal1.getNombreMascota());
        thenLoPuedoBuscarPorNombre(animalBuscado);
    }

    private Animal givenExisteAnimal(String nombreMascota) {
        Animal animal = new Animal();
        animal.setEdad("2 anios");
        animal.setEspecie("gato");
        animal.setNombreMascota("Silvestre");
        session().save(animal);
        return animal;
    }
    private Animal whenLoPuedoBuscarPorNombre(String nombreMascota) {
        return repositorio.buscarPorNombre(nombreMascota);
    }
    private void thenLoPuedoBuscarPorNombre(Animal animalBuscado) {
        assertThat(animalBuscado).isNotNull();
        assertThat(animalBuscado.getNombreMascota()).isEqualTo("Silvestre");
    }

  //   @Test
  //  @Transactional //sirve para usar todas las operaciones que tengas y lo que hace es meterla en la transiccion del Hibernate
  //   @Rollback
  //   public void buscarAnimalesQueEstanPorLaVacunaContraLaLeucemia(){
  //    Cliente Maria = givenCliente("Maria");

  //   givenAnimalDelCliente(Maria);

  //   List<Animal> animal = whenBuscoLosAnimalesDe(Maria);

  //   thenEncuentro(animal, 1);
  //  }

   //  private void thenEncuentro(List<Animal> animal, Integer cantidadEsperada) {
   //     assertThat(animal).hasSize(cantidadEsperada);
   //  }

   //  public List<Animal> whenBuscoLosAnimalesDe(Cliente cliente) {
   //    return repositorio.buscarPor(cliente);
   // }

    // private void givenAnimalDelCliente(Cliente cliente) {
    //   Animal animal = new Animal();
    //   animal.setCliente(cliente);
    //   animal.setEdad("2 anios");
    //   animal.setEspecie("gato");
    //   animal.setNombreMascota("Silvestre");
    //   animal.setNombreMascota(animal.getNombreMascota());//
    //    session().save(animal);
    //}

    //  private Cliente givenCliente(String nombre) {
    //      Cliente cliente = new Cliente();
    //      cliente.setNombre(nombre);
    //      return cliente;
    //}


}
