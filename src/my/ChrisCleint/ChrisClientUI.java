/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChrisClientUI.java
 *
 * Created on Oct 7, 2011, 3:49:47 PM
 */
package my.ChrisCleint;

import com.apple.dnssd.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 *
 * @author christophermeyer
 */
public class ChrisClientUI extends javax.swing.JFrame implements BrowseListener {

    //VARIABLE DECLARATION
    private boolean registered;
    private int listeningPort;
    private static String ServiceType = "_killerapp._tcp";

    /** Creates new form ChrisClientUI */
    public ChrisClientUI() {
        initComponents();
        try {
            DNSSD.browse(ServiceType, this);
        } catch (Exception e) {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtText = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTENER");

        jButton1.setText("jButton1");

        jScrollPane1.setViewportView(txtText);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(87, 87, 87)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChrisClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChrisClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChrisClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChrisClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ChrisClientUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtText;
    // End of variables declaration//GEN-END:variables

    @Override
//    public void serviceFound(DNSSDService browser, int flags, int ifIndex, String serviceName, String regType, String domain)
    public void serviceFound(DNSSDService dnssds, int i, int ifIndex1, String serviceName, String regType, String domain) {

        try {
            DNSSD.resolve(0, ifIndex1, serviceName, regType, domain, new ResolveListener() {

                public void serviceResolved(DNSSDService resolver, int flags, int ifIndex,
                        String fullname, String hostname, int port, TXTRecord txtRecord) {
                    InetAddress theAddress;
                    try {
                        //This returns the IP address of the connection
                        theAddress = InetAddress.getByName(hostname);
                        AddText("IP Address " + theAddress);
                        AddText("IT WORKS");
                    } catch (UnknownHostException e) {
                        // ouch..
                    }
                }

                public void operationFailed(DNSSDService arg0, int arg1) {
                    // ouch, again!
                }

                private void AddText(String string) {
                    txtText.setText(txtText.getText() + "\n" + string);
                }
            });
        } catch (Exception e) {
        }
    }

    @Override
    public void serviceLost(DNSSDService dnssds, int i, int i1, String string, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void operationFailed(DNSSDService dnssds, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
