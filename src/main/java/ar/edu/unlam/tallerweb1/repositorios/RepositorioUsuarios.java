package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.HashMap;
import java.util.Map;

public class RepositorioUsuarios {

    private static RepositorioUsuarios instance = new RepositorioUsuarios();
    private RepositorioUsuarios() { }
    public static RepositorioUsuarios getInstance(){
     return instance;
    }
    private Map<String, Usuario> tablaDeUsuarios = new HashMap<>();

    public boolean existeUsuarioCon(String email){
        return tablaDeUsuarios.containsKey(email);
    }
    public void agregar(Usuario usuario){
        this.tablaDeUsuarios.put(usuario.getEmail(), usuario);
    }
    public void reset(){
        this.tablaDeUsuarios.clear();
    }
}
