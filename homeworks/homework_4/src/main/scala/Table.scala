class Table(val width: Int, val height: Int) {
  private val cells: Array[Option[Cell]] = Array.fill(width * height)(Some(new EmptyCell))

  def getCell(ix: Int, iy: Int): Option[Cell] = if (isInTable(ix, iy)) cells(ix + iy * width) else None

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = if (isInTable(ix, iy)) cells(ix + iy * width) = Some(cell)

  private def isInTable(ix: Int, iy: Int) = ix >= 0 && iy >= 0 && ix < width && iy < height
} 