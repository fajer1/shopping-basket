package com.codurance.shoppingbasket;

import org.junit.Test;

import java.math.BigDecimal;

import static com.codurance.shoppingbasket.ProductBuilder.aBook;
import static com.codurance.shoppingbasket.ProductBuilder.aVideo;
import static com.codurance.shoppingbasket.ShoppingBasketBuilder.aShoppingBasket;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShoppingBasketShould {

    private static final BigDecimal ZERO = BigDecimal.valueOf(0.0);
    private static final BigDecimal FIVE_POUNDS = BigDecimal.valueOf(5);
    private static final BigDecimal TEN_POUNDS = BigDecimal.TEN;
    private static final BigDecimal FORTY_FIVE = BigDecimal.valueOf(45.0);
    private static final int QTY_2 = 2;
    private static final int QTY_5 = 5;
    private static final Product PRODUCT_2 = aVideo().withId("20011").costing(FIVE_POUNDS).build();
    private static final Product PRODUCT_1 = aBook().withId("10001").costing(TEN_POUNDS).build();

    @Test public void
    have_total_cost_of_zero_when_empty() {
        assertThat(aShoppingBasket().build().total(), is(ZERO));
    }

    @Test public void
    return_the_total_cost_for_a_basket_containing_items() {
        ShoppingBasket shoppingBasket = aShoppingBasket()
                                            .withItem(PRODUCT_1, QTY_2)
                                            .withItem(PRODUCT_2, QTY_5)
                                            .build();

        BigDecimal totalCost = shoppingBasket.total();

        assertThat(totalCost, is(FORTY_FIVE));
    } 

}