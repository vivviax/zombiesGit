import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile() {
        setImage(new GreenfootImage(10, 2)); //10 pixel lang und 2 pixel breit
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 25, 10, 2);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
