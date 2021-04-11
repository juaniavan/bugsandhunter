package ar.com.juani.bugsandhunter.model;

import ar.com.juani.bugsandhunter.exception.NegativeOrZeroValueException;

/**
 * Represents a Gun (Weapon).
 * 
 * The damage power will be set using the bullet's caliber for this first version.
 * 
 * @author javantario
 *
 */
public class Gun extends Weapon {

    public Gun(DamagePower damagePower) {
        super(damagePower);
    }

    /**
     * Gun constructor
     * 
     * @param caliberInMm used for setting the proper Damage Power
     */
    public Gun(float caliberInMm) {
        super();

        if (caliberInMm <= 0F) {
            throw new NegativeOrZeroValueException("caliber must NOT be less than zero");
        } else if (caliberInMm < 9F) {
            this.setDamagePower(DamagePower.LOW);
        } else if (caliberInMm < 10F) {
            this.setDamagePower(DamagePower.MEDIUM);
        } else {
            this.setDamagePower(DamagePower.HIGH);
        }
    }
}