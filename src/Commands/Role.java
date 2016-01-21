package Commands;

/**
 * Created by Anna on 12/22/2015.
 */
public enum Role {
    Anonymous(0),
    Admin(1),
    Professor(2),
    Student(3);
    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}