package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Animal;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepositorioAnimal")
public class RepositorioAnimalImpl implements RepositorioAnimal {


    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAnimalImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void guardar(Animal animal) {
        sessionFactory.getCurrentSession().save(animal);
    }
    @Override
    public Animal buscarPor(Long id) {
        return sessionFactory.getCurrentSession().get(Animal.class, id);
    }



    @Override
    public Animal buscarPorNombre(String nombreMascota) {

       return (Animal) sessionFactory.getCurrentSession().createCriteria(Animal.class)
        .add(Restrictions.eq("nombreMascota", nombreMascota ))
        .uniqueResult();// el select*  from <table>

    }
    @Override
    public List<Animal> buscarPor(Cliente cliente) {
        return null;
    }
}
