package christmas.model;

import java.util.List;

public class Discount {
    private final int visiteDate;

    private final List<DiscountType> discounts;

    public Discount(int visiteDate, List<DiscountType> discounts) {
        this.visiteDate = visiteDate;
        this.discounts = discounts;
    }
}
