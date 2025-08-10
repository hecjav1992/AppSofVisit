package com.example.appsofvisit;

public class User {

    private String usuario;
    private String contrasena;
    private String correo;
    private boolean estado;
    private String rol;

    public User(String contrasena, String correo, boolean estado, String rol, String usuario) {
        this.contrasena = contrasena;
        this.correo = correo;
        this.estado = estado;
        this.rol = rol;
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
