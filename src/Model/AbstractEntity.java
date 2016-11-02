package Model;

public abstract class AbstractEntity {

    private static long idSequence = 1000;

    private long id;

    public AbstractEntity() {
        this.id = idSequence++;
    }

    public long getId() {
        return id;
    }
}
