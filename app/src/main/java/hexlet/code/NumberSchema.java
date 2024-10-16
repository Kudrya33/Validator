package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addRule("required", value -> value != null);
        return this;
    }

    public NumberSchema positive() {
        addRule("positive", value -> value == null || value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addRule("range", value -> value != null && value >= min && value <= max);
        return this;
    }
}
