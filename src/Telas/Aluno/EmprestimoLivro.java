package Telas.Aluno;

import Controladores.ControladorDeLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmprestimoLivro extends JFrame implements ActionListener {
    JPanel panel;
    JTextField tfIdLivro;
    JButton enviar;
    JLabel message;
    boolean saia = false;
    public EmprestimoLivro() throws HeadlessException {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));

        // Nome Label
        JPanel pnIdLivro = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JLabel lbIdLivro = new JLabel();
        tfIdLivro = new JTextField();
        lbIdLivro.setText("ID do Livro :");
        tfIdLivro.setColumns(25);
        pnIdLivro.add(lbIdLivro);
        pnIdLivro.add(tfIdLivro);
        panel.add(pnIdLivro);

        // Mensagem
        message = new JLabel(" ");
        panel.add(new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)).add(message));

        criarOpcao("Fazer Emprestimo", "1");
        criarOpcao("Sair", "0");
        add(panel, BorderLayout.CENTER);
        setTitle("Fazer Empréstimo ");
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
        if( action.equals("0") || saia ){
            this.dispose();
            MenuAluno app = new MenuAluno();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setPreferredSize(app.getSize());
            app.setSize(800, 600);
            app.setVisible(true);
            return;
        }else if(action.equals("1")){
            if(!saia){
                String res = ControladorDeLivro.FazerEmprestimo(tfIdLivro.getText());
                if( res != null ){
                    message.setText(res);
                    saia = true;
                }else{
                    message.setText("Livro Indisponivel!");
                    return;
                }
            }
        }


    }
}
