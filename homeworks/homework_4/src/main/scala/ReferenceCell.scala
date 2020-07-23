import scala.collection.mutable.ArrayBuffer

class ReferenceCell(var x: Int, var y: Int, table: Table) extends Cell
{
  override def toString: String = getStringFromLinkedCell()

  private def getStringFromLinkedCell(indexesChainCells: ArrayBuffer[Int] = ArrayBuffer[Int]()): String = {
    val current_cell = table.getCell(x, y)
    if (current_cell.isDefined) {
      current_cell.get match {
        case ref: ReferenceCell => {
          if (containDubles(indexesChainCells)) {
            "cyclic"
          } else {
            indexesChainCells += x + y * table.width
            ref.getStringFromLinkedCell(indexesChainCells)
          }
        }
        case _ => current_cell.get.toString
      }
    } else {
      "outOfRange"
    }
  }

  private def containDubles(chains: ArrayBuffer[Int]): Boolean = chains.length != chains.distinct.length
} 