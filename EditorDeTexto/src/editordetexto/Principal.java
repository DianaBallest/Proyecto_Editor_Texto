
package editordetexto;
// Ventana Principal

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tres 
 */
public class Principal extends javax.swing.JFrame {
    //Apareceran en order los componenentes traduccidos ya se en ES O EN
    //Generamos hashmap para poder guardar los valores a traducir
    private HashMap<String,ArrayList> idiomas = new HashMap<>();

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        aplicarTraduccion();
    }
    
    public void aplicarTraduccion() {
    // 1. Cargamos las listas de palabras
    cargarIdiomas();

    // 2. Usamos TU librería para leer el archivo config.properties
    mis_propiedades.ClassArchivoPropiedades manejador = new mis_propiedades.ClassArchivoPropiedades();
    java.util.Properties propiedades = manejador.LeerPropiedades();

    if (propiedades != null) {
        // Obtenemos el idioma ol(EN o ES)
        String idiomaConfigurado = propiedades.getProperty("Idioma", "ES");
        java.util.ArrayList<String> opcionesIdioma = idiomas.get(idiomaConfigurado);

        int posicion = -1;
        javax.swing.JMenu menu;
        javax.swing.JMenuItem opcionMenu;

        // --- EL CICLO DEL PROFE ---
        // Recorremos la barra de menú (barraMenu es el nombre de tu JMenuBar)
        for (int nMenu = 0; nMenu < barraMenu.getComponentCount(); nMenu++) {
            menu = barraMenu.getMenu(nMenu);
            
            if (menu != null) {
                posicion++;
                menu.setText(opcionesIdioma.get(posicion));

                // Recorremos los ítems de cada menú
                for (int menuItem = 0; menuItem < menu.getItemCount(); menuItem++) {
                    opcionMenu = menu.getItem(menuItem);
                    
                    if (opcionMenu != null) { // Si no es una rayita separadora
                        posicion++;
                        opcionMenu.setText(opcionesIdioma.get(posicion));
                    }
                }
            }
        }
        
        for (int i = 0; i < toolBar.getComponentCount(); i++) {
            // Obtenemos el componente (botón, separador, etc.)
            java.awt.Component comp = toolBar.getComponentAtIndex(i);
        
            if (comp instanceof javax.swing.JButton) {
                posicion++; // Seguimos contando desde donde se quedó el menú
                ((javax.swing.JButton) comp).setToolTipText(opcionesIdioma.get(posicion));
            }
        }
    }
    
}
    
    // --Metodo para preparar el HashMap
    private void cargarIdiomas() {
        //Lista en Inglés (DEBEN ESTAR EN EL MISMO ORDEN)
        //Creacion de arraylist para los idiomas
        ArrayList espanol = new ArrayList();//Traducido a Español
        espanol.add("Archivo");           // Menú Principal 1
        espanol.add("Nuevo");             
        espanol.add("Abrir");             
        espanol.add("Guardar");           
        espanol.add("Guardar Como");     
        espanol.add("Guardar Todo");      
        espanol.add("Cerrar Documento");  
        espanol.add("Cerrar Todo");       
        espanol.add("Salir");             
    
        espanol.add("Editar");            // Menú Principal 2
        espanol.add("Copiar");            
        espanol.add("Cortar");         
        espanol.add("Pegar");            
    
        espanol.add("Herramientas");      // Menú Principal 3
        espanol.add("Configuración");     
    
        espanol.add("Acerca De");         // Menú Principal 4
        
        // --AQUÍ AGREGA LOS TOOLTIPS:
        espanol.add("Nuevo");        // Icono 1
        espanol.add("Abrir");        // Icono 2
        espanol.add("Guardar");      // Icono 3
        espanol.add("Guardar Todo"); // Icono 4
        espanol.add("Copiar");       // Icono 5
        espanol.add("Cortar");       // Icono 6
        espanol.add("Pegar");        // Icono 7
    

        // Lista en Inglés (DEBEN ESTAR EN EL MISMO ORDEN)
        //Creacion de arraylist para los idiomas
        ArrayList ingles = new ArrayList();//Traducido a Ingles
        ingles.add("File");
        ingles.add("New Document");
        ingles.add("Open");
        ingles.add("Save");
        ingles.add("Save As");
        ingles.add("Save All");
        ingles.add("Close Document");
        ingles.add("Close All");
        ingles.add("Exit");
    
        ingles.add("Edit");
        ingles.add("Copy");
        ingles.add("Cut");
        ingles.add("Paste");
    
        ingles.add("Tools");
        ingles.add("Configuration");
    
        ingles.add("About");
        
        // --AQUÍ AGREGA LOS TOOLTIPS EN INGLÉS:
        ingles.add("New");           
        ingles.add("Open");          
        ingles.add("Save");          
        ingles.add("Save All");      
        ingles.add("Copy");          
        ingles.add("Cut");           
        ingles.add("Paste");

        idiomas.put("ES", espanol);
        idiomas.put("EN", ingles);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        btnHerramientasNuevo = new javax.swing.JButton();
        btnHerramientasAbrir = new javax.swing.JButton();
        btnHerramientasGuardar = new javax.swing.JButton();
        btnHerramientasGuardarTodo = new javax.swing.JButton();
        btnHerramientasCopiar = new javax.swing.JButton();
        btnHerramientasCortar = new javax.swing.JButton();
        btnHerramientasPegar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRenglon = new javax.swing.JLabel();
        lblColumna = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        mnuBarArchivo = new javax.swing.JMenu();
        mnuNuevo = new javax.swing.JMenuItem();
        mnuAbrir = new javax.swing.JMenuItem();
        mnuGuardar = new javax.swing.JMenuItem();
        mnuGuardarComo = new javax.swing.JMenuItem();
        mnuGuardarTodo = new javax.swing.JMenuItem();
        mnuCerrarDocumento = new javax.swing.JMenuItem();
        mnuCerrarTodo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuSalir = new javax.swing.JMenuItem();
        mnuBarEditar = new javax.swing.JMenu();
        mnuCopiar = new javax.swing.JMenuItem();
        mnuCortar = new javax.swing.JMenuItem();
        mnuPegar = new javax.swing.JMenuItem();
        mnuBarHerramientas = new javax.swing.JMenu();
        mnuConfiguracion = new javax.swing.JMenuItem();
        mnuBarAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolBar.setRollover(true);

        btnHerramientasNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NewDocument.png"))); // NOI18N
        btnHerramientasNuevo.setToolTipText("Nuevo");
        btnHerramientasNuevo.setFocusable(false);
        btnHerramientasNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasNuevo);

        btnHerramientasAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Open.png"))); // NOI18N
        btnHerramientasAbrir.setToolTipText("Abrir");
        btnHerramientasAbrir.setFocusable(false);
        btnHerramientasAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasAbrir);

        btnHerramientasGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        btnHerramientasGuardar.setToolTipText("Guardar");
        btnHerramientasGuardar.setFocusable(false);
        btnHerramientasGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasGuardar);

        btnHerramientasGuardarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAll.png"))); // NOI18N
        btnHerramientasGuardarTodo.setToolTipText("Guardar Todo");
        btnHerramientasGuardarTodo.setFocusable(false);
        btnHerramientasGuardarTodo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasGuardarTodo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasGuardarTodo);

        btnHerramientasCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy.png"))); // NOI18N
        btnHerramientasCopiar.setToolTipText("Copiar");
        btnHerramientasCopiar.setFocusable(false);
        btnHerramientasCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasCopiar);

        btnHerramientasCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut.png"))); // NOI18N
        btnHerramientasCortar.setToolTipText("Cortar");
        btnHerramientasCortar.setFocusable(false);
        btnHerramientasCortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasCortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasCortar);

        btnHerramientasPegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste.png"))); // NOI18N
        btnHerramientasPegar.setToolTipText("Pegar");
        btnHerramientasPegar.setFocusable(false);
        btnHerramientasPegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHerramientasPegar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnHerramientasPegar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        lblRenglon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRenglon.setText("Renglon: ");

        lblColumna.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblColumna.setText("Columna:");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblRenglon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRenglon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        barraMenu.setBackground(new java.awt.Color(0, 0, 102));
        barraMenu.setForeground(new java.awt.Color(255, 255, 255));
        barraMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        barraMenu.setOpaque(true);

        mnuBarArchivo.setText("Archivo");

        mnuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NewDocument.png"))); // NOI18N
        mnuNuevo.setText("Nuevo");
        mnuBarArchivo.add(mnuNuevo);

        mnuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Open.png"))); // NOI18N
        mnuAbrir.setText("Abrir");
        mnuBarArchivo.add(mnuAbrir);

        mnuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        mnuGuardar.setText("Guardar");
        mnuBarArchivo.add(mnuGuardar);

        mnuGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAs.png"))); // NOI18N
        mnuGuardarComo.setText("Guardar Como");
        mnuBarArchivo.add(mnuGuardarComo);

        mnuGuardarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAll.png"))); // NOI18N
        mnuGuardarTodo.setText("Guardar Todo");
        mnuBarArchivo.add(mnuGuardarTodo);

        mnuCerrarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CloseDocument.png"))); // NOI18N
        mnuCerrarDocumento.setText("Cerrar Documento");
        mnuBarArchivo.add(mnuCerrarDocumento);

        mnuCerrarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CloseAll.png"))); // NOI18N
        mnuCerrarTodo.setText("Cerrar Todo");
        mnuBarArchivo.add(mnuCerrarTodo);
        mnuBarArchivo.add(jSeparator1);

        mnuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Exit.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuBarArchivo.add(mnuSalir);

        barraMenu.add(mnuBarArchivo);

        mnuBarEditar.setText("Editar");

        mnuCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy.png"))); // NOI18N
        mnuCopiar.setText("Copiar");
        mnuBarEditar.add(mnuCopiar);

        mnuCortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut.png"))); // NOI18N
        mnuCortar.setText("Cortar");
        mnuBarEditar.add(mnuCortar);

        mnuPegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuPegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste.png"))); // NOI18N
        mnuPegar.setText("Pegar");
        mnuBarEditar.add(mnuPegar);

        barraMenu.add(mnuBarEditar);

        mnuBarHerramientas.setText("Herramientas");

        mnuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Configuration.png"))); // NOI18N
        mnuConfiguracion.setText("Configuración");
        mnuConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfiguracionActionPerformed(evt);
            }
        });
        mnuBarHerramientas.add(mnuConfiguracion);

        barraMenu.add(mnuBarHerramientas);

        mnuBarAcercaDe.setText("Acerca De");
        barraMenu.add(mnuBarAcercaDe);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfiguracionActionPerformed
        FrmConfiguration confi = new FrmConfiguration();
        confi.setVisible(true);
    }//GEN-LAST:event_mnuConfiguracionActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnHerramientasAbrir;
    private javax.swing.JButton btnHerramientasCopiar;
    private javax.swing.JButton btnHerramientasCortar;
    private javax.swing.JButton btnHerramientasGuardar;
    private javax.swing.JButton btnHerramientasGuardarTodo;
    private javax.swing.JButton btnHerramientasNuevo;
    private javax.swing.JButton btnHerramientasPegar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblColumna;
    private javax.swing.JLabel lblRenglon;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenu mnuBarAcercaDe;
    private javax.swing.JMenu mnuBarArchivo;
    private javax.swing.JMenu mnuBarEditar;
    private javax.swing.JMenu mnuBarHerramientas;
    private javax.swing.JMenuItem mnuCerrarDocumento;
    private javax.swing.JMenuItem mnuCerrarTodo;
    private javax.swing.JMenuItem mnuConfiguracion;
    private javax.swing.JMenuItem mnuCopiar;
    private javax.swing.JMenuItem mnuCortar;
    private javax.swing.JMenuItem mnuGuardar;
    private javax.swing.JMenuItem mnuGuardarComo;
    private javax.swing.JMenuItem mnuGuardarTodo;
    private javax.swing.JMenuItem mnuNuevo;
    private javax.swing.JMenuItem mnuPegar;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
