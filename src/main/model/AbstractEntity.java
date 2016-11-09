package main.model;

public abstract class AbstractEntity {

    private static long idSequence = 1000;

    private long id;

    AbstractEntity() {
        this.id = idSequence++;
    }

    public long getId() {
        return id;
    }
}
