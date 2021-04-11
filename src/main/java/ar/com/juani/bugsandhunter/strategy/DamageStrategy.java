package ar.com.juani.bugsandhunter.strategy;

import ar.com.juani.bugsandhunter.model.Animal;
import ar.com.juani.bugsandhunter.model.Weapon;

/**
 * Damage strategy interface.
 * 
 * Used for getting the life power at the time the animal is created
 * and recalculating it for every received shoot depending on the weapon.
 * 
 * @author javantario
 *
 */
public interface DamageStrategy {

    /**
     * Calculates the available life power using the animal properties.
     * 
     * @param animal must not be null
     * @return a number representing the available life power
     */
    long calculateLifePower(Animal animal);

    /**
     * Processes an attack in the animal
     * 
     * @param animal that receives the attack. must not be null.
     * @param weapon being used for attacking. must not be null.
     * @return remaining animal life power
     */
    long processAttack(Animal animal, Weapon weapon);
}
