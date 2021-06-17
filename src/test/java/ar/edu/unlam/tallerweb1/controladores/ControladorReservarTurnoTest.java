package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Servicio;
import ar.edu.unlam.tallerweb1.modelo.DatosTurno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ControladorReservarTurnoTest extends SpringTest {

    @Autowired
    private ControladorReservarTurno controladorReservarTurno;
    @Autowired
    private ControladorRegistrarme controladorRegistrarme;

    private final Usuario USUARIO = usuario("juan@mail.com", "password2345");
    private final Date fecha = new Date();
    private ModelAndView modelAndView;

    @Test
    @Transactional
    @Rollback
    public void reservarTurno() {
        givenUsuarioRegistrado(USUARIO);

        whenReservarTurno(fecha, getServicios(), 1500.0);

        thenElTurnoSeSeReservaConExito();
    }

    @Test
    public void servicioNoSeleccionado() {
        givenServiciosCargados();

        whenReservarTurno(fecha, null, 1500.0);

        thenFallaReservarTurno("Servicio no seleccionado");
    }

    @Test
    public void fechaNoSeleccionado() {
        givenServiciosCargados();

        whenReservarTurno(null, null, 1500.0);

        thenFallaReservarTurno("Fecha no seleccionada");
    }

    private void givenServiciosCargados() {

    }

    private void givenUsuarioRegistrado(Usuario usuario) {
        DatosRegistro datosRegistro = new DatosRegistro();
        datosRegistro.setEmail(usuario.getEmail());
        datosRegistro.setPassword(usuario.getPassword());
        datosRegistro.setRepitePassword(usuario.getPassword());
        controladorRegistrarme.registrar(datosRegistro);
    }

    private void whenReservarTurno(Date fecha, List<Servicio> servicios, Double precio) {
        DatosTurno datosTurno = new DatosTurno(fecha, precio, servicios);
        modelAndView = controladorReservarTurno.reservar(datosTurno, new BindingResult() {
            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Map<String, Object> getModel() {
                return null;
            }

            @Override
            public Object getRawFieldValue(String s) {
                return null;
            }

            @Override
            public PropertyEditor findEditor(String s, Class<?> aClass) {
                return null;
            }

            @Override
            public PropertyEditorRegistry getPropertyEditorRegistry() {
                return null;
            }

            @Override
            public void addError(ObjectError objectError) {

            }

            @Override
            public String[] resolveMessageCodes(String s) {
                return new String[0];
            }

            @Override
            public String[] resolveMessageCodes(String s, String s1) {
                return new String[0];
            }

            @Override
            public void recordSuppressedField(String s) {

            }

            @Override
            public String[] getSuppressedFields() {
                return new String[0];
            }

            @Override
            public String getObjectName() {
                return null;
            }

            @Override
            public void setNestedPath(String s) {

            }

            @Override
            public String getNestedPath() {
                return null;
            }

            @Override
            public void pushNestedPath(String s) {

            }

            @Override
            public void popNestedPath() throws IllegalStateException {

            }

            @Override
            public void reject(String s) {

            }

            @Override
            public void reject(String s, String s1) {

            }

            @Override
            public void reject(String s, Object[] objects, String s1) {

            }

            @Override
            public void rejectValue(String s, String s1) {

            }

            @Override
            public void rejectValue(String s, String s1, String s2) {

            }

            @Override
            public void rejectValue(String s, String s1, Object[] objects, String s2) {

            }

            @Override
            public void addAllErrors(Errors errors) {

            }

            @Override
            public boolean hasErrors() {
                return false;
            }

            @Override
            public int getErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getAllErrors() {
                return null;
            }

            @Override
            public boolean hasGlobalErrors() {
                return false;
            }

            @Override
            public int getGlobalErrorCount() {
                return 0;
            }

            @Override
            public List<ObjectError> getGlobalErrors() {
                return null;
            }

            @Override
            public ObjectError getGlobalError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors() {
                return false;
            }

            @Override
            public int getFieldErrorCount() {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors() {
                return null;
            }

            @Override
            public FieldError getFieldError() {
                return null;
            }

            @Override
            public boolean hasFieldErrors(String s) {
                return false;
            }

            @Override
            public int getFieldErrorCount(String s) {
                return 0;
            }

            @Override
            public List<FieldError> getFieldErrors(String s) {
                return null;
            }

            @Override
            public FieldError getFieldError(String s) {
                return null;
            }

            @Override
            public Object getFieldValue(String s) {
                return null;
            }

            @Override
            public Class<?> getFieldType(String s) {
                return null;
            }
        });
    }

    private void thenElTurnoSeSeReservaConExito() {
        assertThat(modelAndView.getModel().get("reservado")).isEqualTo(Boolean.TRUE);
        assertThat(modelAndView.getViewName()).isEqualTo("reserva-exitosa");
    }

    private void thenFallaReservarTurno(String mensaje) {
        Assertions.assertThat(modelAndView.getModel().get("error")).isEqualTo(mensaje);
        Assertions.assertThat(modelAndView.getViewName()).isEqualTo("reservar-turno");
    }

    private List<Servicio> getServicios() {
        List<Servicio> servicios = new ArrayList<>();
        servicios.add(new Servicio("Corte de pelo", 300.0));
        servicios.add(new Servicio("Corte de uñas", 100.0));
        servicios.add(new Servicio("Baño", 250.0));
        return servicios;
    }

    private Usuario usuario(String email, String password) {
        return new Usuario(email, password);
    }
}
