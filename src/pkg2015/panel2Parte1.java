/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2015;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import static pkg2015.PrimerPanel.Contador;
import static pkg2015.PrimerPanel.Nodo;
import static pkg2015.PrimerPanel.Nodo1;
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author J.Y.N.CH
 */
public class panel2Parte1 extends javax.swing.JFrame {

    ListaDoblNodoementeEnlazada Nodo = new ListaDoblNodoementeEnlazada();
    
    PrimerPanel panel1 = new PrimerPanel();
    String Nodo1 = panel1.PasarDatos();
    
    //Creando variables estaticas
         Integer contadorP= panel1.getContador();
          Integer banderaGeneralP=0;
        Integer contadorHeoreP=panel1.getContadorhoreo();
        Integer contadorCastilloP=panel1.getContadorcastillo();
        Integer contadorMuroP=panel1.getContadorMuro();
        Integer contadorSueloP=panel1.getContadorSuelo();
        Integer contadorGoombaP=panel1.getContadorGoomba();
         Integer contadorHongoVidaP=panel1.getContadorHongo();
         Integer contadorMonedaP=panel1.getContadorMondeda();
         Integer contadorCKoopaP=panel1.getContadorKoopa();
         
         Integer prueba=0;
    String resumen="";
    String textAr="";
    String textAr1="";
    String textAr2="";
    String cabeceraGrafo="";
    String grafo ="";
    public static String lista = "";
     public  String lista1 = "";
      public static String lista2 = "";
    Integer j=1;
    String[] valorMenor= null;
    String[] valorMayor = Nodo1.split("/");
    public static  String pasar = "";
    
    public String pasarLista(){
    return this.lista2;
    }
    
    public void SetearImagen1(String path){ 
            URL url = this.getClass().getResource(path);  
            ImageIcon icon = new ImageIcon(url);  
            this.jLabel7.setIcon(icon);
            }
    
 public void setearImagenPanel(){
 String total=this.generarTxtGrafo();
 this.EliminarArchivo("C:\\Users\\J.Y.N.CH\\Desktop\\grafo1.txt");
 this.txt(total, "C:\\Users\\J.Y.N.CH\\Desktop\\grafo1.txt");
 this.grafo("C:\\Users\\J.Y.N.CH\\Desktop\\grafo1.txt","C:\\Users\\J.Y.N.CH\\Documents\\NetBeansProjects\\2015\\src\\pkg2015\\Imagenes\\grafo"+this.prueba+".jpg");
 this.prueba++;
 }
    
    
 public String generarTxtGrafo(){
 this.lista = Nodo.imprimir();
        this.grafo="";
        String[] primeroValor = this.lista.split("/");
        if(this.contadorP-1 <2){
        for(int i=0;i<=primeroValor.length-1; i++){
            String[] menos = primeroValor[i].split("_"); 
            this.grafo+= menos[1];
                                                 }
        }else{
         for(int i=0;i<=primeroValor.length-2; i++){
              String[] menos = primeroValor[i].split("_");
               String[] menos1 = primeroValor[i+1].split("_"); 
               if(i == primeroValor.length-2){
                this.grafo+=  menos[1] + "->"+menos1[1] + "->" +menos[1];
               }else{
               this.grafo+=  menos[1] + "->"+menos1[1] + "->" +menos[1]+ ";";
               }  
       }
        }   
        this.cabeceraGrafo ="digraph G\n {"+ this.grafo +"}";
        return this.cabeceraGrafo;
 } 
    
    
  public void txt(String Texto,String path){
  try {
 File outFile = new File(path);
 BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

writer.write(Texto);
 writer.newLine(); // Esto es un salto de linea

writer.close();
 } catch (IOException e) {
 System.err.println(e);
 System.exit(1);
 }

  }
    
  public  void EliminarArchivo (String pArchivo)  {
			File fichero = new File(pArchivo);
                        fichero.delete();
	}  
  
  
  
  
  
  
  public void grafo(String pArchivo, String sArchivo){
    try {
      
      String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
      
      String fileInputPath = pArchivo;
      String fileOutputPath = sArchivo;
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }
  
  
  }  
  
 public String Pasar(){
 return this.pasar;
 };
  
  public void setPasar(){
this.pasar = this.contadorHeoreP + "/" + this.contadorCastilloP +"/" + this.contadorMonedaP+ "/"+
          this.contadorMuroP + "/" +  this.contadorSueloP + "/" + this.contadorHongoVidaP + "/"+
          this.contadorGoombaP + "/" +this.contadorCKoopaP;  
  }  
  
  public void resumen(){
  this.jTextArea2.setText("");
  this.resumen = this.contadorHeoreP + "            Heore\n" + this.contadorCastilloP +"            Castillo\n" + this.contadorMonedaP+ "            Moneda\n"+
          this.contadorMuroP + "            Muro\n" +  this.contadorSueloP + "            Suelo\n" + this.contadorHongoVidaP + "            Hongo Vida\n"+
          this.contadorGoombaP + "            GoombA\n" +this.contadorCKoopaP + "            Koopa\n"
          ;
 this.jTextArea2.setText(this.resumen);
 this.setPasar();
  }
    
    public panel2Parte1() {
        initComponents();
        this.jTextArea1.setEnabled(false);
        this.jTextArea2.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.getContentPane().setBackground(Color.CYAN);
       for(int i=0;i<=this.valorMayor.length-1; i++){
               valorMenor = valorMayor[i].split("_");  
               Nodo.insertar(this.j,Integer.valueOf(valorMenor[0]),valorMenor[1]);
                 j++;
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setResizable(false);

        jButton1.setText("Ver Elementos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("No.");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("No.  Tipo             Nombre");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel5.setText("Cantidad      Tipo");

        jLabel6.setText("GRAFO");

        jScrollPane4.setViewportView(jLabel7);

        jButton4.setText("GRAFO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg2015/Imagenes/sig.gif"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)))
                        .addComponent(jLabel6)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void eliminarPanel(Integer Pos){
         this.jLabel3.setText("");
      if(this.jTextField2.getText().equals("")){
        this.jLabel3.setText("Selecciones No. a Modificar");
      }else{
          if(Integer.valueOf(this.jTextField2.getText())>this.contadorP-1){
           this.jLabel3.setText("No. mayor a los ingresados");
          }else{
              if(Integer.valueOf(this.jTextField2.getText())<1){
                 this.jLabel3.setText("Mayor que 0");   
              }else{
              
           this.lista1 = Nodo.imprimir();
        String[] primeroValor1 = this.lista.split("/");
        String[] segundoValor1 = primeroValor1[Pos-1].split("_");
        switch(segundoValor1[0]){
                  case "1":  this.contadorHeoreP-- ;
                              break;
                      case "2":  this.contadorHongoVidaP-- ;
                                  break;
                          case "3":  this.contadorMonedaP-- ;
                                       break;
                              case "4":  this.contadorMuroP--;
                                            break;
                                  case "5":  this.contadorGoombaP-- ;
                                               break;
                                      case "6":  this.contadorCKoopaP-- ;
                                                   break;
                                          case "7":  this.contadorSueloP--;
                                                     break;
                                              case "8":  this.contadorCastilloP--;
                                                            break;
     }
        
          Nodo.borrar(Pos);
      this.contadorP--;
      this.jLabel3.setText("Eliminacion Exitosa !!!!");
       this.CargarPanel();
        this.resumen();   
              
              }
           
          
          }}
        
      
}
    
    public void CargarPanel(){
    this.jTextArea1.setText("");
    this.lista = Nodo.imprimir();
    this.lista2 = Nodo.imprimir();
        String[] primeroValor = this.lista.split("/");
        String[] segundoValor= null;

        for(int l=1;l<=this.contadorP-1; l++){
            segundoValor = primeroValor[l-1].split("_");
              this.textAr += String.valueOf(l) +"     ";
              switch(segundoValor[0]){
                  case "1":  this.textAr += "Heroe          ";
                              break;
                      case "2":  this.textAr += "Hongo          ";
                                  break;
                          case "3":  this.textAr += "Moneda         ";
                                       break;
                              case "4":  this.textAr += "Muro           ";
                                            break;
                                  case "5":  this.textAr += "Goomba         ";
                                               break;
                                      case "6":  this.textAr += "Koopa          ";
                                                   break;
                                          case "7":  this.textAr += "Suelo          ";
                                                     break;
                                              case "8":  this.textAr += "Castillo       ";
                                                            break;
     }
              
              this.textAr += segundoValor[1] + "\n";
        }
        
        this.jTextArea1.setText(this.textAr);
        this.textAr="";
    
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.CargarPanel();
        this.resumen();
         this.setearImagenPanel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
    char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              this.jLabel3.setText("Ingresa Solo Numeros"); 
               
          }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    public void modificarPanel(){
        this.jLabel3.setText("");
      if(this.jTextField2.getText().equals("")){
        this.jLabel3.setText("Selecciones No. a Modificar");
      }else{
          if(Integer.valueOf(this.jTextField2.getText())>this.contadorP-1){
           this.jLabel3.setText("No. mayor a los ingresados");
          }else{
              if(this.jTextField1.getText().equals("")){
               this.jLabel3.setText("Seleccione Nombre!!");
              }else{
                   if(Integer.valueOf(this.jTextField2.getText())<1){
               this.jLabel3.setText("Seleccione Mayor que 0!!");
              }else{
                   Nodo.modificar(Integer.valueOf(this.jTextField2.getText()), this.jTextField1.getText()); 
                    this.jLabel3.setText("Modificacion Exitosa!!");
                    this.CargarPanel();
                    this.resumen();
                   }
              }
      
          }
      }
        
        
    
    }
    
    
    
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jLabel3.setText("");
        this.modificarPanel();
        this.setearImagenPanel();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.jLabel3.setText("");
        this.eliminarPanel(Integer.valueOf(this.jTextField2.getText()));
this.setearImagenPanel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.prueba = this.prueba-1;
        this.SetearImagen1("/pkg2015/Imagenes/grafo"+this.prueba+".jpg");
        this.prueba ++;
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        SegundaParte dg = null; 
                        try { 

                                    dg = new SegundaParte(); 
                                    } catch (Exception ex) { 
                                    Logger.getLogger(panel2Parte1.class.getName() 
                                    ).log(Level.SEVERE, null, ex); 
                                    } 
                                    dg.setLocationRelativeTo(null); 
                                    dg.setVisible(true); 
                                    this.setVisible(false);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    
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
            java.util.logging.Logger.getLogger(panel2Parte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel2Parte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel2Parte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel2Parte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel2Parte1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
