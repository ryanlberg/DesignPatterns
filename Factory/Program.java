package Factory;


import java.util.ArrayList;
class Program {

    public abstract class Pizza {
        String name;
        String dough;
        String sauce;

        ArrayList<String> toppings = new ArrayList<String>();

        void prepare() {
            System.out.println("Preparing " + name);
            System.out.println("Tossing dough...");
            System.out.println("Adding sauce...");
            System.out.println("Adding toppings: ");
            for (String topping: toppings) {
                System.out.println("   " + topping);
            }
        }

        void bake() {
            System.out.println("Bake for 25 minutes at 350");
        }

        void cut() {
            System.out.println("Cutting the pizza into diagonal slices");
        }

        void box() {
            System.out.println("Place pizza in official pizzaStore box");
        }

        public String getName() {
            return name;
        }
    }

    public class NYStyleCheesePizza extends Pizza {
        public NYStyleCheesePizza() {
            name = "NY Style Sauce and Cheese Pizza";
            dough = "Thin Crust Dough";
            sauce = "Marinara Sauce";

            toppings.add("Grated Reggiano Cheese");
        }
    }

    public class ChicagoStyleCheesePizza extends Pizza {
        public ChicagoStyleCheesePizza() {
            name = "Chicago Style Deep Dish Pizza";
            dough = "Extra Thick Crust Dough";
            sauce = "Plum Tomato Sauce";

            toppings.add("Shredded Mozzarella Cheese");
        }   

        void cut() {
            System.out.println("Cutting the pizza into square slices");
        }
    }

    public abstract class PizzaStore {
        
        public Pizza orderPizza(String type) {
            Pizza pizza;

            pizza = createPizza(type);

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

            return pizza;
        }

        abstract Pizza createPizza(String type);
    }

    public class NYPizzaStore extends PizzaStore {

        @Override
        Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new NYStyleCheesePizza();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Program p = new Program();
        PizzaStore nyStore = p.new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ordered a " + pizza.getName() + "\n");
    }
}