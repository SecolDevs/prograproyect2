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

    // Vars Iniciales
    private HandleData hData = new HandleData();
    private String regexMail = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";

    // Constructor con insercion inicial
    public void initUsers() {
        hData.insertAdmins();
    }

    // Creacion de Usuarios
    public void createuser(String[] datos) {
        hData.signUpUser(datos);
    }

    // Inicio de Sesion
    public String[] loginUser(String userName, String password) {
        String[] response = new String[3];
        if (userName.trim().isEmpty() || password.trim().isEmpty()) {
            response[0] = "Ambos campos son Obligatorios";
            response[1] = "no";
        } else if (verifyIndex(userName)) {
            if (verifyMail(userName)) {
                boolean verif = verifyLogin(userName, password);
                response[0] = verif ? "Correcto" : "Usuario o Contraseña Incorrectos";
                response[1] = verif ? "yes" : "no";
                response[2] = getAllData(userName)[5];
            } else {
                response[0] = "Email Incorrecto, Verifique e intente nuevamente";
                response[1] = "no";
            }
        } else {
            response[0] = "Usuario o Contraseña Incorrectos";
            response[1] = "no";
        }
        return response;
    }

    // Eliminar Usuarios
    public void removeUser(String[] userData) {
        hData.deleteUser(Integer.parseInt(userData[0]));
    }

    // Actualizar Usuarios
    public boolean updateUser(String userName, String name, String recovery, String[] userData) {
        if (verifyMail(userName)) {
            userData[1] = userName;
            userData[3] = name;
            userData[4] = recovery;
            hData.updateUser(Integer.parseInt(userData[0]), userData);
            return true;
        }
        return false;
    }

    // Verificar contraseña en cambio de contraseña user
    public boolean verifyChangePass(String[] data, String nPass, String cPass) {
        if (nPass.equals(cPass)) {
            updatePass(data, nPass);
            return true;
        }
        return false;
    }

    // Verificar mail y respesta de seguridad en olvido contraseña
    public boolean verifyForget(String userName, String answer) {
        String[] data = getAllData(userName);
        return userName.equals(data[1]) && answer.equals(data[4]);
    }

    // Reestablecer contraseña
    public void reestartPass(String[] userData) {
        userData[2] = "123@321";
        hData.updateUser(Integer.parseInt(userData[0]), userData);
    }

    // Actualizar Contraseña
    public void updatePass(String[] userData, String nPass) {
        userData[2] = nPass;
        hData.updateUser(Integer.parseInt(userData[0]), userData);
    }

    // Verificar formato del email
    public boolean verifyMail(String userName) {
        return Pattern.matches(regexMail, userName);
    }

    // Verificar contraseñas Coincidan
    public boolean veryPass(String pass, String passC) {
        return pass.equals(passC);
    }

    // Verificar datos de logeo
    public boolean verifyLogin(String userName, String password) {
        String[] data = hData.finOneUser(hData.getIndex(userName));
        return data[1].equals(userName) && data[2].equals(password);
    }

    // Verificar si existe un email
    public boolean verifyIndex(String userName) {
        return hData.getIndex(userName) >= 0;
    }

    // Tomar todos los datos de x Email
    public String[] getAllData(String userName) {
        String[] data = hData.finOneUser(hData.getIndex(userName));
        return data;
    }

    // Listar todos los usuarios
    public String[] getUsers() {
        String[] data = hData.listUsers();
        return data;
    }

}
