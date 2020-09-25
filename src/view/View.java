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
        container.remove(panel);
        frame.setVisible(false);
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
        JLabel emailLbl = new JLabel("Email Corporativo");
        JTextField userName = new JTextField(20);
        JLabel passLbl = new JLabel("Contraseña");
        JPasswordField password = new JPasswordField(20);
        JButton login = new JButton("Iniciar Session");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                render("signUp");
            }
        });
        
        panel.add(emailLbl);
        panel.add(userName);
        panel.add(passLbl);
        panel.add(password);
        panel.add(login);
    }
    
    public void signUp() {
        panel.setLayout(new FlowLayout());
        JLabel emailLbl = new JLabel("CREAR CUENTA");
        JTextField userName = new JTextField(20);
        JLabel passLbl = new JLabel("CASDJLWASD");
        JPasswordField password = new JPasswordField(20);
        JButton login = new JButton("Crear Cuenta");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                render("login");
            }
        });
        
        panel.add(emailLbl);
        panel.add(userName);
        panel.add(passLbl);
        panel.add(password);
        panel.add(login);
    }
    
    public void forgotPassword() {
        
    }
    
    public void admin() {
        
    }
    
    public void user() {
        
    }
    
}
