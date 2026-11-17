/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tela;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GUSTAVOKNEVITZKLEINW
 */
public class frmConsultaZelador extends javax.swing.JFrame {

    private void atualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tbZelador.getModel();
        
        modelo.setRowCount(0);
        
        String sql = "SELECT * FROM zelador "
                     + "ORDER BY id";
        
        try (Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery() ){
            
            while (resultado.next()){
                modelo.addRow(new Object[]{
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("especialidade"),
                    resultado.getString("telefone"),
                    resultado.getString("email")
                });
            }
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela:\n" + erro.getMessage(),
                                          "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public frmConsultaZelador() {
        initComponents();
        
        tbZelador.setModel(new DefaultTableModel(new Object[][]{}, 
                          new String[] {"ID", "Nome", "Especialidade", "Telefone", "Email"}){
                 @Override
                 public boolean isCellEditable(int linha, int coluna){
                     return false;
                 }
                 } 
        );
        tbZelador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        atualizarTabela();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbZelador = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnLocalizar = new javax.swing.JButton();
        cmbPesquisarPor = new javax.swing.JComboBox<>();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEspecialidade = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbZelador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbZelador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbZeladorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbZelador);

        btnAtualizar.setBackground(new java.awt.Color(255, 255, 102));
        btnAtualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnAtualizar.setText("Atualizar Tabela");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnLocalizar.setBackground(new java.awt.Color(51, 255, 255));
        btnLocalizar.setForeground(new java.awt.Color(0, 0, 0));
        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        cmbPesquisarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Especialidade" }));

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Especialidade:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Email:");

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEspecialidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome))
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPesquisarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        String pesquisa = txtPesquisa.getText().trim();
        
        
        if (pesquisa.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                                        "Digite o nome ou parte do nome do zelador.", 
                                        "Pesquisa Vazia", 
                                        JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tbZelador.getModel();
        
        modelo.setRowCount(0);
        
        
        String modoPesq = cmbPesquisarPor.getSelectedItem().toString();
        String sql = "";
        if (modoPesq == "Nome"){
            sql = "SELECT * FROM zelador "
                   + "WHERE nome ILIKE ? "
                   + "ORDER BY nome"; 
        } else {
            sql = "SELECT * FROM zelador "
                   + "WHERE especialidade ILIKE ? "
                   + "ORDER BY nome"; 
        }
        
        
        try (Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)) {
            
            stmt.setString(1,"%" + pesquisa + "%");
            
            try (ResultSet resultado = stmt.executeQuery()){
                while (resultado.next()){
                    modelo.addRow(new Object [] {
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("especialidade"),
                        resultado.getString("telefone"),
                        resultado.getString("email")
                    });
                }
            }
            
            if (modelo.getRowCount() == 0){
             JOptionPane.showMessageDialog(this,
                                            "Nenhum zelador encontrado para: " + pesquisa,
                                            "Resultado da Pesquisa", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(this, 
                                            "Erro ao localizar zelador:\n" + erro.getMessage(),
                                            "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       atualizarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
                 int linha = tbZelador.getSelectedRow();
        
        if (linha == -1){
            JOptionPane.showMessageDialog(this, "Selecione um zelador para excluir!");
            return;
        }
        
        int id = Integer.parseInt(tbZelador.getValueAt(linha, 0).toString());
        
        int resposta = JOptionPane.showConfirmDialog(this,
                                                    "Deseja realmente excluir o zelador do id " + id + " do sistema?",
                                                    "Confirmar exclusão",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE);
        
        if (resposta != JOptionPane.YES_OPTION){
            return;
        }    
        
        String sql = "DELETE FROM zelador "
                   + "WHERE id = ? ";
        
        try (Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            
            int registros = stmt.executeUpdate();
            if (registros > 0) {
                JOptionPane.showMessageDialog(this,"Zelador excluido com sucesso!");
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this,"Algo deu errado! Tente novamente mais tarde.");
            }
            
        } catch(SQLException erro){
                JOptionPane.showMessageDialog(this, "Erro ao excluir Zelador: " + erro.getMessage());
        };
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        //1. Capturar a linha selecionada
        int linha = tbZelador.getSelectedRow();
        
        if (linha == -1){
            JOptionPane.showMessageDialog(this, "Selecione um zelador na tabela para alterar");
            return;
        }
        
        //2. Pegar id da linha selecionada
        // ID NÃO SERÁ ALTERADO
        int id = Integer.parseInt(tbZelador.getValueAt(linha, 0).toString());
        
        //3. Ler os novos valores digitados nos campos especie, nome, idade
        String nome = txtNome.getText().trim();
        String especialidade = txtEspecialidade.getText().trim();
        String telefone = txtTelefone.getText().trim();
        String email = txtEmail.getText().trim();
        
        //4. Validar se os campos estão preenchidos
        if (nome.isEmpty() || especialidade.isEmpty() || telefone.isEmpty() || email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nenhuma dos campos pode ser vazio! Preencha todos os campos!");
            return;
        }
       
        
        //6. Pedir confirmação antes de gravar no Banco de Dados
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente alterar esses dados do zelador de id: " + id + " no sistema?",
                                                    "Confirmar Alteração", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE );
        
        if (resposta != JOptionPane.YES_OPTION){
            return;
        }    
        
        //7. Alteramos apenas a especie, nome e idade
        // O WHERE
        String sql = "UPDATE zelador "
                   + "SET nome = ?, especialidade = ?, telefone = ?, email = ? "
                   + "WHERE id = ?";
        
        try (Connection conex = Conexao.conectar();
             PreparedStatement stmt = conex.prepareStatement(sql)){
            //8. Preencher os Parametros(?) na mesma ordem do SQL
            stmt.setString(1,nome);
            stmt.setString(2,especialidade);
            stmt.setString(3,telefone);
            stmt.setString(4,email);
            stmt.setInt(5, id);
            
            //9. Executamos a alteração no Banco de Dados
            int registros = stmt.executeUpdate();
            if (registros > 0) {
                JOptionPane.showMessageDialog(this, "Zelador alterado com sucesso!");
                atualizarTabela();
                txtID.setText("");
                txtNome.setText("");
                txtEspecialidade.setText("");
                txtTelefone.setText("");
                txtEmail.setText("");
                
            } else {
                JOptionPane.showMessageDialog(this, "Zelador não encontrado");
            }
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar zelador: " + erro.getMessage());
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tbZeladorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbZeladorMouseClicked
        
        int linha = tbZelador.getSelectedRow();
        
        if (linha == -1){
            return;
        }
        
        txtID.setText(tbZelador.getValueAt(linha, 0).toString());
        txtNome.setText(tbZelador.getValueAt(linha, 1).toString());
        txtEspecialidade.setText(tbZelador.getValueAt(linha, 2).toString());
        txtTelefone.setText(tbZelador.getValueAt(linha, 3).toString());
        txtEmail.setText(tbZelador.getValueAt(linha, 4).toString());
    }//GEN-LAST:event_tbZeladorMouseClicked

   
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultaZelador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JComboBox<String> cmbPesquisarPor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbZelador;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEspecialidade;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
