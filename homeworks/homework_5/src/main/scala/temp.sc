//import Exercises.Animal

trait Animal {
  def name: String
}

case class Cat(override val name: String) extends Animal

case class Dog(override val name: String) extends Animal



case class Shelter[+Pet <: Animal](pets: List[Pet]){

    def + [GenerType >: Pet <: Animal](pet: GenerType): Shelter[GenerType] = {
      new Shelter[GenerType](pet :: pets)
    }

    def ++ [GenerType >: Pet <: Animal](newPets: Shelter[GenerType]): Shelter[GenerType]= {
      Shelter[GenerType](pets ++ newPets.pets)
    }

    def getNames: List[String] = {
      pets.map(pet => pet.name).toList
    }

    def feed(food: Food[Pet]): List[String] = {
      pets.map(pet =>food.feed(pet)).toList
    }
  }

  trait Food[-Pet <: Animal] {
    def feed(pet: Pet): String = {
      pet.name + " eats " + toString
    }
  }

  case object Meat extends Food[Animal]{
    override def toString: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override def toString: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override def toString: String = "bread"
  }

  val s1: Shelter[Cat] = Shelter(List(Cat("Garfield")))

  val s2: Shelter[Dog] = Shelter(List(Dog("Goofy")))

  val s3: Shelter[Animal] = s1 ++ s2

  val s4 = s3 + Cat("Kuzya")

  assert(s4.getNames.toSet == Set("Garfield", "Goofy", "Kuzya"))

  val s5: Shelter[Animal] = s1 + Dog("Barbos")

  assert(s5.getNames.toSet == Set("Garfield", "Barbos"))

  val s6: Shelter[Dog] = s2 + Dog("Barbos")

  val r1 = s1.feed(Meat)
  assert(r1.toSet == Set("Garfield eats meat"))

  val r2 = s1.feed(Milk)

  assert(r2.toSet == Set("Garfield eats milk"))

  val r3 = s2.feed(Meat)

  assert(r3.toSet == Set("Goofy eats meat"))

  val r4 = s2.feed(Bread)

  assert(r4.toSet == Set("Goofy eats bread"))

  val r5 = s4.feed(Meat)

  assert(
    r5.toSet == Set(
      "Garfield eats meat",
      "Goofy eats meat",
      "Kuzya eats meat"
    )
)