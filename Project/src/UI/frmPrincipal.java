package UI;

import BLL.ProjetoBLL;
import DTO.FazendoDTO;
import DTO.FeitoDTO;
import DTO.ParaFazerDTO;
import DTO.ProjetoDTO;
import DTO.UsuarioDTO;
import javax.swing.JOptionPane;

public class frmPrincipal extends javax.swing.JFrame {
    //Atributos
    pnlLogin pnllogin;
    UsuarioDTO usuario;
    ProjetoDTO projeto;
    //Construtor
    public frmPrincipal() {
        initComponents();
        itmLogout.setEnabled(false);
        itmExcluirProjeto.setEnabled(false);
        Login();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLayout = new javax.swing.JPanel();
        crdDefault = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuEntrada = new javax.swing.JMenu();
        itmLogin = new javax.swing.JMenuItem();
        itmLogout = new javax.swing.JMenuItem();
        mnuProjeto = new javax.swing.JMenu();
        itmNovoProjeto = new javax.swing.JMenuItem();
        itmExcluirProjeto = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        itmNovoUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Projetos");
        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(2000, 2000));
        setMinimumSize(new java.awt.Dimension(20, 20));
        setResizable(false);

        pnlLayout.setMaximumSize(new java.awt.Dimension(2000, 2000));
        pnlLayout.setMinimumSize(new java.awt.Dimension(20, 20));
        pnlLayout.setPreferredSize(new java.awt.Dimension(1200, 638));
        pnlLayout.setLayout(new java.awt.CardLayout());

        crdDefault.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout crdDefaultLayout = new javax.swing.GroupLayout(crdDefault);
        crdDefault.setLayout(crdDefaultLayout);
        crdDefaultLayout.setHorizontalGroup(
            crdDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        crdDefaultLayout.setVerticalGroup(
            crdDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        pnlLayout.add(crdDefault, "card2");

        mnuEntrada.setText("Entrada");

        itmLogin.setText("Login");
        itmLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLoginActionPerformed(evt);
            }
        });
        mnuEntrada.add(itmLogin);

        itmLogout.setText("Logout");
        itmLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLogoutActionPerformed(evt);
            }
        });
        mnuEntrada.add(itmLogout);

        jMenuBar1.add(mnuEntrada);

        mnuProjeto.setText("Projeto");

        itmNovoProjeto.setText("Novo Projeto");
        itmNovoProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmNovoProjetoActionPerformed(evt);
            }
        });
        mnuProjeto.add(itmNovoProjeto);

        itmExcluirProjeto.setText("Excluir Projeto");
        itmExcluirProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirProjetoActionPerformed(evt);
            }
        });
        mnuProjeto.add(itmExcluirProjeto);

        jMenuBar1.add(mnuProjeto);

        mnuUsuario.setText("Usuário");

        itmNovoUsuario.setText("Novo Usuário");
        itmNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmNovoUsuarioActionPerformed(evt);
            }
        });
        mnuUsuario.add(itmNovoUsuario);

        jMenuBar1.add(mnuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLoginActionPerformed
        this.usuario = null;
        this.projeto = null;
        Login();
    }//GEN-LAST:event_itmLoginActionPerformed

    private void itmLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLogoutActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Deseja fazer Logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);
        if(op == JOptionPane.OK_OPTION){
            this.usuario = null;
            this.projeto = null;
            this.setTitle("Gerenciador de Projetos");
            itmLogin.setEnabled(true);
            itmLogout.setEnabled(false);
            itmExcluirProjeto.setEnabled(false);
            itmNovoProjeto.setEnabled(true);
            itmNovoUsuario.setEnabled(true);
            Login();
        }
    }//GEN-LAST:event_itmLogoutActionPerformed

    private void itmNovoProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNovoProjetoActionPerformed
        pnlLayout.removeAll();
        pnlLayout.add(new pnlNovoProjeto(this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }//GEN-LAST:event_itmNovoProjetoActionPerformed

    private void itmNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNovoUsuarioActionPerformed
        pnlLayout.removeAll();
        pnlLayout.add(new pnlNovoUsuario(this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }//GEN-LAST:event_itmNovoUsuarioActionPerformed

    private void itmExcluirProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExcluirProjetoActionPerformed
        if(projeto != null && usuario != null){
            if(projeto.getGerente() == usuario.getID()){
                int op = JOptionPane.showConfirmDialog(this, "Deseja excluir esse projeto ?", "Excluir Projeto", JOptionPane.OK_CANCEL_OPTION);
                if(op == JOptionPane.OK_OPTION){
                    ProjetoBLL bll = new ProjetoBLL();
                    if(bll.ExcluirProjeto(projeto)){
                        ExcluirProjeto();
                        JOptionPane.showMessageDialog(this, "Projeto excluido", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Verifique a conexão com o banco de dados", "Erro Desconhecido", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Apenas gerentes podem excluir projetos", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Verifique a conexão com o banco de dados", "Erro Desconhecido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itmExcluirProjetoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    public void Login(){
        pnllogin = new pnlLogin(this);
        pnlLayout.removeAll();
        pnlLayout.add(pnllogin);
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void ConfirmarLogin(UsuarioDTO usuario, ProjetoDTO projeto){
        this.usuario = usuario;
        this.projeto = projeto;
        itmLogin.setEnabled(false);
        itmLogout.setEnabled(true);
        itmExcluirProjeto.setEnabled(true);
        itmNovoProjeto.setEnabled(false);
        itmNovoUsuario.setEnabled(false);
        pnlLayout.removeAll();
        pnlLayout.add(new pnlInicio(this, usuario, projeto));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void CriaParaFazer(UsuarioDTO usuario, ProjetoDTO projeto){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlNovaTarefaParaFazer(usuario, projeto, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void ExpandirParaFazer(UsuarioDTO usuario, ProjetoDTO projeto, ParaFazerDTO paraFazer){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlExpandirParaFazer(this, usuario, projeto, paraFazer));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void EditarParaFazer(UsuarioDTO usuario, ProjetoDTO projeto, ParaFazerDTO paraFazer){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlEditarTarefaParaFazer(usuario, projeto, paraFazer, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void CriaFazendo(UsuarioDTO usuario, ProjetoDTO projeto){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlNovaTarefaFazendo(usuario, projeto, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void ExpandirFazendo(UsuarioDTO usuario, ProjetoDTO projeto, FazendoDTO fazendo){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlExpandirFazendo(usuario, projeto, fazendo, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void EditarFazendo(UsuarioDTO usuario, ProjetoDTO projeto, FazendoDTO fazendo){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlEditarTarefaFazendo(usuario, projeto, fazendo, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void CriaFeito(UsuarioDTO usuario, ProjetoDTO projeto){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlNovaTarefaFeito(usuario, projeto, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void ExpandirFeito(UsuarioDTO usuario, ProjetoDTO projeto, FeitoDTO feito){
        pnlLayout.removeAll();
        pnlLayout.add(new pnlExpandirFeito(usuario, projeto, feito, this));
        pnlLayout.repaint();
        pnlLayout.revalidate();
    }
    
    public void ExcluirProjeto(){
        this.usuario = null;
        this.projeto = null;
        itmLogin.setEnabled(true);
        itmLogout.setEnabled(false);
        itmExcluirProjeto.setEnabled(false);
        itmNovoProjeto.setEnabled(true);
        itmNovoUsuario.setEnabled(true);
        Login();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel crdDefault;
    private javax.swing.JMenuItem itmExcluirProjeto;
    private javax.swing.JMenuItem itmLogin;
    private javax.swing.JMenuItem itmLogout;
    private javax.swing.JMenuItem itmNovoProjeto;
    private javax.swing.JMenuItem itmNovoUsuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuEntrada;
    private javax.swing.JMenu mnuProjeto;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JPanel pnlLayout;
    // End of variables declaration//GEN-END:variables
}
