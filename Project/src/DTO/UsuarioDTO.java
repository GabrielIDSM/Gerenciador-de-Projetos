package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class UsuarioDTO {
    
    //Propriedades
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    
    String Login; //40 caracteres
    
    String Senha; //20 caracteres
    
    //Getters e Setters

    public Integer getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
}
