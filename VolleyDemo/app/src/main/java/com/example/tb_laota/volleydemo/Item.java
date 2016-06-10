package com.example.tb_laota.volleydemo;

import android.widget.TextView;

public class Item {
    public String nombre, direccion, telefono;
    public int id;
    private String schedules;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getSchedules(TextView schedules) {
        return this.schedules;
    }

    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
         this.id = id;
    }
    //public Item(){

    //}
}
