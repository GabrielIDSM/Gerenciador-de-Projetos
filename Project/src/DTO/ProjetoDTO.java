package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class ProjetoDTO {
    //Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    
    String Nome; //50 caracteres
    
    int Gerente;
    
    //Getters e Setters

    public Integer getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGerente() {
        return Gerente;
    }

    public void setGerente(int Gerente) {
        this.Gerente = Gerente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
}
