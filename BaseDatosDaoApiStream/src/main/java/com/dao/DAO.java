package com.dao;

import com.dominio.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DAO {

    public static Connection cn = null;

    public DAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/empresa?serverTimezone=" + TimeZone.getDefault().getID();
            String user = "root";
            String clave = "admin";
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, clave);
            System.out.println("Conexión establecida.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public String insertUsuario(Usuario usuario)throws SQLException{

        String nombre=usuario.getNombre();
        int edad=usuario.getEdad();
        float salario=usuario.getSalario();

        Statement sentencia=this.cn.createStatement();
        String sql="INSERT INTO usertablestream(nombre,edad,salario) VALUES('"+nombre+"','"+edad+"','"+salario+"')";
        int result;

        result=sentencia.executeUpdate(sql);

        String resultado="Se han insertado "+result+" filas, creando el usuario: "+usuario.getNombre();

        sentencia.close();
        return resultado;
    }

    public String removeUsuario(int id) throws SQLException{
        Statement sentencia=this.cn.createStatement();
        String sql="DELETE FROM usertablestream WHERE id="+id;
        int result;

        result=sentencia.executeUpdate(sql);
        String resultado="Se han borrado "+result+" filas";

        sentencia.close();
        return resultado;
    }

    public String alterUsuario(int id, String nuevoNombre, int nuevaEdad, float nuevoSalario) throws SQLException {

        Statement sentencia=this.cn.createStatement();
        String sql="UPDATE usertablestream SET nombre='"+nuevoNombre+"',edad='"+nuevaEdad+"',salario='"+nuevoSalario+"' WHERE id="+id;
        int result;

        result=sentencia.executeUpdate(sql);
        String resultado="Se han modificado "+result+" filas";

        sentencia.close();
        return resultado;
    }

    public List<Usuario> loadUsuarios() throws SQLException {
        List<Usuario> usuarios=new ArrayList<>();
        Statement sentencia=this.cn.createStatement();
        String sql= "SELECT * FROM usertablestream";
        ResultSet result=sentencia.executeQuery(sql);

        while(result.next()){
            Usuario u = new Usuario(result.getInt("id"),
                    result.getString("nombre"),
                    result.getInt("edad"),
                    result.getFloat("salario"));

            usuarios.add(u);
        }
        sentencia.close();
        return usuarios;

    }
}
