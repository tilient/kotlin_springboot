package org.tilient.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

// --- Controller --------------------------------------------------

@RestController
class GreetingController
{
  val counter = AtomicLong()

  @GetMapping("/greeting")
  fun greeting(@RequestParam(value = "name", defaultValue = "World")
               name: String) =
    "${counter.getAndIncrement()} : Hello, $name"
}

// --- Main --------------------------------------------------------

@SpringBootApplication
class Application

fun main(args: Array<String>)
{
  SpringApplication.run(Application::class.java, *args)
}
