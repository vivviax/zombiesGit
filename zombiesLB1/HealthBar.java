import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die HealthBar-Klasse stellt die Gesundheitsleiste des Spielers im Spiel dar.
 * Es zeigt die Gesundheit des Spielers an.
 * 
 * Vivian Igboasoiyi 
 * 25.01.2024
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50; // Gesundheit des Spielers
    
    
    public HealthBar() { // Bild und Aussehen der Gesundheitsleiste festlegen
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1, 1, health, 10);
    }
    
    public void act()
    {
        // Aktualisieren der Anzeige der Gesundheitsleiste
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0, 0, 51, 11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1, 1, health, 10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX() -5, myWorld.getPlayer().getY() -50); //healthbar follows the player
        loseHealth(); // Überprüfung auf Gesundheitsschäden
    }
    
    public void loseHealth() {
        // Gesundheit verringern, wenn der Spieler von Zombies getroffen wird
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if(myWorld.getPlayer().hitByZombie()) { //subtract health when hit by zombies
        health--;
        }
        if(health<=0) {
        getWorld().showText("You Lose! \n You survived for " + (myWorld.getPlayer().time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
        }
    }
}
