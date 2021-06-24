package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioRegistrar")
public class RepositorioRegistrarImpl implements RepositorioRegistrar{


    private SessionFactory sessionfactory;

    @Autowired
    private RepositorioRegistrarImpl(SessionFactory sessionFactory){
        this.sessionfactory = sessionFactory;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        sessionfactory.getCurrentSession().save(usuario);

    }
    @Override
    public Usuario buscarloPor(Long id) {
        return sessionfactory.getCurrentSession().get(Usuario.class, id);
    }
}
