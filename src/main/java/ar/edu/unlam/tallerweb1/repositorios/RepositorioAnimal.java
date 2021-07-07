package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Animal;

public interface RepositorioAnimal {
    
    void guardarAnimal(Animal animal);

    Animal buscarPor(Long id);
}
