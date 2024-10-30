package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private final Map<String, Predicate<T>> rules = new HashMap<>();

    public BaseSchema<T> addRule(String ruleName, Predicate<T> rule) {
        rules.put(ruleName, rule);
        return this;
    }

    public boolean isValid(Object value) {
        for (Predicate<T> rule : rules.values()) {
            if (!rule.test((T) value)) {
                return false;
            }
        }
        return true;
    }
}
