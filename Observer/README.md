# Observer Pattern
* Weather Data Design Taken from Head First Design patterns
* wiki:  https://en.wikipedia.org/wiki/Observer_pattern
#
<p>Subject Maintains a list of its dependents which are observers.  If the subjects state changes it will notify the observiers by calling one of their methods.</p>
<p>Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all of its depndents are notified automatically</p>

# Notes
<b>Loose Coupling</b> - Allos us to build flexible OO system that can handle change because they minimize interdependency between objects.
<p> Golang may have been a weird language choice for this study. Lack of constructors and the ability to pass functions makes me think that there are more idiomatic ways to perform some of these OO strategies.<p>