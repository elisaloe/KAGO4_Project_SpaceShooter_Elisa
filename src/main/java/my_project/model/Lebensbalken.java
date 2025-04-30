package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;


public class Lebensbalken extends GraphicalObject {


    public Lebensbalken(double width){
       this.width = width;
    }

    public void draw(DrawTool drawTool) {

        drawTool.setCurrentColor(162,0,0,255);
        drawTool.drawFilledRectangle(50,100,100,10);
        drawTool.setCurrentColor(95,166,78,255);
        drawTool.drawFilledRectangle(50,100,width,10);
        drawTool.setCurrentColor(255,255,255,255);
        drawTool.drawRectangle(50,100,100,10);
    }

}
