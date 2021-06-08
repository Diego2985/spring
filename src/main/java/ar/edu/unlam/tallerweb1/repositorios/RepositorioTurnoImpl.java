package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Turno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioTurno")
public class RepositorioTurnoImpl extends RepositorioUsuarioImpl implements RepositorioTurno {

    @Autowired
    public RepositorioTurnoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void reservar(Turno turno) {
        sessionFactory.getCurrentSession().save(turno);
    }
}
