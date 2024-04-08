package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import edu.iu.habahram.DinerPancakeHouseMerge.model.*;

@Repository
public class MergerRepository {
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        List<MenuItemRecord> records = new ArrayList<>();
        collectMenuItems(allMenus, records);
        return records;
    }
    public MenuComponent getAllMenus() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        return allMenus;
    }

    private void collectMenuItems(MenuComponent menuComponent, List<MenuItemRecord> records) {
        if (menuComponent instanceof MenuItem) {
            MenuItem menuItem = (MenuItem) menuComponent;
            records.add(new MenuItemRecord(
                    menuItem.getName(),
                    menuItem.getDescription(),
                    menuItem.isVegetarian(),
                    menuItem.getPrice()
            ));
        } else {
            List<MenuComponent> components = ((Menu) menuComponent).getMenuComponents();
            for (MenuComponent component : components) {
                collectMenuItems(component, records);
            }
        }
    }
}
