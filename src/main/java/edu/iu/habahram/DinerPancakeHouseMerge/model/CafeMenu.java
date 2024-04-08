package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CafeMenu extends Menu {
    private List<MenuItem> menuItems;

    public CafeMenu(String name, String description) {
        super(name, description);
        menuItems = new ArrayList<>();

        addItem("Cappuccino",
                "Espresso with steamed milk foam",
                false,
                3.49);

        addItem("Latte",
                "Espresso with steamed milk",
                false,
                3.29);

        addItem("Mocha",
                "Espresso with steamed milk and chocolate",
                false,
                3.59);

        addItem("Espresso",
                "Short black coffee",
                false,
                2.49);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(MenuItem item: getMenuItems()) {
            stringBuilder.append(item.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}
