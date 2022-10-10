package Telas.Bibliotecario;

import Controladores.ControladorDeLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarLivro extends JFrame implements ActionListener {
    JPanel panel;
    JTextField tfAutor, tfSenha, tftitulo, tfNomeCurso;
    JLabel message;
    public CadastrarLivro() throws HeadlessException {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));

        // Titulo Label
        JPanel pnTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbTitulo = new JLabel();
        tftitulo = new JTextField();
        lbTitulo.setText("Titulo :");
        tftitulo.setColumns(25);
        pnTitulo.add(lbTitulo);
        pnTitulo.add(tftitulo);
        panel.add(pnTitulo);

        // Autor Label
        JPanel pnAutor = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbAutor = new JLabel();
        tfAutor = new JTextField();
        lbAutor.setText("Autor :");
        tfAutor.setColumns(25);
        pnAutor.add(lbAutor);
        pnAutor.add(tfAutor);
        panel.add(pnAutor);

        // Submit
        JPanel pnEnviar = new JPanel(new FlowLayout(FlowLayout.CENTER, 00, 0));
        JButton enviar = new JButton("Finalizar Cadastro");
        message = new JLabel();
        enviar.addActionListener(this);
        pnEnviar.add(enviar);
        pnEnviar.add(message);
        panel.add(pnEnviar);

        add(panel, BorderLayout.CENTER);
        setTitle("Cadastrar Livro ");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean res = ControladorDeLivro.CadastrarLivro(tftitulo.getText(), tfAutor.getText());
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

