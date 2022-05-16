import java.time.LocalDate;
import java.time.Period;

class Person(
  val firstname: String,
  val lastname: String,
  val dayOfBirth: LocalDate
) {
  override def toString(): String = {
    firstname + " " + lastname
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val persons = List(
      new Person("Kerstin", "Herz", LocalDate.of(1995, 5, 31)),
      new Person("Matthias", "Zimmermann", LocalDate.of(1950, 1, 23)),
      new Person("Jana", "Schultheiss", LocalDate.of(1973, 10, 10)),
      new Person("Jennifer", "Fischer", LocalDate.of(1944, 12, 4)),
      new Person("Andreas", "Kaufmann", LocalDate.of(1964, 4, 3))
    );
    //Aufgabe 1
    val nachnamen = persons.map(person => person.lastname);
    println(nachnamen);

    //Aufgabe 2
    val oktoberGeburtstag = persons.filter(person => person.dayOfBirth.getMonth.getValue == 10);
    println(oktoberGeburtstag);

    //Aufgabe 3
    val alter = persons.map(person => java.time.Period.between(person.dayOfBirth, LocalDate.now()).getYears);
    println(alter);

    //Aufgabe 4
    var sum = alter.map(x => (x, 1)).reduce((x, y) => (x._1 + y._1, x._2 + y._2));
    var avg = sum._1 / sum._2;
    println(avg);
  }
}