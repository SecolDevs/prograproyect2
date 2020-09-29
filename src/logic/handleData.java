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

    // Vars Iniciales
    private ArrayList<User> db = new ArrayList<>();
    private User usuario;

    // Metodo para crear usuarios iniciales
    public void insertAdmins() {
        usuario = new User("admin1@mail.com", "Admin 1", "root", "admin", "admon");
        addUsers(usuario);
        usuario = new User("admin2@mail.com", "Admin 2", "root", "admin", "admon");
        addUsers(usuario);
        usuario = new User("user1@mail.com", "Usuario 1", "user", "user", "usor");
        addUsers(usuario);
    }

    // Crear usuario nuevo
    public void signUpUser(String[] data) {
        usuario = new User(data[0], data[1], data[2], "user", data[3]);
        addUsers(usuario);
    }

    // Actualizar un usuario
    public void updateUser(int index, String[] userData) {
        usuario = new User(userData[1], userData[3], userData[2], userData[5], userData[4]);
        db.set(index, usuario);
    }

    // Eliminar usuario
    public void deleteUser(int index) {
        db.remove(index);
    }

    // Retornar los datos de x email
    public String[] finOneUser(int index) {
        String data[] = {String.valueOf(index), db.get(index).getAccount(), db.get(index).getPassword(), db.get(index).getName(), db.get(index).getRecoverInfo(), db.get(index).getTypeUser()};
        return data;
    }

    // Listar todos los usuarios
    public String[] listUsers() {
        String[] users = new String[db.size()];
        for (int i = 0; i < db.size(); i++) {
            users[i] = "Cuenta: " + db.get(i).getAccount() + " |Nombres: " + db.get(i).getName() + " |Tipo: " + db.get(i).getTypeUser();
        }
        return users;
    }

    // tomar el indice de x correo
    public int getIndex(String userName) {
        int index = -1;
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getAccount().equals(userName)) {
                index = i;
                i += db.size();
            }
        }
        return index;
    }

    // Añadir nuevos usuarios 
    public void addUsers(User usuario) {
        db.add(usuario);
    }

}
