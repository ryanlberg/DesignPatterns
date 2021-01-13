using System;

namespace Decorator
{
    abstract class Beverage {
        public abstract int cost();
    }

    abstract class AddOn: Beverage {
        public override abstract int cost();
    }

    class Espresso : Beverage {

        public Espresso(){}

        public override int cost() {
            return 1;
        }
    }

    class Milk : AddOn {
        public Beverage b;

        public Milk (Beverage b) {
            this.b = b;
        }

        public override int cost() {
            return b.cost() + 4;
        }
    }

    class Soy : AddOn {
        public Beverage b;

        public Soy (Beverage b) {
            this.b = b;
        }
        
        public override int cost() {
            return b.cost() + 3;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(new Soy(new Milk(new Espresso())).cost());
        }
    }
}
