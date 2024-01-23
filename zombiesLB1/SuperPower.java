import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPower extends Actor
{
    /**
     * Act - do whatever the SuperPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    final int SUPER_POWER_LIMIT = 100; // Maximaler Wert der Superkraft (final bedeutet es ändert sich nie)
    int superCount; // Aktueller Wert der Superkraft
    int count; 
    public SuperPower() { // Bild und Aussehen der Superkraftleiste festlegen
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        getImage().drawRect(0, 0, SUPER_POWER_LIMIT + 1, 11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1, 1, superCount, 10);
    }
    
    public void act()
    {   
        // Aktualisieren der Anzeige der Superkräfteleiste
        setImage(new GreenfootImage(SUPER_POWER_LIMIT + 2, 12));
        getImage().drawRect(0, 0, SUPER_POWER_LIMIT + 1, 11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1, 1, superCount, 10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX() +10, myWorld.getPlayer().getY() -80); //healthbar follows the player
        
        useSuper(); // Überprüfen Sie die Verwendung von Superkräften
    }
    
    public void useSuper() {
        count++;
        if(count % 5 == 0) // Erhöhen des Balkens alle 5 Zählzeiten
        
        superCount++;
        
    }
}
