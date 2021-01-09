package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Anleitungsscreen extends GraphicalObject {

    //Attribute

    //Referenzen
    private BufferedImage background;

    public Anleitungsscreen(){
        background = createImage("assets/Anleitung.png");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(background,-20,0);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }
}
