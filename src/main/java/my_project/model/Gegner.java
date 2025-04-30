package my_project.model;

import KAGO_framework.view.DrawTool;
import KAGO_framework.model.GraphicalObject;
import my_project.Config;

import java.awt.*;
public class Gegner extends GraphicalObject{

    protected double speed;
    public Gegner(double x,double y, double radius, double speed) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = speed;
    }
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(50, 198, 53, 255);
        drawTool.drawFilledCircle(x, y, radius);

    }
    public void update(double dt) {
        this.x = x - speed+dt;
        if ( x< 0) jumpBack();
    }
    public void jumpBack() {
            this.x = Math.random() *(800 -820)+ 820;
            this.y = Math.random() *(Config.WINDOW_HEIGHT-50) + 50;
            this.radius = Math.random()*10;
            this.speed = Math.random()* (7 -15)+15;

    }
}