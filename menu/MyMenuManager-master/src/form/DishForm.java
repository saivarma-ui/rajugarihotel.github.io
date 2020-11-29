package form;

import java.rmi.RemoteException;
import bean.Dish;
import validation.constraints.ConstraintInterface;
import validation.constraints.NotBlank;
import validation.constraints.Price;

public class DishForm extends AbstractForm {

    private final static String name = "name";
    private final static String description = "description";
    private final static String price = "price";
    private Dish dish;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public DishForm(Dish dish) {
        super();

        ConstraintInterface[] cs = { new NotBlank() };
        ConstraintInterface[] fl = { new NotBlank(), new Price() };
        constraints.put(name, cs);
        constraints.put(description, cs);
        constraints.put(price, fl);

        if (dish != null) {
            setValue(name, dish.getName());
            setValue(description, dish.getDescription());
            setValue(price, dish.getPrice());
            this.dish = dish;
        } else {
            try {
                this.dish = new Dish();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public Dish getData() {
        dish.setName((String) value(name));
        dish.setDescription((String) value(description));
        dish.setPrice(Float.parseFloat((String) value(price)));

        return dish;
    }
}
