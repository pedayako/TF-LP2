package Telas.Livro;

import Controladores.ControladorDeLivro;
import Telas.Aluno.MenuAluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevolveLivro extends JFrame implements ActionListener {
    JPanel panel;
    JTextField tfID;
    JLabel message;
    public DevolveLivro() throws HeadlessException {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));

        Object[][] dados = ControladorDeLivro.ListarMeusLivros();
        if(dados != null ){
            String[] colunas = { "ID", "Titulo", "Autor", "Data de Emprestimo", "Data de Entrega"};
            JTable tabela = new JTable(dados, colunas){
                @Override
                public boolean isCellEditable(int row, int column){return false;}
            };
            JScrollPane barraRolagem =  new JScrollPane(tabela);
            barraRolagem.setPreferredSize( new Dimension(400, 300));
            panel.add(barraRolagem);

            // Nome Label
            JPanel pnID = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            JLabel lbID = new JLabel();
            tfID = new JTextField();
            lbID.setText("Id :");
            tfID.setColumns(25);
            pnID.add(lbID);
            pnID.add(tfID);
            panel.add(pnID);

            // Mensagem
            message = new JLabel(" ");
            panel.add(new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)).add(message));
            criarOpcao("Devolver", "1");
        }else{
            JPanel pnMessage = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            pnMessage.add(new JLabel("Não há Livros a serem Devolvidos!"));
            panel.add(pnMessage);
        }
        //sair
        criarOpcao("Sair", "0");

        add(panel, BorderLayout.CENTER);
        setTitle("Devolver Livro ");
    }
    public void criarOpcao(String texto, String action){
        JPanel pnOpcao = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton opcao = new JButton(texto);
        opcao.setActionCommand(action);
        opcao.setPreferredSize(new Dimension(300, 30));
        opcao.addActionListener(this);
        pnOpcao.add(opcao);
        panel.add(pnOpcao);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        if( action.equals("0") ){
            this.dispose();
            MenuAluno app = new MenuAluno();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setPreferredSize(app.getSize());
            app.setSize(800, 600);
            app.setVisible(true);
            return;
        }else if( action.equals("1") ){
            boolean res = ControladorDeLivro.DevolverLivro(tfID.getText());
            if(res){
                message.setText("Livro Devolvido com Sucesso!");
                return;
            }else{
                message.setText("ID Inválido");
                return;
            }

        }
    }
}