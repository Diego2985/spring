package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Animal;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

import java.util.List;

public interface RepositorioAnimal {

    void guardar(Animal animal);

    Animal buscarPor(Long id);

    Animal buscarPorNombre(String nombreMascota);

    List<Animal> buscarPor(Cliente cliente);
}
