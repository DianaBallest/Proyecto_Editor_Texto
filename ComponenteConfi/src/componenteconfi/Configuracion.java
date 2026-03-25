//Componente
package componenteconfi;

import java.awt.GraphicsEnvironment;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

public class Configuracion extends javax.swing.JPanel {

    public Configuracion() {
        initComponents();
        
        btnGroupIdioma.add(radioEspanol);
        btnGroupIdioma.add(radioIngles);
        
        DefaultListModel modelTipoFuente=new DefaultListModel();

        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String StrFuente:fontNames){
            modelTipoFuente.addElement(StrFuente);
        }
        lstFuente.setModel(modelTipoFuente); 
       
        DefaultListModel modelEstiloFuente=new DefaultListModel();
        modelEstiloFuente.addElement("Normal");  //0
        modelEstiloFuente.addElement("Negrita");   //1
        modelEstiloFuente.addElement("Cursiva");
        lstEstilo.setModel(modelEstiloFuente);
       
        for (int tan = 8; tan <=78; tan++) {
            comboTamano.addItem(String.valueOf(tan));
        }

//selecion predeterminada
        lstFuente.setSelectedIndex(3);
        lstEstilo.setSelectedIndex(0); 
        comboTamano.setSelectedItem("18"); 
        txtRuta.setText(System.getProperty("user.dir")+"\\"); 
        radioIngles.setSelected(true); 

        
        // Evento para cuando cambia el tipo de letra
        lstFuente.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    actualizarMuestra();
                }
            }
        });

        // Evento para cuando cambia el estilo
        lstEstilo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    actualizarMuestra();
                }
            }
        });

        // Evento para cuando cambia el tamaño en el combobox
        comboTamano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarMuestra();
            }
        });

        actualizarMuestra();
    }

    private void actualizarMuestra() {
    try {
        
        String nombreFuente = lstFuente.getSelectedValue();
        if (nombreFuente == null) {
            nombreFuente = "Arial";
        }
        
        txtFuente.setText(nombreFuente); 


        int estilo = java.awt.Font.PLAIN;
        String estiloSeleccionado = lstEstilo.getSelectedValue();
        if (estiloSeleccionado != null) {
            if (estiloSeleccionado.equals("Negrita")) {
                estilo = java.awt.Font.BOLD;
            } else if (estiloSeleccionado.equals("Cursiva")) {
                estilo = java.awt.Font.ITALIC;
            }
        }


        int tamano = 12; 
        Object tamanoSeleccionado = comboTamano.getSelectedItem();
        if (tamanoSeleccionado != null) {
            tamano = Integer.parseInt(tamanoSeleccionado.toString());
        }

        java.awt.Font nuevaFuente = new java.awt.Font(nombreFuente, estilo, tamano);
        lblMuestra.setFont(nuevaFuente);

    } catch (Exception e) {
        System.out.println("Error al actualizar fuente: " + e.getMessage());
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupIdioma = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtFuente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFuente = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboTamano = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEstilo = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        radioEspanol = new javax.swing.JRadioButton();
        radioIngles = new javax.swing.JRadioButton();
        lblMuestra = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Tipo De Letra");

        txtFuente.setEditable(false);
        txtFuente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFuente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        lstFuente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        jScrollPane1.setViewportView(lstFuente);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Ruta deTrabajo");

        txtRuta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Tamaño");

        comboTamano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Estilo");

        lstEstilo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        jScrollPane2.setViewportView(lstEstilo);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), "Idioma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        radioEspanol.setText("Español");

        radioIngles.setText("Ingles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioEspanol, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioIngles, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioEspanol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioIngles)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblMuestra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMuestra.setText("AaBbYyZz");
        lblMuestra.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)), "Visualización", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 102));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255)));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(111, 111, 111)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(comboTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(17, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboTamano, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addGap(252, 252, 252))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(12, 12, 12))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser dialogo = new JFileChooser();
        dialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = dialogo.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION){
            txtRuta.setText(dialogo.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    //Metodo Propiedades Escribir
    public boolean EscribirPropiedades(Properties propiedades){ 
      OutputStream configOutput; 
        try{ 
            configOutput = new FileOutputStream(System.getProperty("user.dir")+"/config.properties");           
            propiedades.store(configOutput, "<------ Archivo de Configuraciones ------>"); 
            configOutput.close(); 
            return (true);  
        } catch(Exception e){ 
          return(false); 
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup btnGroupIdioma;
    private javax.swing.JComboBox<String> comboTamano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMuestra;
    private javax.swing.JList<String> lstEstilo;
    private javax.swing.JList<String> lstFuente;
    private javax.swing.JRadioButton radioEspanol;
    private javax.swing.JRadioButton radioIngles;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
