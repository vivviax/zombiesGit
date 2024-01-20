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
    
    int speed = 3;
    int time = 0;
    WeaponButton weaponButton;
    SuperPower superPower;
    int superTimer;
    
    public Player () {
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW); //farbe des spielers setzen
        getImage().fillOval(0, 0, 50, 50); // form des spielers setzen
        getImage().setColor(Color.BLUE); //farbe der waffe
        getImage().fillRect(50, 25, 70, 10);//waffe eingefügt
    }
    
    public Player (WeaponButton weaponButton, SuperPower superPower) {
        this.superPower = superPower;
        this.weaponButton = weaponButton;
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.YELLOW); //farbe des spielers setzen
        getImage().fillOval(0, 0, 50, 50); // form des spielers setzen
        getImage().setColor(Color.BLUE); //farbe der waffe
        getImage().fillRect(50, 25, 70, 10);//waffe eingefügt
    }
    
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        superPowerUsed();
        hitByZombie();
    }
    
    public void turnAround() {
        if(Greenfoot.getMouseInfo() != null) //der maus ist auf dem bildschrim
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY()); //spieler dreht in richtung der maus
    }
    
    public void moveAround() {
        if(Greenfoot.isKeyDown("w")) //spieler bewegt sich mit w,a,s,d tasten
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX() - speed,getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX() + speed,getY());
    }
    
    public void fireProjectile() {
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 1) { //level 1 upgrade: 1 bullet
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
        }
        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 2) { //level 2 upgrade: 2 bullets
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10);
            projectile.move(20);
            
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(5);
        }

        if(Greenfoot.mousePressed(null) && weaponButton.weaponUpgrade == 3) { //level 3 upgrade: 3 bullets
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 10); // -+10 is the space between the bullets
            projectile.move(20);
            
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 10);
            projectile2.move(5);
            
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(5);
        }
    }
    
    public void superPowerUsed() {
        if(superPower.superCount > 99 && superTimer < 30) {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60); // -+60 is the space between the bullets
            projectile.move(20);
            
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(5);
            
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation()); // schiesst geradeaus
            projectile3.move(5);
            
            Projectile projectile1 = new Projectile();
            getWorld().addObject(projectile1, getX(), getY());
            projectile1.setRotation(getRotation() - 180); // -+10 is the space between the bullets
            projectile1.move(20);
            
            Projectile projectile21 = new Projectile();
            getWorld().addObject(projectile21, getX(), getY());
            projectile21.setRotation(getRotation() + 120);
            projectile21.move(5);
            
            Projectile projectile31 = new Projectile();
            getWorld().addObject(projectile31, getX(), getY());
            projectile31.setRotation(getRotation() -120);
            projectile31.move(5);
            
            superTimer++;
        }
        if(superTimer > 29) {
            superPower.superCount = 0;
            superTimer = 0;
        }
    }
    
    public boolean hitByZombie() {
        Actor zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        if(zombie!=null) {
            return true;
        }
        else
        return false;
    }
}

    