package com.w47s0n

object ConsoleBox {

  enum LogLevel {
    case Info, Warning, Error, Success
  }
  import LogLevel._

  private val reset = "\u001b[0m"

  private val horizontal = "─"
  private val vertical = "│"
  private val topRight = "┐"
  private val bottomLeft = "└"
  private val bottomRight = "┘"
  private val topLeft = "┌"

  private def colors(level: LogLevel): (String, String) = level match {
    case Info    => ("\u001b[1m", "\u001b[36m")     
    case Warning => ("\u001b[1m\u001b[33m", "\u001b[33m") 
    case Error   => ("\u001b[1m\u001b[31m", "\u001b[31m")
    case Success => ("\u001b[1m\u001b[38;2;0;255;0m", "\u001b[38;2;0;255;0m")
  }

  def print(text: String, level: LogLevel = LogLevel.Info): String = {
    val (textColor, borderColor) = colors(level)
    val lines = text.split("\n", -1)
    val pad = 1
    val paddedLines = lines.map(line => " " * pad + line + " " * pad)
    val maxWidth = if (paddedLines.isEmpty) 0 else paddedLines.map(_.length).max
    val top = s"${borderColor}$topLeft${horizontal * maxWidth}$topRight$reset"
    val bottom = s"${borderColor}$bottomLeft${horizontal * maxWidth}$bottomRight$reset"
    val content = paddedLines.map { line =>
      val padding = " " * (maxWidth - line.length)
      s"${borderColor}$vertical$reset$textColor$line$padding$reset${borderColor}$vertical$reset"
    }
    (top +: content :+ bottom).mkString("\n")
  }
} 
