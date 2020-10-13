package com;

import com.view.Menu;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Menu menu=new Menu();
        menu.ejecutar();
    }
}
