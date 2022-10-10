package Telas.Bibliotecario;

import Controladores.ControladorDeAluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarAluno extends JFrame implements ActionListener {
    JPanel panel;
    JTextField tfEmail, tfSenha, tfNome, tfNomeCurso;
    JLabel message;
    public CadastrarAluno() throws HeadlessException {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));

        // Nome Label
        JPanel pnNome = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbNome = new JLabel();
        tfNome = new JTextField();
        lbNome.setText("Nome :");
        tfNome.setColumns(25);
        pnNome.add(lbNome);
        pnNome.add(tfNome);
        panel.add(pnNome);

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

        // Nome Curso
        JPanel pnNomeCurso = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbNomeCurso = new JLabel();
        lbNomeCurso.setText("Curso :");
        tfNomeCurso = new JTextField();
        tfNomeCurso.setColumns(25);
        pnNomeCurso.add(lbNomeCurso);
        pnNomeCurso.add(tfNomeCurso);
        panel.add(pnNomeCurso);

        // Submit
        JPanel pnEnviar = new JPanel(new FlowLayout(FlowLayout.CENTER, 00, 0));
        JButton enviar = new JButton("Finalizar Cadastro");
        message = new JLabel();
        enviar.addActionListener(this);
        pnEnviar.add(enviar);
        pnEnviar.add(message);
        panel.add(pnEnviar);

        add(panel, BorderLayout.CENTER);
        setTitle("Cadastrar Aluno ");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean res = ControladorDeAluno.CadastrarAluno(tfNome.getText(), tfEmail.getText(), tfSenha.getText(), tfNomeCurso.getText());
        if( res ){
            this.dispose();
            MenuBibliotecario app = new MenuBibliotecario();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setPreferredSize(app.getSize());
            app.setSize(800, 600);
            app.setVisible(true);
            return;
        }else{
            message.setText("Valores Inválidos");
            return;
        }
    }
}

