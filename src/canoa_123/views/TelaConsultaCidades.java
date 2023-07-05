/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package canoa_123.views;

import canoa_123.Controller.CidadesController;
import canoa_123.Controller.DAO.ExceptionDAO;
import canoa_123.Models.Cidades;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class TelaConsultaCidades extends javax.swing.JPanel {

    /**
     * Creates new form TelaConsultaCidades
     */
    public TelaConsultaCidades() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisarCid = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        btnPesquisarCid1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCidade = new javax.swing.JTable();

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel3.setText("Cidade::");

        btnPesquisarCid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPesquisarCid.setText("Pesquisar");
        btnPesquisarCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCidActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel1.setText("Consultar Cidade");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel4.setText("Cidade::");

        btnPesquisarCid1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPesquisarCid1.setText("Pesquisar");
        btnPesquisarCid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCid1ActionPerformed(evt);
            }
        });

        tblCidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "LOCALIDADE", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCidade);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisarCid1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnPesquisarCid1)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCidActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        DefaultTableModel tableModel = (DefaultTableModel) tblCidade.getModel(); // SEMPRE QUE CRIAR UMA TABELA, PRECISA INSTANCIAR
        tableModel.setRowCount(0); // zera as linhas da tabela, sempre que fizer uma pesquisa, se nao colocar ele deixa todas as linhas das consultas interiores, se colocar 2 no lugar do 0 ele deixa 2
        CidadesController cidCont = new CidadesController();

        try {
            ArrayList<Cidades> cidades = cidCont.listarCidades(nome);
            cidades.forEach((Cidades cidade) -> {
                tableModel.addRow(new Object[]{cidade.getId(), cidade.getLocalidade(), cidade.getEstado()});

            });

        } catch (ExceptionDAO e) {

        }
    }//GEN-LAST:event_btnPesquisarCidActionPerformed

    private void btnPesquisarCid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCid1ActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        DefaultTableModel tableModel = (DefaultTableModel) tblCidade.getModel(); // SEMPRE QUE CRIAR UMA TABELA, PRECISA INSTANCIAR
        tableModel.setRowCount(0); // zera as linhas da tabela, sempre que fizer uma pesquisa, se nao colocar ele deixa todas as linhas das consultas interiores, se colocar 2 no lugar do 0 ele deixa 2
        CidadesController cidCont = new CidadesController();

        try {
            ArrayList<Cidades> cidades = cidCont.listarCidades(nome);
            cidades.forEach((Cidades cidade) -> {
                tableModel.addRow(new Object[]{cidade.getId(), cidade.getLocalidade(), cidade.getEstado()});

            });

        } catch (ExceptionDAO e) {

        }
    }//GEN-LAST:event_btnPesquisarCid1ActionPerformed

    private void tblCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCidadeMouseClicked
        if (evt.getClickCount() == 1) {
            Integer cidadeid = (Integer) tblCidade.getModel().getValueAt(tblCidade.getSelectedRow(), 0);
            String localidade = (String) tblCidade.getModel().getValueAt(tblCidade.getSelectedRow(), 1);
            String estado = (String) tblCidade.getModel().getValueAt(tblCidade.getSelectedRow(), 2);
            this.telacadastracidade.buscarCidade(cidadeid, localidade, estado);
            this.telacadastracidade.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tblCidadeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisarCid;
    private javax.swing.JButton btnPesquisarCid1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    // End of variables declaration//GEN-END:variables

    private class telacadastracidade {

        private static void buscarCidade(Integer cidadeid, String localidade, String estado) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public telacadastracidade() {
        }
    }
}
