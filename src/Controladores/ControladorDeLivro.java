package Controladores;

import Entidades.Livro;
import Telas.Bibliotecario.MenuBibliotecario;

import javax.swing.text.LabelView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Locale;

public class ControladorDeLivro {
        private static ArrayList<Livro> LivroBD = new ArrayList<Livro>();

        public static boolean CadastrarLivro(String titulo, String autor){
            if (titulo.isEmpty() || autor.isEmpty() ) return false;
            int id = LivroBD.size() +1;
            Livro novo = new Livro(id, titulo, autor);
            LivroBD.add(novo);
            return true;
        }
        public static String FazerEmprestimo(String id){
            if (id.isEmpty() || !id.matches("[0-9]+")) return null;
            for (Livro livro: LivroBD) {
                if(livro.getId() == Integer.parseInt(id)){
                    livro.setAlunoComLivro(ControladorDeAluno.getAlunoAtual());
                    livro.setDataEmprestimo(LocalDate.now());
                    livro.setDataEntrega(LocalDate.now().plusMonths(1));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/uuuu", new Locale("pt", "BR"));
                    return "Data de Empréstimo: "+ dtf.format(livro.getDataEmprestimo())
                            +" Data de Entrega: "+ dtf.format(livro.getDataEntrega());
                }
            }
            return null;
        }
    public static boolean DevolverLivro(String id){
        if (id.isEmpty() || !id.matches("[0-9]+")) return false;
        for (Livro livro: LivroBD) {
            if(livro.getId() == Integer.parseInt(id)){
                livro.setAlunoComLivro(null);
                livro.setDataEmprestimo(null);
                livro.setDataEntrega(null);
                return true;
            }
        }
        return false;
    }
        public static Object[][] ListarTodoslivros(){
            Object[][] dados = null;
            for ( Livro livro : LivroBD) {
                String disponibilidade = livro.getAlunoComLivro() == null ? "Disponivel" : "Ocupado";
                Object[] dadosLivro = {
                    livro.getId(),
                    livro.getTitulo(),
                    livro.getAutor(),
                    disponibilidade,
                };
                dados = add(dados, dadosLivro);
            }
            return dados;
        }
    public static Object[][] ListarLivrosLivres(){
        Object[][] dados = null;
        for ( Livro livro : LivroBD) {
            if(livro.getAlunoComLivro() == null) {
                Object[] dadosLivro = {
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                };
                dados = add(dados, dadosLivro);
            }
        }
        return dados;
    }
    public static Object[][] ListarMeusLivros(){
        Object[][] dados = null;//

        for ( Livro livro : LivroBD) {
            if(livro.getAlunoComLivro() != null){
                if(livro.getAlunoComLivro().getId() == ControladorDeAluno.getAlunoAtual().getId()) {
                    Object[] dadosLivro = {
                            livro.getId(),
                            livro.getTitulo(),
                            livro.getAutor(),
                            livro.getDataEmprestimo(),
                            livro.getDataEntrega(),
                    };
                    dados = add(dados, dadosLivro);
                }
            }
        }
        return dados;
    }
    private static Object[][] add(Object[][] arr, Object[] novo_ele){
            Object[][] novo_arr = null;
            if(arr == null) {
                novo_arr = new Object[1][];
                novo_arr[0] = novo_ele;
            }
            else {
                novo_arr = new Object[arr.length+1][];
                for(int i = 0; i < arr.length; i++){
                    novo_arr[i] = arr[i];
                }
                novo_arr[arr.length] = novo_ele;
            }
            return novo_arr;
    }
}
