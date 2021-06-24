package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.Properties;

public class RegistrarmePersistenceTest extends SpringTest {

    @Test @Transactional @Rollback
    public void poderRegistrarUnUsuario(){
        Usuario usuario = givenNoRegitrado();
        Long id = whenSeRegistraUsuario(usuario);
        thenElUsuarioSeARegistrado(id);
    }

    private Usuario givenNoRegitrado() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Leandro Rodriguez");
        usuario.setEmail("leandro@mail.com");
        usuario.setPassword("2378");
        usuario.setDireccion("Mariano Acosta 3789");
        usuario.setTelefono("1134562798");
        return usuario;
    }

    private Long whenSeRegistraUsuario(Usuario usuario) {
        session().save(usuario);
        return usuario.getId();


    }

    private void thenElUsuarioSeARegistrado(Long id) {
        Usuario registrado = session().get(Usuario.class, id);
        assertThat(registrado).isNotNull();
    }
}
