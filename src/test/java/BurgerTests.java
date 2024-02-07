import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    @Mock
    Bun bun;

    @Mock
    Ingredient bunIngredient, sauseIngredient, fillingIngredient;

    Burger burger = new Burger();

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(bunIngredient);
        burger.addIngredient(sauseIngredient);
        burger.addIngredient(fillingIngredient);
        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(bunIngredient);
        burger.addIngredient(sauseIngredient);
        burger.removeIngredient(1);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(bunIngredient);
        burger.addIngredient(sauseIngredient);
        burger.addIngredient(fillingIngredient);
        burger.moveIngredient(1, 2);
        ArrayList<Ingredient> expectedResult = new ArrayList<>(Arrays.asList(bunIngredient, fillingIngredient, sauseIngredient));
        Assert.assertEquals(expectedResult, burger.ingredients);
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(bunIngredient);
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(bunIngredient.getPrice()).thenReturn(20f);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(40f));
    }

    @Test
    public void getReceipt() {
        Bun bun = new Bun("black bun", 100);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 300,000000\n";
        assertThat(actual, equalTo(expected));
    }
}
