package Sistema;

import Controladores.ControladorDeAluno;
import Controladores.ControladorDeLivro;
import Telas.Login;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        /**/
        ControladorDeLivro.CadastrarLivro("titulo", "Autor");
        ControladorDeLivro.CadastrarLivro("titulo1", "Autor");
        ControladorDeLivro.CadastrarLivro("titulo2", "Autor");
        /**/
        ControladorDeAluno.CadastrarAluno("Aluno", "email@email.com", "senha", "Curso");

            Login app = new Login();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //app.setLayout(  );
            app.setPreferredSize(app.getSize());
            app.setSize(800, 600);
            app.setVisible(true);
    }

}
