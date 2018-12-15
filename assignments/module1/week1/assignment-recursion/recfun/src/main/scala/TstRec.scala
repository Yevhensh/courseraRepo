

object TstRec extends App {
  def printRevStr(str: String): Unit = {
    if (str.length != 0) {
      printRevStr(str.substring(1))
      print(str(0))
    }
  }

  printRevStr("something")
}
