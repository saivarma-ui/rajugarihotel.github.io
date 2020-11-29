package validation;

import validation.constraints.ConstraintInterface;

public class Validator {

    public boolean isValid(ConstraintInterface constraint, Object value)
    {
        return constraint.valid(value);
    }
}
