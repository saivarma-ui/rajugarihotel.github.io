package validation.constraints;


public class NotBlank extends AbstractConstraint {

    public NotBlank() {
        super("The field can not be blank.");
    }

    @Override
    public boolean valid(Object value) {
        if(value == null) return false;
        if(!(value instanceof String)) return false;
        return ((String) value).length() != 0;
    }
    
}
