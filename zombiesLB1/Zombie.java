import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0;
    int animateSpeed = 5; //Geschwindigkeit der Zombies 
    int count;
    
    public Zombie() {
        setImage("skeleton-idle_16.png");
        getImage().scale(80,80);
    }
    public void act()
    {
        count++;
        animate();
    }
    
    public void animate() {
        if(count % animateSpeed == 0) { //geschwindigkeit der zombies beim gehen
            if(animateImage > 16) {
                animateImage = 0;
            }
            setImage("skeleton-move_" + animateImage + ".png"); //zombies laufen
            animateImage++;
            getImage().scale(80,80); //die grösse der zombies reduktieren
        }
    }
}
