package Telas.Bibliotecario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Telas.Livro.ListarLivrosLivres;
import Telas.Livro.ListarTodosLivros;
import Telas.Login;

public class MenuBibliotecario extends JFrame implements ActionListener {
    ArrayList<JButton> opcoes;
    JPanel panel;
    public MenuBibliotecario() throws HeadlessException {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));

        criarOpcao("Cadastrar Aluno ", "1");
        criarOpcao("Cadastrar Livro ", "2");
        criarOpcao("Todos os Livros", "3");
        criarOpcao("Livros Livres", "4");
        criarOpcao("Alunos Cadastrados", "5");
        criarOpcao("Sair ", "0");

        add(panel, BorderLayout.CENTER);
        setTitle("Menu ");
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

        switch (action){
            case "0":
                this.dispose();
                Login login = new Login();
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setPreferredSize(login.getSize());
                login.setSize(800, 600);
                login.setVisible(true);
                break;
            case "1":
                this.dispose();
                CadastrarAluno CA = new CadastrarAluno();
                CA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                CA.setPreferredSize(CA.getSize());
                CA.setSize(800, 600);
                CA.setVisible(true);
                break;
            case "2":
                this.dispose();
                CadastrarLivro CL = new CadastrarLivro();
                CL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                CL.setPreferredSize(CL.getSize());
                CL.setSize(800, 600);
                CL.setVisible(true);
                break;
            case "3":
                this.dispose();
                ListarTodosLivros LTL = new ListarTodosLivros();
                LTL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                LTL.setPreferredSize(LTL.getSize());
                LTL.setSize(800, 600);
                LTL.setVisible(true);
                break;
            case "4":
                this.dispose();
                ListarLivrosLivres LLL = new ListarLivrosLivres(){
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
                };
                LLL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                LLL.setPreferredSize(LLL.getSize());
                LLL.setSize(800, 600);
                LLL.setVisible(true);
                break;
            case "5":
                this.dispose();
                ListarAlunosCadastrados LAC = new ListarAlunosCadastrados();
                LAC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                LAC.setPreferredSize(LAC.getSize());
                LAC.setSize(800, 600);
                LAC.setVisible(true);
                break;
        }
    }
}
