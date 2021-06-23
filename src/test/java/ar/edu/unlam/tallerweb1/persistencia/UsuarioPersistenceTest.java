package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;


import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioPersistenceTest extends SpringTest {

    @Test
    @Transactional
    @Rollback
    public void guardarUnUsuario(){
        Usuario usuario = givenExisteUsuario();
        Long id = whenSeGuardoUsuario(usuario);
        thenLoPuedoBuscarPorId(id);

    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Usuario usuarioBuscado = session().get(Usuario.class, id);
        assertThat(usuarioBuscado).isNotNull();

    }

    private Long whenSeGuardoUsuario(Usuario usuario) {
        session().save(usuario);
        return usuario.getId();
    }

    private Usuario givenExisteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Maria");
        usuario.setEmail("maria@mail.com");
        return usuario;
    }
}
