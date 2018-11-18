package ru.job4j.tracker;

import java.util.Random;
import java.util.Arrays;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public void replaceById(String id, Item update) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                //item = update;
                item.setId(update.getId());
                item.setName(update.getName());
                item.setDesc(update.getDesc());
                item.setCreated(update.getCreated());
                item.setComments(update.getComments());
                break;
            }
        }


    }

    public void deleteById(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i);
                position--;
                break;
            }
        }
    }

    public Item[] findByName(String name) {
        int j = 0;
        Item[] result = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().contains(name)) {
                System.arraycopy(items, i, result, j, 1);
                j++;
            }
        }
        return result;
    }
}
