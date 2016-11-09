package main.model;

abstract class NamedEntity extends AbstractEntity {
    private String name;

    NamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
