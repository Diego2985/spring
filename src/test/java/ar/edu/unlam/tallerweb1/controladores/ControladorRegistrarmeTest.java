package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioDefault;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;



public class ControladorRegistrarmeTest {
    private final Usuario USUARIO = usuario("juan@mail.com", "password2345");

    private Usuario usuario(String s, String password2345) {
        Usuario usuario = new Usuario();
        usuario.setEmail(s);
        usuario.setPassword(password2345);
        return usuario;
    }

    private ModelAndView mav;
    ControladorRegistrarme controladorRegistro = new ControladorRegistrarme(new ServicioUsuarioDefault());

    @Test
    public void siNoExisteElUsuarioDebeRegistrarse(){
        givenUsuarioNoRegistrado(USUARIO);

        whenRegistroElUsuario(USUARIO.getEmail(), USUARIO.getPassword(),USUARIO.getPassword()+ "3564278" );

        thenElUsuarioSeRegistroConExito();
    }

    private void givenUsuarioNoRegistrado(Usuario usuario) {

    }

    private void whenRegistroElUsuario(String email, String password, String repitePassword) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setEmail(email);
        datosRegistro.setPassword(password);
        datosRegistro.setRepitePassword(repitePassword);
        mav = controladorRegistro.registrar(datosRegistro);
    }

    private void thenElUsuarioSeRegistroConExito() {
        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getViewName()).isEqualTo("registro");
    }
    @Test
    public void siYaExisteElUsuarioNoDebeRegistrarse(){
        givenUsuarioRegistrado(USUARIO);

        whenRegistroElUsuario(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword());

        thenRegistraFallaPor("usuario ya existente");

    }

    private void givenUsuarioRegistrado(Usuario usuario) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setEmail(usuario.getEmail());
        datosRegistro.setPassword(usuario.getPassword());
        datosRegistro.setRepitePassword(usuario.getPassword());
        controladorRegistro.registrar(datosRegistro);

    }

    private void thenRegistraFallaPor(String usuario_ya_existente) {
        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getModel().get("error")).isEqualTo(usuario_ya_existente);
        assertThat(mav.getViewName()).isEqualTo("registro");

    }


}
