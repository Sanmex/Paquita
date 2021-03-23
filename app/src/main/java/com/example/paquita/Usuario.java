package com.example.paquita;

public class Usuario {
    int id;
    String nombre,apellidos,usuario,password,email;

    @Override
    public String toString() {
        return nombre+" "+apellidos+" "+usuario+" "+password+" "+email;
    }
     //obtener contraseña
    public String getPassword() {
        return password;
    }
    //establecer contraseña
    public void setPassword(String password) {
        this.password = password;
    }
    //obtener mail
    public String getEmail() {
        return email;
    }
    //establecer mail
    public void setEmail(String email) {
        this.email = email;
    }
     //obtener numero id que servira para identificar al usuario en la base de datso
    public int getId() {
        return id;
    }
    //establecer id
    public void setId(int id) {
        this.id = id;
    }
    //obtiene nombre
    public String getNombre() {
        return nombre;
    }
    //establece nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //obtener apellido
    public String getApellidos() {
        return apellidos;
    }
    //establecer apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    //obtener usuario
    public String getUsuario() {
        return usuario;
    }
   //establecer usuario
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
   //constructor vacio
    public Usuario() {

    }
    //constructor con todos los parametros
    public Usuario( String nombre, String apellidos, String usuario, String password, String email) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.email = email;
    }
    //metodo que verificara que todos los campos de datos solicitados al usuario no esten en blanco
    public boolean isNull(){
        if(nombre.equals("")&&apellidos.equals("")&&usuario.equals("")&&password.equals("")&&email.equals("")){
            return false;
        }else{
            return true;
        }

    }

}
