package main

import "fmt"

// duck type delegates in flying and quacking behaviors
// instead of using the quacking and flying methods in
// the duck class or subclass
type duck struct {
	name      string
	flyType   flyBehavior
	quackType quackBehavior
}

func (d duck) fly() string {
	return d.flyType.fly()
}

func (d duck) quack() string {
	return d.quackType.quack()
}

func (d duck) String() string {
	return fmt.Sprintf("\nName: %s\nFlyType: %s\nQuackType: %s\n", d.name, d.flyType.fly(), d.quackType.quack())
}

//Interfaces and types that implement the interface.
//To be used within the duck type to define their behaviors.

type flyBehavior interface{ fly() string }

type quackBehavior interface{ quack() string }

type flyWithWings struct{}

func (w flyWithWings) fly() string { return "Flying with wings" }

type quackityQuack struct{}

func (q quackityQuack) quack() string { return "Quacking quackety" }

type soaring struct{}

func (w soaring) fly() string { return "Soaring" }

type meow struct{}

func (q meow) quack() string { return "Meowing" }

func main() {
	flyingDuck := duck{"Flying Duck", flyWithWings{}, quackityQuack{}}
	catDuck := duck{"Cat Duck", soaring{}, meow{}}
	fmt.Print(flyingDuck)
	fmt.Print(catDuck)
}
