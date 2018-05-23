package com.peix;

import acm.graphics.GImage;

public abstract class pez implements animal {
    private GImage imagen;
    private String direccion;
    private String sexo;
    private String especie;

    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setImagen(GImage imagen) {this.imagen = imagen;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public void setEspecie(String especie) {this.especie = especie;}

    public GImage getImagen() {return imagen;}
    public String getDireccion() {return direccion;}
    public String getSexo() {return sexo;}
    public String getEspecie() {return especie;}
    /*public void mover(String direccion,double x,double y){
        switch (direccion){
           case  "arriba":x=0;y=1;break;
           case  "abajo": x=0;y=-1;break;
           case  "izquierda":x=-1;y=0;break;
           case  "derecha":x=1;y=0;break;
        }
        this.imagen.move(x,y);
    }*/

}
