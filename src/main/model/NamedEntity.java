package main.model;

public abstract class NamedEntity extends AbstractEntity {
    private String name;

    public NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
