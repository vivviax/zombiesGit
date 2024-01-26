import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Zombie-Klasse kümmert sich um Zombie-Animation, Bewegung und Interaktion mit Projektilen.
 * 
 * Vivian Igboasoiyi 
 * 25.01.2024
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int animateImage = 0; // Zähler für Zombie-Animationsbilder
    int animateSpeed = 5; //Geschwindigkeit der Zombie-Animation 
    int count;
    int health = 3; // leben der Zombies
    Player player; 
    Counter counter; 
    
    public Zombie(Player mainPlayer,Counter counter) {
        this.counter = counter;
        player = mainPlayer;
        setImage("skeleton-idle_16.png");
        getImage().scale(80,80);
    }
    
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByProjectile();
    }
    
    public void animate() { 
        // Den Zombie animieren
        if(count % animateSpeed == 0) { //geschwindigkeit der zombies beim gehen
            if(animateImage > 16) {
                animateImage = 0;
            }
            setImage("skeleton-move_" + animateImage + ".png"); //zombies laufen (16 photos of zombies)
            animateImage++;
            getImage().scale(80,80); //die grösse der zombies reduktieren
        }
    }
    
    public void moveAround() {
        move(1);
        turnTowards(player.getX(), player.getY()); //Zombies drehen sich dem Spieler zu
    }
    
    public void hitByProjectile() {
        // prüfen, ob der Zombie von einem Projektil getroffen wurde
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null) {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0) {
            counter.score++; //add score for every kill
            counter.money+=5; // add money for every kill
            getWorld().removeObject(this);
        }
    }
}
