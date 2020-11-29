package validation.constraints;


public abstract class AbstractConstraint implements ConstraintInterface {

    protected String message;
    
    public AbstractConstraint() {
        this.message = "Incorrect value.";
    }
    
    public AbstractConstraint(String message) {
        this.message = message;
    }
    
    @Override
    public String message() {
        return message;
    }
}
