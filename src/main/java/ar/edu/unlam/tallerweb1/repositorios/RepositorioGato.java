package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Gato;

public interface RepositorioGato {


    void guardarGato(Gato gato);

    Gato buscarPor(Long id);
}
