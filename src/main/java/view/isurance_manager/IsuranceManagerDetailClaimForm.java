/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.isurance_manager;

import dao.ClaimDao;
import model.Claim;
import service.ClaimService;
import service.ClaimServiceImpl;
import utils.DateTimeUtils;

/**
 *
 * @author ADMIN
 */
public class IsuranceManagerDetailClaimForm extends javax.swing.JFrame {

    private Long claimId;
    private final ClaimService claimService = new ClaimServiceImpl(new ClaimDao());

    /**
     * Creates new form DetailClaimForm
     */
    public IsuranceManagerDetailClaimForm(Long claimId) {
        this.claimId = claimId;

        initComponents();

        jButton3.addActionListener((e) -> {
            this.hide();
        });

        Claim claim = claimService.getById(this.claimId);
        jTextPane1.setText(
                String.format(
                        "Claim Id: %d\nClaimDate: %s\nInsured Person: %s\nCard Number: %s\nClaim Amount: %d" +
                                "\nStatus: %s\nReceiver Bank Name: %s\nReceiver Bank Account: %s\nNote: %s",
                        claim.getId(),
                        DateTimeUtils.format(claim.getClaimDate()),
                        claim.getInsuredPerson(),
                        claim.getCardNumber(),
                        claim.getClaimAmount(),
                        claim.getStatus(),
                        claim.getReceiverBankName(),
                        claim.getReceiverBankAccount(),
                        claim.getNote()
                )
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTextPane1);

        jButton3.setText("Close And Back To Home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration                   
}
