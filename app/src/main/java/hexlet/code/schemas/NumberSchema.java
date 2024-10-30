package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        addRule("required", value -> value != null);
        return this;
    }

    public final NumberSchema positive() {
        addRule("positive", value -> value == null || value > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        addRule("range", value -> value != null && value >= min && value <= max);
        return this;
    }
}
