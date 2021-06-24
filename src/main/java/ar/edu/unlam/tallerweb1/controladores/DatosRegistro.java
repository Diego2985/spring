package ar.edu.unlam.tallerweb1.controladores;

public class DatosRegistro {
    private String nombre;
    private String email;
    private String password;
    private String repitePassword;
    private String direccion;
    private String telefono;


    public String getNombre(){return nombre;}

    public void setNombre(String nombre) { this.nombre = nombre;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepitePassword() {
        return repitePassword;
    }

    public void setRepitePassword(String repitePassword) {
        this.repitePassword = repitePassword;
    }

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}
}
