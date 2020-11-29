package validation.constraints;


public class Length extends AbstractConstraint {

    private Integer min;
    private Integer max;
    
    public Length(int min, int max) {
        super("The field must contains between "+min+" and "+max+" characters.");
        this.min = min;
        this.max = max;
    }
    
    public Length(int min) {
        super("The field must contains at least "+min+" characters.");
        this.min = min;
    }

    @Override
    public boolean valid(Object value) {
        if(value == null) return false;
        if(!(value instanceof String)) return false;
        String str = (String) value;
        if(str.length() < min) return false;
        if(max == null) return true;
        return str.length() >= max;
    }

}
