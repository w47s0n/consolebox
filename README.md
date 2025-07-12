# ConsoleBox

A simple terminal box/logging utility for Scala.
![screenshot](./docs/playground-sc.png)

## Install

**sbt:**

```scala
libraryDependencies += "com.w47s0n" %% "consolebox" % "0.2.1"
```

**mill:**

```scala
def ivyDeps = Agg(
  ivy"com.w47s0n::consolebox:0.2.1"
)
```

**Scala-cli**:

```scala
//> using dep com.w47s0n::consolebox:0.2.1
//> using scala 3.7.1
import com.w47s0n.consolebox.Consolebox

Consolebox.info("hello, world!")
Consolebox.warning("this is a warning.")
Consolebox.error("an error occurred.")
Consolebox.success("success!")
Consolebox.info("Multi-line\nsupported.")
```

Cross-built for Scala 2.12.x, 2.13 & 3.x

## Usage

```scala
import com.w47s0n.consolebox.Consolebox

Consolebox.info("hello, world!")
Consolebox.warning("this is a warning.")
Consolebox.error("an error occurred.")
Consolebox.success("success!")
Consolebox.info("Multi-line\nsupported.")
```

## License

MIT
