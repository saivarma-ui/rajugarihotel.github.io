package validation.constraints;


public interface ConstraintInterface {
    public String message();
    public boolean valid(Object value);
}
