
package BLL;

import DAL.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import DTO.ProjetoDTO;
import DTO.UsuarioDTO;
import javax.persistence.EntityManager;

public class ProjetoBLL {
    //Constantes
    public final int ERRO_CRITICO =  -1;
    public final int PROJETO_CRIADO = 0;
    //CRUD
    private ProjetoDTO Create(ProjetoDTO projeto){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.persist(projeto);
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
        return projeto;
    }
    private ProjetoDTO Update(ProjetoDTO projeto){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            eM.getTransaction().begin();
            //Iniciar a transação
            if(projeto.getID() == null){
                eM.persist(projeto);
            }else{
                eM.merge(projeto);
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
        return projeto;
    }
    public ProjetoDTO ReadByID(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        ProjetoDTO projeto = null;
        try {
            projeto = eM.find(ProjetoDTO.class, ID);
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return projeto;
    }
    public List<ProjetoDTO> Read(){
        EntityManager eM = new ConnectionFactory().getConnection();
        List<ProjetoDTO> projetos = null;
        try {
            projetos = eM.createQuery("from ProjetoDTO P").getResultList();
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return projetos;
    }
    private ProjetoDTO Delete(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        ProjetoDTO projeto = null;
        try {
            projeto = eM.find(ProjetoDTO.class, ID);
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.remove(projeto);
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
        return projeto;
    }
    //Métodos
    /**
     * Retorna um objeto com o mesmo ID do projeto.
     * Se não houver projeto retorn null.
     * 
     * @param ID ID do projeto
     * @return Um objeto com as informações do projeto
     */
    public ProjetoDTO RetornaProjeto(int ID){
        try{
            List<ProjetoDTO> projetos = Read();
            if(projetos.isEmpty()) return null;
            for(ProjetoDTO p : projetos){
                if(p.getID() == ID) return p;
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
    
    /**
     * Cria um novo projeto.
     * @param Nome Nome do Projeto
     * @param Gerente ID do Usuário
     * @return 0 - Usuário criado, -1 - Erro
     */
    public int NovoProjeto(String Nome, UsuarioDTO Gerente){
        try{
            Nome = Nome.replace("'", "''");
            if(Nome.length() > 50) return -1;
            ProjetoDTO projeto = new ProjetoDTO();
            projeto.setNome(Nome);
            projeto.setGerente(Gerente.getID());
            Create(projeto);
            return 0;
        }catch(Exception e){
            return -1;
        }
    }
    
    public boolean ExcluirProjeto(ProjetoDTO projeto){
        try{
            new ParaFazerBLL().ExcluirTodosDeUmProjeto(projeto.getID());
            new FazendoBLL().ExcluirTodosDeUmProjeto(projeto.getID());
            new FeitoBLL().ExcluirTodosDeUmProjeto(projeto.getID());
            Delete(projeto.getID());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
