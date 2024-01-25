import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Klasse Projectile stellt die vom Spieler abgefeuerten Kugeln dar.
 * 
 * Vivian Igboasoiyi 
 * 25.01.2024
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile() {
        setImage(new GreenfootImage(10, 2)); //10 pixel lang und 2 pixel breit
        getImage().setColor(Color.RED);
        getImage().fillRect(0, 0, 10, 2);
    }
    
    public void act()
    {
        move(10); //projectile bewegt sich
        if(isAtEdge()) {
            getWorld().removeObject(this); // Projektil entfernen, wenn es die Ecke erreicht
        }
    }
}
