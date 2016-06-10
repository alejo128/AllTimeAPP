package com.example.tb_laota.volleydemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

public class Adapter extends BaseAdapter{
    private LayoutInflater inflater;
    private Activity activity;
    private List<Item> items;
    ImageLoader imageLoader=AppController.getmInstance().getmImageLoader();

    public Adapter(Activity activity,List<Item> items){
        this.activity=activity;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView ==null){
            convertView=inflater.inflate(R.layout.custom_layout,null);
        }
        if(imageLoader==null){
            imageLoader=AppController.getmInstance().getmImageLoader();
            TextView id =(TextView) convertView.findViewById(R.id.id);
            TextView nombre= (TextView) convertView.findViewById(R.id.nombre);
            TextView telefono= (TextView) convertView.findViewById(R.id.telefono);
            TextView direccion= (TextView) convertView.findViewById(R.id.dirrecion);
            TextView schedules= (TextView) convertView.findViewById(R.id.schedules);
            //getting data for row
            Item item=items.get(position);
            //obtener id
            id.setText(item.getId());
            //obtener nombre
            nombre.setText(item.getNombre());
            //obtener telefono
            //telefono.setText(String.valueOf(item.getTelefono()));
            //obtener direccion
            //direccion.setText(item.getDireccion());
            //obtener horario
            //schedules.setText(String.valueOf(item.getSchedules(schedules)));
            //String schedulesStr="";
            //for(String str: item.getSchedules(schedules)){
            //schedulesStr +=str = ",";
            //}
            //schedulesStr = schedulesStr.length()>0 ? schedulesStr.substring(0, schedulesStr.length() - 2) : schedulesStr;
            //schedules.setText(schedulesStr);

            }
            return convertView;
    }
}