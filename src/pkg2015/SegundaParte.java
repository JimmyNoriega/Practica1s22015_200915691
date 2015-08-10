/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2015;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author J.Y.N.CH
 */
public class SegundaParte extends javax.swing.JFrame {

    panel2Parte1 Panel2 = new panel2Parte1();
    ListaDoblNodoementeEnlazada Nodo = new ListaDoblNodoementeEnlazada();
    String[] valorMenor= null;
    
    Integer j=1;
    Integer ContadorParte2=0;
    String resumen = this.Panel2.Pasar();
    String lista = this.Panel2.pasarLista();
    String lista1 = "";
    String[] valorMayor = lista.split("/");
    String[] contadores =null;
    Integer posicionX = 2;
    Integer posicionY = 4;
    String[][] matriz = new String[posicionX][posicionY];
    
        Integer banderaGeneralP2=0;
        Integer contadorHeoreP2=0;
        Integer contadorCastilloP2=0;
        Integer contadorMuroP2=0;
        Integer contadorSueloP2=0;
        Integer contadorGoombaP2=0;
        Integer contadorHongoVidaP2=0;
        Integer contadorMonedaP2=0;
        Integer contadorCKoopaP2=0;
        String prueba = "";
        String pasarDatos = "";
        String pasarDatos1 = "";
        Integer jugando=1;
        Integer jugando1=0;
        String InicioGrafo="digraph G\n {";

         
         
         
   public void cargarResumen(){
   this.contadores = this.resumen.split("/");    
   this.contadorHeoreP2= Integer.valueOf(this.contadores[0]);
   this.contadorCKoopaP2= Integer.valueOf(this.contadores[7]);
   this.contadorCastilloP2 = Integer.valueOf(this.contadores[1]);
   this.contadorHongoVidaP2 = Integer.valueOf(this.contadores[5]);
   this.contadorMonedaP2 = Integer.valueOf(this.contadores[2]);
   this.contadorMuroP2 =Integer.valueOf(this.contadores[3]);
   this.contadorSueloP2 =Integer.valueOf(this.contadores[4]);
   this.contadorGoombaP2 =Integer.valueOf(this.contadores[6]); 
      
       this.ContadorParte2 = this.contadorHeoreP2 + this.contadorCastilloP2 + this.contadorMonedaP2+
          this.contadorMuroP2  +  this.contadorSueloP2  + this.contadorHongoVidaP2 +
          this.contadorGoombaP2 +this.contadorCKoopaP2;
       this.jugando1 = this.ContadorParte2;
   }
         
   public void cargarListaEnlazada(){
   this.lista1 = Nodo.imprimir();
   String[] valorMayor1= lista1.split("/");
      
   jScrollPane1.setViewportView(jPanel2);
        jPanel2.setLayout(null);
        jPanel2.setPreferredSize(new Dimension(138,10000));
        
         jScrollPane2.setViewportView(jPanel1);
        jPanel1.setLayout(null);
        jPanel1.setPreferredSize(new Dimension(10000,10000));
        
     for(int i=0;i<=valorMayor1.length-1; i++){
               valorMenor = valorMayor1[i].split("_");  
               this.cargarBoton(i, valorMenor[0]);
        }
   this.jPanel2.repaint();
   } 
   
    public void resumen(){
  this.jTextArea1.setText("");
  this.resumen = this.contadorHeoreP2+ "            Heore\n" + this.contadorCastilloP2 +"            Castillo\n" + this.contadorMonedaP2+ "            Moneda\n"+
          this.contadorMuroP2 + "            Muro\n" +  this.contadorSueloP2 + "            Suelo\n" + this.contadorHongoVidaP2 + "            Hongo Vida\n"+
          this.contadorGoombaP2 + "            GoombA\n" +this.contadorCKoopaP2 + "            Koopa\n"
          ;
 this.jTextArea1.setText(this.resumen);
  }
   
   
   public void cargarBoton(Integer cantidad, String Bandera ){
   JButton boton = new JButton();
   boton.setBounds(0, cantidad*123 ,123, 123);
   switch(Bandera){
       case "1": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/heroe Panel.jpg")));
                 boton.setText("1");
                 break;
          case "2": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/hongo.jpg")));
          boton.setText("2");       
          break;
              case "3": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/moneda.jpg")));
          boton.setText("3");
              break;
                  case "4": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/pared.jpg")));
              boton.setText("4");
                  break;
                      case "5": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/goomba.jpg")));
                 boton.setText("5");
                      break;
                          case "6": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/koopa.jpg")));
                 boton.setText("6");
                          break;
                              case "7": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/suelo.jpg")));
                 boton.setText("7");
                              break;
                                  case "8": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/castillo.jpg")));
                 boton.setText("8");
                                  break;
   }
   boton.setVisible(true);
   this.jPanel2.add(boton);
   this.jPanel2.repaint();
   
   }
   
   public void agregarFila(Integer XX, Integer YY){
  this.matriz = new String[XX][YY];  
 
  
  for (int x=0; x < this.matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                    this.matriz[x][y] ="0";
                 
                  }
                }
   String[] mover = this.pasarDatos.split("/");
  String[] mover2=null ;
   for(int i=0;i<=mover.length-1; i++){
               mover2 = mover[i].split("_");  
               for(int j=0;j<=mover2.length-1; j++){
                this.matriz[i][j] = mover2[j];
               }
        } 
   
    jPanel1.removeAll();
    this.pasarDatos="";
    for (int x=0; x < this.matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                   this.cargarBotonMatriz(y,x,matriz[x][y]);
                   this.pasarDatos += matriz[x][y]+"_"; 
                  }
                  this.pasarDatos += "/";
                }   
          jPanel1.repaint(); 
 
   }
   
   
    public void cargarBotonMatriz(Integer x, Integer y, String Bandera ){
   JButton boton = new JButton();
   boton.setBounds(x*123, y*123 ,123, 123);
   switch(Bandera){
       case "0": boton.setText("0");
               break;
       case "1": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/heroe Panel.jpg")));
                 boton.setText("1");
                 break;
          case "2": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/hongo.jpg")));
          boton.setText("2");       
          break;
              case "3": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/moneda.jpg")));
          boton.setText("3");
              break;
                  case "4": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/pared.jpg")));
              boton.setText("4");
                  break;
                      case "5": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/goomba.jpg")));
                 boton.setText("5");
                      break;
                          case "6": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/koopa.jpg")));
                 boton.setText("6");
                          break;
                              case "7": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/suelo.jpg")));
                 boton.setText("7");
                              break;
                                  case "8": boton.setIcon(new ImageIcon(getClass().getResource("/pkg2015/Imagenes/castillo.jpg")));
                 boton.setText("8");
                                  break;
   }
   boton.setVisible(true);
   this.jPanel1.add(boton);
   this.jPanel1.repaint();
   
   }
   
    public void datosListA(){
         for (int x=0; x < matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                   this.pasarDatos += matriz[x][y]+"_"; 
                  }
                  this.pasarDatos += "/";
                }
    
    }
    
    public void setearValor(Integer m, Integer n){
        if(this.matriz[m-1][n-1].equals("0")){
        jPanel1.removeAll(); 
        jPanel1.repaint();
        jPanel2.removeAll(); 
        this.pasarDatos="";
        String valor = Nodo.imprimir();
        String[] uno = valor.split("/");
        String[] dos = uno[0].split("_");
        Nodo.borrar(1);
        this.matriz[m-1][n-1] = dos[0];
        switch(dos[0]){
        case "1": this.contadorHeoreP2--;
                 break;
          case "2": this.contadorHongoVidaP2--;       
          break;
              case "3": this.contadorMonedaP2--;
              break;
                  case "4": this.contadorMuroP2--;
                  break;
                      case "5": this.contadorGoombaP2--;
                      break;
                          case "6": this.contadorCKoopaP2--;
                          break;
                              case "7": this.contadorSueloP2--;
                              break;
                                  case "8": this.contadorCastilloP2--;
                                  break;
        }
        this.cargarListaEnlazada();
        
          for (int x=0; x < matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                   this.cargarBotonMatriz(y,x,matriz[x][y]);
                   this.pasarDatos += matriz[x][y]+"_"; 
                  }
                  this.pasarDatos += "/";
                }   
          this.ContadorParte2--;
          jPanel2.repaint(); 
        }else{
               this.jLabel5.setText("Posicion Ocupada");
        }
        
        System.out.println(this.ContadorParte2);
    }
    public void generarGrafo(){
    
    String[] grafo = this.pasarDatos.split("/");
    String[] grafo1 =null;
    String[] grafo2 =null;
    String intermediografo ="";
     for(int i=0;i<=grafo.length-1; i++){
         if(i==grafo.length-1){
         intermediografo+="";
         }else{
         grafo1 = grafo[i].split("_");
                 grafo2 = grafo[i+1].split("_"); 
              for(int j=0;j<=grafo1.length-1; j++){
                  if(j==grafo1.length-1){
                  intermediografo+= "";
                  }else{
                  intermediografo+=grafo1[j] + "->" + grafo1[j+1] + "->"+grafo1[j]+";"+grafo1[j] + "->" + grafo2[j] + "->"+grafo1[j]+";"; 
                  }
              }
              
         
         }      
        }     
        
    this.InicioGrafo += intermediografo +"}";
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
     
     
 public void setearImagenPanel(){
 String total=this.InicioGrafo;
 this.EliminarArchivo("C:\\Users\\J.Y.N.CH\\Desktop\\lista1.txt");
 this.txt(total, "C:\\Users\\J.Y.N.CH\\Desktop\\lista1.txt");
 this.grafo("C:\\Users\\J.Y.N.CH\\Desktop\\lista1.txt","C:\\Users\\J.Y.N.CH\\Documents\\NetBeansProjects\\2015\\src\\pkg2015\\Imagenes\\lista1.jpg");
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
    
    
    public void getearValor(Integer m, Integer n){
        String Bandera=this.matriz[m-1][n-1]; 
        if(this.matriz[m-1][n-1].equals("0")){
          this.jLabel5.setText("Posicion Vacia");
        }else{
        jPanel1.removeAll(); 
        jPanel1.repaint();
        jPanel2.removeAll(); 
        this.pasarDatos="";
        this.ContadorParte2++;
        Nodo.insertar(this.ContadorParte2, Integer.valueOf(Bandera), "jimmy");
        switch(Bandera){
        case "1": this.contadorHeoreP2++;
                 break;
          case "2": this.contadorHongoVidaP2++;       
          break;
              case "3": this.contadorMonedaP2++;
              break;
                  case "4": this.contadorMuroP2++;
                  break;
                      case "5": this.contadorGoombaP2++;
                      break;
                          case "6": this.contadorCKoopaP2++;
                          break;
                              case "7": this.contadorSueloP2++;
                              break;
                                  case "8": this.contadorCastilloP2++;
                                  break;
        }
        
        this.matriz[m-1][n-1] = "0";
        this.cargarListaEnlazada();
        
          for (int x=0; x < matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                   this.cargarBotonMatriz(y,x,matriz[x][y]);
                   this.pasarDatos += matriz[x][y]+"_"; 
                  }
                  this.pasarDatos += "/";
                }   
          jPanel2.repaint();       
        }
       
        System.out.println(this.ContadorParte2);
        
    }
    
   
   public void matrizInicial(){
    for (int x=0; x < matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                    matriz[x][y] ="0";
                  }
                }
       
    for (int x=0; x < matriz.length; x++) {
                  for (int y=0; y < matriz[x].length; y++) {
                   this.cargarBotonMatriz(y,x,matriz[x][y]);
                   this.pasarDatos += matriz[x][y]+"_"; 
                  }
                  this.pasarDatos += "/";
                }
       
   }
      
   
 
    public SegundaParte() {
        initComponents();  
              
        this.getContentPane().setBackground(Color.CYAN);
        this.jTextArea1.setEnabled(false);
        for(int i=0;i<=this.valorMayor.length-1; i++){
               valorMenor = valorMayor[i].split("_");  
               Nodo.insertar(this.j,Integer.valueOf(valorMenor[0]),valorMenor[1]);
                 j++;
        }     
        this.cargarResumen();
        this.cargarListaEnlazada();
        this.matrizInicial();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("ARMAR ESCENARIO DE JUEGO");

        jButton1.setText("RESUMEN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setWheelScrollingEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jScrollPane2.setWheelScrollingEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        jButton2.setText("AGREGAR FILA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("AGREGAR COLUMNA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jScrollPane4.setViewportView(jLabel2);

        jButton4.setText("GRAFO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("AGREGAR ELEMENTO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel3.setText("X");

        jLabel4.setText("Y");

        jLabel5.setForeground(new java.awt.Color(204, 0, 0));

        jButton6.setText("ELIMINAR FILA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("ELIMINAR COLUMNA");

        jButton8.setText("ELIMINAR ELEMENTO");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("TERCERA FASE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jButton9)))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton6)
                                .addComponent(jButton7)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.resumen();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  this.posicionX ++;
        agregarFila(this.posicionX, this.posicionY);
        System.out.println(this.pasarDatos);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.generarGrafo();
        this.setearImagenPanel();
        System.out.println(this.pasarDatos);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.posicionY ++;
        agregarFila(this.posicionX, this.posicionY);
        System.out.println(this.pasarDatos);  // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
               this.jLabel5.setText(""); 

        char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              this.jLabel5.setText("Ingresa Solo Numeros"); 
               
          }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
                this.jLabel5.setText(""); 

        
        char c=evt.getKeyChar(); 
             
         
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              this.jLabel5.setText("Ingresa Solo Numeros"); 
               
          }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      if(this.ContadorParte2>0){
        if(Integer.valueOf(this.jTextField1.getText())>0 && Integer.valueOf(this.jTextField1.getText())<= this.posicionX ){
       if(Integer.valueOf(this.jTextField2.getText())>0 && Integer.valueOf(this.jTextField2.getText())<=this.posicionY){
       
       this.setearValor(Integer.valueOf(this.jTextField1.getText()), Integer.valueOf(this.jTextField2.getText())); 
       
       }  
       }else{
        this.jLabel5.setText("Coordenadas incorrectas");
       }
      }
      else{
       this.jLabel5.setText("Ya no hay elementos que agregar");
                       } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     if(this.ContadorParte2 >= this.jugando1){
        
        this.jLabel5.setText("Ya no hay elementos que quitar");
      }
      else{
       if(Integer.valueOf(this.jTextField1.getText())>0 && Integer.valueOf(this.jTextField1.getText())<= this.posicionX ){
       if(Integer.valueOf(this.jTextField2.getText())>0 && Integer.valueOf(this.jTextField2.getText())<=this.posicionY){
       
       this.getearValor(Integer.valueOf(this.jTextField1.getText()), Integer.valueOf(this.jTextField2.getText())); 
       
       }  
       }else{
        this.jLabel5.setText("Coordenadas incorrectas");
       }}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
 AreaJuego dg  = new AreaJuego();
                        try { 

                                    
                                    } catch (Exception ex) { 
                                    Logger.getLogger(PrimerPanel.class.getName() 
                                    ).log(Level.SEVERE, null, ex); 
                                    } 
                                    dg.setLocationRelativeTo(null); 
                                    dg.setVisible(true); 
                                    this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(SegundaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SegundaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SegundaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SegundaParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SegundaParte().setVisible(true);
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
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
