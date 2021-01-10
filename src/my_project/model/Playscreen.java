package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.SceneControll;

import java.awt.image.BufferedImage;

public class Playscreen extends GraphicalObject {


    private BufferedImage idcard;
    private BufferedImage reisepass;
    private BufferedImage fuehrerschein;
    private Person person;
    private double timer;
    private boolean timerOver;
    private SceneControll sC;

    public Playscreen(Person person,SceneControll sC){
        idcard = createImage("assets/Personalausweis.png");
        reisepass = createImage("assets/Reisepass.jpg");
        fuehrerschein = createImage("assets/Fuehrerschein.jpg");
        this.person = person;
        timer = 60;
        timerOver = false;
        this.sC = sC;
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(idcard,1200,0);
        drawTool.drawImage(reisepass,50,0);
        drawTool.drawImage(fuehrerschein,600,0);
        drawPersonOnIDCard(drawTool);
        drawPersonOnDriverLicense(drawTool);
        drawPersonOnReisepass(drawTool);
        drawTool.formatText("Arial",1,25);
        drawTool.drawText(450,50,"Timer: "+Math.round(timer));
    }

    public void drawPersonOnIDCard(DrawTool drawTool){
        try{
            drawTool.setCurrentColor(255,255,255,255);
            drawTool.drawText(1350,45,person.getVorname());
            drawTool.drawText(1350,70,person.getNachname());
            drawTool.drawText(1350,95,person.getStaatsangehoerigkeit());
            drawTool.drawText(1350,120,person.getPerso_gueltig());
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void drawPersonOnDriverLicense(DrawTool drawTool){
        try{
            drawTool.formatText("Arial",1,15);
            drawTool.drawText(770,100,person.getVorname());
            drawTool.drawText(770,130,person.getNachname());
            drawTool.drawText(770,160, person.getStaatsangehoerigkeit());
            drawTool.drawText(770,185, person.getFuehrerschein_gueltig());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void drawPersonOnReisepass(DrawTool drawTool){
        try{
            drawTool.setCurrentColor(0,0,0,255);
            drawTool.formatText("Arial",1,12);
            drawTool.drawText(205,330, person.getVorname());
            drawTool.drawText(205,350, person.getNachname());
            drawTool.drawText(205,370, person.getStaatsangehoerigkeit());
            drawTool.drawText(205,450, person.getReisepass_gueltig());
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        timer -= 1*dt;
        if(timer<=0){
            sC.setScene(4);
        }
    }

}
