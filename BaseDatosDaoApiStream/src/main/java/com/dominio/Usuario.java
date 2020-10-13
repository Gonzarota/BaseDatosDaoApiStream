package com.dominio;

public class Usuario {

    public int id;
    public String nombre;
    public int edad;
    public float salario;

    public Usuario(int id, String nombre, int edad, float salario){
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
        this.salario=salario;
    }

    public Usuario( String nombre, int edad, float salario){
        this.nombre=nombre;
        this.edad=edad;
        this.salario=salario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                '}';
    }
}
