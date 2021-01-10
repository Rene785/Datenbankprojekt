package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Person;

import java.awt.image.BufferedImage;

public class Endscreen extends GraphicalObject {

    //Attribute

    //Referenzen
    private BufferedImage endscreen1;
    private BufferedImage endscreen2;
    private BufferedImage endscreen3;
    private Person person;

    public Endscreen(Person person){
        endscreen1 = createImage("assets/Endscreen_1.png");
        endscreen2 = createImage("assets/Endscreen_1.2.jpg");
        endscreen3 = createImage("assets/Endscreen_3.jpg");
        this.person = person;
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        if(person.getPunkte()<10){
            drawTool.drawImage(endscreen1,100,0);
            drawTool.drawImage(endscreen2,1000,350);
        }else{
            drawTool.drawImage(endscreen3,0,0);
        }
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }
}
