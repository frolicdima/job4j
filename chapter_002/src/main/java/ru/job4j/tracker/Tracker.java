package ru.job4j.tracker;

import java.util.Random;

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
        Item[] result = new Item[this.position];
        for (int index = 0; index != position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public void replaceById(String id, Item update) {
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                item = update;
                /*String tempId = update.getId();
                item.setId(tempId);
                String tempName = update.getName();
                item.setName(tempName);
                String tempDesc = update.getDesc();
                item.setDesc(tempDesc);
                long tempCreated = update.getCreated();
                item.setCreated(tempCreated);
                String[] tempComments = update.getComments();
                item.setComments(tempComments);*/
                break;
            }
        }


    }
}
