package com.peix;

import acm.graphics.GImage;

public interface animal {
    public void setDireccion(String direccion) ;
    public void setImagen(GImage imagen) ;
    public void setSexo(String sexo) ;
    public void setEspecie(String especie) ;
    public GImage getImagen();
    public String getDireccion() ;
    public String getSexo() ;
    public String getEspecie() ;
    public void mover(String direccion,double x,double y);
}
