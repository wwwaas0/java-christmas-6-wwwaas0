package christmas.model;

public class Discount {
    private final int visiteDate;
    private final boolean christmasDayDiscount;
    private final boolean weekdayDiscount;
    private final boolean weekendDiscount;
    private final boolean specialDiscount;

    public Discount(int visiteDate, boolean christmasDayDiscount, boolean weekdayDiscount,
                    boolean weekendDiscount, boolean specialDiscount) {
        this.visiteDate = visiteDate;
        this.christmasDayDiscount = christmasDayDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
    }
}
