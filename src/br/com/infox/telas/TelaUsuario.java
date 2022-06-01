/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.telas;

/**
 *
 * @author eduam
 */
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;
        
public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void consultar() {
        String sql = "select * from tbusuarios where iduser = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuarioId.getText());
            rs = pst.executeQuery();
            
            if (rs.next()) {
                txtUsuarioNome.setText(rs.getString(2));
                txtUsuarioFone.setText(rs.getString(3));
                txtUsuarioLogin.setText(rs.getString(4));
                txtUsuarioSenha.setText(rs.getString(5));
                cboUsuarioPerfil.setSelectedItem(rs.getString(6));  
            } 
            else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                 limpar();
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void adicionar() {
        String sql = "insert into tbusuarios(iduser,usuario,fone,login,senha,perfil) values(?,?,?,?,?,?)";
  
                try {
                    pst = conexao.prepareStatement(sql);

                    pst.setString(1, txtUsuarioId.getText());
                    pst.setString(2, txtUsuarioNome.getText());
                    pst.setString(3, txtUsuarioFone.getText());
                    pst.setString(4, txtUsuarioLogin.getText());
                    pst.setString(5, txtUsuarioSenha.getText());
                    pst.setString(6, cboUsuarioPerfil.getSelectedItem().toString());
                    
                    if (txtUsuarioId.getText().isEmpty() || txtUsuarioNome.getText().isEmpty() || txtUsuarioLogin.getText().isEmpty()
                        || txtUsuarioSenha.getText().isEmpty() || cboUsuarioPerfil.getSelectedItem().toString().isEmpty()) { 
                            JOptionPane.showMessageDialog(null, "Os campos com asterisco são obrigatórios!");   
                    }
                    else {
                        int adicionado = pst.executeUpdate(); 
                        if(adicionado > 0) {
                            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                           limpar();
                        }
                    }
                } 
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
    }
    
    private void atualizar() {
        String sql = "update tbusuarios set usuario=?,fone=?, login=?,senha=?,perfil=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, txtUsuarioNome.getText());
            pst.setString(2, txtUsuarioFone.getText());
            pst.setString(3, txtUsuarioLogin.getText());
            pst.setString(4, txtUsuarioSenha.getText());
            pst.setString(5, cboUsuarioPerfil.getSelectedItem().toString());
            pst.setString(6, txtUsuarioId.getText());
                    
                    if (txtUsuarioId.getText().isEmpty() || txtUsuarioNome.getText().isEmpty() || txtUsuarioLogin.getText().isEmpty()
                        || txtUsuarioSenha.getText().isEmpty() || cboUsuarioPerfil.getSelectedItem().toString().isEmpty()) { 
                            JOptionPane.showMessageDialog(null, "Os campos com asterisco são obrigatórios!");   
                    }
                    else {
                        int atualizar = pst.executeUpdate(); 
                        if(atualizar > 0) {
                            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
                            limpar();
                        }
                    }        
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    private void remover() {
        int deletar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
       
        if(deletar == JOptionPane.YES_OPTION) {
            String sql = "delete from tbusuarios where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUsuarioId.getText()); 
               int deletado = pst.executeUpdate();
               if(deletado == 1) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    limpar();
               }
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    private void limpar() {
        txtUsuarioNome.setText(null);
        txtUsuarioFone.setText(null);
        txtUsuarioLogin.setText(null);
        txtUsuarioSenha.setText(null);    
    }
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuarioId = new javax.swing.JTextField();
        txtUsuarioNome = new javax.swing.JTextField();
        txtUsuarioLogin = new javax.swing.JTextField();
        txtUsuarioSenha = new javax.swing.JTextField();
        cboUsuarioPerfil = new javax.swing.JComboBox<>();
        txtUsuarioFone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnUsuarioCreate = new javax.swing.JButton();
        btnUsuarioRead = new javax.swing.JButton();
        btnUsuarioDelete = new javax.swing.JButton();
        btnUsuarioUpdate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("* Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("* Login");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("* Nome");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("* Senha");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("* Perfil");

        txtUsuarioId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioIdActionPerformed(evt);
            }
        });

        txtUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioNomeActionPerformed(evt);
            }
        });

        txtUsuarioLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioLoginActionPerformed(evt);
            }
        });

        txtUsuarioSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioSenhaActionPerformed(evt);
            }
        });

        cboUsuarioPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        txtUsuarioFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioFoneActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Fone");

        btnUsuarioCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/create.png"))); // NOI18N
        btnUsuarioCreate.setToolTipText("Adicionar");
        btnUsuarioCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuarioCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioCreateActionPerformed(evt);
            }
        });

        btnUsuarioRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/read.png"))); // NOI18N
        btnUsuarioRead.setToolTipText("Consultar");
        btnUsuarioRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioRead.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuarioRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioReadActionPerformed(evt);
            }
        });

        btnUsuarioDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/delete.png"))); // NOI18N
        btnUsuarioDelete.setToolTipText("Deletar");
        btnUsuarioDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuarioDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioDeleteActionPerformed(evt);
            }
        });

        btnUsuarioUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/infox/icones/update.png"))); // NOI18N
        btnUsuarioUpdate.setToolTipText("Atualizar");
        btnUsuarioUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarioUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuarioUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioUpdateActionPerformed(evt);
            }
        });

        jLabel7.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addComponent(txtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuarioFone, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioSenha)
                            .addComponent(txtUsuarioLogin))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnUsuarioCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnUsuarioRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnUsuarioUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnUsuarioDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUsuarioDelete, btnUsuarioRead, btnUsuarioUpdate});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUsuarioDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(txtUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtUsuarioFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))))
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cboUsuarioPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUsuarioRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsuarioCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUsuarioUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );

        btnUsuarioDelete.getAccessibleContext().setAccessibleDescription("Remover");

        setBounds(0, 0, 640, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioIdActionPerformed

    private void txtUsuarioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioNomeActionPerformed

    private void txtUsuarioLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioLoginActionPerformed

    private void txtUsuarioSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioSenhaActionPerformed

    private void txtUsuarioFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioFoneActionPerformed

    private void btnUsuarioReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioReadActionPerformed
         consultar();
    }//GEN-LAST:event_btnUsuarioReadActionPerformed

    private void btnUsuarioCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioCreateActionPerformed
         adicionar();
    }//GEN-LAST:event_btnUsuarioCreateActionPerformed

    private void btnUsuarioUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioUpdateActionPerformed
        atualizar();
    }//GEN-LAST:event_btnUsuarioUpdateActionPerformed

    private void btnUsuarioDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioDeleteActionPerformed
        remover();
    }//GEN-LAST:event_btnUsuarioDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuarioCreate;
    private javax.swing.JButton btnUsuarioDelete;
    private javax.swing.JButton btnUsuarioRead;
    private javax.swing.JButton btnUsuarioUpdate;
    private javax.swing.JComboBox<String> cboUsuarioPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtUsuarioFone;
    private javax.swing.JTextField txtUsuarioId;
    private javax.swing.JTextField txtUsuarioLogin;
    private javax.swing.JTextField txtUsuarioNome;
    private javax.swing.JTextField txtUsuarioSenha;
    // End of variables declaration//GEN-END:variables
}
