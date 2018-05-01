/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_marketing_massivo_browser_swt;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.MozillaXPCOM;
import javax.swing.JOptionPane;
import org.mozilla.interfaces.nsIDOMDocument;
import org.mozilla.interfaces.nsIDOMNSHTMLDocument;
import org.mozilla.interfaces.nsIDOMWindow;
import org.mozilla.interfaces.nsIWebBrowser;

/**
 *
 * @author NewUser
 */
public class Codigo_Fonte_E_Script extends javax.swing.JPanel {

    JWebBrowser webBrowser;
    /** String 
     * Creates new form Visualizador_De_Codigo_Fonte
     * @param webBrowser2
     */
    public Codigo_Fonte_E_Script( JWebBrowser webBrowser2 ) {
        initComponents();
        webBrowser = webBrowser2;
        inicio();
    }
    
    public Codigo_Fonte_E_Script( JWebBrowser webBrowser2, String fonte ) {
        initComponents();
        webBrowser = webBrowser2;
        inicio();
        txt.setText( fonte );
    }
    
    nsIWebBrowser iWebBrowser;
    nsIDOMWindow window;
    nsIDOMDocument document;
    nsIDOMNSHTMLDocument nsDocument;
    private void inicio(){                                 
        try {
            
            iWebBrowser = MozillaXPCOM.getWebBrowser(webBrowser); 
            if(iWebBrowser == null) {
                
                JOptionPane.showMessageDialog(webBrowser, "The XPCOM nsIWebBrowser interface could not be obtained.\nPlease check your XULRunner configuration.", "XPCOM interface", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            window = iWebBrowser.getContentDOMWindow();
            document = window.getDocument();
            nsDocument = (nsIDOMNSHTMLDocument)document.queryInterface(nsIDOMNSHTMLDocument.NS_IDOMNSHTMLDOCUMENT_IID);
            nsDocument.setDesignMode( "on" ); // "off"

        } catch( Exception e ){ 
            System.out.println( "inicio();"  );
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt1 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        bt4 = new javax.swing.JButton();

        bt1.setText("Executar Script");
        bt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt1MousePressed(evt);
            }
        });

        bt3.setText("Setar Html Alterando ID");

        txt.setColumns(20);
        txt.setRows(5);
        txt.setText("document.getElementsByTagName(\"*\")");
        jScrollPane1.setViewportView(txt);

        bt4.setText("Setar Html ");
        bt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bt4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt3)
                .addGap(138, 138, 138))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt1)
                    .addComponent(bt3)
                    .addComponent(bt4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void bt1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt1MousePressed
        try {
            
            String script = "";

            String script_1 = txt.getText().trim();
            boolean espacoAnterior = false;
            char[] sequencia = script_1.toCharArray();
            for( int i = 0; i < script_1.length(); i++ ){ 
                
                int letra = (int)sequencia[i];
                char chLetra = (char) letra;
                
                if( chLetra == '\n' ){ 
                    
                    //script += sequencia[i];
                    espacoAnterior =  false;
                }
                else if( chLetra == '\r' ){ 
                    //script += sequencia[i];
                    espacoAnterior =  false;
                }
                else if( chLetra == ' ' ){ 
                    //script += sequencia[i];
                    if( espacoAnterior == false ){
                        script += sequencia[i];
                        espacoAnterior = true;
                    }
                }
                else if( chLetra == '\"' ){ 
                    script += '\'';
                    espacoAnterior =  false;
                }
                else{
                    script += sequencia[i];
                    espacoAnterior =  false;
                }
            }
            
            webBrowser.executeJavascript( script );

        } catch( Exception e ){ 
            System.out.println( "Codigo_Fonte_E_Script extends javax.swing.JPanel {"  );
        }
    }//GEN-LAST:event_bt1MousePressed

    private void bt4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt4MousePressed
        webBrowser.setHTMLContent( txt.getText().trim() );
    }//GEN-LAST:event_bt4MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bt1;
    public javax.swing.JButton bt3;
    public javax.swing.JButton bt4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
