package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioRegistrar {

    void crearUsuario(Usuario usuario);

    Usuario buscarloPor(Long id);

}
