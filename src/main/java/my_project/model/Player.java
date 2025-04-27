package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double speed;
    private double hoverY;
    private boolean hoverUp;
    private int keyToGoUp;
    private int keyToGoDown;
    private int direction;

    public Player(double x, double y){
        this.setNewImage("src/main/resources/graphic/spaceship.png");
        this.x = x;
        this.y = y;
        speed = 15;
        hoverUp = true;
        this.keyToGoUp    = KeyEvent.VK_W;
        this.keyToGoDown   = KeyEvent.VK_S;
        this.direction      = -1;
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
        if(direction == 0){
            y = y + speed*dt;
        }
        if(direction == 2){
           y = y - speed*dt;
        }

    }
    public void keyPressed(int key) {
        if (key == keyToGoUp){
            direction = 2;
        }
        if(key == keyToGoDown){
            direction = 0;
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
