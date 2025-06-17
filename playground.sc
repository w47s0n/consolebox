//> using dep com.w47s0n::consolebox:0.1.5
//> using scala 3.7.1
import com.w47s0n.consolebox.ConsoleBox
import com.w47s0n.consolebox.ConsoleBox.LogLevel

println(ConsoleBox.print("Hello, World!", LogLevel.Info))
println(ConsoleBox.print("This is a warning.", LogLevel.Warning))
println(ConsoleBox.print("An error occurred.", LogLevel.Error))
println(ConsoleBox.print("Success!", LogLevel.Success))
println(ConsoleBox.print("Multi-line\nsupported.", LogLevel.Info))
