package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatCafeTest {

    private CatCafe cafe;
    private FelineOverLord cat1;
    private FelineOverLord cat2;

    @BeforeEach
    void setUp() {
        cafe = new CatCafe();
        cat1 = new FelineOverLord("Milo", 2);
        cat2 = new FelineOverLord("Luna", 5);
    }

    @Test
    void givenEmptyCafe_whenGettingCatCount_thenReturnsZero() {
        assertEquals(0, cafe.getCatCount());
    }

    @Test
    void givenOneAddedCat_whenGettingCatCount_thenReturnsOne() {
        cafe.addCat(cat1);
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void givenTwoAddedCats_whenGettingCatCount_thenReturnsTwo() {
        cafe.addCat(cat1);
        cafe.addCat(cat2);

        assertEquals(2, cafe.getCatCount());
    }

    @Test
    void givenNullCat_whenAddingCat_thenThrowsException() {
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }

    @Test
    void givenExistingCatName_whenGettingCatByName_thenReturnsCat() {
        cafe.addCat(cat1);

        FelineOverLord result = cafe.getCatByName("Milo");

        assertEquals(cat1, result);
    }

    @Test
    void givenUnknownCatName_whenGettingCatByName_thenReturnsNull() {
        cafe.addCat(cat1);

        assertNull(cafe.getCatByName("Ghost"));
    }

    @Test
    void givenNullName_whenGettingCatByName_thenReturnsNull() {
        cafe.addCat(cat1);

        assertNull(cafe.getCatByName(null));
    }

    @Test
    void givenCats_whenGettingByWeightWithinRange_thenReturnsCorrectCat() {
        cafe.addCat(cat1);
        cafe.addCat(cat2);

        FelineOverLord result = cafe.getCatByWeight(1, 3);

        assertEquals(cat1, result);
    }

    @Test
    void givenWeightExactlyAtLowerBound_whenGettingByWeight_thenReturnsCat() {
        cafe.addCat(cat1); // weight = 2

        FelineOverLord result = cafe.getCatByWeight(2, 10);

        assertEquals(cat1, result);
    }

    @Test
    void givenWeightExactlyAtUpperBound_whenGettingByWeight_thenReturnsNull() {
        cafe.addCat(cat1); // weight = 2

        FelineOverLord result = cafe.getCatByWeight(0, 2);

        assertNull(result);
    }

    @Test
    void givenInvalidWeightRange_whenGettingByWeight_thenReturnsNull() {
        cafe.addCat(cat1);

        assertNull(cafe.getCatByWeight(5, 2));
    }

    @Test
    void givenNegativeMinWeight_whenGettingByWeight_thenReturnsNull() {
        cafe.addCat(cat1);

        assertNull(cafe.getCatByWeight(-1, 5));
    }
}

