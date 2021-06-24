package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Gato;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioGato")
public class RepositorioGatoImpl implements RepositorioGato{


    private SessionFactory sessionFactory;

    @Autowired
    private RepositorioGatoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarGato(Gato gato) {
        sessionFactory.getCurrentSession().save(gato);

    }

    @Override
    public Gato buscarPor(Long id) {
        return sessionFactory.getCurrentSession().get(Gato.class, id);
    }


}
