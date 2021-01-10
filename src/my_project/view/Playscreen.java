package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.control.SceneControll;
import my_project.model.Person;

import java.awt.image.BufferedImage;

public class Playscreen extends GraphicalObject {


    private BufferedImage idcard;
    private BufferedImage reisepass;
    private BufferedImage fuehrerschein;
    private BufferedImage kriterien;
    private BufferedImage background;
    private Person person;
    private ProgramController pC;
    private SceneControll sC;

    public Playscreen(Person person,SceneControll sC,ProgramController pC){
        background = createImage("assets/Playscreen.jpg");
        idcard = createImage("assets/Personalausweis.png");
        reisepass = createImage("assets/Reisepass.jpg");
        fuehrerschein = createImage("assets/Fuehrerschein.jpg");
        kriterien = createImage("assets/Kriterien_blatt.jpg");
        this.person = person;
        this.sC = sC;
        this.pC = pC;
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
        drawTool.drawImage(background,0,0);
        drawTool.drawImage(idcard,1200,0);
        drawTool.drawImage(reisepass,50,0);
        drawTool.drawImage(fuehrerschein,600,0);
        drawTool.drawImage(kriterien,1200,450);
        drawPersonOnIDCard(drawTool);
        drawPersonOnDriverLicense(drawTool);
        drawPersonOnReisepass(drawTool);
        drawButtons(drawTool);
        drawKriterien(drawTool);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.formatText("Arial",1,25);
        drawTool.drawText(450,50,"Timer: "+Math.round(pC.getTimer()));
        drawTool.drawText(450,150,"Punkte:"+person.getPunkte());

    }

    public void drawButtons(DrawTool drawTool){
        drawTool.setCurrentColor(146,146,146,255);
        drawTool.drawFilledRectangle(100,700,300,150);
        drawTool.drawFilledRectangle(500,700,300,150);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(100,700,300,150);
        drawTool.drawRectangle(500,700,300,150);
        drawTool.setCurrentColor(255,0,0,255);
        drawTool.formatText("Arial",1,28);
        drawTool.drawText(150,780,"Zurückweisen");
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.drawText(570,780,"Annehmen");
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

    public void drawKriterien(DrawTool drawTool){
        try{
            drawTool.setCurrentColor(0,0,0,255);
            drawTool.formatText("Arial",1,14);
            drawTool.drawText(1220,580,"-Alle Dokumente müssen Gültig sein");
            drawTool.drawText(1220,630,"-Alle Dokumente müssen vorhanden sein");
            if(person.getKriterium() != null) {
                drawTool.drawText(1220, 680, "-" + person.getKriterium());
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }


}
