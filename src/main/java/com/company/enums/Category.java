package com.company.enums;

public enum Category {
    GROCERY("Grocery"),
    GASTRONOMY("Gastronomy"),
    BABYFOOD("BabyFood"),
    DIETFOOD("DietFood"),
    FROZENPRODUCTS("FrozenProducts"),
    CONFECTIONERY("Confectionery"),
    COOKERY("Cookery"),
    DAIRY("Dairy"),
    MEAT("Meat"),
    BIRD("Bird"),
    EGG("Egg"),
    SOFTDRINKS("SoftDrinks"),
    FISH("Fish"),
    SEAFOOD("Seafood"),
    SPORTSNUTRITION("SportsNutrition"),
    FRUITS("Fruits"),
    VEGETABLES("Vegetables"),
    MUSHROOMS("Mushrooms"),
    BAKERYPRODUCTS("BakeryProducts"),
    TEA("Tea"),
    COFFEE("Coffee"),
    COCOA("Cocoa"),
    OTHERPRODUCTS("OtherProducts");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public static Category chooseCategory(int a) {
        switch (a) {
            case 1:
                return Category.GROCERY;
            case 2:
                return Category.GASTRONOMY;
            case 3:
                return Category.BABYFOOD;
            case 4:
                return Category.DIETFOOD;
            case 5:
                return Category.FROZENPRODUCTS;
            case 6:
                return Category.CONFECTIONERY;
            case 7:
                return Category.COOKERY;
            case 8:
                return Category.DAIRY;
            case 9:
                return Category.MEAT;
            case 10:
                return Category.BIRD;
            case 11:
                return Category.EGG;
            case 12:
                return Category.SOFTDRINKS;
            case 13:
                return Category.FISH;
            case 14:
                return Category.SEAFOOD;
            case 15:
                return Category.SPORTSNUTRITION;
            case 16:
                return Category.FRUITS;
            case 17:
                return Category.VEGETABLES;
            case 18:
                return Category.MUSHROOMS;
            case 19:
                return Category.BAKERYPRODUCTS;
            case 20:
                return Category.TEA;
            case 21:
                return Category.COFFEE;
            case 22:
                return Category.COCOA;
        }
        return Category.OTHERPRODUCTS;
    }

    public static void showCategoryList() {
        for (int i = 0; i < Category.values().length; i++) {
            System.out.println((i+1) + ". " + Category.values()[i].description);
        }
    }
}

