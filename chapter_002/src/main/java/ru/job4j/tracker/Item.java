package ru.job4j.tracker;

import java.util.Random;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;
    private static final Random RN = new Random();

    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    public void setId {
        id = this.id;
    }

    public String getId {
        return this.id;
    }

    public String generateId {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    private void setName {
        name = this.name;
    }

    private String getName {
        return this.name;
    }

    private void setDesc {
        this.desc = desc;
    }

    private String getDesc {
        return this.desc;
    }

    private void setCreated {
        this.created = created;
    }

    private long getCreated {
        return this.created;
    }

    private  void setComments {
        this.comments = comments;
    }

    private String[] getComments {
        return this.comments;
    }
}
