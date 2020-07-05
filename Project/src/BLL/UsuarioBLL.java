package BLL;

import DAL.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import DTO.UsuarioDTO;
import javax.persistence.EntityManager;

public class UsuarioBLL{
    //Constantes
    public final int ERRO_CRITICO =  -1;
    public final int USUARIO_CRIADO = 0;
    public final int USUARIO_JA_CADASTRADO = 1;
    public final int LOGIN_OU_SENHA_INVALIDOS = 2;
    //CRUD
    private UsuarioDTO Create(UsuarioDTO usuario){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.persist(usuario);
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
        return usuario;
    }
    private UsuarioDTO Update(UsuarioDTO usuario){
        EntityManager eM = new ConnectionFactory().getConnection();
        try {
            eM.getTransaction().begin();
            //Iniciar a transação
            if(usuario.getID() == null){
                eM.persist(usuario);
            }else{
                eM.merge(usuario);
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
        return usuario;
    }
    public UsuarioDTO ReadByID(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        UsuarioDTO usuario = null;
        try {
            usuario = eM.find(UsuarioDTO.class, ID);
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return usuario;
    }
    public List<UsuarioDTO> Read(){
        EntityManager eM = new ConnectionFactory().getConnection();
        List<UsuarioDTO> usuarios = null;
        try {
            usuarios = eM.createQuery("from UsuarioDTO U").getResultList();
        }catch(Exception e){
            //Exibe o problema
            System.out.println(e.getMessage());
        }finally{
            //Fechar transação
            eM.close();
        }
        return usuarios;
    }
    private UsuarioDTO Delete(Integer ID){
        EntityManager eM = new ConnectionFactory().getConnection();
        UsuarioDTO usuario = null;
        try {
            usuario = ReadByID(ID);
            //Iniciar a transação
            eM.getTransaction().begin();
            eM.remove(usuario);
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
        return usuario;
    }
    //Métodos
    /**
     * Retorna o usuário com Login e Senha iguais ao parâmetros passados.
     * Se não houver um usuário com o Login e Senha retorna null
     * 
     * @param Login O Login do usuário
     * @param Senha A Senha do usuário
     * @return Um objeto com as informações do usuário
     */
    public UsuarioDTO RetornaUsuario(String Login, String Senha){
        try{
            List<UsuarioDTO> usuarios = Read();
            if(usuarios.isEmpty()) return null;
            for(UsuarioDTO u : usuarios){
                if(u.getLogin().equals(Login) && u.getSenha().equals(Senha)) return u;
            }
            return null;
        }catch(Exception e){
            return null;
        }
    }
    
    /**
     * Cria um novo usuário.
     * Retorna uma constante que indica se foi possível ou não efetuar a operação
     * @param Login Login do Usuário
     * @param Senha Senha do Usuário
     * @return Inteiro que indica o erro ou se foi possível
     */
    public int NovoUsuario(String Login, String Senha){
        try{
            Login = Login.replace("'", "''");
            if(Login.length() > 40 || Senha.length() > 20) return 2;
            List<UsuarioDTO> usuarios = Read();
            if(!usuarios.isEmpty()) for(UsuarioDTO u : usuarios){
                if(u.getLogin().equals(Login)) return 1;
            }
            try{
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setLogin(Login);
                usuario.setSenha(Senha);
                Create(usuario);
                return 0;
            }catch(Exception e){
                return -1;
            }
        }catch(Exception e){
            return -1;
        }
    }
}
