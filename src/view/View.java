/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Sebastian
 */
public class View {

    JFrame frame = new JFrame("GESTION DE CORREOS");
    Container container = frame.getContentPane();
    JPanel panel = new JPanel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new View().run();
    }

    public void run() {
        ventana();
        render("login");
    }

    public void render(String state) {
        container.removeAll();
        frame.repaint();
        switch (state) {
            case "login":
                login();
                break;
            case "signUp":
                signUp();
                break;
            default:
                login();
                break;
        }
        container.add(panel);
        frame.setVisible(true);
    }

    public void ventana() {
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void login() {
        panel.setLayout(new FlowLayout());
        JTextField userName = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JButton signUp = new JButton("Crear Cuenta");
        JButton login = new JButton("Iniciar Session");
        JButton forgetPass = new JButton("Olvide mi Contraseña");

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                render("signUp");
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                render("signUp");
            }
        });

        panel.add(new JLabel("Email Corporativo: "));
        panel.add(userName);
        panel.add(new JLabel("Contraseña: "));
        panel.add(password);
        panel.add(signUp);
        panel.add(login);
        panel.add(forgetPass);
    }

    public void signUp() {
        panel.setLayout(new FlowLayout());
        JTextField nombres = new JTextField(20);
        JTextField email = new JTextField(20);
        JPasswordField pass = new JPasswordField(20);
        JPasswordField passComp = new JPasswordField(20);
        JTextField recovery = new JTextField(15);
        JButton signUp = new JButton("Crear Cuenta");
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                render("login");
            }
        });

        panel.add(new JLabel("Nombres y Apellidos: "));
        panel.add(nombres);
        panel.add(new JLabel("Direccion de Correo: "));
        panel.add(email);
        panel.add(new JLabel("Contraseña: "));
        panel.add(pass);
        panel.add(new JLabel("Comprobar Contraseña: "));
        panel.add(passComp);
        panel.add(new JLabel("Nombre de su Primera Mascota"));
        panel.add(recovery);
        panel.add(signUp);
    }

    public void forgotPassword() {
        panel.setLayout(new FlowLayout());

    }

    public void admin() {

    }

    public void user() {

    }

}
