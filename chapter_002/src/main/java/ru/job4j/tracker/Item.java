package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    public void setId(String id) {
        id = this.id;
    }

    public String getId() {
        return this.id;
    }

    private void setName(String name) {
        name = this.name;
    }

    private String getName() {
        return this.name;
    }

    private void setDesc(String desc) {
        this.desc = desc;
    }

    private String getDesc() {
        return this.desc;
    }

    private void setCreated(long created) {
        this.created = created;
    }

    private long getCreated() {
        return this.created;
    }

    private  void setComments(String[] comments) {
        this.comments = comments;
    }

    private String[] getComments() {
        return this.comments;
    }
}
