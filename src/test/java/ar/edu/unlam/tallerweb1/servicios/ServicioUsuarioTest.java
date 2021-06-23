package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarios;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ServicioUsuarioTest {
    private static final String MAIL = "direccion@mail.com";
    private static final String CLAVE = "23456";
    private final ServicioUsuarioDefault servicio = new ServicioUsuarioDefault();
    private Usuario usuarioRegistrado;

    @Before
    public void init() {
        RepositorioUsuarios.getInstance().reset();
    }
    @Test
    public void siLasClavesCoincidenYUsuarioEsNuevoSeDebeRegistrar(){
         givenUsuarioNoExiste();
         whenRegistroUsuario(MAIL, CLAVE, CLAVE);
         thenRegistroExitoso();
    }

    private void thenRegistroExitoso() {

        assertThat(usuarioRegistrado).isNotNull();
    }

    @Test(expected = ClavesNoCoinciden.class)
    public void registroFallasSiLasClavesNoCoinciden(){
        givenUsuarioNoExiste();
        whenRegistroUsuario(MAIL, CLAVE, CLAVE+"1");
        thenRegistroError();
    }

    private void givenUsuarioNoExiste() {
    }

    private void whenRegistroUsuario(String email, String password, String s) {
        DatosRegistro datos = new DatosRegistro();
        datos.setEmail(email);
        datos.setPassword(password);
        datos.setRepitePassword(password);
        servicio.registrar(datos);

    }

    @Test(expected = UsuarioExistente.class)
    public void registroFallaSiUsuarioYaExiste(){
        givenUsuarioExiste(MAIL, CLAVE);
        whenRegistroUsuario(MAIL, CLAVE, CLAVE);
        thenRegistroError();
    }
    public void givenUsuarioExiste(String email, String password){
        DatosRegistro datos = new DatosRegistro();
        datos.setEmail(email);
        datos.setPassword(password);
        datos.setRepitePassword(password);
        servicio.registrar(datos);
    }

    private void thenRegistroError() {
        assertThat(usuarioRegistrado).isNotNull();
    }

}
