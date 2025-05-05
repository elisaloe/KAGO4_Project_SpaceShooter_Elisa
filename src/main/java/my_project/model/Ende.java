package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

/**
 * Dient zum Zeichnen von nicht beweglichen Objekten im Hintergrund
 */
public class Ende extends GraphicalObject {

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.black);
        drawTool.drawFilledRectangle(0,0,800,800);
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.drawFilledCircle(70,30,2);
        drawTool.drawFilledCircle(170,60,2);
        drawTool.drawFilledCircle(20,230,2);
        drawTool.drawFilledCircle(400,130,2);
        drawTool.drawFilledCircle(230,530,2);
        drawTool.drawFilledCircle(700,630,2);
        drawTool.drawFilledCircle(700,230,2);

    }

}