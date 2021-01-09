package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Anleitungsscreen;
import my_project.model.Endscreen;
import my_project.model.Playscreen;
import my_project.model.Startscreen;

public class SceneControll {

    //Attribute
    private int scene;

    //Referenzen
    private ViewController viewController;
    private Startscreen startscreen;
    private Playscreen playscreen;
    private Endscreen endscreen;
    private Anleitungsscreen anleitungsscreen;

    public SceneControll(ViewController viewController){
        scene = 0;
        this.viewController = viewController;
        startscreen = new Startscreen();
        playscreen = new Playscreen();
        endscreen = new Endscreen();
        anleitungsscreen = new Anleitungsscreen();
        setScene(1);
    }

    public void setScene(int s){
        if(scene == 1){
            viewController.removeDrawable(startscreen);
        }else if(scene == 2){
            viewController.removeDrawable(anleitungsscreen);
        }else if(scene == 3){
            viewController.removeDrawable(playscreen);
        }else if(scene == 4){
            viewController.removeDrawable(endscreen);
        }
        scene = s;
        if(scene == 1){
            viewController.draw(startscreen);
        }else if(scene == 2){
            viewController.draw(anleitungsscreen);
        }else if(scene == 3){
            viewController.draw(playscreen);
        }else if(scene == 4){
            viewController.draw(endscreen);
        }
    }

    public int getScene(){
        return scene;
    }

}
