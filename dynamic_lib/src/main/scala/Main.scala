package com.example

class DataDynamic extends IData {
  def foo() = {
    println("DataDynamic")
    // println("DataDynamicAboba")
    println("sanya privet")
  }
}

object DynamicLoader extends ILoader {
  def load(): List[IData] = {
    List(DataDynamic(), Data1())
  }
}

@main def main(): Unit = {
  println("dynamic lib main run")
  val loader = DynamicLoader
  val data = loader.load()
  data.foreach(_.foo())
}
