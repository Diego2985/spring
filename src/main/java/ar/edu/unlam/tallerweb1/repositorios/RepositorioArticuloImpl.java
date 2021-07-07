package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Articulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioArticulo")
public class RepositorioArticuloImpl implements  RepositorioArticulo{

    private SessionFactory sessionFactory;
    private List<Articulo> articulos;

    @Autowired
    private RepositorioArticuloImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Articulo verArticulo(Long id) {
       return sessionFactory.getCurrentSession().get(Articulo.class, id);
        // final Session session = this.sessionFactory.getCurrentSession();
       // Articulo articulo = session.get(Articulo.class, id);
       // return articulo;
    }

    @Override
    public void guardarArticulo(Articulo articulo) {
        sessionFactory.getCurrentSession().save(articulo);
    }

    @Override
    public List<Articulo> getArticulos() {
        articulos = sessionFactory.getCurrentSession().createCriteria(Articulo.class).list();
        return articulos;
    }
}
