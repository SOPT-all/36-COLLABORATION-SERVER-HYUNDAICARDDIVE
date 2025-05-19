package org.sopt.hyundai.card.service;

public enum CardCategory {
    TOTAL("total"),
    DESIGN("design"),
    BUILDING("building"),
    TRIP("trip"),
    MUSIC("music"),
    COOKING("cooking"),
    STYLE("style"),
    TECH("tech"),
    SPECIAL("special");

    private final String value;

    CardCategory(String value) {
        this.value = value;
    }

    public static boolean isValid(String input) {
        for (CardCategory category : values()) {
            if (category.value.equalsIgnoreCase(input)) return true;
        }
        return false;
    }
}