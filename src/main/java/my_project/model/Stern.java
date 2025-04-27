package my_project.model;

import KAGO_framework.view.DrawTool;
import KAGO_framework.model.GraphicalObject;
import my_project.Config;

import java.awt.*;
public class Stern extends GraphicalObject{

    protected double speed;
    public Stern(double x,double y, double radius,double speed) {
        this.x = x;
        this.y =y;
        this.radius = radius;
        this.speed = speed;
    }
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(228, 198, 53, 255);
        drawTool.drawFilledCircle(x, y, radius);
        drawTool.setCurrentColor(255, 255, 255, 255);
        drawTool.drawFilledCircle(x, y, radius);
    }
    public void update(double dt) {
        this.x = x - speed+dt;
        jumpBack();
    }
    public void jumpBack() {
        if (x < -5) {
            this.x = 805;
        }
    }
}
