package hexlet.code;

public class NumberSchema {
    private boolean isRequired = false;
    private boolean isPositive = false;
    private boolean inTheRange = false;
    private Integer minNumber;
    private Integer maxNumber;

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(Integer minNumber, Integer maxNumber) {
        this.inTheRange = true;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        return this;
    }

    public boolean isValid(Integer count) {
        if(isRequired) {
            if(count == null) {
                return false;
            }
        }

        if(isPositive) {
            if(count <= 0) {
                return false;
            }
        }

        if(inTheRange) {
            if(count < minNumber || count > maxNumber) {
                return false;
            }
        }
        return true;
    }
}
