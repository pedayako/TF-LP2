package Telas.Livro;

import Controladores.ControladorDeLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarLivrosLivres extends JFrame implements ActionListener {
    JPanel panel;
    JLabel message;
    public ListarLivrosLivres() throws HeadlessException {
        Object[][] dados = ControladorDeLivro.ListarLivrosLivres();
        if(dados != null) {
            String[] colunas = {"ID", "Titulo", "Autor"};
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));
            JTable tabela = new JTable(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JScrollPane barraRolagem = new JScrollPane(tabela);
            panel.add(barraRolagem);
        }else{
            JPanel pnMessage = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            pnMessage.add(new JLabel("Não há Livros Disponiveis!"));
            panel.add(pnMessage);
        }
        // Submit
        JPanel pnEnviar = new JPanel(new FlowLayout(FlowLayout.CENTER, 00, 0));
        JButton enviar = new JButton("Voltar");
        message = new JLabel();
        enviar.addActionListener(this);
        pnEnviar.add(enviar);
        pnEnviar.add(message);
        panel.add(pnEnviar);

        add(panel, BorderLayout.CENTER);
        setTitle("Livros Livres");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {}
}


