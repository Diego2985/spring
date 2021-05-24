package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarios;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("servicioUsuarios")
@Transactional
public class ServicioUsuarioDefault implements ServicioUsuario {

    private final RepositorioUsuarios tablaDeUsuarios = RepositorioUsuarios.getInstance();


    public Usuario registrar(DatosRegistro datos) {
        if (!datos.getPassword().equals(datos.getRepitePassword())){
            throw new ClavesNoCoinciden();
        }
        if (tablaDeUsuarios.existeUsuarioCon(datos.getEmail())){
            throw new UsuarioExistente();
        }
        Usuario nuevoUsuario = new Usuario(datos.getEmail(), datos.getRepitePassword());
        tablaDeUsuarios.agregar(nuevoUsuario);
        return nuevoUsuario;

    }
}
