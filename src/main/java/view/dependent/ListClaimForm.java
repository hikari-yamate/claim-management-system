/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dependent;

import dao.ClaimDao;
import model.Claim;
import model.Customer;
import model.IObject;
import service.ClaimService;
import service.ClaimServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class ListClaimForm extends JFrame {

    private ClaimService claimService = new ClaimServiceImpl(new ClaimDao());
    private Customer login = Customer.builder()
            .insuranceCard("03021030301")
            .id(1L)
            .build();
    /**
     * Creates new form ListClaimForm
     */
    public ListClaimForm() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.addColumn("Exam date");
        List<Claim> claims = claimService.getAll().stream()
                        .filter(c -> c.getCardNumber().equals(login.getInsuranceCard()))
                .collect(Collectors.toList());

        loadDataToTabel(claims, jTable4);

        jButton3.addActionListener((e) -> {
            this.hide();
            new Dependent_HomeForm().show();
        });

        loadItemsForComboBox(claims, jComboBox1);


        jButton1.addActionListener((e) -> {
            String data = (String) jComboBox1.getSelectedItem();
            Long claimId = Long.valueOf(data.trim().split("-")[0].trim());
            new DetailClaimForm(claimId).show();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton3 = new JButton();
        jScrollPane4 = new JScrollPane();
        jTable4 = new JTable();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton3.setText("Close And Back To Home");

        jTable4.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Claim Id", "Claim Date", "Insuraed Person", "Card Number", "Amount", "Status"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Xem chi tiết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 993, GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }

    private void loadItemsForComboBox(List<? extends Object> list, JComboBox box){
        box.removeAllItems();
        for(Object object: list){
            box.addItem(object.toString());
        }
    }

    private void loadDataToTabel(List<? extends IObject> list, JTable table){
        ((DefaultTableModel)table.getModel()).setRowCount(0);
        for(IObject object: list){
            addRowToTable(object, table);
        }
    }
    private void addRowToTable(IObject object, JTable table){
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.addRow(object.toObject());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListClaimForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListClaimForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton jButton1;
    private JButton jButton3;
    private JComboBox<String> jComboBox1;
    private JScrollPane jScrollPane4;
    private JTable jTable4;
    // End of variables declaration                   
}
