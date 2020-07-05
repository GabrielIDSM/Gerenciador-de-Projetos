package UI;

import BLL.FazendoBLL;
import BLL.FeitoBLL;
import BLL.ParaFazerBLL;
import DTO.FazendoDTO;
import DTO.FeitoDTO;
import DTO.ParaFazerDTO;
import DTO.ProjetoDTO;
import DTO.UsuarioDTO;
import UTILIT.Datas;
import java.util.List;

public class pnlInicio extends javax.swing.JPanel {
    //Atributos
    frmPrincipal principal;
    UsuarioDTO usuario;
    ProjetoDTO projeto;
    //PF
    ParaFazerBLL paraFazerBll = new ParaFazerBLL();
    List<ParaFazerDTO> paraFazerList;
    int nDePaginasPF = 1;
    int paginaAtualPF = 1;
    //F
    FazendoBLL fazendoBll = new FazendoBLL();
    List<FazendoDTO> fazendoList;
    int nDePaginasF = 1;
    int paginaAtualF = 1;      
    //Ft
    FeitoBLL feitoBll = new FeitoBLL();
    List<FeitoDTO> feitoList;
    int nDePaginasFt = 1;
    int paginaAtualFt = 1;
    //Construtor
    public pnlInicio(frmPrincipal principal, UsuarioDTO usuario, ProjetoDTO projeto) {
        this.principal = principal;
        this.usuario = usuario;
        this.projeto = projeto;
        initComponents();
        //Verificar se é o gerente do projeto
        if(!(usuario.getID() == projeto.getGerente())) btnNovaFeito.setEnabled(false);
        //Modificar nome do Frame
        principal.setTitle("Gerenciador de Projetos - " + projeto.getNome());
        //Tornar paineis invisiveis
        pnlPFcard1.setVisible(false);
        pnlPFcard2.setVisible(false);
        pnlPFcard3.setVisible(false);
        pnlPFcard4.setVisible(false);
        pnlFcard1.setVisible(false);
        pnlFcard2.setVisible(false);
        pnlFcard3.setVisible(false);
        pnlFtcard1.setVisible(false);
        pnlFtcard2.setVisible(false);
        pnlFtcard3.setVisible(false);
        pnlFtcard4.setVisible(false);
        //Tornar botões desabilitados
        btnAntF.setEnabled(false);
        btnAntPF.setEnabled(false);
        btnAntFt.setEnabled(false);
        btnProxF.setEnabled(false);
        btnProxPF.setEnabled(false);
        btnProxFt.setEnabled(false);
        //Lista com tarefas para fazer
        paraFazerList = paraFazerBll.Read(projeto);
        if(!paraFazerList.isEmpty()){
            nDePaginasPF = paraFazerList.size() / 4;
            if(paraFazerList.size() % 4 != 0) nDePaginasPF++;
            DefineCardsPF(1);
        }else{
            nDePaginasPF = 0;
        }
        if(nDePaginasPF > 1) btnProxPF.setEnabled(true);
        //Lista com tarefas em execução
        fazendoList = fazendoBll.Read(projeto);
        if(!fazendoList.isEmpty()){
            nDePaginasF = fazendoList.size() / 3;
            if(fazendoList.size() % 3 != 0) nDePaginasF++;
            DefineCardsF(1);
        }else{
            nDePaginasF = 0;
        }
        if(nDePaginasF > 1) btnProxF.setEnabled(true);
        //Lista com tarefas feitas
        feitoList = feitoBll.Read(projeto);
        if(!feitoList.isEmpty()){
            nDePaginasFt = feitoList.size() / 4;
            if(feitoList.size() % 4 != 0) nDePaginasFt++;
            DefineCardsFt(1);
        }else{
            nDePaginasFt = 0;
        }
        if(nDePaginasFt > 1) btnProxFt.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlParaFazer = new javax.swing.JPanel();
        btnNovaParaFazer = new javax.swing.JButton();
        pnlPFcard1 = new javax.swing.JPanel();
        lbTituloPFcard1 = new javax.swing.JLabel();
        btnPFcard1 = new javax.swing.JButton();
        pnlPFcard2 = new javax.swing.JPanel();
        lbTituloPFcard2 = new javax.swing.JLabel();
        btnPFcard2 = new javax.swing.JButton();
        pnlPFcard3 = new javax.swing.JPanel();
        lbTituloPFcard3 = new javax.swing.JLabel();
        btnPFcard3 = new javax.swing.JButton();
        pnlPFcard4 = new javax.swing.JPanel();
        lbTituloPFcard4 = new javax.swing.JLabel();
        btnPFcard4 = new javax.swing.JButton();
        btnProxPF = new javax.swing.JButton();
        btnAntPF = new javax.swing.JButton();
        pnlFazendo = new javax.swing.JPanel();
        btnNovaFazendo = new javax.swing.JButton();
        btnAntF = new javax.swing.JButton();
        pnlFcard1 = new javax.swing.JPanel();
        lbTituloFcard1 = new javax.swing.JLabel();
        btnFcard1 = new javax.swing.JButton();
        lbDataFcard1 = new javax.swing.JLabel();
        lbEstcard1 = new javax.swing.JLabel();
        lbEstagioFcard1 = new javax.swing.JLabel();
        pnlFcard2 = new javax.swing.JPanel();
        lbTituloFcard2 = new javax.swing.JLabel();
        btnFcard2 = new javax.swing.JButton();
        lbDataFcard2 = new javax.swing.JLabel();
        lbEstcard2 = new javax.swing.JLabel();
        lbEstagioFcard2 = new javax.swing.JLabel();
        pnlFcard3 = new javax.swing.JPanel();
        lbTituloFcard3 = new javax.swing.JLabel();
        btnFcard3 = new javax.swing.JButton();
        lbDataFcard3 = new javax.swing.JLabel();
        lbEstcard3 = new javax.swing.JLabel();
        lbEstagioFcard3 = new javax.swing.JLabel();
        btnProxF = new javax.swing.JButton();
        pnlFeito = new javax.swing.JPanel();
        btnNovaFeito = new javax.swing.JButton();
        btnAntFt = new javax.swing.JButton();
        pnlFtcard1 = new javax.swing.JPanel();
        lbTituloFtcard1 = new javax.swing.JLabel();
        btnFtcard1 = new javax.swing.JButton();
        pnlFtcard2 = new javax.swing.JPanel();
        lbTituloFtcard2 = new javax.swing.JLabel();
        btnFtcard2 = new javax.swing.JButton();
        pnlFtcard3 = new javax.swing.JPanel();
        lbTituloFtcard3 = new javax.swing.JLabel();
        btnFtcard3 = new javax.swing.JButton();
        pnlFtcard4 = new javax.swing.JPanel();
        lbTituloFtcard4 = new javax.swing.JLabel();
        btnFtcard4 = new javax.swing.JButton();
        btnProxFt = new javax.swing.JButton();
        lbParaFazer = new javax.swing.JLabel();
        lbFazendo = new javax.swing.JLabel();
        lbFeito = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(1200, 638));
        setMinimumSize(new java.awt.Dimension(1200, 638));
        setPreferredSize(new java.awt.Dimension(1200, 638));

        pnlParaFazer.setBackground(new java.awt.Color(255, 255, 255));
        pnlParaFazer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        pnlParaFazer.setMaximumSize(new java.awt.Dimension(388, 3000));
        pnlParaFazer.setMinimumSize(new java.awt.Dimension(388, 10));
        pnlParaFazer.setPreferredSize(new java.awt.Dimension(388, 554));

        btnNovaParaFazer.setBackground(new java.awt.Color(153, 255, 153));
        btnNovaParaFazer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovaParaFazer.setText("+");
        btnNovaParaFazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaParaFazerActionPerformed(evt);
            }
        });

        pnlPFcard1.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloPFcard1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloPFcard1.setText("Título");
        lbTituloPFcard1.setMaximumSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard1.setMinimumSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard1.setPreferredSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard1.setRequestFocusEnabled(false);

        btnPFcard1.setBackground(new java.awt.Color(204, 204, 255));
        btnPFcard1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnPFcard1.setText("Expandir");
        btnPFcard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPFcard1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPFcard1Layout = new javax.swing.GroupLayout(pnlPFcard1);
        pnlPFcard1.setLayout(pnlPFcard1Layout);
        pnlPFcard1Layout.setHorizontalGroup(
            pnlPFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloPFcard1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPFcard1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPFcard1Layout.setVerticalGroup(
            pnlPFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloPFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPFcard2.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloPFcard2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloPFcard2.setText("Título");
        lbTituloPFcard2.setMaximumSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard2.setMinimumSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard2.setPreferredSize(new java.awt.Dimension(340, 30));

        btnPFcard2.setBackground(new java.awt.Color(204, 204, 255));
        btnPFcard2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnPFcard2.setText("Expandir");
        btnPFcard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPFcard2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPFcard2Layout = new javax.swing.GroupLayout(pnlPFcard2);
        pnlPFcard2.setLayout(pnlPFcard2Layout);
        pnlPFcard2Layout.setHorizontalGroup(
            pnlPFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloPFcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPFcard2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPFcard2Layout.setVerticalGroup(
            pnlPFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloPFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlPFcard3.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloPFcard3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloPFcard3.setText("Título");
        lbTituloPFcard3.setMaximumSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard3.setMinimumSize(new java.awt.Dimension(340, 30));
        lbTituloPFcard3.setPreferredSize(new java.awt.Dimension(340, 30));

        btnPFcard3.setBackground(new java.awt.Color(204, 204, 255));
        btnPFcard3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnPFcard3.setText("Expandir");
        btnPFcard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPFcard3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPFcard3Layout = new javax.swing.GroupLayout(pnlPFcard3);
        pnlPFcard3.setLayout(pnlPFcard3Layout);
        pnlPFcard3Layout.setHorizontalGroup(
            pnlPFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloPFcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPFcard3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPFcard3Layout.setVerticalGroup(
            pnlPFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloPFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPFcard3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlPFcard4.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloPFcard4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloPFcard4.setText("Título");

        btnPFcard4.setBackground(new java.awt.Color(204, 204, 255));
        btnPFcard4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnPFcard4.setText("Expandir");
        btnPFcard4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPFcard4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPFcard4Layout = new javax.swing.GroupLayout(pnlPFcard4);
        pnlPFcard4.setLayout(pnlPFcard4Layout);
        pnlPFcard4Layout.setHorizontalGroup(
            pnlPFcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPFcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloPFcard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPFcard4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPFcard4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlPFcard4Layout.setVerticalGroup(
            pnlPFcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPFcard4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloPFcard4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPFcard4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnProxPF.setBackground(new java.awt.Color(204, 204, 255));
        btnProxPF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnProxPF.setText("Próxima");
        btnProxPF.setMaximumSize(new java.awt.Dimension(100, 50));
        btnProxPF.setMinimumSize(new java.awt.Dimension(100, 10));
        btnProxPF.setPreferredSize(new java.awt.Dimension(100, 30));
        btnProxPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxPFActionPerformed(evt);
            }
        });

        btnAntPF.setBackground(new java.awt.Color(204, 204, 255));
        btnAntPF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAntPF.setText("Anterior");
        btnAntPF.setMaximumSize(new java.awt.Dimension(100, 50));
        btnAntPF.setMinimumSize(new java.awt.Dimension(100, 10));
        btnAntPF.setPreferredSize(new java.awt.Dimension(100, 30));
        btnAntPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlParaFazerLayout = new javax.swing.GroupLayout(pnlParaFazer);
        pnlParaFazer.setLayout(pnlParaFazerLayout);
        pnlParaFazerLayout.setHorizontalGroup(
            pnlParaFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParaFazerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParaFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPFcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovaParaFazer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPFcard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlParaFazerLayout.createSequentialGroup()
                        .addComponent(btnAntPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(btnProxPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlPFcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPFcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        pnlParaFazerLayout.setVerticalGroup(
            pnlParaFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParaFazerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovaParaFazer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(pnlPFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(pnlPFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(pnlPFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(pnlPFcard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(pnlParaFazerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAntPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlFazendo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFazendo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        pnlFazendo.setMaximumSize(new java.awt.Dimension(3000, 3000));
        pnlFazendo.setMinimumSize(new java.awt.Dimension(10, 10));
        pnlFazendo.setPreferredSize(new java.awt.Dimension(388, 554));

        btnNovaFazendo.setBackground(new java.awt.Color(153, 255, 153));
        btnNovaFazendo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovaFazendo.setText("+");
        btnNovaFazendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaFazendoActionPerformed(evt);
            }
        });

        btnAntF.setBackground(new java.awt.Color(204, 204, 255));
        btnAntF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAntF.setText("Anterior");
        btnAntF.setMaximumSize(new java.awt.Dimension(100, 50));
        btnAntF.setMinimumSize(new java.awt.Dimension(100, 10));
        btnAntF.setPreferredSize(new java.awt.Dimension(100, 30));
        btnAntF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntFActionPerformed(evt);
            }
        });

        pnlFcard1.setBackground(new java.awt.Color(255, 255, 255));
        pnlFcard1.setPreferredSize(new java.awt.Dimension(360, 125));

        lbTituloFcard1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFcard1.setText("Título");
        lbTituloFcard1.setMaximumSize(new java.awt.Dimension(340, 30));
        lbTituloFcard1.setMinimumSize(new java.awt.Dimension(340, 30));
        lbTituloFcard1.setPreferredSize(new java.awt.Dimension(340, 30));

        btnFcard1.setBackground(new java.awt.Color(204, 204, 255));
        btnFcard1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFcard1.setText("Expandir");
        btnFcard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFcard1ActionPerformed(evt);
            }
        });

        lbDataFcard1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDataFcard1.setText("Conclusão prevista para: ");

        lbEstcard1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbEstcard1.setText("Estágio:");

        lbEstagioFcard1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbEstagioFcard1.setText("Estágio");

        javax.swing.GroupLayout pnlFcard1Layout = new javax.swing.GroupLayout(pnlFcard1);
        pnlFcard1.setLayout(pnlFcard1Layout);
        pnlFcard1Layout.setHorizontalGroup(
            pnlFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFcard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlFcard1Layout.createSequentialGroup()
                        .addGroup(pnlFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstagioFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbDataFcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFcard1Layout.setVerticalGroup(
            pnlFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFcard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDataFcard1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFcard1Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(btnFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFcard1Layout.createSequentialGroup()
                        .addComponent(lbEstcard1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstagioFcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlFcard2.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloFcard2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFcard2.setText("Título");

        btnFcard2.setBackground(new java.awt.Color(204, 204, 255));
        btnFcard2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFcard2.setText("Expandir");
        btnFcard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFcard2ActionPerformed(evt);
            }
        });

        lbDataFcard2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDataFcard2.setText("Conclusão prevista para: ");

        lbEstcard2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbEstcard2.setText("Estágio:");

        lbEstagioFcard2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbEstagioFcard2.setText("Estágio");

        javax.swing.GroupLayout pnlFcard2Layout = new javax.swing.GroupLayout(pnlFcard2);
        pnlFcard2.setLayout(pnlFcard2Layout);
        pnlFcard2Layout.setHorizontalGroup(
            pnlFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFcard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFcard2Layout.createSequentialGroup()
                        .addGroup(pnlFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstagioFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbDataFcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFcard2Layout.setVerticalGroup(
            pnlFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFcard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDataFcard2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFcard2Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(btnFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFcard2Layout.createSequentialGroup()
                        .addComponent(lbEstcard2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstagioFcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlFcard3.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloFcard3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFcard3.setText("Título");

        btnFcard3.setBackground(new java.awt.Color(204, 204, 255));
        btnFcard3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFcard3.setText("Expandir");
        btnFcard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFcard3ActionPerformed(evt);
            }
        });

        lbDataFcard3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbDataFcard3.setText("Previsão de conclusão: ");

        lbEstcard3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbEstcard3.setText("Estágio:");

        lbEstagioFcard3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbEstagioFcard3.setText("Estágio");

        javax.swing.GroupLayout pnlFcard3Layout = new javax.swing.GroupLayout(pnlFcard3);
        pnlFcard3.setLayout(pnlFcard3Layout);
        pnlFcard3Layout.setHorizontalGroup(
            pnlFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFcard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFcard3Layout.createSequentialGroup()
                        .addGroup(pnlFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstagioFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbDataFcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFcard3Layout.setVerticalGroup(
            pnlFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFcard3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDataFcard3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFcard3Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(btnFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFcard3Layout.createSequentialGroup()
                        .addComponent(lbEstcard3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEstagioFcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnProxF.setBackground(new java.awt.Color(204, 204, 255));
        btnProxF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnProxF.setText("Próxima");
        btnProxF.setMaximumSize(new java.awt.Dimension(100, 50));
        btnProxF.setMinimumSize(new java.awt.Dimension(100, 10));
        btnProxF.setPreferredSize(new java.awt.Dimension(100, 30));
        btnProxF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFazendoLayout = new javax.swing.GroupLayout(pnlFazendo);
        pnlFazendo.setLayout(pnlFazendoLayout);
        pnlFazendoLayout.setHorizontalGroup(
            pnlFazendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFazendoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFazendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovaFazendo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFazendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlFazendoLayout.createSequentialGroup()
                            .addComponent(btnAntF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(btnProxF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlFazendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlFcard3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFcard1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFcard2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        pnlFazendoLayout.setVerticalGroup(
            pnlFazendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFazendoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovaFazendo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(pnlFcard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(pnlFcard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(pnlFcard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnlFazendoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAntF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlFeito.setBackground(new java.awt.Color(255, 255, 255));
        pnlFeito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        pnlFeito.setMaximumSize(new java.awt.Dimension(3000, 3000));
        pnlFeito.setMinimumSize(new java.awt.Dimension(10, 10));
        pnlFeito.setPreferredSize(new java.awt.Dimension(388, 554));

        btnNovaFeito.setBackground(new java.awt.Color(153, 255, 153));
        btnNovaFeito.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovaFeito.setText("+");
        btnNovaFeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaFeitoActionPerformed(evt);
            }
        });

        btnAntFt.setBackground(new java.awt.Color(204, 204, 255));
        btnAntFt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAntFt.setText("Anterior");
        btnAntFt.setMaximumSize(new java.awt.Dimension(100, 50));
        btnAntFt.setMinimumSize(new java.awt.Dimension(100, 10));
        btnAntFt.setPreferredSize(new java.awt.Dimension(100, 30));
        btnAntFt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntFtActionPerformed(evt);
            }
        });

        pnlFtcard1.setBackground(new java.awt.Color(255, 255, 255));
        pnlFtcard1.setMaximumSize(new java.awt.Dimension(360, 93));
        pnlFtcard1.setMinimumSize(new java.awt.Dimension(360, 93));
        pnlFtcard1.setPreferredSize(new java.awt.Dimension(360, 93));

        lbTituloFtcard1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFtcard1.setText("Título");

        btnFtcard1.setBackground(new java.awt.Color(204, 204, 255));
        btnFtcard1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFtcard1.setText("Expandir");
        btnFtcard1.setMaximumSize(new java.awt.Dimension(100, 35));
        btnFtcard1.setMinimumSize(new java.awt.Dimension(100, 35));
        btnFtcard1.setPreferredSize(new java.awt.Dimension(100, 35));
        btnFtcard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFtcard1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFtcard1Layout = new javax.swing.GroupLayout(pnlFtcard1);
        pnlFtcard1.setLayout(pnlFtcard1Layout);
        pnlFtcard1Layout.setHorizontalGroup(
            pnlFtcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFtcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFtcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFtcard1Layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(btnFtcard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFtcard1Layout.setVerticalGroup(
            pnlFtcard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFtcard1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFtcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlFtcard2.setBackground(new java.awt.Color(255, 255, 255));
        pnlFtcard2.setMaximumSize(new java.awt.Dimension(360, 94));
        pnlFtcard2.setMinimumSize(new java.awt.Dimension(360, 94));
        pnlFtcard2.setPreferredSize(new java.awt.Dimension(360, 93));

        lbTituloFtcard2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFtcard2.setText("Título");

        btnFtcard2.setBackground(new java.awt.Color(204, 204, 255));
        btnFtcard2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFtcard2.setText("Expandir");
        btnFtcard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFtcard2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFtcard2Layout = new javax.swing.GroupLayout(pnlFtcard2);
        pnlFtcard2.setLayout(pnlFtcard2Layout);
        pnlFtcard2Layout.setHorizontalGroup(
            pnlFtcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFtcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFtcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFtcard2Layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(btnFtcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFtcard2Layout.setVerticalGroup(
            pnlFtcard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFtcard2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFtcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlFtcard3.setBackground(new java.awt.Color(255, 255, 255));
        pnlFtcard3.setMaximumSize(new java.awt.Dimension(360, 94));
        pnlFtcard3.setMinimumSize(new java.awt.Dimension(360, 94));
        pnlFtcard3.setPreferredSize(new java.awt.Dimension(360, 93));

        lbTituloFtcard3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFtcard3.setText("Título");

        btnFtcard3.setBackground(new java.awt.Color(204, 204, 255));
        btnFtcard3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFtcard3.setText("Expandir");
        btnFtcard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFtcard3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFtcard3Layout = new javax.swing.GroupLayout(pnlFtcard3);
        pnlFtcard3.setLayout(pnlFtcard3Layout);
        pnlFtcard3Layout.setHorizontalGroup(
            pnlFtcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFtcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFtcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFtcard3Layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(btnFtcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFtcard3Layout.setVerticalGroup(
            pnlFtcard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFtcard3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFtcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlFtcard4.setBackground(new java.awt.Color(255, 255, 255));
        pnlFtcard4.setMaximumSize(new java.awt.Dimension(360, 94));
        pnlFtcard4.setMinimumSize(new java.awt.Dimension(360, 94));
        pnlFtcard4.setPreferredSize(new java.awt.Dimension(360, 93));

        lbTituloFtcard4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbTituloFtcard4.setText("Título");

        btnFtcard4.setBackground(new java.awt.Color(204, 204, 255));
        btnFtcard4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnFtcard4.setText("Expandir");
        btnFtcard4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFtcard4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFtcard4Layout = new javax.swing.GroupLayout(pnlFtcard4);
        pnlFtcard4.setLayout(pnlFtcard4Layout);
        pnlFtcard4Layout.setHorizontalGroup(
            pnlFtcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFtcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTituloFtcard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFtcard4Layout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(btnFtcard4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlFtcard4Layout.setVerticalGroup(
            pnlFtcard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFtcard4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloFtcard4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFtcard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnProxFt.setBackground(new java.awt.Color(204, 204, 255));
        btnProxFt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnProxFt.setText("Próxima");
        btnProxFt.setMaximumSize(new java.awt.Dimension(100, 50));
        btnProxFt.setMinimumSize(new java.awt.Dimension(100, 10));
        btnProxFt.setPreferredSize(new java.awt.Dimension(100, 30));
        btnProxFt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxFtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFeitoLayout = new javax.swing.GroupLayout(pnlFeito);
        pnlFeito.setLayout(pnlFeitoLayout);
        pnlFeitoLayout.setHorizontalGroup(
            pnlFeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFeitoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlFeitoLayout.createSequentialGroup()
                            .addComponent(btnAntFt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(btnProxFt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlFeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlFtcard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlFtcard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlFtcard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlFtcard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnNovaFeito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        pnlFeitoLayout.setVerticalGroup(
            pnlFeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFeitoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnNovaFeito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFtcard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(pnlFtcard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(pnlFtcard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlFtcard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(pnlFeitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAntFt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxFt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbParaFazer.setFont(new java.awt.Font("Script MT Bold", 0, 36)); // NOI18N
        lbParaFazer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbParaFazer.setText("Para Fazer");

        lbFazendo.setFont(new java.awt.Font("Script MT Bold", 0, 36)); // NOI18N
        lbFazendo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFazendo.setText("Fazendo");

        lbFeito.setFont(new java.awt.Font("Script MT Bold", 0, 36)); // NOI18N
        lbFeito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFeito.setText("Feito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbParaFazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlParaFazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFazendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFazendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFeito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbParaFazer, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(lbFazendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFeito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlParaFazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFazendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFeito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAntPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntPFActionPerformed
        paginaAtualPF--;
        if(paginaAtualPF == 1) btnAntPF.setEnabled(false);
        btnProxPF.setEnabled(true);
        DefineCardsPF(paginaAtualPF);
    }//GEN-LAST:event_btnAntPFActionPerformed

    private void btnProxPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxPFActionPerformed
        paginaAtualPF++;
        if(paginaAtualPF == nDePaginasPF) btnProxPF.setEnabled(false);
        btnAntPF.setEnabled(true);
        DefineCardsPF(paginaAtualPF);
    }//GEN-LAST:event_btnProxPFActionPerformed

    private void btnNovaParaFazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaParaFazerActionPerformed
        principal.CriaParaFazer(usuario, projeto);
    }//GEN-LAST:event_btnNovaParaFazerActionPerformed

    private void btnPFcard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPFcard1ActionPerformed
        //determinar o index inicial do array
        int index = 0 + ((paginaAtualPF - 1) * 4);
        principal.ExpandirParaFazer(usuario, projeto, paraFazerList.get(index));
    }//GEN-LAST:event_btnPFcard1ActionPerformed

    private void btnPFcard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPFcard2ActionPerformed
        //determinar o index inicial do array
        int index = 1 + ((paginaAtualPF - 1) * 4);
        principal.ExpandirParaFazer(usuario, projeto, paraFazerList.get(index));
    }//GEN-LAST:event_btnPFcard2ActionPerformed

    private void btnPFcard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPFcard3ActionPerformed
        //determinar o index inicial do array
        int index = 2 + ((paginaAtualPF - 1) * 4);
        principal.ExpandirParaFazer(usuario, projeto, paraFazerList.get(index));
    }//GEN-LAST:event_btnPFcard3ActionPerformed

    private void btnPFcard4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPFcard4ActionPerformed
        //determinar o index inicial do array
        int index = 3 + ((paginaAtualPF - 1) * 4);
        principal.ExpandirParaFazer(usuario, projeto, paraFazerList.get(index));
    }//GEN-LAST:event_btnPFcard4ActionPerformed

    private void btnAntFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntFActionPerformed
        paginaAtualF--;
        if(paginaAtualF == 1) btnAntF.setEnabled(false);
        btnProxF.setEnabled(true);
        DefineCardsF(paginaAtualF);
    }//GEN-LAST:event_btnAntFActionPerformed

    private void btnProxFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxFActionPerformed
        paginaAtualF++;
        if(paginaAtualF == nDePaginasF) btnProxF.setEnabled(false);
        btnAntF.setEnabled(true);
        DefineCardsF(paginaAtualF);
    }//GEN-LAST:event_btnProxFActionPerformed

    private void btnNovaFazendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaFazendoActionPerformed
        principal.CriaFazendo(usuario, projeto);
    }//GEN-LAST:event_btnNovaFazendoActionPerformed

    private void btnFcard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFcard1ActionPerformed
        //determinar o index inicial do array
        int index = 0 + ((paginaAtualF - 1) * 3);
        principal.ExpandirFazendo(usuario, projeto, fazendoList.get(index));
    }//GEN-LAST:event_btnFcard1ActionPerformed

    private void btnFcard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFcard2ActionPerformed
        //determinar o index inicial do array
        int index = 1 + ((paginaAtualF - 1) * 3);
        principal.ExpandirFazendo(usuario, projeto, fazendoList.get(index));
    }//GEN-LAST:event_btnFcard2ActionPerformed

    private void btnFcard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFcard3ActionPerformed
       //determinar o index inicial do array
        int index = 2 + ((paginaAtualF - 1) * 3);
        principal.ExpandirFazendo(usuario, projeto, fazendoList.get(index));
    }//GEN-LAST:event_btnFcard3ActionPerformed

    private void btnNovaFeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaFeitoActionPerformed
        principal.CriaFeito(usuario, projeto);
    }//GEN-LAST:event_btnNovaFeitoActionPerformed

    private void btnAntFtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntFtActionPerformed
        paginaAtualFt--;
        if(paginaAtualFt == 1) btnAntFt.setEnabled(false);
        btnProxFt.setEnabled(true);
        DefineCardsFt(paginaAtualFt);
    }//GEN-LAST:event_btnAntFtActionPerformed

    private void btnProxFtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxFtActionPerformed
        paginaAtualFt++;
        if(paginaAtualFt == nDePaginasFt) btnProxFt.setEnabled(false);
        btnAntFt.setEnabled(true);
        DefineCardsFt(paginaAtualFt);
    }//GEN-LAST:event_btnProxFtActionPerformed

    private void btnFtcard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFtcard1ActionPerformed
        //determinar o index inicial do array
        int index = 0 + ((paginaAtualFt - 1) * 4);
        principal.ExpandirFeito(usuario, projeto, feitoList.get(index));
    }//GEN-LAST:event_btnFtcard1ActionPerformed

    private void btnFtcard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFtcard2ActionPerformed
        //determinar o index inicial do array
        int index = 1 + ((paginaAtualFt - 1) * 4);
        principal.ExpandirFeito(usuario, projeto, feitoList.get(index));
    }//GEN-LAST:event_btnFtcard2ActionPerformed

    private void btnFtcard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFtcard3ActionPerformed
        //determinar o index inicial do array
        int index = 2 + ((paginaAtualFt - 1) * 4);
        principal.ExpandirFeito(usuario, projeto, feitoList.get(index));
    }//GEN-LAST:event_btnFtcard3ActionPerformed

    private void btnFtcard4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFtcard4ActionPerformed
        //determinar o index inicial do array
        int index = 3 + ((paginaAtualFt - 1) * 4);
        principal.ExpandirFeito(usuario, projeto, feitoList.get(index));
    }//GEN-LAST:event_btnFtcard4ActionPerformed

    private void DefineCardsPF(int paginaAtual){
        //determinar o index inicial do array
        int index = 0 + ((paginaAtual - 1) * 4);
        //Tornar paineis invisíveis
        pnlPFcard1.setVisible(false);
        pnlPFcard2.setVisible(false);
        pnlPFcard3.setVisible(false);
        pnlPFcard4.setVisible(false);
        //Card1
        if(index + 1 <= paraFazerList.size()){
            pnlPFcard1.setVisible(true);
            MudaCorPainel(pnlPFcard1, paraFazerList.get(index).getCor());
            lbTituloPFcard1.setText(paraFazerList.get(index).getTitulo());
        }
        index++;
        //Card2
        if(index + 1 <= paraFazerList.size()){
            pnlPFcard2.setVisible(true);
            MudaCorPainel(pnlPFcard2, paraFazerList.get(index).getCor());
            lbTituloPFcard2.setText(paraFazerList.get(index).getTitulo());
        }
        index++;
        //Card3
        if(index + 1 <= paraFazerList.size()){
            pnlPFcard3.setVisible(true);
            MudaCorPainel(pnlPFcard3, paraFazerList.get(index).getCor());
            lbTituloPFcard3.setText(paraFazerList.get(index).getTitulo());
        }
        index++;
        //Card4
        if(index + 1 <= paraFazerList.size()){
            pnlPFcard4.setVisible(true);
            MudaCorPainel(pnlPFcard4, paraFazerList.get(index).getCor());
            lbTituloPFcard4.setText(paraFazerList.get(index).getTitulo());
        }
    }
    
    private void DefineCardsF(int paginaAtual){
        //determinar o index inicial do array
        int index = 0 + ((paginaAtual - 1) * 3);
        //Tornar paineis invisíveis
        pnlFcard1.setVisible(false);
        pnlFcard2.setVisible(false);
        pnlFcard3.setVisible(false);
        //Card1
        if(index + 1 <= fazendoList.size()){
            pnlFcard1.setVisible(true);
            MudaCorPainel(pnlFcard1, fazendoList.get(index).getCor());
            lbTituloFcard1.setText(fazendoList.get(index).getTitulo());
            lbDataFcard1.setText("Conclusão prevista para: "+fazendoList.get(index).getPrazo());
            lbEstagioFcard1.setText(DefineEstagio(fazendoList.get(index).getEstagio()));
        }
        index++;
        //Card2
        if(index + 1 <= fazendoList.size()){
            pnlFcard2.setVisible(true);
            MudaCorPainel(pnlFcard2, fazendoList.get(index).getCor());
            lbTituloFcard2.setText(fazendoList.get(index).getTitulo());
            lbDataFcard2.setText("Conclusão prevista para: "+fazendoList.get(index).getPrazo());
            lbEstagioFcard2.setText(DefineEstagio(fazendoList.get(index).getEstagio()));
        }
        index++;
        //Card3
        if(index + 1 <= fazendoList.size()){
            pnlFcard3.setVisible(true);
            MudaCorPainel(pnlFcard3, fazendoList.get(index).getCor());
            lbTituloFcard3.setText(fazendoList.get(index).getTitulo());
            lbDataFcard3.setText("Conclusão prevista para: "+fazendoList.get(index).getPrazo());
            lbEstagioFcard3.setText(DefineEstagio(fazendoList.get(index).getEstagio()));
        }
    }
    
    private void DefineCardsFt(int paginaAtual){
        //determinar o index inicial do array
        int index = 0 + ((paginaAtual - 1) * 4);
        //Tornar paineis invisíveis
        pnlFtcard1.setVisible(false);
        pnlFtcard2.setVisible(false);
        pnlFtcard3.setVisible(false);
        pnlFtcard4.setVisible(false);
        //Card1
        if(index + 1 <= feitoList.size()){
            pnlFtcard1.setVisible(true);
            MudaCorPainel(pnlFtcard1, feitoList.get(index).getCor());
            lbTituloFtcard1.setText(feitoList.get(index).getTitulo());
        }
        index++;
        //Card2
        if(index + 1 <= feitoList.size()){
            pnlFtcard2.setVisible(true);
            MudaCorPainel(pnlFtcard2, feitoList.get(index).getCor());
            lbTituloFtcard2.setText(feitoList.get(index).getTitulo());
        }
        index++;
        //Card3
        if(index + 1 <= feitoList.size()){
            pnlFtcard3.setVisible(true);
            MudaCorPainel(pnlFtcard3, feitoList.get(index).getCor());
            lbTituloFtcard3.setText(feitoList.get(index).getTitulo());
        }
        index++;
        //Card4
        if(index + 1 <= feitoList.size()){
            pnlFtcard4.setVisible(true);
            MudaCorPainel(pnlFtcard4, feitoList.get(index).getCor());
            lbTituloFtcard4.setText(feitoList.get(index).getTitulo());
        }
    }
    
    private void MudaCorPainel(javax.swing.JPanel Painel, int Cor){
        switch(Cor){
            case 0: //Vermelho
                Painel.setBackground(new java.awt.Color(255, 200, 200));
                break;
            case 1: //Azul
                Painel.setBackground(new java.awt.Color(200, 200, 255));
                break;
            case 2: //Verde
                Painel.setBackground(new java.awt.Color(200, 255, 200));
                break;
            case 3: //Amarelo
                Painel.setBackground(new java.awt.Color(255, 255, 180));
                break;
            default: //Cinza
                Painel.setBackground(new java.awt.Color(220, 220, 220));
                break;
        }
    }
    
    private String DefineEstagio(int Estagio){
        switch (Estagio){
            case 0:
                return "Iniciada";
            case 1:
                return "Em execução";
            case 2:
                return "Aguardando Confirmação";
            default:
                return "Erro";
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAntF;
    private javax.swing.JButton btnAntFt;
    private javax.swing.JButton btnAntPF;
    private javax.swing.JButton btnFcard1;
    private javax.swing.JButton btnFcard2;
    private javax.swing.JButton btnFcard3;
    private javax.swing.JButton btnFtcard1;
    private javax.swing.JButton btnFtcard2;
    private javax.swing.JButton btnFtcard3;
    private javax.swing.JButton btnFtcard4;
    private javax.swing.JButton btnNovaFazendo;
    private javax.swing.JButton btnNovaFeito;
    private javax.swing.JButton btnNovaParaFazer;
    private javax.swing.JButton btnPFcard1;
    private javax.swing.JButton btnPFcard2;
    private javax.swing.JButton btnPFcard3;
    private javax.swing.JButton btnPFcard4;
    private javax.swing.JButton btnProxF;
    private javax.swing.JButton btnProxFt;
    private javax.swing.JButton btnProxPF;
    private javax.swing.JLabel lbDataFcard1;
    private javax.swing.JLabel lbDataFcard2;
    private javax.swing.JLabel lbDataFcard3;
    private javax.swing.JLabel lbEstagioFcard1;
    private javax.swing.JLabel lbEstagioFcard2;
    private javax.swing.JLabel lbEstagioFcard3;
    private javax.swing.JLabel lbEstcard1;
    private javax.swing.JLabel lbEstcard2;
    private javax.swing.JLabel lbEstcard3;
    private javax.swing.JLabel lbFazendo;
    private javax.swing.JLabel lbFeito;
    private javax.swing.JLabel lbParaFazer;
    private javax.swing.JLabel lbTituloFcard1;
    private javax.swing.JLabel lbTituloFcard2;
    private javax.swing.JLabel lbTituloFcard3;
    private javax.swing.JLabel lbTituloFtcard1;
    private javax.swing.JLabel lbTituloFtcard2;
    private javax.swing.JLabel lbTituloFtcard3;
    private javax.swing.JLabel lbTituloFtcard4;
    private javax.swing.JLabel lbTituloPFcard1;
    private javax.swing.JLabel lbTituloPFcard2;
    private javax.swing.JLabel lbTituloPFcard3;
    private javax.swing.JLabel lbTituloPFcard4;
    private javax.swing.JPanel pnlFazendo;
    private javax.swing.JPanel pnlFcard1;
    private javax.swing.JPanel pnlFcard2;
    private javax.swing.JPanel pnlFcard3;
    private javax.swing.JPanel pnlFeito;
    private javax.swing.JPanel pnlFtcard1;
    private javax.swing.JPanel pnlFtcard2;
    private javax.swing.JPanel pnlFtcard3;
    private javax.swing.JPanel pnlFtcard4;
    private javax.swing.JPanel pnlPFcard1;
    private javax.swing.JPanel pnlPFcard2;
    private javax.swing.JPanel pnlPFcard3;
    private javax.swing.JPanel pnlPFcard4;
    private javax.swing.JPanel pnlParaFazer;
    // End of variables declaration//GEN-END:variables
}
