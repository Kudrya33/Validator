package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema required() {
        addRule("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public final StringSchema minLength(int minLength) {
        addRule("minLength", value -> value != null && value.length() >= minLength);
        return this;
    }

    public final StringSchema contains(String substring) {
        addRule("contains", value -> value != null && value.contains(substring));
        return this;
    }
}
