trait Cell {
  def toString: String

  override def hashCode(): Int = this.hashCode()

  override def equals(obj: Any): Boolean = this.toString.equals(obj.toString)
}