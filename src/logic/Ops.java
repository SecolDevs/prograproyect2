/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.regex.Pattern;

/**
 *
 * @author Sebastian
 */
public class Ops {

    private HandleData hData = new HandleData();
    private String regexMail = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";

    public void initUsers() {
        hData.insertAdmins();
    }

    public String[] loginUser(String userName, String password) {
        String[] response = new String[3];
        if (userName.trim().length() == 0 || password.trim().length() == 0) {
            response[0] = "Ambos campos son Obligatorios";
            response[1] = "no";
        } else if (verifyMail(userName, password)) {
            boolean verif = verifyLogin(userName, password);
            response[0] = verif ? "Correcto" : "Usuario o Contraseña Incorrectos";
            response[1] = verif ? "yes" : "no";
            response[2] = getAllData(userName)[4];
        } else {
            response[0] = "Email Incorrecto, Verifique e intente nuevamente";
            response[1] = "no";
        }
        return response;
    }

    public boolean verifyMail(String userName, String password) {
        return Pattern.matches(regexMail, userName);
    }

    public boolean verifyLogin(String userName, String password) {
        String[] data = hData.finOneUser(hData.getIndex(userName));
        return data[0].equals(userName) && data[1].equals(password);
    }

    public String[] getAllData(String userName) {
        String[] data = hData.finOneUser(hData.getIndex(userName));
        return data;
    }

    public String[] getUsers() {
        String[] data = hData.listUsers();
        return data;
    }

}
