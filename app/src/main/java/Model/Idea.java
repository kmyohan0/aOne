package Model;

import java.util.Map;

import Model.List;

public class Idea {
    Map<String, List> lists;

    public Idea(Map<String, List> lists) {
        this.lists = lists;
    }

    public Map<String, List> getLists() {
        return lists;
    }

    public void setLists(Map<String, List> lists) {
        this.lists = lists;
    }
}
