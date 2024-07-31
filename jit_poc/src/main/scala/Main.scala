package com.example

import java.io.File
import java.net.URL
import java.net.URLClassLoader
import scala.util.Try

object PluginManager {
  def loadPlugin(jarFilePath: String): List[IData] = {
    val jarFile = new File(jarFilePath)
    val jarUrl = jarFile.toURI.toURL
    val classLoader =
      new URLClassLoader(Array(jarUrl), this.getClass.getClassLoader)

    // The class name and method name should match what's in the plugin
    val className = "com.example.DynamicLoader"
    val methodName = "load"

    // Load the class and invoke the load method
    val clazz = classLoader.loadClass(className)
    val loadMethod = clazz.getDeclaredMethod(methodName)

    // Cast the result to MyTrait
    loadMethod.invoke(null).asInstanceOf[List[IData]]
  }
}

trait IData {
  def foo(): Unit
}

trait ILoader {
  def load(): List[IData]
}

case class Data1() extends IData {
  def foo() = {
    println("Data1")
  }
}

def abobaPlugin(): List[IData] = {
  val jarPath =
    "/Users/q/Sync/Projects/pets/scala_jit_poc/dynamic_lib/target/scala-3.4.2/dynamic_lib_3-0.1.0-SNAPSHOT.jar"
  val data = PluginManager.loadPlugin(jarPath)
  data
}

def promptUser(continue: Boolean): Unit = {
  if (!continue) {
    println("goodbuy!")
    return
  }
  println("   loading jar...")
  val data = abobaPlugin()
  println("   jar ready!")
  data.foreach(_.foo())

  println("Continue? enter 0 to stop")
  val input = Try(scala.io.StdIn.readLine().toInt).getOrElse(1)
  promptUser(input != 0)
}

@main def run(): Unit = {
  promptUser(true)
}
