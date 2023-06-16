package io.bitcode.scripting.api

import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromClassContext
import kotlin.script.experimental.jvm.jvm

@KotlinScript(
    displayName = "Script",
    fileExtension = "script.kts",
    compilationConfiguration = ProjectScriptCompilationConfiguration::class
)
abstract class AbstractScript(script: Script) : Script by script {
    abstract fun anotherTest()
}

internal
object ProjectScriptCompilationConfiguration : ScriptCompilationConfiguration({

    baseClass(AbstractScript::class)

    jvm {
        dependenciesFromClassContext(
            AbstractScript::class,
            "scripting-test"
        )
    }

    ide {
        acceptedLocations(ScriptAcceptedLocation.Everywhere)
    }
})