package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class FazendoDTO {
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
    
    String Prazo; //10 caracteres
    
    int Estagio; //0 - Iniciado / 1 - Em curso / 2 - Aguardando Confirmação do Gerente
    
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

    public String getPrazo() {
        return Prazo;
    }

    public void setPrazo(String Prazo) {
        this.Prazo = Prazo;
    }

    public int getEstagio() {
        return Estagio;
    }

    public void setEstagio(int Estagio) {
        this.Estagio = Estagio;
    }
    
}
