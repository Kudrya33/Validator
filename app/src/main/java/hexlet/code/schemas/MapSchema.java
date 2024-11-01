package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, Object>> {

    public final MapSchema required() {
        addRule("required", value -> value != null);
        return this;
    }

    public final MapSchema sizeof(int size) {
        addRule("sizeof", value -> value != null && value.size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Map<String, BaseSchema<String>> shapeSchemas = new HashMap<>(schemas);
        addRule("shape", value -> {
            if (value == null) {
                return true;
            }
            for (Map.Entry<String, BaseSchema<String>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object fieldValue = value.get(key);

                if (!schema.isValid(fieldValue)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
