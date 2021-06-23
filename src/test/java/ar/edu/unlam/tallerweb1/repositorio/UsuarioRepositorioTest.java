package ar.edu.unlam.tallerweb1.repositorio;

import ar.edu.unlam.tallerweb1.SpringTest;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioRepositorioTest extends SpringTest {

    @Autowired
    private RepositorioUsuario repositorio;

    @Test
    @Transactional
    @Rollback
    public void guardarUnUsuarioDeberiaPersistirlo(){
        Usuario usuario = givenExisteUsuario();
        Long id = whenSeGuardoUsuario(usuario);
        thenLoPuedoBuscarPorId(id);

    }

    private Usuario givenExisteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Maria");
        usuario.setEmail("maria@mail.com");
        return usuario;
    }

    private Long whenSeGuardoUsuario(Usuario usuario) {
        repositorio.guardar(usuario);
        return usuario.getId();
    }

    private void thenLoPuedoBuscarPorId(Long id) {
        Usuario usuarioBuscado = repositorio.buscarPor(id);
        assertThat(usuarioBuscado).isNotNull();
    }
}
