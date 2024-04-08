package edu.iu.habahram.DinerPancakeHouseMerge.model;

import org.springframework.util.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return null;
    }

    public List<MenuComponent> getMenuComponents() {
        return menuComponents;
    }


    public Iterator<MenuItem> getMenuIterator() {
        List<MenuItem> items = new ArrayList<>();
        for (MenuComponent menuComponent : menuComponents) {
            items.add((MenuItem) menuComponent);
        }
        return items.iterator();
    }
}
