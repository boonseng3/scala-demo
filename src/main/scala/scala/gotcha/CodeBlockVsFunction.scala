package scala.gotcha

object CodeBlockVsFunction extends App {
  /**
   * Expect a function as parameter
   */
  def f1(f: Int => Int) {
    println("start f1")
    println("add 10, got " + f(10))
    println("add 15, got " + f(15))
    println("end f1")
  }

  println("A code block is a sequence of statements that are executed and the last statement is returned")
  println("If code block is passed to a method/function only the last statement will be returned to the function/method")

  {
    println("Show that code block is executed sequentially")
  }

  println("=====Demo Code Block=====")
  println("=====Code Block execute first, Code Block last statement is returned everytime called")
  f1 {
    println("code block, add 20")
    _ + 20
  }

  def f2(x: Int): Int = {
    println(s"start f2, add 20")
    x + 20
  }
  println("=====Demo normal function====")
  println("=====f1 function execute first, f2 function execute everytime called")
  f1 { f2 }

  println("=====Demo anonymous function with code block====")
  println("=====Code block execute first, Code Block last statement is returned everytime called")
  val f3: Int => Int = { println("start anonymous function f3, add 20"); _ + 20 }
  f1 { f3 }

  println("=====Demo anonymous function====")
  println("=====f1 function execute first, anonymous function execute everytime called")

  val f4: Int => Int = (x: Int) => { println("start f4, add 20"); x + 20 }
  println(f4)
  f1 { f4 }

  println("=====Demo code block with anonymous function===")
  println("=====Code block execute first, the last statement is a anonymous function. f1 then execute first, anonymous function execute everytime called")
  f1 { println("code block line"); x => println("start anonymous function, add 20"); x + 20 }

}

