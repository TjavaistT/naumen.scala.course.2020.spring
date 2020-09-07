object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    if(seq.init!= Nil) seq.last +: reverse(seq.init)

    else Seq(seq.last)
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    if (idx == 0) 0
    else if(idx == 1) 1
    else  fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    if (idx == 0) Seq(0)
    else if(idx == 1) Seq(0, 1)
    else  fibonacci4Index(idx - 1) :+ fibonacci4Index(idx - 1).last + fibonacci4Index(idx - 2).last
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text
      .toUpperCase.split("")
      .map(char => MORSE.getOrElse(char, char))
      .mkString(" ")
  }


  def wordReverse(text: String): String = {

    def wordReverseCapitalize(word: String) = {
      if(word.slice(0,1) == word.slice(0,1).toUpperCase) word.toLowerCase.reverse.capitalize
      else word.reverse
    }

    text.split("\\s+").map(word => wordReverseCapitalize(word)).mkString(" ")
  }

}
