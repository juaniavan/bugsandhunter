package ar.com.juani.bugsandhunter.model;

/**
 * Base class for any Weapon. 
 * 
 * It uses the @DamagePower to set the level of damage it can cause. It must need to be set.
 * 
 * @author javantario
 *
 */
public class Weapon {

    private DamagePower damagePower = null;

    
    /**
     * Weapon default constructor.
     * 
     * Damage Power must be set manually afterwards. Uses LOW by default.
     */
    public Weapon() {
        this.damagePower = DamagePower.LOW;
    }

    /**
     * Weapon constructor
     * @param damagePower to use for this weapon
     */
    public Weapon(DamagePower damagePower) {
        this.damagePower = damagePower;
    }

    public DamagePower getDamagePower() {
        return damagePower;
    }

    protected void setDamagePower(DamagePower damagePower) {
        this.damagePower = damagePower;
    }
}