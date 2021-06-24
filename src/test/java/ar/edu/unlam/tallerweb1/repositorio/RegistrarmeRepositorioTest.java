package ar.edu.unlam.tallerweb1.repositorio;

import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegistrar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class RegistrarmeRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioRegistrar repositorio;


    @Test @Transactional @Rollback
    public void registrarUnUsuarioYQuePersista(){
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
        repositorio.crearUsuario(usuario);
        return usuario.getId();
    }

    private void thenElUsuarioSeARegistrado(Long id) {
        Usuario usuarioEncontrado = repositorio.buscarloPor(id);
        assertThat(usuarioEncontrado).isNotNull();
    }
}
