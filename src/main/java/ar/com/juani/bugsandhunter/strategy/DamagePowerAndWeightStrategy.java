package ar.com.juani.bugsandhunter.strategy;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.com.juani.bugsandhunter.model.Animal;
import ar.com.juani.bugsandhunter.model.DamagePower;
import ar.com.juani.bugsandhunter.model.Weapon;

/**
 * Calculates the life power using the animal weight and
 * ties the damage power to an affected weight.
 * 
 * i.e. if the animal weight is 60kg and the damage power of the weapon is LOW (50kg per shoot),
 * the animal can resist only one shoot. 
 * 
 * @author javantario
 *
 */
public class DamagePowerAndWeightStrategy implements DamageStrategy {

    private final Map<DamagePower, Integer> damagePerWeight;
        
    public DamagePowerAndWeightStrategy() {
        damagePerWeight = Stream.of(
                new AbstractMap.SimpleImmutableEntry<>(DamagePower.LOW, 50),    
                new AbstractMap.SimpleImmutableEntry<>(DamagePower.MEDIUM, 150),    
                new AbstractMap.SimpleImmutableEntry<>(DamagePower.HIGH, 300),    
                new AbstractMap.SimpleImmutableEntry<>(DamagePower.EXTREME, 500))    
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
    public long calculateLifePower(Animal animal) {
        return animal.getWeight();
    }

    public long processAttack(Animal animal, Weapon weapon) {
        return animal.getAvailableLifePower() - damagePerWeight.get(weapon.getDamagePower());    
    }
}