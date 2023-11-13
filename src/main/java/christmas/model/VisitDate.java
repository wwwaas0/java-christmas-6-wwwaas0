package christmas.model;

import christmas.validator.InputValidator;

public class VisitDate {
    private final int visitDate;

    public VisitDate(int visitDate) {
        this.visitDate = visitDate;
    }

    public VisitDate(String visitDate) {
        this.visitDate = validate(visitDate);
    }

    private int validate(String date) {
        int intDate = InputValidator.isDigit(date);
        InputValidator.outOfRange(intDate);
        return intDate;
    }

    public int getVisitDate() {
        return visitDate;
    }
}
