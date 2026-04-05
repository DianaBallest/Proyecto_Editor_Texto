
package editordetexto;
// Ventana Principal

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.net.URL.of;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author tres 
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    private void guardar() {
    int index = jTabbedPane1.getSelectedIndex();
    // Si no hay pestañas
    if (index == -1) {
        JOptionPane.showMessageDialog(this, "No hay documento abierto");
        return;
    }
    JScrollPane scroll = (JScrollPane) jTabbedPane1.getComponentAt(index);
    JTextArea area = (JTextArea) scroll.getViewport().getView();

    File archivo = (File) area.getClientProperty("archivo");

    try {
        FileWriter  escribir= new FileWriter(archivo);
        escribir.write(area.getText());
        escribir.close();
        // Marcar como NO modificado
        area.putClientProperty("modificado", false);
        // Quitar el * del título
        String titulo = jTabbedPane1.getTitleAt(index);
        jTabbedPane1.setTitleAt(index, titulo.replace("*", ""));
        JOptionPane.showMessageDialog(this, "Archivo guardado correctamente");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar archivo");
    }
}
    

    private void modificaciones(JTextArea area){
        area.putClientProperty("modificado", true);
        int indicador=jTabbedPane1.getSelectedIndex();
        String titulo=jTabbedPane1.getTitleAt(indicador);
        if(!titulo.endsWith("*")){
            jTabbedPane1.setTitleAt(indicador, titulo +"*");
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lblRenglon = new javax.swing.JLabel();
        lblColumna = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuBarFile = new javax.swing.JMenu();
        mnuNew = new javax.swing.JMenuItem();
        mnuOpen = new javax.swing.JMenuItem();
        mnuSave = new javax.swing.JMenuItem();
        mnuSaveAs = new javax.swing.JMenuItem();
        mnuSaveAll = new javax.swing.JMenuItem();
        mnuCloseDocument = new javax.swing.JMenuItem();
        mnuCloseAll = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        mnuBarEdit = new javax.swing.JMenu();
        mnuCopy = new javax.swing.JMenuItem();
        mnuCut = new javax.swing.JMenuItem();
        mnuPaste = new javax.swing.JMenuItem();
        mnuBarTools = new javax.swing.JMenu();
        mnuConfiguration = new javax.swing.JMenuItem();
        mnuBarAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolBar.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NewDocument.png"))); // NOI18N
        jButton1.setToolTipText("New");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Open.png"))); // NOI18N
        jButton2.setToolTipText("Open");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        jButton3.setToolTipText("Save");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAll.png"))); // NOI18N
        jButton4.setToolTipText("Save All");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy.png"))); // NOI18N
        jButton5.setToolTipText("Copy");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut.png"))); // NOI18N
        jButton6.setToolTipText("Cut");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste.png"))); // NOI18N
        jButton7.setToolTipText("Paste");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(jButton7);

        jTabbedPane1.addTab("tab 1", jTabbedPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
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

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 102));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.setOpaque(true);

        mnuBarFile.setText("File");

        mnuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NewDocument.png"))); // NOI18N
        mnuNew.setText("New");
        mnuBarFile.add(mnuNew);

        mnuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Open.png"))); // NOI18N
        mnuOpen.setText("Open");
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        mnuBarFile.add(mnuOpen);

        mnuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        mnuSave.setText("Save");
        mnuBarFile.add(mnuSave);

        mnuSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAs.png"))); // NOI18N
        mnuSaveAs.setText("Save As");
        mnuBarFile.add(mnuSaveAs);

        mnuSaveAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAll.png"))); // NOI18N
        mnuSaveAll.setText("Save All");
        mnuBarFile.add(mnuSaveAll);

        mnuCloseDocument.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CloseDocument.png"))); // NOI18N
        mnuCloseDocument.setText("Close Document");
        mnuBarFile.add(mnuCloseDocument);

        mnuCloseAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CloseAll.png"))); // NOI18N
        mnuCloseAll.setText("Close All");
        mnuBarFile.add(mnuCloseAll);
        mnuBarFile.add(jSeparator1);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Exit.png"))); // NOI18N
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuBarFile.add(mnuExit);

        jMenuBar1.add(mnuBarFile);

        mnuBarEdit.setText("Edit");

        mnuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy.png"))); // NOI18N
        mnuCopy.setText("Copy");
        mnuBarEdit.add(mnuCopy);

        mnuCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut.png"))); // NOI18N
        mnuCut.setText("Cut");
        mnuBarEdit.add(mnuCut);

        mnuPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste.png"))); // NOI18N
        mnuPaste.setText("Paste");
        mnuPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPasteActionPerformed(evt);
            }
        });
        mnuBarEdit.add(mnuPaste);

        jMenuBar1.add(mnuBarEdit);

        mnuBarTools.setText("Tools");

        mnuConfiguration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Configuration.png"))); // NOI18N
        mnuConfiguration.setText("Configuration");
        mnuConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfigurationActionPerformed(evt);
            }
        });
        mnuBarTools.add(mnuConfiguration);

        jMenuBar1.add(mnuBarTools);

        mnuBarAbout.setText("About");
        jMenuBar1.add(mnuBarAbout);

        setJMenuBar(jMenuBar1);

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

    private void mnuPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuPasteActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfigurationActionPerformed
        FrmConfiguration confi = new FrmConfiguration();
        confi.setVisible(true);
    }//GEN-LAST:event_mnuConfigurationActionPerformed

    
    private void mnuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevoActionPerformed

        //al ya instanciar la clase propiedades no es necesario volverlo a hacer; hecho en la linea 32 y 33
        //simplemente usar propierties directamente
        JFileChooser selector=new JFileChooser();
        
        // Ruta por defecto: Documentos
        File ruta = new File(System.getProperty("user.home") + "/Documents");
        selector.setCurrentDirectory(ruta);
        
        // Filtro de archivos
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        selector.setFileFilter(filtro);

        int seleccion=selector.showSaveDialog(this);
        
        if(seleccion==JFileChooser.APPROVE_OPTION){
            File archivo=selector.getSelectedFile();
            //asegurar extencion
            if(!archivo.getName().endsWith(".txt")){
                archivo=new File(archivo.getAbsolutePath()+".txt");
            }
            try{
                //crear archivo vacio (texto plano)
                FileWriter editor=new FileWriter(archivo);
                editor.write("");
                editor.close();
                archivo.createNewFile();

                JTextArea area = new JTextArea();
                JScrollPane scroll = new JScrollPane(area);

                jTabbedPane1.addTab(archivo.getName(), scroll);
                jTabbedPane1.setSelectedComponent(scroll);

                area.putClientProperty("archivo", archivo);
                
                
            }catch(IOException e){
                JOptionPane.showMessageDialog(this, "Error al crear archivo");
            }
        }
    }//GEN-LAST:event_mnuNuevoActionPerformed

    private void btnHerramientasNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHerramientasNuevoActionPerformed

    }//GEN-LAST:event_btnHerramientasNuevoActionPerformed

    private void mnuCerrarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCerrarDocumentoActionPerformed
       //Aquí necesita cambios para mostrar el msj de guardar al realizar cambios
        
        int indicador = jTabbedPane1.getSelectedIndex();
        if(indicador==-1) return;
        JScrollPane scroll= (JScrollPane) jTabbedPane1.getComponentAt(indicador);
        JTextArea area=(JTextArea) scroll.getViewport().getView();
        
        // Obtener estado de modificación (puede ser null)
        Boolean modificado = (Boolean) area.getClientProperty("modificado");

        // preguntar si realmente fue modificado
        if (modificado != null && modificado) {

            int op= JOptionPane.showConfirmDialog(
                this,"¿Deseas guardar los cambios antes de cerrar?","Cerrar documento",JOptionPane.YES_NO_CANCEL_OPTION);
                if (op== JOptionPane.CANCEL_OPTION) {return; }//Cancelar cierre
                if(op==JOptionPane.YES_OPTION){
                    
                JScrollPane scll=(JScrollPane) jTabbedPane1.getSelectedComponent();
                JTextArea a=(JTextArea) scll.getViewport().getView();
                
                File archivo=(File) a.getClientProperty("archivo");
                try{
                    FileWriter esc=new FileWriter(archivo);
                    esc.write(a.getText());
                    esc.close();
                    JOptionPane.showMessageDialog(this, "Archivo Guardado");
                    
                }catch(IOException e){
                    JOptionPane.showMessageDialog(this, "Error al guardar");
                }
            }
        jTabbedPane1.removeTabAt(indicador);
    }//GEN-LAST:event_mnuCerrarDocumentoActionPerformed

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
       
    }//GEN-LAST:event_mnuAbrirActionPerformed

    private void mnuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_mnuGuardarActionPerformed

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
         JFileChooser buscar=new JFileChooser();
        
        //ruta de documentos
        File ruta=new File(System.getProperty("user.home")+"/Documents");
        buscar.setCurrentDirectory(ruta);
        
        //filtro de archivos
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivos de texto(*.txt)","txt");
        buscar.setFileFilter(filtro);
        
        int seleccion= buscar.showOpenDialog(this);
        if (seleccion==JFileChooser.APPROVE_OPTION){
            File archivo = buscar.getSelectedFile();
            
            //no abrir el mismo archovo dos veces
        for(int i=0; i< jTabbedPane1.getTabCount();i++){
            JScrollPane scl= (JScrollPane) jTabbedPane1.getComponentAt(i);
            JTextArea a=(JTextArea) scl.getViewport().getView();
            
            File abierto=(File) a.getClientProperty("Archivo");
            if(abierto!=null && abierto.equals(archivo));
            jTabbedPane1.setSelectedIndex(i);
            return;
        }
            
            try{
                //leer contenido
                String contenido = new String(Files.readAllBytes(archivo.toPath()));
                
                //crear nueva área de texto
                JTextArea area=new JTextArea();
                area.setText(contenido);
                JScrollPane scroll = new JScrollPane(area);
                
                //agg al tobbedpane con el nombre del archivo
                jTabbedPane1.addTab(archivo.getName(), scroll);
                jTabbedPane1.setSelectedComponent(scroll);
                
                //guardar referencia del archivo
                area.putClientProperty("archivo", archivo);
                
            }catch(IOException e){
                JOptionPane.showMessageDialog(this, "Error al abrir archivo");
            }
        }
    }//GEN-LAST:event_mnuOpenActionPerformed

    public static void main(String args[]) {

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblColumna;
    private javax.swing.JLabel lblRenglon;
    private javax.swing.JMenu mnuBarAbout;
    private javax.swing.JMenu mnuBarEdit;
    private javax.swing.JMenu mnuBarFile;
    private javax.swing.JMenu mnuBarTools;
    private javax.swing.JMenuItem mnuCloseAll;
    private javax.swing.JMenuItem mnuCloseDocument;
    private javax.swing.JMenuItem mnuConfiguration;
    private javax.swing.JMenuItem mnuCopy;
    private javax.swing.JMenuItem mnuCut;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuNew;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JMenuItem mnuPaste;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JMenuItem mnuSaveAll;
    private javax.swing.JMenuItem mnuSaveAs;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
