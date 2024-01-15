import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Player () {
        setImage(new GreenfootImage(50,50));
        getImage().setColor(Color.YELLOW); //farbe des spielers setzen
        getImage().fillOval(0, 0, 50, 50); // form des spielers setzen
    }
    public void act()
    {
        // Add your action code here.
    }
}
