package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.string();

        var v2 = new Validator();
        var schema2 = v2.number();

    }
}
