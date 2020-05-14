package Model;

import java.util.Map;

import Model.List;

public class Idea {
    Map<String, List[]> idea;

    public Idea(Map<String, List[]> idea) {
        this.idea = idea;
    }

    public Map<String, List[]> getIdea() {
        return idea;
    }

    public void setIdea(Map<String, List[]> idea) {
        this.idea = idea;
    }
}
