package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Playscreen extends GraphicalObject {


    private BufferedImage idcard;
    private BufferedImage reisepass;
    private BufferedImage fuehrerschein;

    public Playscreen(){
        idcard = createImage("assets/Personalausweis.png");
        reisepass = createImage("assets/Reisepass.jpg");
        fuehrerschein = createImage("assets/Fuehrerschein.jpg");
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(idcard,1200,0);
        drawTool.drawImage(reisepass,50,0);
        drawTool.drawImage(fuehrerschein,600,0);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }
}
