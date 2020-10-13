package com.view;

import com.dominio.Usuario;
import com.service.UserService;
import com.service.helper.UserHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    UserService userService=new UserService();
    Scanner sc=new Scanner(System.in);


    public int showMenu(){
        System.out.println(" Elija una opción: \n" +
                "1. Añadir usuario \n"+
                "2. Eliminar usuario \n"+
                "3. Actualizar usuario \n"+
                "4. Filtrar \n"+
                "5. Salir");

        int opcion=sc.nextInt();
        return opcion;
    }

    public void ejecutar() throws SQLException {
        int seleccion=0;
        while(seleccion!=5){
            seleccion=showMenu();
            switch (seleccion){
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    alterUser();
                    break;
                case 4:
                    ejecutarFilter();
                    break;
            }
        }
        System.out.println("Saliendo de la aplicación");
    }

    public int showMenufilter(){
        System.out.println(" Elija una opción: \n" +
                "1. Filtrar por nombre \n"+
                "2. Filtrar por edad \n"+
                "3. Filtrar por salario \n"+
                "4. Filtrar por el salario más elevado \n"+
                "5. Filtrar por la edad mayor \n"+
                "6. Filtrar por rango de edad \n" +
                "7. Filtrar por rango de salario \n"+
                "8. Volver"
        );

        int opcion=sc.nextInt();
        return opcion;
    }

    public void ejecutarFilter() throws SQLException {
        int seleccion=0;
        while(seleccion!=8){
            seleccion=showMenufilter();
            switch (seleccion){
                case 1:
                    filterByName();
                    break;
                case 2:
                    filterByAge();
                    break;
                case 3:
                    filterBySalary();
                    break;
                case 4:
                    filterMaxSalary();
                    break;
                case 5:
                    filterMaxAge();
                    break;
                case 6:
                    filterRangeAge();
                    break;
                case 7:
                    filterRangeSalary();
                    break;
            }
        }
        System.out.println("Saliendo de la aplicación");
    }

    public void addUser() throws SQLException {
        System.out.println("Introduce el nombre");
        String nombre=sc.next();

        System.out.println("Introduce la edad");
        int edad=sc.nextInt();

        System.out.println("Introduce el salario");
        float salario=sc.nextFloat();

        Usuario usuario=new Usuario(nombre, edad, salario);
        userService.addUsuario(usuario);
    }

    public void removeUser() throws SQLException {
        System.out.println("Introduce el id de la persona a borrar");
        int id=sc.nextInt();

        userService.removeUsuario(id);
    }

    public void alterUser() throws SQLException {
        System.out.println("Introduce el id de la persona a modificar");
        int id=sc.nextInt();

        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el nuevo nombre");
        String nuevoNombre=sc.nextLine();
        System.out.println("Introduce la nueva edad");
        int nuevaEdad=sc.nextInt();
        System.out.println("Introduce el nuevo salario");
        float nuevoSalario=sc.nextInt();

        userService.updateUsuario(id, nuevoNombre, nuevaEdad, nuevoSalario);
    }

    public void filterByName() throws SQLException {
        System.out.println("Introduce el nombre por el que quieres filtrar");
        String name = sc.next();

        userService.filterByName(name);
    }

    public void filterByAge() throws SQLException {
        System.out.println("Introduce la edad por la que quieres filtrar");
        int age=sc.nextInt();

        userService.filterByAge(age);
    }

    public void filterBySalary() throws SQLException {
        System.out.println("Introduce el salario por el que quieres filtrar");
        float salary=sc.nextInt();

        userService.filterBySalary(salary);
    }

    public void filterMaxSalary() throws SQLException {
        System.out.println("El salario más alto es:");
        userService.filterMaxSalary();
    }

    public void filterMaxAge() throws SQLException{
        System.out.println("La edad más alta es:");
        userService.filterMaxAge();
    }

    public void filterRangeAge() throws SQLException {
        System.out.println("Introduce la edad mínima del rango");
        int min=sc.nextInt();
        System.out.println("Introduce la edad máxima del rango");
        int max=sc.nextInt();

        userService.filterRangeAge(max,min);
    }

    public void filterRangeSalary() throws SQLException {
        System.out.println("Introduce el salario mínimo del rango");
        float min=sc.nextFloat();
        System.out.println("Introduce el salario máximo del rango");
        float max=sc.nextFloat();

        userService.filterRangeSalary(max,min);
    }
}