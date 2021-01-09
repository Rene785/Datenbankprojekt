package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Startscreen extends GraphicalObject {

    //Attribute

    //Referenzen
    private BufferedImage background;

    public Startscreen(){
        background = createImage("assets/Do_Logo.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.setCurrentColor(146,146,146,255);
        drawTool.drawFilledRectangle(0,0,1600,900);
        drawTool.drawImage(background,200,0);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }
}
