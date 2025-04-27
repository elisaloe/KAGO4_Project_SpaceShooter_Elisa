package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.*;

public class Background extends GraphicalObject {


   /* double x = Math.random()*(Config.WINDOW_WIDTH-50) + 50;
    double y = Math.random()*(Config.WINDOW_HEIGHT-50) + 50;
    double radius = Math.random()*5+10;*/




    public void draw(DrawTool drawTool/*,double x, double y, double radius*/) {
        drawTool.setCurrentColor(63, 86, 132,255 );
        drawTool.drawFilledRectangle(0,0,800,800);

        /*drawTool.setCurrentColor(228, 198, 53, 255);
        drawTool.drawFilledCircle(Math.random()*50,300,10);*/
    }
    
}
