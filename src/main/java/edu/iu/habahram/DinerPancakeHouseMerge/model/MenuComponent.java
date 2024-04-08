package edu.iu.habahram.DinerPancakeHouseMerge.model;

import org.springframework.util.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public List<MenuItem> getItems() {
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<MenuItem> createIterator();
}
