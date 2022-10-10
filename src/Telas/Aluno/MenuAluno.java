package Telas.Aluno;

import Controladores.ControladorDeAluno;
import Telas.Livro.DevolveLivro;
import Telas.Livro.ListarLivrosLivres;
import Telas.Login;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MenuAluno extends JFrame implements ActionListener {
    JPanel panel;
    BufferedImage getImg ;
    ImageIcon fotoPerfil;
    public MenuAluno() throws HeadlessException {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));
        JPanel perfil = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JLabel iFotoPerfil;
        fotoPerfil = new ImageIcon(getClass().getResource(ControladorDeAluno.getAlunoAtual().getSrcFoto()));
        fotoPerfil.setImage(fotoPerfil.getImage().getScaledInstance(150, 150, 20));
        iFotoPerfil = new JLabel(fotoPerfil);
        perfil.add(iFotoPerfil);

        JPanel dadosPerfil = new JPanel(new GridLayout(3,1));
        JLabel nome = new JLabel("Nome : " + ControladorDeAluno.getAlunoAtual().getNome());
        JLabel email = new JLabel("Email: " + ControladorDeAluno.getAlunoAtual().getEmail());
        JLabel curso = new JLabel("Curso: " + ControladorDeAluno.getAlunoAtual().getNomeCurso());
        JButton opcao = new JButton("Adicionar ou Alterar Foto");
        opcao.setActionCommand("alterar");
        opcao.setPreferredSize(new Dimension(200, 10));
        opcao.addActionListener(this);

        dadosPerfil.add( new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10)).add(nome));
        dadosPerfil.add( new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10)).add(email));
        dadosPerfil.add( new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10)).add(curso));
        dadosPerfil.add( new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10)).add(opcao));

        perfil.add(dadosPerfil);
        panel.add(perfil);
        criarOpcao("Emprestimo de Livro", "1");
        criarOpcao("Devolver Livro", "2");
        criarOpcao("Consultar Livros Disponiveis", "3");
        criarOpcao("Sair", "0");

        add(panel, BorderLayout.CENTER);
        setTitle("Login ");
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
                EmprestimoLivro EL = new EmprestimoLivro();
                EL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EL.setPreferredSize(EL.getSize());
                EL.setSize(800, 600);
                EL.setVisible(true);
                break;
            case "2":
                this.dispose();
                DevolveLivro DL = new DevolveLivro();
                DL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                DL.setPreferredSize(DL.getSize());
                DL.setSize(800, 600);
                DL.setVisible(true);
                break;
            case "3":
                this.dispose();
                ListarLivrosLivres LLL = new ListarLivrosLivres(){
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            this.dispose();
                            MenuAluno app = new MenuAluno();
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
            case "alterar":
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(new FileNameExtensionFilter("Imagem", "jpg", "jpeg", "gif", "png"));
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.showDialog(jfc, "Selecione");
                if(jfc.getSelectedFile() != null){
                    System.out.println(jfc.getSelectedFile().toString() +"::::"+jfc.getSelectedFile().getPath());
                        try {
                            String nome_foto = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MMMM_uuuu_HH_mm_ss", new Locale("pt", "BR")));
                            nome_foto = nome_foto + ".jpg";
                            System.out.println(nome_foto);
                            File nova_foto = new File(getClass().getResource("/").getPath(), nome_foto);
                            if (nova_foto.createNewFile()) {
                                System.out.println("File created: " + nova_foto.getName());
                                String url = nova_foto.getPath(); //getClass().getResource("/img.jpg").getPath();

                                Path dir = new File(url).toPath();
                                System.out.println(dir);
                                Files.copy(jfc.getSelectedFile().toPath(), dir, StandardCopyOption.REPLACE_EXISTING);
                                ControladorDeAluno.getAlunoAtual().setSrcFoto("/"+nome_foto);
                            } else {
                                System.out.println("File already exists.");
                            }
                        } catch (IOException ex) {
                            System.err.println(ex);
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erro de carregamento!");
                        }
                }

                //JOptionPane.showMessageDialog(null, jfc.getSelectedFile());
                break;
        }
    }
}
