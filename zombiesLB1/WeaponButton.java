import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponButton extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Counter counter; // Verweis auf das Counter-Objekt
    int weaponUpgrade = 1; // Aktuelle Waffenaufrüstungsstufe
    
    public WeaponButton (Counter counter) {
        this.counter = counter;
        setImage(new GreenfootImage("Weapon \n Upgrade", 25, Color.RED, new Color(0,0,0,0)));
    }
    
    public void act()
    {
        // Waffe aufrüsten, wenn sie angeklickt wird und der Spieler genug Geld hat
        if(Greenfoot.mousePressed(this) && counter.money > 149) { //weapon can only be upgraded when the cash is over 150
            counter.money -= 150;
            weaponUpgrade++;
        }
        // Begrenzung der Waffenaufrüstungsstufe auf 3
        if(weaponUpgrade > 3) {
            weaponUpgrade = 3;
        }
    }
}
