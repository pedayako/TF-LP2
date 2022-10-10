package Controladores;

import Entidades.Bibliotecario;

public class ControladorDeBibliotecario {
    public static boolean FazerLogin(String email, String senha ){
        Bibliotecario b = new Bibliotecario(0, "admin", "admin@admin.com", "password");
        return b.login(email, senha);
    }
}
