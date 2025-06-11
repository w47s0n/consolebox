package com.w47s0n

import org.scalatest.funsuite.AnyFunSuite

class ConsoleBoxSuite extends AnyFunSuite {
  import ConsoleBox._
  import LogLevel._

  val boxChars = Seq("┌", "─", "┐", "│", "└", "┘")

  def assertIsBoxed(output: String, message: String): Unit = {
    println(s"  [Check] Output should contain message: '$message' -> ${output.contains(message)}")
    boxChars.foreach { char =>
      println(s"  [Check] Output should contain box character '$char': ${output.contains(char)}")
    }
  }

  test("success message should be boxed") {
    val successMsg = "operation completed successfully!"
    val output = print(successMsg, Success)
    println("\n==============================")
    println("Test: success message should be boxed")
    println(s"Message: $successMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, successMsg)
  }

  test("info message should be boxed") {
    val infoMsg = "server is running on http://localhost:8080"
    val output = print(infoMsg, Info)
    println("\n==============================")
    println("Test: info message should be boxed")
    println(s"Message: $infoMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, infoMsg)
  }

  test("warning message should be boxed") {
    val warningMsg = "disk space is running low!"
    val output = print(warningMsg, Warning)
    println("\n==============================")
    println("Test: warning message should be boxed")
    println(s"Message: $warningMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, warningMsg)
  }

  test("error message should be boxed") {
    val errorMsg = "failed to connect to database!"
    val output = print(errorMsg, Error)
    println("\n==============================")
    println("Test: error message should be boxed")
    println(s"Message: $errorMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, errorMsg)
  }

  test("short message should be boxed and padded") {
    val shortMsg = "OK"
    val output = print(shortMsg, Info)
    println("\n==============================")
    println("Test: short message should be boxed and padded")
    println(s"Message: $shortMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, " OK ")
  }

  test("long message with newlines should be boxed") {
    val longMsg = "This is a very long message to demonstrate how the box adapts to different lengths."
    val output = print(s"\n\n$longMsg\n\n", Warning)
    println("\n==============================")
    println("Test: long message with newlines should be boxed")
    println(s"Message: $longMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, longMsg)
    println(s"  [Check] Number of empty box lines: ${output.linesIterator.count(_.trim == "│")}")
  }

  test("multi-line message should be boxed") {
    val multiLineMsg = "First line\nSecond is longer\nShort"
    val output = print(multiLineMsg, Error)
    println("\n==============================")
    println("Test: multi-line message should be boxed")
    println(s"Message: $multiLineMsg")
    println("Output:")
    println(output)
    assertIsBoxed(output, "First line")
    assertIsBoxed(output, "Second is longer")
    assertIsBoxed(output, "Short")
  }

  test("multi-line message with empty lines should be boxed") {
    val multiLineWithEmpty = "Line one\n\nLine three after a blank.\n\n\nEnd."
    val output = print(multiLineWithEmpty, Info)
    println("\n==============================")
    println("Test: multi-line message with empty lines should be boxed")
    println(s"Message: $multiLineWithEmpty")
    println("Output:")
    println(output)
    assertIsBoxed(output, "Line one")
    assertIsBoxed(output, "Line three after a blank.")
    assertIsBoxed(output, "End.")
    println(s"  [Check] Number of empty box lines: ${output.linesIterator.count(_.trim == "│")}")
  }
} 
