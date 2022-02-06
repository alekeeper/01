

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamsterTest {

    Hamster hamster;

    /*
    @BeforeAll - если ставим его, то переменную Hamster и метод void нужно делать static
    static void prepareData(){
        hamster = new Hamster("Homka", 1);
    }
     */

    @BeforeEach
    void prepareData() {
        hamster = new Hamster("Homka", 1);
    }

    @Test
    void testGetDogName() {
        assertEquals("Homka", hamster.getName());
    }

    @Test
    void testSetDogName() {
        hamster.setName("Venya");
        assertEquals("Homka", hamster.getName());
    }

    @Test
    void testSetDogNameIfEmpty() {
        Hamster hamster = new Hamster("", 1);
        hamster.setName("Penya");
        assertEquals("Penya", hamster.getName());
    }

    @Test
    void testGetDogAge() {
    }

    @Test
    void testSetDogAge() {
    }
}