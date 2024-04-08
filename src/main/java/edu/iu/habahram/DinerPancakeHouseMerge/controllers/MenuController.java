package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.util.CompositeIterator;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {

    private final MenuComponent allMenus;

    public MenuController(MergerRepository mergerRepository) {
        this.allMenus = mergerRepository.getAllMenus();
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems() {
        List<MenuItemRecord> vegetarianItems = new ArrayList<>();
        Iterator<MenuItem> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.isVegetarian()) {
                vegetarianItems.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return vegetarianItems;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems() {
        List<MenuItemRecord> breakfastItems = new ArrayList<>();
        Iterator<MenuItem> iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.getDescription().toLowerCase().contains("breakfast")) {
                breakfastItems.add(new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()));
            }
        }
        return breakfastItems;
    }


    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        try {
            FileWriter writer = new FileWriter("data/customers.txt", true);
            writer.write("Username: " + username + ", Password: " + password + ", Email: " + email + "\n");
            writer.close();
            return "Signup successful!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to sign up. Please try again later.";
        }
    }
}
