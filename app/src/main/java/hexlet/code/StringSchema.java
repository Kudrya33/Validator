package hexlet.code;

public class StringSchema {
    private boolean isRequired = false;
    private int minLength = -1;
    private String containsSubstring = null;

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.containsSubstring = substring;
        return this;
    }

    public boolean isValid(String str) {
        if (isRequired) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }

        if (minLength != -1 && (str == null || str.length() < minLength)) {
            return false;
        }

        if (containsSubstring != null && (str == null || !str.contains(containsSubstring))) {
            return false;
        }

        return true;
    }
}
