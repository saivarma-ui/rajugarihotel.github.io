package form;

import bean.DishGroup;
import validation.constraints.ConstraintInterface;
import validation.constraints.NotBlank;

public class DishGroupForm extends AbstractForm {

    private final static String name = "name";
    private DishGroup group;

    public String getName() {
        return name;
    }

    public DishGroupForm(DishGroup group) {
        super();

        ConstraintInterface[] cs = { new NotBlank() };
        constraints.put(name, cs);

        if (group != null) {
            setValue(name, group.getName());
            this.group = group;
        } else {
            this.group = new DishGroup();
        }
    }

    public DishGroup getData() {
        group.setName((String) value(name));
        return group;
    }
}
