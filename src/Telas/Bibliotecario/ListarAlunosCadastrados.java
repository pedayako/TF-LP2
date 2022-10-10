package Telas.Bibliotecario;

import Controladores.ControladorDeAluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarAlunosCadastrados extends JFrame implements ActionListener {
    JPanel panel;
    JLabel message;
    public ListarAlunosCadastrados() throws HeadlessException {
        Object[][] dados = ControladorDeAluno.ListarAlunosCadastrados();
        String[] colunas = { "ID", "Nome", "Email", "Curso" };
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));
        JTable tabela = new JTable(dados, colunas){
            @Override
            public boolean isCellEditable(int row, int column){return false;}
        };
        JScrollPane barraRolagem =  new JScrollPane(tabela);
        panel.add(barraRolagem);

        // Submit
        JPanel pnEnviar = new JPanel(new FlowLayout(FlowLayout.CENTER, 00, 0));
        JButton enviar = new JButton("Voltar");
        message = new JLabel();
        enviar.addActionListener(this);
        pnEnviar.add(enviar);
        pnEnviar.add(message);
        panel.add(pnEnviar);

        add(panel, BorderLayout.CENTER);
        setTitle("Alunos Cadastrados");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.dispose();
        MenuBibliotecario app = new MenuBibliotecario();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setPreferredSize(app.getSize());
        app.setSize(800, 600);
        app.setVisible(true);
        return;
    }
}