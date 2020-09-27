/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Sebastian
 */
public class User {

    private String account, name, password, typeUser, recoverInfo;

    public User(String account, String name, String password, String typeUser, String recoverInfo) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.typeUser = typeUser;
        this.recoverInfo = recoverInfo;
    }

    public User() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getRecoverInfo() {
        return recoverInfo;
    }

    public void setRecoverInfo(String recoverInfo) {
        this.recoverInfo = recoverInfo;
    }

}
