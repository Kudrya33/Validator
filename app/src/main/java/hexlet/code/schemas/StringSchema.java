package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addRule("required", value -> value != null && !value.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        addRule("minLength", value -> value != null && value.length() >= minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        addRule("contains", value -> value != null && value.contains(substring));
        return this;
    }
}
