package com.company.enums;

import com.company.logger.Loggers;

public enum Menu {
    ADDPRODUCT("Add the product"),
    REMOVEPRODUCT("Remove product"),
    FINDPRODUCT("Find the product"),
    DISPLAYPRODUCTS("Display all products"),
    CHANGEPRODUCTINFO("Change product information"),
    FILTRATION("Filtration"),
    SETDISCOUNTFORCATEGORY("Set discount for category"),
    SHOWPRODUCTSFROMONECATEGORY("Remove products from a specific category"),
    EXIT("Exit");

    private final String description;

    Menu(String description) {
        this.description = description;
    }

    public static void MenuShow() {
        Loggers loggers = new Loggers(Menu.class.getName());
        for (int i = 0; i < Menu.values().length ; i++) {
           loggers.log.info((i+1) + ". " + Menu.values()[i].description);
        }
    }
}
