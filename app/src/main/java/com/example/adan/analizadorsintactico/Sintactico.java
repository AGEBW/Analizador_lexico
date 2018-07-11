package com.example.adan.analizadorsintactico;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Sintactico {
    Pila cLP=new Pila();//Variable para llevar el control de las llaves y parentesis

    public String cLlavesPar(String C){//Metodo para llevar el control de las llaves y parentesis
        String Llaves="";
        boolean b;
        String S[]=C.split("\n");
        for(int j=0; j<S.length; j++){
            for(int i=0; i<S[j].length(); i++){
                //Llaves
                if(S[j].charAt(i) == 123 ){
                    b = cLP.apilar("{");
                    if(b==false){
                        return "No se pudo añadir \"{\"  a la pila en fila "+(j+1)+" columa: "+(i+1);
                    }
                }else if( S[j].charAt(i) == 125 ){
                    b = cLP.retirar("{");
                    if(b==false){
                        return "Error de llaves en fila "+(j+1)+" columa: "+(i+1);
                    }
                }
                //Parentesis
                if(S[j].charAt(i) == 40 ){
                    b = cLP.apilar("(");
                    if(b==false){
                        return "No se pudo añadir \"(\" a la pila en fila "+(j+1)+" columa: "+(i+1);
                    }
                }else if( S[j].substring(i,i+1).equals(")") ){
                    b = cLP.retirar("(");
                    if(b==false){
                        return "Error de parentesis en fila "+(j+1)+" columa: "+(i+1);
                    }
                }
            }
        }
        //si esta vacia retorna verdadero, osea que todo esta cerrado como debe de ser
        if(cLP.estaVacia())
            return null;
        else
            return "Falta cerrar: "+cLP.mostrado();
    }

    public void MoverInstruccion(String Texto,Object[][] Simbolos){
        String Parentesis="";
        String Uno[]=Texto.split("\\.");
        String Instruccion[]=new String[5];
        Instruccion[0]=Uno[0];
        Instruccion[1]=Uno[1].substring(0,3);
        if(Uno[1].length()==14){
            Parentesis=Uno[1].substring(3,14);
        }

        if(Uno[1].length()==12){
            Parentesis=Uno[1].substring(3,12);
        }
     //   showMessageDialog(null,Parentesis);
        MainActivity mainActivity= new MainActivity();
        Toast msg = null;
        msg.setText("Parentesis"+Parentesis);

        msg.setDuration(Toast.LENGTH_SHORT);
       // msg.setView(Toast);
        msg.show();





    }

}

