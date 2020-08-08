object Exercises {
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
}
