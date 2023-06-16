package io.bitcode.scripting.host

import io.bitcode.scripting.api.ScriptInstance
import org.junit.jupiter.api.Test
import java.io.File

class ScriptHostTest {
    @Test
    fun scriptTest() {
        println("Evaluating script")
        val result = ScriptHost.evalFile(File("src/main/resources/test.script.kts"), ScriptInstance())
        println("Done: ${result.reports}")
    }
}