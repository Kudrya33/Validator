package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.string();

        System.out.println(schema.isValid("")); // true
        System.out.println(schema.isValid(null)); // true

        schema.required();

        System.out.println(schema.isValid(null)); // false
        System.out.println(schema.isValid("")); // false
        System.out.println(schema.isValid("what does the fox say")); // true
        System.out.println(schema.isValid("hexlet")); // true

        schema.contains("wh");
        System.out.println(schema.isValid("what does the fox say")); // true
        System.out.println(schema.isValid("what does the fox say")); // true
        schema.contains("whatthe");
        System.out.println(schema.isValid("what does the fox say")); // false

        StringSchema schema1 = v.string();
        schema1.minLength(10).minLength(4);
        System.out.println(schema1.isValid("Hexlet")); // true

    }
}
