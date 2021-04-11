package ar.com.juani.bugsandhunter.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.com.juani.bugsandhunter.exception.NegativeOrZeroValueException;

class ModelTests {

    private Hunter hunter;

    @BeforeEach
    void setup() {
        hunter = new Hunter();
    }

    @Test
    void givenAnAnimalShouldReceiveOnlyOneAttack() {
        Animal deer = new Animal(100);
        Weapon bow = new Weapon(DamagePower.LOW);

        assertTrue(deer.isAlive());
        hunter.shoot(deer, bow);
        assertTrue(deer.isAlive());
        hunter.shoot(deer, bow);
        assertFalse(deer.isAlive());
    }

    @Test
    void givenAnAnimalShouldReceiveOnlyOneShoot() {
        Animal deer = new Animal(100);
        Gun twentyTwo = new Gun(DamagePower.LOW);

        assertTrue(deer.isAlive());
        hunter.shoot(deer, twentyTwo);
        assertTrue(deer.isAlive());
        hunter.shoot(deer, twentyTwo);
        assertFalse(deer.isAlive());
    }

    @Test
    void givenALowCaliberShouldReturnLowDamagePower() {
        Gun twentyTwo = new Gun(5.58F);
        assertEquals(DamagePower.LOW, twentyTwo.getDamagePower());
    }

    @Test
    void givenAMediumCaliberShouldReturnMediumDamagePower() {
        Gun twentyTwo = new Gun(9F);
        assertEquals(DamagePower.MEDIUM, twentyTwo.getDamagePower());
    }

    @Test
    void givenALargeCaliberShouldReturnHighDamagePower() {
        Gun twentyTwo = new Gun(11.5F);
        assertEquals(DamagePower.HIGH, twentyTwo.getDamagePower());
    }

    @Test
    void givenANegativeCaliberForGunShouldReturnNegativeException() {

        assertThrows(NegativeOrZeroValueException.class, () -> new Gun(-11.5F));
    }

    @Test
    void givenANegativeWeightForAnimalShouldReturnNegativeException() {
        
        assertThrows(NegativeOrZeroValueException.class, () -> new Animal(-500));
    }
    
    
}
