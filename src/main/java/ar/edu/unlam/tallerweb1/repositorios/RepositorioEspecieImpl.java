package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Especie;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioGato")
public class RepositorioEspecieImpl implements RepositorioEspecie {


    private SessionFactory sessionFactory;

    @Autowired
    private RepositorioEspecieImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarEspecie(Especie especie) {
        sessionFactory.getCurrentSession().save(especie);

    }

    @Override
    public Especie buscarPor(Long id) {
        return sessionFactory.getCurrentSession().get(Especie.class, id);
    }


}
