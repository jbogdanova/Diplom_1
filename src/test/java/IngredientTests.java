import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

public class IngredientTests {
    private IngredientType typeIngredient = FILLING;
    private String nameIngredient = "cutlet";
    private float priceIngredient = 100;

    @Test
    public void getPriceIngredient() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        Assert.assertEquals(priceIngredient, ingredient.getPrice(), 0.00001);
    }

    @Test
    public void getNameIngredient() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        Assert.assertEquals(nameIngredient, ingredient.getName());
    }

    @Test
    public void getTypeIngredient() {
        Ingredient ingredient = new Ingredient(typeIngredient, nameIngredient, priceIngredient);
        Assert.assertEquals(typeIngredient, ingredient.getType());
    }
}
