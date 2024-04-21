package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

@Repository
public class MergerRepository {
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = buildAllMenus();
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem menuItem) {
                records.add(new MenuItemRecord(menuItem.getName(), menuItem.getDescription(),
                        menuItem.isVegetarian(), menuItem.getPrice()));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getVegetarianItems() {
        MenuComponent allMenus = buildAllMenus();
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof MenuItem menuItem && menuItem.isVegetarian()) {
                records.add(new MenuItemRecord(menuItem.getName(), menuItem.getDescription(),
                        menuItem.isVegetarian(), menuItem.getPrice()));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getBreakfastItems() {
        MenuComponent allMenus = buildAllMenus();
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof PancakeHouseMenu) {
                records.addAll(getMenuItemRecords(component));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getLunchItems() {
        MenuComponent allMenus = buildAllMenus();
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof DinerMenu) {
                records.addAll(getMenuItemRecords(component));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getSupperItems() {
        MenuComponent allMenus = buildAllMenus();
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            if (component instanceof CafeMenu) {
                records.addAll(getMenuItemRecords(component));
            }
        }
        return records;
    }

    private MenuComponent buildAllMenus() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        return allMenus;
    }

    private List<MenuItemRecord> getMenuItemRecords(MenuComponent component) {
        List<MenuItemRecord> records = new ArrayList<>();
        Iterator<MenuComponent> iterator = component.createIterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof MenuItem menuItem) {
                records.add(new MenuItemRecord(menuItem.getName(), menuItem.getDescription(),
                        menuItem.isVegetarian(), menuItem.getPrice()));
            }
        }
        return records;
    }

    public void saveCustomer(String username, String password, String email) {
        String customerData = username + "," + password + "," + email + "\n";
        try (FileWriter writer = new FileWriter("data/customers.txt", true)) {
            writer.write(customerData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
