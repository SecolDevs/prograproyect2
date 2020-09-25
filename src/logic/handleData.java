/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class HandleData {

    private ArrayList<User> db = new ArrayList<>();
    private User usuario;
    private boolean isLoged;
    private String logedUser;

    public void insertData(String[] data) { // LLama a los metodos sin importar detalle
        if (verifyUser(data)) {
            addUser(data);
            listUsers();
            findUser();
            logoutUser();
        }
    }

    public boolean verifyUser(String[] data) {
        return true;
    }

    public void addUser(String[] data) {

    }

    public void listUsers() {

    }

    public void findUser() {

    }

    public void loginUser() {

    }

    public void logoutUser() {

    }

    public void restorePass() {

    }

    public void deleteUser() {

    }

}
