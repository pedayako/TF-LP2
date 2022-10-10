package Entidades;

public class Aluno extends Usuario{
    private String nomeCurso;

    private String srcFoto;

    public Aluno(int id, String nome, String email, String senha, String nomeCurso) {
        super(id, nome, email, senha);
        this.nomeCurso = nomeCurso;
        srcFoto = "/Icone_Homem.png";
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getSrcFoto() {
        return srcFoto;
    }

    public void setSrcFoto(String srcFoto) {
        this.srcFoto = srcFoto;
    }
}

