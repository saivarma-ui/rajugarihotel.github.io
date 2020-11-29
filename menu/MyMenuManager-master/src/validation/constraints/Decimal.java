package validation.constraints;

public class Decimal extends AbstractConstraint {

    protected Integer precision;

    public Decimal(int precision) {
        super("Please enter a valid decimal number");
    }
    public Decimal(int precision, String message) {
        super(message);
    }

    @Override
    public boolean valid(Object value) {
        if(value == null) return true; // Not our business
        /* Is a float */
        try{
            Float.parseFloat(value.toString());
        } catch(Exception e) {
            return false;
        }
        /* Has 2 decimal max */
        if(value.toString().length() - 1 - value.toString().indexOf(".") > 2) {
            return false;
        }
               
        return true;
    }
}
