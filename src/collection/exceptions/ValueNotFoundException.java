package collection.exceptions;

public class ValueNotFoundException extends RuntimeException {

    public ValueNotFoundException(String key) {
        super("Value for \"" + key + "\" not found.");
    }
}
