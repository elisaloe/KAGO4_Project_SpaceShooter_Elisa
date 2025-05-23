package my_project.control;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import my_project.Config;
import my_project.model.*;
import my_project.view.InputManager;

import java.awt.event.KeyEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern.
 * Hinweise:
 * - Der Konstruktor sollte nicht geändert werden.
 * - Sowohl die startProgram()- als auch die updateProgram(...)-Methoden müssen vorhanden sein und ihre Signatur sollte
 *   nicht geändert werden
 * - Zusätzliche Methoden sind natürlich gar kein Problem
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Player p1;
    private int currentScene;
    private Gegner enemy;
    private Gegner[] enemys;

    private Lebensbalken leben;
    private Planet planet;
    // Das ist ein toller Kommentar

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Hier sollte also alles geregelt werden,
     * was zu diesem Zeipunkt passieren muss.
     */
    public void startProgram() {
        // Vorbereitungen
        InputManager inputManager = new InputManager(this);
        currentScene = 0;

        // Startbildschirm (Szene 0)
        // Ton
        viewController.getSoundController().loadSound("src/main/resources/sound/bgm_startScreen.mp3","startBGM", true);
        SoundController.playSound("startBGM");
        // Bild
        StartBackground sback = new StartBackground();
        viewController.draw(sback,0);
        Picture titleText = new Picture(100, 200, "src/main/resources/graphic/title_text.png");
        viewController.draw(titleText,0);
        // Interaktion
        viewController.register(inputManager,0);

        // Spielbildschirm (Szene 1)
        viewController.createScene();
        Background bground = new Background();
        viewController.draw(bground,1);
        for (int i = 0; i < 20; i++) {
            Stern star = new Stern(Math.random() *(Config.WINDOW_WIDTH-50) + 50,  Math.random() * 800,Math.random()*4,5);
            viewController.draw(star,1);
        }
        for (int i = 0; i < 25; i++) {
            Stern star = new Stern(Math.random() *(Config.WINDOW_WIDTH-50) + 50,  Math.random() * 800,2,3.5);
            viewController.draw(star,1);
        }
        for (int i = 0; i < 30; i++) {
            Stern star = new Stern(Math.random() *(Config.WINDOW_WIDTH-50) + 50,  Math.random() * 800,1,2);
            viewController.draw(star,1);
        }
        enemys = new Gegner[5];
        for (int i = 0; i < enemys.length;  i++) {
            enemys[i] = new Gegner(Math.random() *(Config.WINDOW_WIDTH-50) + 50,Math.random() * 800,Math.random()*10,5);
            viewController.draw(enemys[i],1);
        }




        p1 = new Player(50,300);
        viewController.draw(p1,1);
        viewController.register(p1, 1);
        leben = new Lebensbalken(100);
        viewController.draw(leben,1);
        planet = new Planet(Math.random() *(Config.WINDOW_WIDTH-50) + 50,Math.random() * 800,Math.random()*10,5);
        viewController.draw(planet,1);

        // Endbildschirm (Szene 2)
        viewController.createScene();
        Ende end = new Ende();
        viewController.draw(end,2);
    }


    /**
     * Diese Methode wird vom ViewController-Objekt automatisch mit jedem Frame aufgerufen (ca. 60mal pro Sekunde)
     * @param dt Zeit seit letztem Frame in Sekunden
     */
    public void updateProgram(double dt){
        //System.out.println("P1: " + p1.getWidth() + " " + p1.getHeight());
        //System.out.println("Gegner: " + enemy.getRadius());
        if(p1.collidesWith(enemys)) {
            leben.setWidth( leben.getWidth()-10 );
            enemy.jumpBack();
            p1.setLife(p1.getLife()-10 );
        }
        if(p1.getLife()<=0 && currentScene == 1){
            currentScene = 2;
            viewController.showScene(currentScene);
        }
    }

    public void processKeyboardInput(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE && currentScene == 0) {
            currentScene = 1;
            viewController.showScene(currentScene);
            SoundController.stopSound("startBGM");
        }

    }
}
