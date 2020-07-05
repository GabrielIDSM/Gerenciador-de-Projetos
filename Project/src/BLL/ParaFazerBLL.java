package BLL;

import DAL.ConnectionFactory;
import DTO.ParaFazerDTO;
import DTO.ProjetoDTO;
import DTO.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class ParaFazerBLL {
    //Constantes
    final public int ERRO_CRITICO = -1;
    final public int PARA_FAZER_CRIADO = 0;
    final public int TITULO_INVALIDO = 1;
    final public int MENSAGEM_INVALIDA = 2;
    //CRUD
    private ParaFazerDTO Create(ParaFazerDTO paraFazer){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.persist(paraFazer);
            eM.getTransaction().commit();
        }catch(Exception e){
            //Restaura modificações
            eM.getTransaction().rollback();
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return paraFazer;
    }
    private ParaFazerDTO Update(ParaFazerDTO paraFazer){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            eM.getTransaction().begin();
            //Iniciar a transação
            if(paraFazer.getID() == null){
                eM.persist(paraFazer);
            }else{
                eM.merge(paraFazer);
            }   
            eM.getTransaction().commit();
        }catch(Exception e){
            //Restaura modificações
            eM.getTransaction().rollback();
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return paraFazer;
    }
    public ParaFazerDTO ReadByID(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        ParaFazerDTO paraFazer = null;
        try {
            paraFazer = eM.find(ParaFazerDTO.class, ID);
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return paraFazer;
    }
    public List<ParaFazerDTO> Read(){
        EntityManager eM = new ConnectionFactory().getConnection();
        List<ParaFazerDTO> paraFazerList = null;
        try {
            paraFazerList = eM.createQuery("from ParaFazerDTO P").getResultList();
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return paraFazerList;
    }
    private ParaFazerDTO Delete(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        ParaFazerDTO paraFazer = null;
        try {
            paraFazer = eM.find(ParaFazerDTO.class, ID);
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.joinTransaction();
            eM.remove(paraFazer);
            eM.getTransaction().commit();
        }catch(Exception e){
            //Restaura modificações
            eM.getTransaction().rollback();
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return paraFazer;
    }
    //Métodos
    public List<ParaFazerDTO> Read(ProjetoDTO projeto){
        List<ParaFazerDTO> paraFazerAll = Read();
        List<ParaFazerDTO> paraFazerProject = new ArrayList<>();
        for(ParaFazerDTO f : paraFazerAll){
            if(f.getProjeto().getID() == projeto.getID()) paraFazerProject.add(f);
        }
        return paraFazerProject;
    }
    
    public int NovoParaFazer(ProjetoDTO Projeto, UsuarioDTO Usuario, int Cor, String Titulo, String Mensagem){
        try{
            Titulo = Titulo.replace("'", "''");
            Mensagem = Mensagem.replace("'", "''");
            if(Titulo.length() > 50) return 1;
            if(Titulo.length() > 1000) return 2;
            ParaFazerDTO paraFazer = new ParaFazerDTO();
            paraFazer.setProjeto(Projeto);
            paraFazer.setUsuario(Usuario);
            paraFazer.setCor(Cor);
            paraFazer.setTitulo(Titulo);
            paraFazer.setMensagem(Mensagem);
            Create(paraFazer);
            return 0;
        }catch(Exception e){
            return 1;
        }
    }
    public int EditarParaFazer(int ID, ProjetoDTO Projeto, UsuarioDTO Usuario, int Cor, String Titulo, String Mensagem){
        try{
            Titulo = Titulo.replace("'", "''");
            Mensagem = Mensagem.replace("'", "''");
            if(Titulo.length() > 50) return 1;
            if(Titulo.length() > 1000) return 2;
            ParaFazerDTO paraFazer = new ParaFazerDTO();
            paraFazer.setProjeto(Projeto);
            paraFazer.setUsuario(Usuario);
            paraFazer.setCor(Cor);
            paraFazer.setTitulo(Titulo);
            paraFazer.setMensagem(Mensagem);
            paraFazer.setID(ID);
            Update(paraFazer);
            return 0;
        }catch(Exception e){
            return 1;
        }
    }
    public boolean ExcluirParaFazer(int ID){
        try{
            Delete(ID);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean ExcluirTodosDeUmProjeto(int Id){
        try{
            List<ParaFazerDTO> paraFazerList = Read();
            for(ParaFazerDTO f : paraFazerList){
                if(f.getProjeto().getID() == Id){
                    Delete(f.getID());
                }
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
