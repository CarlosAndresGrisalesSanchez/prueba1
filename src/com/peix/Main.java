package com.peix;
import java.awt.*;
import java.util.*;
import acm.program.*;
import acm.graphics.*;


public class Main {

    public static void main(String[] args) {new pecera().start();}
    public static class pecera extends GraphicsProgram{
        public void run() {
            ArrayList <pez> pecesPecera=new ArrayList<>();

            Random elecciones=new Random();
            int numeroDePeces=0;
            boolean noEliminado=true;
            setSize(1000,1000);




            while (true){
                if (!noEliminado|numeroDePeces<15) {
                    switch (elecciones.nextInt(4)) {
                        case 0:
                            pecesPecera.add(new tiburon());
                            pecesPecera.get(numeroDePeces).setEspecie("tiburon");
                            break;
                        case 1:
                            pecesPecera.add(new tiburon());
                            pecesPecera.get(numeroDePeces).setImagen(new GImage("tiburonHembra.png"));
                            pecesPecera.get(numeroDePeces).setSexo("hembra");
                            pecesPecera.get(numeroDePeces).setEspecie("tiburon");
                            break;
                        case 2:
                            pecesPecera.add(new peces());
                            pecesPecera.get(numeroDePeces).setEspecie("pez");
                            break;
                        case 3:
                            pecesPecera.add(new peces());
                            pecesPecera.get(numeroDePeces).setImagen(new GImage("pezHembra.png"));
                            pecesPecera.get(numeroDePeces).setSexo("hembra");
                            pecesPecera.get(numeroDePeces).setEspecie("pez");
                            break;

                    }
                    pecesPecera.get(numeroDePeces).setDireccion(direccionamiento());
                    pecesPecera.get(numeroDePeces).getImagen().setSize(40, 20);
                    switch (elecciones.nextInt(4)) {
                        case 0:
                            add(pecesPecera.get(numeroDePeces).getImagen(), getWidth() - 40, elecciones.nextInt(getHeight() - 20));
                            break;
                        case 1:
                            add(pecesPecera.get(numeroDePeces).getImagen(), 0, elecciones.nextInt(getHeight() - 20));
                            break;

                        case 2:
                            add(pecesPecera.get(numeroDePeces).getImagen(), elecciones.nextInt(getWidth() - 40), 0);
                            break;
                        case 3:
                            add(pecesPecera.get(numeroDePeces).getImagen(), elecciones.nextInt(getWidth() - 40), getHeight() - 20);
                            break;
                    }
                    System.out.println(pecesPecera.get(numeroDePeces).getSexo());
                    //pecesPecera.get(numeroDePeces).mover(pecesPecera.get(numeroDePeces).getDireccion(), pecesPecera.get(numeroDePeces).getImagen().getX(), pecesPecera.get(numeroDePeces).getImagen().getY());
                    pause(5);
                    System.out.println(numeroDePeces);
                    noEliminado=true;
                }
                for (int i=0;i<pecesPecera.size();i++) {
                    if (noEliminado) {
                    pecesPecera.get(i).mover(pecesPecera.get(i).getDireccion(),pecesPecera.get(i).getImagen().getX(),pecesPecera.get(i).getImagen().getY(),elecciones.nextInt(4)+1);
                        switch (pecesPecera.get(i).getDireccion()){
                            case "arriba":
                                if (pecesPecera.get(i).getImagen().getY()<-pecesPecera.get(i).getImagen().getHeight()){
                                            double x=pecesPecera.get(i).getImagen().getX();
                                            remove(pecesPecera.get(i).getImagen());
                                            add(pecesPecera.get(i).getImagen(),x,getGCanvas().getHeight());
                                          }break;
                            case "abajo":

                                if (pecesPecera.get(i).getImagen().getY()>getGCanvas().getHeight()) {
                                                double x = pecesPecera.get(i).getImagen().getX();
                                                remove(pecesPecera.get(i).getImagen());
                                                add(pecesPecera.get(i).getImagen(),x,-pecesPecera.get(i).getImagen().getHeight());
                                            }break;
                            case "derecha":
                                if (pecesPecera.get(i).getImagen().getX()>getGCanvas().getWidth()) {
                                    double y = pecesPecera.get(i).getImagen().getY();
                                                remove(pecesPecera.get(i).getImagen());
                                                add(pecesPecera.get(i).getImagen(),-pecesPecera.get(i).getImagen().getWidth(),y);
                                            }break;

                            case "izquierda":
                                            if (pecesPecera.get(i).getImagen().getX()<-pecesPecera.get(i).getImagen().getWidth()) {
                                                double y = pecesPecera.get(i).getImagen().getY();
                                                remove(pecesPecera.get(i).getImagen());
                                                add(pecesPecera.get(i).getImagen(),getGCanvas().getWidth(),y);
                                            }break;
                        }

                    pause(5);
                            for (int j = 0; j < pecesPecera.size(); j++) {

                                if (!(i == j)) {
                                   if(pecesPecera.get(i).getImagen().getBounds().intersects(pecesPecera.get(j).getImagen().getBounds())){
                                       remove(pecesPecera.get(i).getImagen());
                                       //pecesPecera.remove(pecesPecera.get(i));
                                       //remove(pecesPecera.get(j).getImagen());
                                       //if (i>j){pecesPecera.remove(pecesPecera.get(j));}//else {pecesPecera.get(j-1);};
                                       System.out.println(pecesPecera.get(i).getEspecie()+" "+pecesPecera.get(j).getEspecie());
                                   };
                                }
                            }
                        }
                }



                if (noEliminado){if (numeroDePeces<15) numeroDePeces++;}


            }
        }
        public String direccionamiento(){
            switch (new Random().nextInt(4)){
                case 0:return "abajo";
                case 1:return "arriba";
                case 2:return "izquierda";
                case 3:return "derecha";
            }
            return "arriba";
        }
    }

}
