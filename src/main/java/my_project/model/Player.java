package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

//    private double speed;
//    private double hoverY;
//    private boolean hoverUp;
//    private int keyToGoUp;
//    private int keyToGoDown;
//    private int direction;
    private static final double MOVE_SPEED = 5;     // Pixel pro Sekunde
    private int dirY = 0;                             // -1 = hoch, 0 = stehen, +1 = runter
    private shoot = false;

    public Player(double x, double y){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        this.x = x;
        this.y = y;
        this.shoot = shoot;

//        speed = 15;
//        hoverUp = true;
//        this.keyToGoUp    = KeyEvent.VK_W;
//        this.keyToGoDown   = KeyEvent.VK_S;
//        this.direction      = -1;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(getMyImage(),x,y/*+hoverY*/);
    }

    @Override
    public void update(double dt){
        // Bewegung auf der Stelle
//        if (hoverUp){
//            hoverY = hoverY - 8*dt;
//            if (hoverY < -5) hoverUp = false;
//        } else {
//            hoverY = hoverY + 8*dt;
//            if (hoverY > 5) hoverUp = true;
//        }
//        if(direction == 0){
//            y = y + speed*dt;
//        }
//        if(direction == 2){
//           y = y - speed*dt;
//        }
        y += dirY * MOVE_SPEED * dt;                  // Bewegung berechnen

        // Fenstergrenzen einhalten
        int maxY = Config.WINDOW_HEIGHT - getMyImage().getHeight(null);
        if(y < 0)   y = 0;
        if(y > maxY)y = maxY;
    }
//    public void keyPressed(int key) {
//        if (key == keyToGoUp){
//            direction = 2;
//        }
//        if(key == keyToGoDown){
//            direction = 0;
//        }
public void keyPressed(int key){
    if(key == KeyEvent.VK_W) dirY = -1;           // W = hoch
    if(key == KeyEvent.VK_S) dirY =  1;           // S = runter
    if(key == KeyEvent.VK_F) shoot = true;
}

    @Override
    public void keyReleased(int key){
        // nur stoppen, wenn die Taste losgelassen wurde, die gerade fährt
        if(key == KeyEvent.VK_W && dirY == -1) dirY = 0;
        if(key == KeyEvent.VK_S && dirY ==  1) dirY = 0;
    }

    public void schießen(){
        if(shoot == true){

        }
    }
    /*public void keyReleased(int key) {
        if(key == keyToGoUp){
            direction = -1;
        }
        if(key == keyToGoDown){
            direction = -1;
        }
    }*/
}
