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

    public void insertAdmins() {
        usuario = new User("admin1@mail.com", "Admin 1", "root", "admin", "admon");
        addUsers(usuario);
        usuario = new User("admin2@mail.com", "Admin 2", "root", "admin", "admon");
        addUsers(usuario);
        usuario = new User("user1@mail.com", "Usuario 1", "user", "user", "usor");
        addUsers(usuario);
    }

    public void signUpUser() {

    }

    public void forgotPass() {

    }

    public void restartPass() {

    }

    public void changePass() {

    }

    public String[] finOneUser(int index) {
        String data[] = {db.get(index).getAccount(), db.get(index).getPassword(), db.get(index).getName(), db.get(index).getRecoverInfo(), db.get(index).getTypeUser()};
        return data;
    }

    public String[] listUsers() {
        String[] users = new String[db.size()];

        for (int i = 0; i < db.size(); i++) {
            users[i] = "Cuenta: " + db.get(i).getAccount() + " |Nombres: " + db.get(i).getName() + " |Tipo: " + db.get(i).getTypeUser();
        }

        return users;

    }

    public int getIndex(String userName) {
        int index = 0;
        for (int i = 0; i < db.size(); i++) {
            if (db.get(i).getAccount().equals(userName)) {
                index = i;

                i += db.size();
            }
        }

        return index;
    }

    public void addUsers(User usuario) {
        db.add(usuario);
    }

}
