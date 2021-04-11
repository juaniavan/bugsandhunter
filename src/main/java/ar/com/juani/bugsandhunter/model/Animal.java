package ar.com.juani.bugsandhunter.model;

import ar.com.juani.bugsandhunter.exception.NegativeOrZeroValueException;
import ar.com.juani.bugsandhunter.strategy.DamagePowerAndWeightStrategy;
import ar.com.juani.bugsandhunter.strategy.DamageStrategy;

/**
 * Base class for any Animal. It uses the weight in kg as part of the @DamageStrategy.
 * 
 * In this first version we will use an strategy based in weight 
 * for calculating the available life power @DamagePowerAndWeightStrategy.
 * 
 * @author javantario
 *
 */
public class Animal {

    private final DamageStrategy damageStrategy;

    private long weightInKg = 0;
    private long availableLifePower = 0;

    /**
     * Animal constructor
     * 
     * @param weightInKg for the animal. Must not be zero or less.
     */
    public Animal(long weightInKg) {

        if (weightInKg > 0) {
            this.weightInKg = weightInKg;
            damageStrategy = new DamagePowerAndWeightStrategy();
            this.availableLifePower = damageStrategy.calculateLifePower(this);
        } else {
            throw new NegativeOrZeroValueException("weight cannot be zero or negative");
        }
    }

    /**
     * @return Returns true if the animal is still alive, false otherwise.
     */
    public final boolean isAlive() {
        return availableLifePower > 0;
    }

    /**
     * Process the attack in the animal through the strategy and recalculates the available life power.
     * 
     * @param weapon for attacking the animal. Must not be null.
     */
    public final void receiveAttack(Weapon weapon) {
        this.availableLifePower = damageStrategy.processAttack(this, weapon);
    }

    public final long getWeight() {
        return weightInKg;
    }

    public final long getAvailableLifePower() {
        return availableLifePower;
    }
}