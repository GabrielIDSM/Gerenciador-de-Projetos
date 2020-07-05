package BLL;

import DAL.ConnectionFactory;
import DTO.FazendoDTO;
import DTO.ParaFazerDTO;
import DTO.ProjetoDTO;
import UTILIT.Datas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class FazendoBLL {
    //Constantes
    final public int ERRO_CRITICO = -1;
    final public int FAZENDO_CRIADO = 0;
    final public int TITULO_INVALIDO = 1;
    final public int MENSAGEM_INVALIDA = 2; 
    final public int DATA_INVALIDA = 3;
    //CRUD
    private FazendoDTO Create(FazendoDTO fazendo){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.persist(fazendo);
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
        return fazendo;
    }
    private FazendoDTO Update(FazendoDTO fazendo){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            eM.getTransaction().begin();
            //Iniciar a transação
            if(fazendo.getID() == null){
                eM.persist(fazendo);
            }else{
                eM.merge(fazendo);
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
        return fazendo;
    }
    public FazendoDTO ReadByID(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        FazendoDTO fazendo = null;
        try {
            fazendo = eM.find(FazendoDTO.class, ID);
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return fazendo;
    }
    public List<FazendoDTO> Read(){
        EntityManager eM = new ConnectionFactory().getConnection();
        List<FazendoDTO> fazendoList = null;
        try {
            fazendoList = eM.createQuery("from FazendoDTO F").getResultList();
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return fazendoList;
    }
    private FazendoDTO Delete(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        FazendoDTO fazendo = null;
        try {
            fazendo = eM.find(FazendoDTO.class, ID);
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.remove(fazendo);
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
        return fazendo;
    }
    //Métodos
    public List<FazendoDTO> Read(ProjetoDTO projeto){
        List<FazendoDTO> fazendoAll = Read();
        List<FazendoDTO> fazendoProject = new ArrayList<>();
        for(FazendoDTO f : fazendoAll){
            if(f.getProjeto().getID() == projeto.getID()) fazendoProject.add(f);
        }
        return fazendoProject;
    }
    
    public int NovoFazendo(ParaFazerDTO paraFazer, String Prazo, int Estagio){
        try{
            if(Prazo.equals("")) return 3;
            if(!Datas.DataValidade(Prazo)) return 3;
            //Cria objeto de trasnferência
            FazendoDTO fazendo = new FazendoDTO();
            fazendo.setProjeto(paraFazer.getProjeto());
            fazendo.setUsuario(paraFazer.getUsuario());
            fazendo.setCor(paraFazer.getCor());
            fazendo.setTitulo(paraFazer.getTitulo());
            fazendo.setMensagem(paraFazer.getMensagem());
            fazendo.setPrazo(Prazo);
            fazendo.setEstagio(Estagio);
            //Transfere dados pro BD
            Create(fazendo);
            //Exclui dados do objeto ParaFazer
            ParaFazerBLL bll = new ParaFazerBLL();
            bll.ExcluirParaFazer(paraFazer.getID());
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public int EditarFazendo(FazendoDTO fazendo, String Titulo, String Mensagem, String Prazo, int Cor, int Estagio){
        try{
            Mensagem = Mensagem.replace("'", "''");
            Titulo = Titulo.replace("'", "''");
            if(Titulo.length() > 50) return 1;
            if(Mensagem.length() > 1000) return 2;
            if(!Datas.DataValidade(Prazo)) return 3;
            fazendo.setTitulo(Titulo);
            fazendo.setMensagem(Mensagem);
            fazendo.setPrazo(Prazo);
            fazendo.setCor(Cor);
            fazendo.setEstagio(Estagio);
            Update(fazendo);
            return 0;
        }catch(Exception e){
            return -1;
        }
    }
    public boolean ExcluirFazendo(FazendoDTO fazendo){
        try{
            Delete(fazendo.getID());
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean ExcluirTodosDeUmProjeto(int Id){
        try{
            List<FazendoDTO> fazendoList = Read();
            for(FazendoDTO f : fazendoList){
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
