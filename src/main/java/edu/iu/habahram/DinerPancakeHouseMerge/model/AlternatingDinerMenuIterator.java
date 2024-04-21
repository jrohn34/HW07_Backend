package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        Calendar date = Calendar.getInstance();
        int day_of_week = date.get(Calendar.DAY_OF_WEEK);
        if (day_of_week == Calendar.MONDAY || day_of_week == Calendar.WEDNESDAY || day_of_week == Calendar.FRIDAY || day_of_week == Calendar.SUNDAY) {
            position = 0;
        } else {
            position = 1;
        }
    }

    public MenuItem next() {
        MenuItem menuItem = items[position];
        position += 2;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}