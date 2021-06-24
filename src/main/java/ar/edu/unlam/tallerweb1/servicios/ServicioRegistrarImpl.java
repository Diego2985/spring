package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistrar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioRegistrar")
@Transactional
public class ServicioRegistrarImpl implements ServicioRegistrar{

    private RepositorioRegistrar repositorioRegistrar;

    @Override
    public void crearUsuario(Usuario usuario){
        repositorioRegistrar.crearUsuario(usuario);
    }
    @Override
    public Usuario buscarloPor(Long id){
        return repositorioRegistrar.buscarloPor(id);
    }

}
