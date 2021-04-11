package ar.com.juani.bugsandhunter.model;


/**
 * Represents a Hunter.
 * 
 * 
 * @author javantario
 *
 */
public class Hunter {

    /**
     * shoot an animal with a weapon
     * 
     * @param animal
     *            to be shoot
     * @param weapon
     *            used to shoot
     */
    public final void shoot(Animal animal, Weapon weapon) {
        animal.receiveAttack(weapon);
    }
}