package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class FeitoDTO {
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    
    @ManyToOne
    ProjetoDTO Projeto;
    
    @ManyToOne
    UsuarioDTO Usuario;
    
    int Cor;
    
    String Titulo; //50 caracteres
    
    String Mensagem; //1000 caracteres
    
    String Termino;
    
    //Getters e Setters

    public Integer getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ProjetoDTO getProjeto() {
        return Projeto;
    }

    public void setProjeto(ProjetoDTO Projeto) {
        this.Projeto = Projeto;
    }

    public UsuarioDTO getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioDTO Usuario) {
        this.Usuario = Usuario;
    }

    public int getCor() {
        return Cor;
    }

    public void setCor(int Cor) {
        this.Cor = Cor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }
    
    public String getTermino() {
        return Termino;
    }

    public void setTermino(String Termino) {
        this.Termino = Termino;
    }
    
}
