package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Articulo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioArticulo")
@Transactional
public class ServicioArticuloImpl implements ServicioArticulo {

    private final RepositorioArticulo repositorioArticulo;

    @Autowired
    public ServicioArticuloImpl(RepositorioArticulo repositorioArticulo) {
        this.repositorioArticulo = repositorioArticulo;
    }


    @Override
    public Articulo verArticulo(long id) throws Exception {
        if (repositorioArticulo.verArticulo(id) != null){
            return repositorioArticulo.verArticulo(id);
        }
        throw new Exception("Hubo un error al buscar los datos");
    }
}
