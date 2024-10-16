package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        addRule("required", value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        addRule("sizeof", value -> value != null && value.size() == size);
        return this;
    }
}
