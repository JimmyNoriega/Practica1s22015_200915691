/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2015;

/**
 *
 * @author J.Y.N.CH
 */

public class ListaDoblNodoementeEnlazada {
    String Nombre;
    Integer Id;
 
    ListaDoblNodoementeEnlazada ant,sig;
    
   private ListaDoblNodoementeEnlazada raiz;
    
    public ListaDoblNodoementeEnlazada () {
        raiz=null;
    }
    
    
    public int cantidad ()
    {
        int cant = 0;
        ListaDoblNodoementeEnlazada reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
    
    public void modificar (Integer pos, String Nombre){
     Integer Tipo;
    Tipo= this.extraer(pos);
    this.insertar(pos,Tipo,Nombre);
    }
    
    public void borrar (int pos)
    {
        
        if (pos <= cantidad ())    {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                ListaDoblNodoementeEnlazada reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                ListaDoblNodoementeEnlazada prox = reco.sig;
                prox=prox.sig;
                reco.sig = prox;
                if (prox!=null)
                    prox.ant=reco;
            }
        }
    }
    
    public int extraer (int pos) {
        if (pos <= cantidad ())    {
            int informacion;
            if (pos == 1) {
                informacion = raiz.Id;
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                ListaDoblNodoementeEnlazada reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                ListaDoblNodoementeEnlazada prox = reco.sig;
                reco.sig = prox.sig;
                ListaDoblNodoementeEnlazada siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = prox.Id;
            }
            return informacion;
        }
        else
            return Integer.MAX_VALUE;
    }
    
     public String imprimir ()
    {
        String Impresion="";
        
        ListaDoblNodoementeEnlazada reco = raiz;
        while (reco != null) {
            Impresion += reco.Id + "_" + reco.Nombre+"/";
            reco = reco.sig;
        } 
        return Impresion;
    }
   
  
    public void insertar (Integer pos, Integer x, String Nombre)
    {
        if (pos <= cantidad () + 1)    {
            ListaDoblNodoementeEnlazada nuevo = new ListaDoblNodoementeEnlazada ();
            nuevo.Id = x;
            nuevo.Nombre = Nombre;
            if (pos == 1){
                nuevo.sig = raiz;
                if (raiz!=null)
                    raiz.ant=nuevo;
                raiz = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    ListaDoblNodoementeEnlazada reco = raiz;
                    while (reco.sig != null) {
                        reco = reco.sig;
                    }
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = null;
                    
                } else {
                    ListaDoblNodoementeEnlazada reco = raiz;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.sig;
                    ListaDoblNodoementeEnlazada siguiente = reco.sig;
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = siguiente;
                    siguiente.ant=nuevo;
                }
            
        }
    }
}
