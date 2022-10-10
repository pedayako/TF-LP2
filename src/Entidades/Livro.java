package Entidades;
import java.time.LocalDate;

public class Livro implements Comparable<Livro>{
    private int id;
    private String titulo, autor;
    private LocalDate dataEmprestimo;

    private LocalDate dataEntrega;
    Aluno alunoComLivro;

    public Livro(int id, String titulo, String autor) {
        super();
        this.titulo = titulo;
        this.autor = autor;
        dataEmprestimo = null;
        alunoComLivro = null;
        this.id= id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Aluno getAlunoComLivro() {
        if(alunoComLivro != null) return alunoComLivro;
        else return null;
    }

    public void setAlunoComLivro(Aluno alunoComLivro) {
        this.alunoComLivro = alunoComLivro;
    }

    public int compareTo(Livro l) {
        return this.titulo.compareToIgnoreCase(l.getTitulo());
    }
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}