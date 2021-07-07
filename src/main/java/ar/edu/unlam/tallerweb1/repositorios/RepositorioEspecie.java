package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Especie;

public interface RepositorioEspecie {


    void guardarEspecie(Especie especie);

    Especie buscarPor(Long id);
}
