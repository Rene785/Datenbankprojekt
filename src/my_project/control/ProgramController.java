package my_project.control;

import KAGO_framework.control.DatabaseController;
import KAGO_framework.control.ViewController;

import java.awt.event.MouseEvent;

import static java.lang.Math.random;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute

    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private SQLControll sqlControll;
    private SceneControll sceneControll;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        sqlControll = new SQLControll();
        sceneControll = new SceneControll(viewController);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {

    }

    /**
     * Sorgt dafür, dass zunächst gewartet wird, damit der SoundController die
     * Initialisierung abschließen kann. Die Wartezeit ist fest und damit nicht ganz sauber
     * implementiert, aber dafür funktioniert das Programm auch bei falscher Java-Version
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }


    /**
     * Verarbeitet einen Mausklick.
     * @param e das Objekt enthält alle Informationen zum Klick
     */
    public void mouseClicked(MouseEvent e){
        if(sceneControll.getScene() == 1) {
            if (e.getX() > 346 && e.getX() < 646 && e.getY() > 350 && e.getY() < 450) {
                sceneControll.setScene(3);
            }
            if(e.getX()> 946 && e.getX() < 1246 && e.getY() > 350 && e.getY() <450){
                sceneControll.setScene(2);
            }
        }
        if(sceneControll.getScene() == 2){
            if(e.getX()>300 && e.getX()<610 && e.getY()>700 && e.getY()<800){
                sceneControll.setScene(1);
            }
            if(e.getX()>900 && e.getX()<1200 && e.getY()>700 && e.getY()<800){
                sceneControll.setScene(3);
            }
        }
        if(sceneControll.getScene() == 3){

        }
        if(sceneControll.getScene() == 4){

        }
    }

    public void erstelleNeuePerson(){
        double scenario = Math.random()*100;
        boolean correct = false;
        boolean notCorrect = false;
        if(scenario > 50){
            correct = true;
        }else{
            notCorrect = true;
        }
        if(correct){
            sqlControll.createNewEntity();
        }
    }

    public String zweiDimArrayinString(String[][] s){
        String result = "";
        for(int i = 0; i<s.length;i++){
            for(int j = 0;j<s[i].length;j++){
                result += s[i][j];
            }
            result += "\n";
        }
        return result;
    }

}
