package com.service.helper;


import com.dominio.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserHelper {


    public static void filterByName( List<Usuario> usuarios, String name) throws SQLException {
        List<Usuario> filtroNombre = usuarios.stream().filter(usuario -> name.equals(usuario.getNombre()))
                .collect(Collectors.toList());
        if(filtroNombre.isEmpty()){
            System.out.println("No hay nadie con ese nombre");
        }else{
            filtroNombre.forEach(item-> System.out.println(item.toString()));
        }
    }

    public static void filterByAge( List<Usuario> usuarios, Integer edad) throws SQLException {
        List<Usuario> filtroEdad = usuarios.stream().filter(usuario -> edad.equals(usuario.getEdad()))
                .collect(Collectors.toList());
        if(filtroEdad.isEmpty()){
            System.out.println("No hay nadie con esa edad");
        }else{
            filtroEdad.forEach(item-> System.out.println(item.toString()));
        }
    }

    public static void filterBySalary( List<Usuario> usuarios, Float salary) throws SQLException {
        List<Usuario> filtroSalario = usuarios.stream().filter(usuario -> salary.equals(usuario.getSalario()))
                .collect(Collectors.toList());
        if(filtroSalario.isEmpty()){
            System.out.println("No hay nadie con ese salario");
        }else{
            filtroSalario.forEach(item-> System.out.println(item.toString()));
        }
    }

    public static void filterMaxSalary(List<Usuario> usuarios) throws SQLException {
        Optional<Usuario> filtroMaxSalario = usuarios.stream().max((a1, a2) -> (int) (a1.getSalario() - a2.getSalario()));

        if(filtroMaxSalario.isPresent()){
            System.out.println(filtroMaxSalario.toString());
        }
    }

    public static void filterMaxAge(List<Usuario> usuarios) throws SQLException {
        Optional<Usuario> filtroMaxAge = usuarios.stream().max((a1,a2)->a1.getEdad()-a2.getEdad());

        if(filtroMaxAge.isPresent()){
            System.out.println(filtroMaxAge.toString());
        }
    }

    public static void filterRangeEdad( List<Usuario> usuarios, int max, int min) throws SQLException {
        List<Usuario> filtroRangoEdad = usuarios.stream().filter(usuario -> usuario.getEdad()<=max && usuario.getEdad()>=min)
                .collect(Collectors.toList());
        if(filtroRangoEdad.isEmpty()){
            System.out.println("No hay nadie con una edad en ese rango");
        }else{
            filtroRangoEdad.forEach(item-> System.out.println(item.toString()));
        }
    }

    public static void filterRangeSalary( List<Usuario> usuarios, float max, float min) throws SQLException {
        List<Usuario> filtroRangoSalario = usuarios.stream().filter(usuario -> usuario.getSalario()<=max && usuario.getSalario()>=min)
                .collect(Collectors.toList());
        if(filtroRangoSalario.isEmpty()){
            System.out.println("No hay nadie con un salario en ese rango");
        }else{
            filtroRangoSalario.forEach(item-> System.out.println(item.toString()));
        }
    }
}
