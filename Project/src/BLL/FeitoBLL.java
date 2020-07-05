package BLL;

import DAL.ConnectionFactory;
import DTO.FeitoDTO;
import DTO.FazendoDTO;
import DTO.ProjetoDTO;
import UTILIT.Datas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class FeitoBLL {
    //Constantes
    final public int ERRO_CRITICO = -1;
    final public int FEITO_CRIADO = 0;
    final public int TITULO_INVALIDO = 1;
    final public int MENSAGEM_INVALIDA = 2; 
    final public int TERMINO_INVALIDA = 3;
    //CRUD
    private FeitoDTO Create(FeitoDTO feito){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.persist(feito);
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
        return feito;
    }
    private FeitoDTO Update(FeitoDTO feito){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            eM.getTransaction().begin();
            //Iniciar a transação
            if(feito.getID() == null){
                eM.persist(feito);
            }else{
                eM.merge(feito);
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
        return feito;
    }
    public FeitoDTO ReadByID(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        FeitoDTO feito = null;
        try {
            feito = eM.find(FeitoDTO.class, ID);
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return feito;
    }
    public List<FeitoDTO> Read(){
        EntityManager eM = new ConnectionFactory().getConnection();
        List<FeitoDTO> feitoList = null;
        try {
            feitoList = eM.createQuery("from FeitoDTO Ft").getResultList();
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return feitoList;
    }
    private FeitoDTO Delete(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        FeitoDTO feito = null;
        try {
            feito = eM.find(FeitoDTO.class, ID);
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.joinTransaction();
            eM.remove(feito);
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
        return feito;
    }
    //Métodos
    public List<FeitoDTO> Read(ProjetoDTO projeto){
        List<FeitoDTO> feitoAll = Read();
        List<FeitoDTO> feitoProject = new ArrayList<>();
        for(FeitoDTO f : feitoAll){
            if(f.getProjeto().getID() == projeto.getID()) feitoProject.add(f);
        }
        return feitoProject;
    }
    
    public int NovoFeito(FazendoDTO fazendo){
        try{
            String Termino = Datas.retornaStringDataAtual();
            //Cria objeto de trasnferência
            FeitoDTO feito = new FeitoDTO();
            feito.setProjeto(fazendo.getProjeto());
            feito.setUsuario(fazendo.getUsuario());
            feito.setCor(fazendo.getCor());
            feito.setTitulo(fazendo.getTitulo());
            feito.setMensagem(fazendo.getMensagem());
            feito.setTermino(Termino);
            //Transfere os dados
            Create(feito);
            //Exclui o objeto ParaFazer
            FazendoBLL fazendoBll = new FazendoBLL();
            fazendoBll.ExcluirFazendo(fazendo);
            return 0;
        }catch(Exception e){
            return -1;
        }
    }
    
    public boolean ExcluirTodosDeUmProjeto(int Id){
        try{
            List<FeitoDTO> feitoList = Read();
            for(FeitoDTO f : feitoList){
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
