package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public  Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    public void setId(String id) {
       this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return this.created;
    }

    public  void setComments(String[] comments) {
        this.comments = comments;
    }

    public String[] getComments() {
        return this.comments;
    }
}
