package hexlet.code;

public class NumberSchema {
    private boolean isRequired = false;
    private boolean isPositive = false;
    private boolean inTheRange = false;
    private Integer minNumber = Integer.MIN_VALUE;
    private Integer maxNumber = Integer.MAX_VALUE;

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(Integer minCount, Integer maxCount) {
        this.inTheRange = true;
        this.minNumber = minCount;
        this.maxNumber = maxCount;
        return this;
    }

    public boolean isValid(Integer count) {
        if (isRequired) {
            if (count == null) {
                return false;
            }
        }

        if (isPositive) {
            if (count <= 0) {
                return false;
            }
        }

        if (inTheRange) {
            if (count < minNumber || count > maxNumber) {
                return false;
            }
        }
        return true;
    }
}
