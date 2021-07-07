package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Animal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("RepositorioAnimal")
public class RepositorioAnimalImpl implements RepositorioAnimal{

    private SessionFactory sessionFactory;

    @Autowired
    private RepositorioAnimalImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardarAnimal(Animal animal) {
        sessionFactory.getCurrentSession().save(animal);
    }

    @Override
    public Animal buscarPor(Long id) {
        return sessionFactory.getCurrentSession().get(Animal.class, id);
    }
}
