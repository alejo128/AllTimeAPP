package com.example.tb_laota.volleydemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.tb_laota.volleydemo.R.layout.listview;

public class list extends AppCompatActivity {
    private static final String url = "http://appalltime.herokuapp.com/places.json";
    private ProgressDialog dialog;
    private List<Item> array = new ArrayList<Item>();
    private ListView listView;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(listview);


        listView = (ListView) findViewById(R.id.list_item);
        adapter=new Adapter(this,array);
        listView.setAdapter(adapter);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();


        //Creat volley request obj
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();
                //parsing json
                for(int i=0;i<2;i++){
                    try{
                        JSONObject obj=response.getJSONObject(i);
                        Item item=new Item();
                        item.setId(obj.getInt("id"));
                        item.setNombre(obj.getString("nombre"));
                        item.setTelefono(obj.getString("telefono"));
                        item.setDireccion(obj.getString("direccion"));
                        item.setSchedules(obj.getString("schedules"));
                        //add to array
                        array.add(item);
                    }catch(JSONException ex){
                        ex.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getmInstance().addToRequesQueue(jsonArrayRequest);
    }
    public void hideDialog(){
        if(dialog !=null){
            dialog.dismiss();
            dialog=null;
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
