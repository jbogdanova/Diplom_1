import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTests {

    private IngredientType ingredientType;
    private IngredientType expectedIngredientType;
    private String NAME_INGREDIENT = "test";
    private float PRICE_INGREDIENT = 100;

    public IngredientTypeTests(IngredientType ingredientType, IngredientType expectedIngredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, SAUCE},
                {FILLING, FILLING}
        };
    }

    @Test
    public void getTypeIngredientWithTestData() {
        Ingredient ingredient = new Ingredient(ingredientType, NAME_INGREDIENT, PRICE_INGREDIENT);
        Assert.assertEquals(expectedIngredientType, ingredient.getType());
    }
}
