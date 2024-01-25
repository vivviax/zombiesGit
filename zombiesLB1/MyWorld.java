import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die MyWorld-Klasse kümmert sich um die Spielinitialisierung, die Spielereinrichtung, das Spawnen von Zombies und den Spielfortschritt.
 * 
 * Vivian Igboasoiyi 
 * 25.01.2024
 */
public class MyWorld extends World
{
    int count = 0; //Zähler zur Erfassung der Spielzeit
    int spawnSpeed =50; // Geschwindigkeit, mit der Zombies auftauchen, nimmt mit der Zeit ab
    int randomSpawn; //enthält eine Zufallszahl zwischen 1 und 7
    public Player mainPlayer = new Player(); // Player object
    Counter counter = new Counter(); // Punkte- und Geldzähler
    HealthBar healthbar = new HealthBar(); // Lebenspunkteleiste für den Spieler
    WeaponButton weaponButton = new WeaponButton(counter); // Button für Waffen-Upgrades
    SuperPower superPower = new SuperPower(); // Superkräfte-Bar
    public MyWorld()
    {    
        // Create a new world with 10000x800 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        mainPlayer = new Player(weaponButton, superPower);
        addObject(mainPlayer, getWidth()/2, getHeight()/2); //player in myWorld einfügen
        addObject(counter, 130, 100); //counter in myWorld einfügen
        addObject(healthbar, mainPlayer.getX() -5, mainPlayer.getY() -50); //places the healthbar above the player
        addObject(weaponButton, 900, 100);
        addObject(superPower, mainPlayer.getX() + 10, mainPlayer.getY() -80);
    }
    
    public Player getPlayer() { // Getter-Methode für das Player-Objekt
        return mainPlayer;
    }
    
    public void act() {
        count++;
        // Geschwindigkeit des Spawns über die Zeit anpassen
        if(count % 600 == 0) { 
            spawnSpeed--;
        }
        // Das Spiel anhalten, wenn 'p' gedrückt wird
        while(Greenfoot.isKeyDown("p")) {
            Greenfoot.delay(1);
        }
        spawnZombies();
    }
    
    public void spawnZombies() { 
        // Switch-Anweisung, um den Spawn-Ort der Zombies zu bestimmen
        if(count % spawnSpeed == 0) {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn) {
                case 0 : addObject(new Zombie(mainPlayer, counter), 0, 0); break;
                case 1 : addObject(new Zombie(mainPlayer, counter), getWidth()/2, 0); break;
                case 2 : addObject(new Zombie(mainPlayer, counter), getWidth(), 0); break;
                case 3 : addObject(new Zombie(mainPlayer, counter), 0, getHeight()/2); break;
                case 4 : addObject(new Zombie(mainPlayer, counter), getWidth(), getHeight()/2); break;
                case 5 : addObject(new Zombie(mainPlayer, counter), 0, getHeight()); break;
                case 6 : addObject(new Zombie(mainPlayer, counter), getWidth()/2, getHeight()); break;
                case 7 : addObject(new Zombie(mainPlayer, counter), getWidth(), getHeight()); break;
            }
        }
    }
}
