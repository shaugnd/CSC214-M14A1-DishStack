package edu.csc214.dishstack;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DishStackTest {

    @Test
    @Order(1)
    @Tag("Z")
    void zeroNewDishStackStartsEmpty() {
        DishStack stack = new DishStack();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }


    @Test
    @Order(2)
    @Tag("O")
    void oneDishCanBePeekedAndPopped() {
        DishStack  stack = new DishStack();
        Dish plate = new Dish("plate");

        stack.push(plate);

        assertSame(plate, stack.peek());
        assertSame(plate, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    @Order(3)
    @Tag("M")
    void manyDishesPopInLastInFirstOutOrder() {
        DishStack stack = new DishStack(3);
        Dish plate = new Dish("plate");
        Dish bowl = new Dish("bowl");
        Dish cup =  new Dish("cup");

        stack.push(plate);
        stack.push(bowl);
        stack.push(cup);

        assertSame(cup, stack.pop());
        assertSame(bowl, stack.pop());
        assertSame(plate, stack.pop());
    }

    @Test
    @Order(4)
    @Tag("B")
    void boundaryDishStackUsesRequestedCapacity() {
        DishStack stack = new DishStack(2);

        stack.push(new Dish("plate"));
        stack.push(new Dish("bowl"));
        stack.push(new Dish("extra cup"));

        assertEquals(2, stack.size());
        assertTrue(stack.isFull());
    }

    @Test
    @Order(5)
    @Tag("I")
    void interfaceDishStackExtendsArrayStackOfDish() {
        ArrayStack<Dish> stack = new DishStack(2);
        Dish plate = new Dish("plate");

        stack.push(plate);

        assertSame(plate, stack.pop());

    }

    @Test
    @Order(6)
    @Tag("I")
    void interfaceClearWorksThroughDishStack() {
        DishStack stack = new DishStack(2);

        stack.push(new Dish("plate"));
        stack.push(new Dish("bowl"));
        stack.clear();

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
}
