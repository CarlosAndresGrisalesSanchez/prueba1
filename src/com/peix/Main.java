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
                if (noEliminado&&numeroDePeces<15) {
                    switch (elecciones.nextInt(4)) {
                        case 0:
                            pecesPecera.add(new tiburon());
                            break;
                        case 1:
                            pecesPecera.add(new tiburon());
                            pecesPecera.get(numeroDePeces).setImagen(new GImage("tiburonHembra.png"));
                            pecesPecera.get(numeroDePeces).setSexo("Hembra");
                            ;
                            break;
                        case 2:
                            pecesPecera.add(new peces());
                            break;
                        case 3:
                            pecesPecera.add(new tiburon());
                            pecesPecera.get(numeroDePeces).setImagen(new GImage("pezHembra.png"));
                            pecesPecera.get(numeroDePeces).setSexo("Hembra");
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
                    pause(50);
                    System.out.println(numeroDePeces);
                }
                for (int i=0;i<pecesPecera.size();i++) {
                    pecesPecera.get(i).mover(pecesPecera.get(i).getDireccion(),pecesPecera.get(i).getImagen().getX(),pecesPecera.get(i).getImagen().getY());
                        /*switch (pecesPecera.get(i).getDireccion()){
                            case "arriba":
                                if (pecesPecera.get(i).getImagen().getY()<=-(pecesPecera.get(i).getImagen().getHeight())){
                                            double x=pecesPecera.get(i).getImagen().getX();
                                            remove(pecesPecera.get(i).getImagen());
                                            pecesPecera.remove(pecesPecera.get(i));;

                                          }break;
                            case "abajo":
                                System.out.println("ab");
                                if (pecesPecera.get(i).getImagen().getY()>=900) {
                                                double x = pecesPecera.get(i).getImagen().getX();
                                                remove(pecesPecera.get(i).getImagen());
                                                pecesPecera.remove(pecesPecera.get(i));
                                                noEliminado=false;
                                                numeroDePeces--;
                                            }break;
                            case "derecha":
                                System.out.println("d");
                                if (pecesPecera.get(i).getImagen().getX()<=-pecesPecera.get(i).getImagen().getWidth()) {
                                                double x = pecesPecera.get(i).getImagen().getX();
                                                remove(pecesPecera.get(i).getImagen());
                                                pecesPecera.remove(pecesPecera.get(i));
                                            }break;

                            case "izquierda":
                                System.out.println("i");
                                            if (pecesPecera.get(i).getImagen().getX()>=getGCanvas().getHeight()+pecesPecera.get(i).getImagen().getWidth()) {
                                                double x = pecesPecera.get(i).getImagen().getX();
                                                remove(pecesPecera.get(i).getImagen());
                                                pecesPecera.remove(pecesPecera.get(i));
                                            }break;
                        }*/
                    pause(5);
                        if (noEliminado) {
                            for (int j = 0; j < pecesPecera.size(); j++) {
                                if (!(i == j)) {
                                    System.out.println(pecesPecera.get(i).getImagen().getBounds().intersects(pecesPecera.get(j).getImagen().getBounds()));
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
