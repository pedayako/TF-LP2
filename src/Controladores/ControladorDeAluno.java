package Controladores;

import Entidades.Aluno;
import Telas.Aluno.MenuAluno;

import java.util.ArrayList;

public class ControladorDeAluno {
    private static ArrayList<Aluno> AlunosBD = new ArrayList<Aluno>();
    private static Aluno alunoAtual = null;
    public static boolean FazerLogin(String email, String senha ){
        for (Aluno aluno : AlunosBD) {
            if(aluno.getEmail().equals(email)){
                if(aluno.getSenha().equals(senha)){
                    alunoAtual = aluno;
                    return aluno.login(email, senha);
                }
            }
        }
        return false;
    }
    public static boolean CadastrarAluno(String nome, String email, String senha, String nomeCurso){
        if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || nomeCurso.isEmpty()) return false;
        int id = AlunosBD.size() +1;
        Aluno novo = new Aluno(id, nome, email, senha, nomeCurso);
        AlunosBD.add(novo);
        return true;
    }
    public static Object[][] ListarAlunosCadastrados(){
        Object[][] dados = new Object [AlunosBD.size()][4];
        int i = 0;
        for ( Aluno aluno : AlunosBD) {
            Object[] dadosLivro = {
                    aluno.getId(),
                    aluno.getNome(),
                    aluno.getEmail(),
                    aluno.getNomeCurso(),
            };
            dados[i] = dadosLivro;
            i++;
        }
        return dados;
    }
    public static Aluno getAlunoAtual(){
        return  alunoAtual;
    }
}
