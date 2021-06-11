package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Vacuna;
import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVacunaImpl implements RepositorioVacuna{


    private SessionFactory sessionFactory;
    @Override
    public void guardar(Vacuna vacuna) {


    }
}
