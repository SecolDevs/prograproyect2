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
import logic.Ops;

/**
 *
 * @author Sebastian
 */
public class View {

    // Var
    Ops op = new Ops();
    String[] emptyData = {""};

    // Inicializacion de Frames
    JFrame frame = new JFrame("GESTION DE CORREOS");
    Container container = frame.getContentPane();
    JPanel panel = new JPanel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new View().run();
    }

    // Clase Principal
    public void run() {
        op.initUsers();
        ventana();
        render("login", emptyData);
    }

    // Renderizado Condicional de Componentes
    public void render(String state, String[] data) {
        clearView();
        switch (state) {
            case "login":
                login();
                break;
            case "signUp":
                signUp();
                break;
            case "forget":
                forgotPassword();
                break;
            case "admin":
                admin(data);
                break;
            case "user":
                user(data);
                break;
            default:
                login();
                break;
        }
        fillView();
    }

    // Limpiar los contenedores
    public void clearView() {
        panel.removeAll();
        container.removeAll();
        frame.repaint();
        container.add(panel);
    }

    // Llenar los contenedores
    public void fillView() {
        container.add(panel);
        frame.setVisible(true);
    }

    // Inicializacion de Ventana con params Iniciales
    public void ventana() {
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // VISTA INICIAR SESION
    public void login() {
        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField userName = new JTextField(20);
        JPasswordField password = new JPasswordField(20);

        // Buttons
        JButton signUp = new JButton("Crear Cuenta");
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("signUp", emptyData);
            }
        });

        JButton login = new JButton("Iniciar Session");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] response = op.loginUser(userName.getText(), new String(password.getPassword()));
                if (response[1].equals("yes")) {
                    render(response[2], op.getAllData(userName.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, response[0], "Incorrecto", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // --------------
        JButton forgetPass = new JButton("Olvide mi Contraseña");
        forgetPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("forget", emptyData);
            }
        });

        // Panel Components
        panel.add(new JLabel("Email Corporativo: "));
        panel.add(userName);
        panel.add(new JLabel("Contraseña: "));
        panel.add(password);
        panel.add(signUp);
        panel.add(login);
        panel.add(forgetPass);
    }

    // VISTA CREAR CUENTA
    public void signUp() {
        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField nombres = new JTextField(20);
        JTextField email = new JTextField(20);
        JPasswordField pass = new JPasswordField(20);
        JPasswordField passComp = new JPasswordField(20);
        JTextField recovery = new JTextField(15);

        // Buttons
        JButton signUp = new JButton("Crear Cuenta");
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("login", emptyData);
            }
        });

        // Panel Components
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

    // LOGIN: Olvido Contraseña
    public void forgotPassword() {
        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField forgotMail = new JTextField(20);
        JTextField forgotQuest = new JTextField(20);

        // Buttons
        JButton forgotButton = new JButton("Comprobar");
        forgotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgotPassword2();
            }
        });

        // Panel Components
        panel.add(new JLabel("Ingrese su Email Corporativo"));
        panel.add(forgotMail);
        panel.add(new JLabel("Nombre de su Primera Mascota"));
        panel.add(forgotQuest);
        panel.add(forgotButton);
    }

    // LOGIN: Olvido contraseña 2
    public void forgotPassword2() {
        clearView();
        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField newPass = new JTextField(20);
        JTextField confirmPass = new JTextField(20);

        // Buttons
        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("login", emptyData);
            }
        });

        // Panel Components
        panel.add(new JLabel("Nueva Contraseña: "));
        panel.add(newPass);
        panel.add(new JLabel("Confirme Contraseña: "));
        panel.add(confirmPass);
        panel.add(confirmButton);

        fillView();
    }

    // VISTA DE ADMIN
    public void admin(String[] data) {

        // Listado
        JList list = new JList(op.getUsers());

        // Buttons
        panel.setLayout(new FlowLayout());
        JButton findOneB = new JButton("Buscar Correo");
        findOneB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findOne();
            }
        });

        JButton logoutB = new JButton("Cerrar Sesion");
        logoutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("login", emptyData);
            }
        });

        // Panel Components
        panel.add(findOneB);
        panel.add(logoutB);
        panel.add(new JLabel("---- Listando .... -----"));
        panel.add(new JScrollPane(list));
    }

    // ADMIN: Buscar 1 Usuario
    public void findOne() {
        clearView();

        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField mailFind = new JTextField(20);

        // Buttons
        JButton search = new JButton("Buscar");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mailFind.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                } else if (op.verifyIndex(mailFind.getText())) {
                    String[] data = op.getAllData(mailFind.getText());
                    findedUser(data);
                } else {
                    JOptionPane.showMessageDialog(null, "No se Encuentra el Correo Solicitado", "Incorrecto", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton back = new JButton("Atras");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("admin", emptyData);
            }
        });

        // Panel Components
        panel.add(new JLabel("Correo a Buscar"));
        panel.add(mailFind);
        panel.add(back);
        panel.add(search);

        fillView();
    }

    // ADMIN: Usuario Filtrado
    public void findedUser(String[] data) {
        clearView();

        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField account = new JTextField(20);
        JTextField name = new JTextField(20);

        account.setText(data[1]);
        name.setText(data[3]);

        // Buttons
        JButton affirm = new JButton("Aceptar");
        affirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("admin", emptyData);
            }
        });

        JButton restorePass = new JButton("Restaurar Contraseña");

        JButton delete = new JButton("Eliminar");

        // Panel Components
        panel.add(new JLabel("Cuenta de Usuario:"));
        panel.add(account);
        panel.add(new JLabel("Nombres: "));
        panel.add(name);
        panel.add(restorePass);
        panel.add(delete);
        panel.add(affirm);

        fillView();
    }

    // VISTA DE USUARIO
    public void user(String[] data) {
        panel.setLayout(new FlowLayout());
        // Inputs
        JTextField account = new JTextField(20);
        JTextField name = new JTextField(20);
        JTextField recoverInf = new JTextField(20);

        account.setText(data[1]);
        name.setText(data[3]);
        recoverInf.setText(data[4]);

        // Buttons
        JButton affirm = new JButton("Aceptar");

        JButton restorePass = new JButton("Cambiar Contraseña");
        restorePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePass();
            }
        });

        JButton delete = new JButton("Eliminar Cuenta");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("login", emptyData);
            }
        });

        JButton logout = new JButton("Cerrar Sesion");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("login", emptyData);
            }
        });

        // Panel Components
        panel.add(new JLabel("Cuenta de Usuario: "));
        panel.add(account);
        panel.add(new JLabel("Nombres y Apellidos: "));
        panel.add(name);
        panel.add(new JLabel("Nombre de su Primera Mascota: "));
        panel.add(recoverInf);
        panel.add(restorePass);
        panel.add(delete);
        panel.add(affirm);
        panel.add(logout);
    }

    // USUARIO: Cambiar Contraseña
    public void changePass() {
        clearView();

        // Inputs
        panel.setLayout(new FlowLayout());
        JTextField pass = new JTextField(20);
        JTextField passC = new JTextField(20);

        // Buttons
        JButton cancel = new JButton("Cancelar");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("user", emptyData);
            }
        });

        JButton confirm = new JButton("Confirmar");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                render("user", emptyData);
            }
        });

        // Panel Components
        panel.add(new JLabel("Nueva Contraseña: "));
        panel.add(pass);
        panel.add(new JLabel("Confirmar Contraseña"));
        panel.add(passC);
        panel.add(cancel);
        panel.add(confirm);

        fillView();
    }

}
