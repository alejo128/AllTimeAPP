package com.example.tb_laota.volleydemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MiLista extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        registrarEventos();
            dialog = new ProgressDialog(this);
            dialog.setMessage("Cargando...");
            dialog.show();
        }

    public void hideDialog(){
        if(dialog !=null){
            dialog.dismiss();
            dialog=null;
        }

    }

    private void registrarEventos() {

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.nombre);
        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /// Obtiene el valor de la casilla elegida
                String itemSeleccionado = adapterView.getItemAtPosition(i).toString();
                // muestra un mensaje
                Toast.makeText(getApplicationContext(), "Información " + itemSeleccionado, Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}