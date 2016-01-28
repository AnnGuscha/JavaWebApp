package commands;

/**
 * Created by Anna on 12/22/2015.
 */
public enum Role {
    ANONYMOUS(0),
    ADMIN(1),
    PROFESSOR(2),
    STUDENT(3);
    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}