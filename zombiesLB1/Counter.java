import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Counter-Klasse stellt den Punkte- und Geldzähler im Spiel dar.
 * Es zeigt den aktuellen Punktestand und Geldbetrag auf dem Bildschirm an.
 * 
 * Vivian Igboasoiyi 
 * 25.01.2024
 */
public class Counter extends Actor
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int score;
    int money;
    int time;
    
    public Counter() { // Bild und Aussehen des Zählers festlegen
        setImage(new GreenfootImage("Score: " + score + "\n Cash " + money, 40, Color.RED, new Color (0, 0, 0, 0))); //add counter in myworld
    }
    
    public void act() // Aktualisieren Sie die Zähler-Display
    {
        setImage(new GreenfootImage("Score: " + score + "\n Cash " + money, 40, Color.RED, new Color (0, 0, 0, 0)));
    }
}
