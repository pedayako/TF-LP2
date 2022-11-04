package Sistema;

import Controladores.ControladorDeAluno;
import Controladores.ControladorDeLivro;
import Telas.Login;

import javax.swing.*;

public class Main {

    private static void initLivros(){
        ControladorDeLivro.CadastrarLivro("The General Zapped an Angel", "Howard Fast");
        ControladorDeLivro.CadastrarLivro("Admirável Mundo Novo", "Aldous Huxley");
        ControladorDeLivro.CadastrarLivro("O Estrangeiro", "Livro por Albert Camus");
    }

    private static void initAlunos(){
        ControladorDeAluno.CadastrarAluno("Aluno", "email@email.com", "senha", "Curso");
    }


    public static void main(String[] args) {
        initLivros();
        initAlunos();
        Login app = new Login();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setPreferredSize(app.getSize());
        app.setSize(800, 600);
        app.setVisible(true);
    }

}
