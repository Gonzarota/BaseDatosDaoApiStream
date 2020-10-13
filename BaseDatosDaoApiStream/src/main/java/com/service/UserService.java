package com.service;

import com.dao.DAO;
import com.dominio.Usuario;
import com.service.helper.UserHelper;

import java.sql.SQLException;
import java.util.List;


public class UserService {

    DAO dao=new DAO();

    public UserService(){

    }

    public void addUsuario(Usuario usuario) throws SQLException {
        String mensaje=dao.insertUsuario(usuario);
        System.out.println(mensaje);
    }

    public void removeUsuario(int id) throws SQLException {
        String mensaje=dao.removeUsuario(id);
        System.out.println(mensaje);
    }

    public void updateUsuario(int id, String name, int edad, float salario) throws SQLException {
        String mensaje=dao.alterUsuario(id, name, edad, salario);
        System.out.println(mensaje);
    }

    public void filterByName(String name) throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();
        UserHelper.filterByName(usuarios,name);
    }

    public void filterByAge(int age) throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();

        UserHelper.filterByAge(usuarios,age);
    }

    public void filterBySalary(float salary) throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();

        UserHelper.filterBySalary(usuarios,salary);
    }

    public void filterMaxSalary() throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();

        UserHelper.filterMaxSalary(usuarios);
    }

    public void filterMaxAge() throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();

        UserHelper.filterMaxAge(usuarios);
    }

    public void filterRangeAge(int max, int min) throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();

        UserHelper.filterRangeEdad(usuarios,max,min);
    }

    public void filterRangeSalary(float max,float min) throws SQLException {
        List<Usuario> usuarios=dao.loadUsuarios();

        UserHelper.filterRangeSalary(usuarios,max,min);
    }

}
