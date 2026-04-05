
package editordetexto;
// Ventana Principal

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Diana, Valeria, Areli
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
        espanol.add("Nuevo");        
        espanol.add("Abrir");        
        espanol.add("Guardar");      
        espanol.add("Guardar Todo"); 
        espanol.add("Copiar");       
        espanol.add("Cortar");       
        espanol.add("Pegar");        
    

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
    }
    private void guardarComo(JTextArea area) {

    JFileChooser fileChooser = new JFileChooser();

    // Ruta por defecto (config o Documents)
    File ruta = new File(System.getProperty("user.home") + "/Documents");
    fileChooser.setCurrentDirectory(ruta);

    // Filtro
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
    fileChooser.setFileFilter(filtro);

    // Verificar si hay cambios sin guardar
    String original = (String) area.getClientProperty("contenidoOriginal");
    String actual = area.getText();

    boolean modificado = (original == null || !original.equals(actual));

    if (modificado) {
        int op = JOptionPane.showConfirmDialog(
            this,
            "Hay cambios sin guardar. ¿Deseas continuar?",
            "Guardar como",
            JOptionPane.YES_NO_CANCEL_OPTION
        );

        if (op == JOptionPane.CANCEL_OPTION) return;
        if (op == JOptionPane.NO_OPTION) return;
    }

    int seleccion = fileChooser.showSaveDialog(this);

    if (seleccion == JFileChooser.APPROVE_OPTION) {

        File archivo = fileChooser.getSelectedFile();

        // Asegurar extensión
        if (!archivo.getName().endsWith(".txt")) {
            archivo = new File(archivo.getAbsolutePath() + ".txt");
        }

        try {
            FileWriter writer = new FileWriter(archivo);
            writer.write(area.getText());
            writer.close();

            // Guardar referencia del archivo
            area.putClientProperty("archivo", archivo);

            int index = jTabbedPane1.getSelectedIndex();

            // Cambiar nombre de pestaña
            jTabbedPane1.setTitleAt(index, archivo.getName());

            // Actualizar contenido original
            area.putClientProperty("contenidoOriginal", area.getText());

            JOptionPane.showMessageDialog(this, "Archivo guardado correctamente");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar archivo");
        }
    }
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
        jPanel2 = new javax.swing.JPanel();
        lblRenglon = new javax.swing.JLabel();
        lblColumna = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        btnHerramientasNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHerramientasNuevoActionPerformed(evt);
            }
        });
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
        mnuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevoActionPerformed(evt);
            }
        });
        mnuBarArchivo.add(mnuNuevo);

        mnuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Open.png"))); // NOI18N
        mnuAbrir.setText("Abrir");
        mnuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAbrirActionPerformed(evt);
            }
        });
        mnuBarArchivo.add(mnuAbrir);

        mnuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Save.png"))); // NOI18N
        mnuGuardar.setText("Guardar");
        mnuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGuardarActionPerformed(evt);
            }
        });
        mnuBarArchivo.add(mnuGuardar);

        mnuGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAs.png"))); // NOI18N
        mnuGuardarComo.setText("Guardar Como");
        mnuGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGuardarComoActionPerformed(evt);
            }
        });
        mnuBarArchivo.add(mnuGuardarComo);

        mnuGuardarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/SaveAll.png"))); // NOI18N
        mnuGuardarTodo.setText("Guardar Todo");
        mnuBarArchivo.add(mnuGuardarTodo);

        mnuCerrarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CloseDocument.png"))); // NOI18N
        mnuCerrarDocumento.setText("Cerrar Documento");
        mnuCerrarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCerrarDocumentoActionPerformed(evt);
            }
        });
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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                area.putClientProperty("modificado", false);
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
                    area.putClientProperty("modificado", false);
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
        }
        jTabbedPane1.removeTabAt(indicador);
    }//GEN-LAST:event_mnuCerrarDocumentoActionPerformed

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
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
                area.putClientProperty("modificado", false);
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
    }//GEN-LAST:event_mnuAbrirActionPerformed

    private void mnuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_mnuGuardarActionPerformed

    private void mnuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarComoActionPerformed
        int index = jTabbedPane1.getSelectedIndex();
    if (index == -1) return;

    JScrollPane scroll = (JScrollPane) jTabbedPane1.getComponentAt(index);
    JTextArea area = (JTextArea) scroll.getViewport().getView();
        guardarComo(area);
    }//GEN-LAST:event_mnuGuardarComoActionPerformed


    public static void main(String args[]) {

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
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
