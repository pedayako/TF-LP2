package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controladores.ControladorDeAluno;
import Controladores.ControladorDeBibliotecario;
import Telas.Aluno.MenuAluno;
import Telas.Bibliotecario.MenuBibliotecario;
import Enum.TipoDePanel;
import Enum.TipoUsuarios;

public class Login extends JFrame implements ActionListener {
    JTextField tfEmail, tfSenha;
    JComboBox<String> cboTipoUsuario;
    JLabel message;

    private FlowLayout layoutPadrao(){
        return new FlowLayout(FlowLayout.CENTER, 20, 20);
    }

    private JLabel criarLabel(String text){
        JLabel label = new JLabel();
        label.setText(text);
        return label;
    }

    private JTextField criarTextField(String text){
        JTextField textField = new JTextField();
        textField.setText(text);
        textField.setColumns(25);
        return textField;
    }

    private JPanel tipoUsuarioPanel(String[] tipos){
        JLabel lblTipoUsuario = criarLabel("Tipo Usuário:");
        this.cboTipoUsuario = new JComboBox<>(tipos);
        JPanel tipoUsuarioPanel = new JPanel();
        tipoUsuarioPanel.add(lblTipoUsuario);
        tipoUsuarioPanel.add(cboTipoUsuario);
        return tipoUsuarioPanel;
    }

    private Boolean isEmail(TipoDePanel tipoDePanel){
        return tipoDePanel == TipoDePanel.Email;
    }

    private JTextField getLocalTextField(TipoDePanel tipo){
        if (isEmail(tipo))
           return this.tfEmail;
        else
            return this.tfSenha;
    }

    private void initLocalTextField(TipoDePanel tipoDePanel){
        if (isEmail(tipoDePanel))
            this.tfEmail = criarTextField("");
        else
            this.tfSenha = criarTextField("");
    }

    private JPanel labelETextFieldPanel(String labelText, TipoDePanel tipo){
        JLabel label = criarLabel(labelText);
        JPanel panel = new JPanel(layoutPadrao());
        initLocalTextField(tipo);
        panel.add(label);
        panel.add(getLocalTextField(tipo));
        return panel;
    }

    private JPanel botaoPanel(String buttonText){
        JPanel botaoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton botao = new JButton(buttonText);
        botao.addActionListener(this);
        this.message = criarLabel("");
        botaoPanel.add(message);
        botaoPanel.add(botao);
        return botaoPanel;
    }

    public Login() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 400, 10));
        String[] tiposUsuario = {
                "Bibliotecario",
                "Aluno",
        };
        panel.add(tipoUsuarioPanel(tiposUsuario));
        panel.add(labelETextFieldPanel("Email:", TipoDePanel.Email));
        panel.add(labelETextFieldPanel("Senha:", TipoDePanel.Senha));
        panel.add(botaoPanel("Entrar"));
        add(panel, BorderLayout.CENTER);
        setTitle("Login ");
    }


    private Boolean selecionouAluno(){
        System.out.println(cboTipoUsuario.getSelectedIndex());
        return cboTipoUsuario.getSelectedIndex() == 1;

    }

    private Boolean selecionouBibliotecario(){
        return  cboTipoUsuario.getSelectedIndex() == 1;
    }

    private Boolean autenticar(){
        if(selecionouAluno()){
            return ControladorDeAluno.FazerLogin(tfEmail.getText(), tfSenha.getText());
        }else if(selecionouBibliotecario()){
            return ControladorDeBibliotecario.FazerLogin(tfEmail.getText(), tfSenha.getText());
        }
        return false;
    }

    private JFrame autenticadoPage(TipoUsuarios tipoUsuario){
        if(tipoUsuario == TipoUsuarios.Aluno)
            return new MenuAluno();
        else if (tipoUsuario == TipoUsuarios.Bibliotecario)
            return new MenuBibliotecario();
        return null;
    }

    private void abrirMenuFrame(TipoUsuarios tipoUsuarios){
        JFrame app = autenticadoPage(tipoUsuarios);
        assert app != null;
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setPreferredSize(app.getSize());
        app.setSize(800, 600);
        app.setVisible(true);
    }

    private TipoUsuarios getTipoUsuario(){
        if(selecionouAluno())
            return TipoUsuarios.Aluno;
        else
            return TipoUsuarios.Bibliotecario;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean autenticado = autenticar();
        if(autenticado){
            abrirMenuFrame(getTipoUsuario());
         }else{
             message.setText("Usuario ou senha Invalidos");
         }
    }
}