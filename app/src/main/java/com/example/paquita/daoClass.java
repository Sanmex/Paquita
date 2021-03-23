package com.example.paquita;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class daoClass {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDprueba";
    String tabla="create table if not exists usuario(id integer primary key autoincrement,nombre text,apellidos text,usuario text,password text,email text)";
//constructor base de datos
    public daoClass(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u=new Usuario();
    }
    //metodo para agregar un nuevo usuario
    public boolean agregarUsuario(Usuario u){
        if(buscar(u.getUsuario())==0) {
            ContentValues cv=new ContentValues();
            cv.put("nombre",u.getNombre());
            cv.put("apellido",u.getApellidos());
            cv.put("usuario",u.getUsuario());
            cv.put("contraseña",u.getPassword());
            cv.put("email",u.getEmail());
            return (sql.insert("usuario",null,cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista=seleccion();
        for(Usuario usuario:lista){
            //verificar no hay 2 usuarios iguales
            if(usuario.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }
    //metodo para devolver el usuario  registrado con el nombre de usuario y contraseña
    public Usuario getUsuario(String us,String pas){
        lista=seleccion();
        for(Usuario u:lista){
            if(u.getUsuario().equals(us)&&u.getPassword().equals(pas)){
              return u;
            }
        }
        return null;
    }

   //metodo de consulta de usuarios ,se construye una lista y se establece el orden y valor de los datos recibidos
    public  ArrayList<Usuario>seleccion(){
        ArrayList<Usuario>lista=new ArrayList<Usuario>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                Usuario u=new Usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setApellidos(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setPassword(cr.getString(4));
                u.setEmail(cr.getString(5));
                lista.add(u);
            }while(cr.moveToNext());

        }
        return lista;

    }
    //metodo de comprobacion de usuario mediante el nombre de usuario y contraseña
    public int login(String u,String p){
        int x=0;
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                if(cr.getString(3).equals(u)&&cr.getString(4).equals(p)){
                    x++;
                }
            }while(cr.moveToNext());
        }
        return x;
    }

}





