package com.example.adan.analizadorsintactico;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.adan.analizadorsintactico.R.id.tipos;

public class MainActivity extends AppCompatActivity {

EditText t1;
TextView error;
TableLayout tipos;
Button p1;
Activity actividad;
Resources rs;
int FILAS,COLUMNAS;
ArrayList<TableRow> filas;
ArrayList<String> elementos= null;
String texto=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=findViewById(R.id.texto);
        error=findViewById(R.id.error);
        p1=findViewById(R.id.btn);
        tipos = this.<TableLayout>findViewById(R.id.tipos);


       // Toast toast3 = new Toast(getApplicationContext());
       // LayoutInflater inflater = getLayoutInflater();
       // View layout = inflater.inflate(R.layout.,
       //         (ViewGroup) findViewById(R.id.lytLayout));

        p1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){


                Analisis_Lexico A = new Analisis_Lexico();
                String Err="";
    //            model = (javax.swing.table.DefaultTableModel)tblSimbolos.getModel();
      //          model.setRowCount(0);
                ArrayAdapter<String> model;
                //model = new ArrayAdapter<String>(android.R.layout.simple_list_item_1,tipos);
                String cadena=(t1.getText().toString());
                TableRow row= new TableRow(getBaseContext());
                TextView textView;
                for(int i=0;i<4;i++) {
                textView = new TextView(getBaseContext());
                textView.setGravity(Gravity.CENTER_VERTICAL);
                }
//        String temp="hola,,como,estas,,?";
//        System.out.println(mostrar(temp.split(",")));
              //utilice cadena para poder indicar que el arreglo almacenara
              //lo que contenga la cadena separada
                String[] lineas= cadena.split("\n");


                for(int i=0;i<lineas.length;i++){

                    String ts[]=A.Compile(lineas[i],(i+1)).split("#");
                    for(int Q=0;Q<ts.length;Q++){
                        String Row[]=ts[Q].split(",");
                        if(Row[0].equals("Desconocido") || Row[0].equals("Elemento Desconocido")){
                            Err=Err+"Error Léxico;; Simbolo Desconocido: "+Row[1]+" Encontrado en la línea "+Row[4]+"\n";
                        }
                        else{
                        //    model.addRow(Row);
                            row.addView(p1);
                            tipos.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
                        }
                    }
                }
                if(!(Err.equals(""))){
                    error.setText(Err);
                }
                else{error.setText("Build Succesful");}

                Sintactico Syntax=new Sintactico();
                String Error=Syntax.cLlavesPar(cadena);
//       if(!(Error.equals(""))){ErrCon.setText(Error);}

                //Llenado tabla simbolos
             /*   Object[][] Symbols=new Object[row.getChildCount()][row.getChildAt()];
                for(int R=0;R<row.getChildCount();R++){
                    for(int C=0; C<row.getChildAt();C++)
                    {
                        Symbols[R][C]=row.getValueAt(R,C).toString();
                    }

                }

                Syntax.MoverInstruccion(cadena,Symbols);//Mandamos a llamar el metodo para hacer al analisis sintáctico
*/

/*

                public void agregarCabecera(int recursocabecera)
                {
                    TableRow.LayoutParams layoutCelda;
                    TableRow fila = new TableRow(actividad);
                    TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                    fila.setLayoutParams(layoutFila);

                    String[] arraycabecera = rs.getStringArray(recursocabecera);
                    COLUMNAS = arraycabecera.length;

                    for(int i = 0; i < arraycabecera.length; i++)
                    {
                        TextView texto = new TextView(actividad);
                      //  layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(arraycabecera[i]), TableRow.LayoutParams.WRAP_CONTENT);
                        texto.setText(arraycabecera[i]);
                        texto.setGravity(Gravity.CENTER_HORIZONTAL);
                       // texto.setLayoutParams(layoutCelda);

                        fila.addView(texto);
                    }

                    tipos.addView(fila);
                    filas.add(fila);

                    FILAS++;
                }

                public void agregarFilaTabla(ArrayList<String> elementos)
                {
                    TableRow.LayoutParams layoutCelda;
                    TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
                    TableRow fila = new TableRow(actividad);
                    fila.setLayoutParams(layoutFila);

                    for(int i = 0; i< elementos.size(); i++)
                    {
                        TextView texto = new TextView(actividad);
                        texto.setText(String.valueOf(elementos.get(i)));
                        texto.setGravity(Gravity.CENTER_HORIZONTAL);
                      //  layoutCelda = new TableRow.LayoutParams(obtenerAnchoPixelesTexto(texto.getText().toString()), TableRow.LayoutParams.WRAP_CONTENT);
                       // texto.setLayoutParams(layoutCelda);

                        fila.addView(texto);
                    }

                    tipos.addView(fila);
                    filas.add(fila);

                    FILAS++;
                }
                public void obtenerAnchoPixelesTexto(String texto)
                {
                    Paint p = new Paint();
                    Rect bounds = new Rect();
                    p.setTextSize(50);

                    p.getTextBounds(texto, 0, texto.length(), bounds);
                    return bounds.width();
                }
            }//GEN-LAST:event_jButton1ActionPerformed

            private String mostrar(String[] s){
                String temp="";
                for(int i=0; i<s.length; i++){
                    if(!s[i].equals(""))
                        temp=temp+s[i]+"-";
                }
                return temp;
            }
*/
        }

        });



    }



}
