package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioDefault;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;



public class ControladorRegistrarmeTest {
    private final Usuario USUARIO = usuario("Lucas Perez", "lucas@mail.com", "1345", "Brown 2317", "4481-7032");

    private Usuario usuario(String nombre,String email, String password, String direccion, String telefono) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setDireccion(direccion);
        usuario.setTelefono(telefono);
        return usuario;
    }

    private ModelAndView mav;
    ControladorRegistrarme controladorRegistro = new ControladorRegistrarme(new ServicioUsuarioDefault());

    @Test
    public void siNoExisteElUsuarioDebeRegistrarse(){
        givenUsuarioNoRegistrado(USUARIO);

        whenRegistroElUsuario(USUARIO.getNombre(), USUARIO.getEmail(), USUARIO.getPassword(),USUARIO.getPassword()+ "3564278", USUARIO.getDireccion(), USUARIO.getTelefono());

        thenElUsuarioSeRegistroConExito();
    }

    private void givenUsuarioNoRegistrado(Usuario usuario) {

    }

    private void whenRegistroElUsuario(String nombre, String email, String password, String repitePassword, String direccion, String telefono) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setNombre(nombre);
        datosRegistro.setEmail(email);
        datosRegistro.setPassword(password);
        datosRegistro.setRepitePassword(repitePassword);
        datosRegistro.setDireccion(direccion);
        datosRegistro.setTelefono(telefono);
        mav = controladorRegistro.registrar(datosRegistro);
    }

    private void thenElUsuarioSeRegistroConExito() {
        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getViewName()).isEqualTo("login");
    }
    @Test
    public void siYaExisteElUsuarioNoDebeRegistrarse(){
        givenUsuarioRegistrado(USUARIO);

        whenRegistroElUsuario(USUARIO.getNombre(), USUARIO.getEmail(), USUARIO.getPassword(),USUARIO.getPassword()+ "3564278", USUARIO.getDireccion(), USUARIO.getTelefono());

        thenRegistraFallaPor("usuario ya existente");

    }


    private void givenUsuarioRegistrado(Usuario usuario) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setEmail(usuario.getEmail());
        datosRegistro.setPassword(usuario.getPassword());
        datosRegistro.setRepitePassword(usuario.getPassword());
        controladorRegistro.registrar(datosRegistro);

    }

    private void thenRegistraFallaPor(String usuario_Ya_Existente) {
        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getModel().get("error")).isEqualTo(usuario_Ya_Existente);
        assertThat(mav.getViewName()).isEqualTo("registro");

    }



}
