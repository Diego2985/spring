package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarios;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ServicioUsuarioTest {
    private static final String NOMBRE = "nombre";
    private static final String MAIL = "direccion@mail.com";
    private static final String CLAVE = "23456";
    private static final String DIRECCION = "calle numero";
    private static final String TELEFONO = "1140778968";
    private final ServicioUsuarioDefault servicio = new ServicioUsuarioDefault();
    private Usuario usuarioRegistrado;

    @Before
    public void init() {
        RepositorioUsuarios.getInstance().reset();
    }
    @Test
    public void siLasClavesNoCoincidenYUsuarioEsNuevoSeDebeRegistrar(){
         givenUsuarioNoExiste();
         whenRegistroUsuario(NOMBRE,MAIL, CLAVE, CLAVE+"1", DIRECCION, TELEFONO);
         thenRegistroExitoso();
    }

    private void givenUsuarioNoExiste() {
        DatosRegistro datos = new DatosRegistro();
    }

    private void whenRegistroUsuario(String nombre, String email, String password, String repitePassword, String direccion, String telefono){
      DatosRegistro datos = new DatosRegistro();
      datos.setNombre(nombre);
      datos.setEmail(email);
      datos.setPassword(password);
      datos.setRepitePassword(repitePassword);
      datos.setDireccion(direccion);
      datos.setTelefono(telefono);
      servicio.registrar(datos);

     }
    private void thenRegistroExitoso() {
        assertThat(usuarioRegistrado).isNull();
    }

   // @Test(expected = ClavesNoCoinciden.class)
   // public void registroFallasSiLasClavesNoCoinciden(){
     //   givenUsuarioNoExiste();
     //   whenRegistroUsuario(NOMBRE, MAIL, CLAVE, CLAVE+"1", DIRECCION, TELEFONO);
     //   thenRegistroError();
   // }

    //private void givenUsuarioNoExiste() {
   // }

    //private void whenRegistroUsuario(String nombre, String email, String password, String repitePassword, String direccion, String telefono){
      //  DatosRegistro datos = new DatosRegistro();
      //  datos.setNombre(nombre);
      //  datos.setEmail(email);
      //  datos.setPassword(password);
      //  datos.setRepitePassword(repitePassword);
      //  datos.setDireccion(direccion);
      //  datos.setTelefono(telefono);
      //  servicio.registrar(datos);

   // }

    @Test(expected = UsuarioExistente.class)
    public void registroFallaSiUsuarioYaExiste(){
        givenUsuarioExiste(MAIL, CLAVE);
        whenRegistroUsuario(MAIL, CLAVE);
        thenRegistroError();
    }

    private void whenRegistroUsuario(String email, String password) {
        DatosRegistro datos = new DatosRegistro();
         datos.setEmail(email);
         datos.setPassword(password);
         servicio.registrar(datos);
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
