package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Articulo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("repositorioArticulo")
public class RepositorioArticuloImpl implements  RepositorioArticulo{

    private SessionFactory sessionFactory;

    @Override
    public Articulo verArticulo(Long id) {
        final Session session = this.sessionFactory.getCurrentSession();
        Articulo articulo = session.get(Articulo.class, id);
        return articulo;
    }
}
