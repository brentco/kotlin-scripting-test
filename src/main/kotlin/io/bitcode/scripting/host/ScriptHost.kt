package io.bitcode.scripting.host

import io.bitcode.scripting.api.AbstractScript
import io.bitcode.scripting.api.Script
import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.constructorArgs
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

object ScriptHost {
    fun evalFile(scriptFile: File, scriptInstance: Script): ResultWithDiagnostics<EvaluationResult> {
        return BasicJvmScriptingHost().evalWithTemplate<AbstractScript>(scriptFile.toScriptSource(), evaluation = {
            constructorArgs(scriptInstance)
        })
    }
}