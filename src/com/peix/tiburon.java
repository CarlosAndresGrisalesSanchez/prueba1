package com.peix;

import acm.graphics.GImage;

public class tiburon extends pez{
    GImage imagen=new GImage("tiburon.png");
    String sexo="macho";

    @Override
    public GImage getImagen() {
        return imagen;
    }

    @Override
    public void setImagen(GImage imagen) {
        this.imagen = imagen;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this.sexo=sexo;
    }

    @Override
    public void mover (String direccion, double x, double y) {
        switch (direccion){
            case  "arriba":x=0;y=1;break;
            case  "abajo": x=0;y=-1;break;
            case  "izquierda":x=-1;y=0;break;
            case  "derecha":x=1;y=0;break;
        }
        this.imagen.move(x,y);
    }
}

