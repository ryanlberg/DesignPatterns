package main

import "fmt"

type subject interface {
	registerObserver(o observer)
	removeObserver(o observer)
	notifyObservers()
}

type observer interface {
	update(temp, humidity, pressure float32)
}

type displayElement interface {
	displaty()
}

/*
Inherets from subject interface
*/
type weatherData struct {
	observers   map[observer]bool
	temperature float32
	humidity    float32
	pressure    float32
}

func (wd weatherData) registerObserver(o observer) {
	wd.observers[o] = true
}

func (wd weatherData) removeObserver(o observer) {
	delete(wd.observers, o)
}

func (wd weatherData) notifyObservers() {
	for key := range wd.observers {
		key.update(wd.temperature, wd.humidity, wd.pressure)
	}
}

func (wd weatherData) measurementsChanged() {
	wd.notifyObservers()
}

func (wd weatherData) setMeausrements(temperature, humidity, pressure float32) {
	wd.temperature = temperature
	wd.humidity = humidity
	wd.pressure = pressure
	wd.measurementsChanged()
}

/*
Inherets from displayElement and from Observer
*/
type currentConditionDisplay struct {
	temperature float32
	humidity    float32
}

func (ccd currentConditionDisplay) update(temperature, humidity, pressure float32) {
	ccd.temperature = temperature
	ccd.humidity = humidity
	ccd.display()
}

func (ccd currentConditionDisplay) display() {
	fmt.Printf("Current conditions: %.2f F degrees\nHumidity: %.2f", ccd.temperature, ccd.humidity)
}

type weatherStation struct {
	weatherData weatherData
}

func main() {

	weatherdata := weatherData{observers: make(map[observer]bool)}
	weatherdata.registerObserver(currentConditionDisplay{})
	weatherdata.setMeausrements(80, 65, 30.4)

}
