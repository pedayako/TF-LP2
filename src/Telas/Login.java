package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controladores.ControladorDeAluno;
import Controladores.ControladorDeBibliotecario;
import Telas.Aluno.MenuAluno;
import Telas.Bibliotecario.MenuBibliotecario;

public class Login extends JFrame implements ActionListener {
    JTextField tfEmail, tfSenha;
    JComboBox cbUsuario;
    JLabel message;
    public Login() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));

        //Tipo usuario
        String[] patterns = {
                "Bibliotecario",
                "Aluno",
        };
        JLabel lbUsuario = new JLabel();

        cbUsuario = new JComboBox(patterns);
        JPanel pnUsuario = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        lbUsuario.setText("Tipo de Usuario :");
        pnUsuario.add(lbUsuario);
        pnUsuario.add(cbUsuario);
        panel.add(pnUsuario);

        // Email Label
        JPanel pnEmail = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbEmail = new JLabel();
        tfEmail = new JTextField();
        lbEmail.setText("Email :");
        tfEmail.setColumns(25);
        pnEmail.add(lbEmail);
        pnEmail.add(tfEmail);
        panel.add(pnEmail);

        // Password
        JPanel pnSenha = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbSenha = new JLabel();
        lbSenha.setText("Senha :");
        tfSenha = new JTextField();
        tfSenha.setColumns(25);
        pnSenha.add(lbSenha);
        pnSenha.add(tfSenha);
        panel.add(pnSenha);

        // Submit
        JPanel pnEnviar = new JPanel(new FlowLayout(FlowLayout.CENTER, 00, 0));
        JButton enviar = new JButton("Entrar");
        message = new JLabel();
        enviar.addActionListener(this);
        pnEnviar.add(enviar);
        pnEnviar.add(message);
        panel.add(pnEnviar);

        // Adding the listeners to components..
        add(panel, BorderLayout.CENTER);
        setTitle("Login ");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean res = false;
        if( cbUsuario.getSelectedIndex() == 0 ){
            res = ControladorDeBibliotecario.FazerLogin(tfEmail.getText(), tfSenha.getText());
        }else if( cbUsuario.getSelectedIndex() == 1 ){
            res = ControladorDeAluno.FazerLogin(tfEmail.getText(), tfSenha.getText());
        }

        if( res ){
            this.dispose();
            if( cbUsuario.getSelectedIndex() == 0 ){
                MenuBibliotecario app = new MenuBibliotecario();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setPreferredSize(app.getSize());
                app.setSize(800, 600);
                app.setVisible(true);

            } else if( cbUsuario.getSelectedIndex() == 1 ){
                MenuAluno app = new MenuAluno();
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setPreferredSize(app.getSize());
                app.setSize(800, 600);
                app.setVisible(true);
            }
         }else{
             message.setText("Usuario ou senha Invalidos");
         }

    }

}
