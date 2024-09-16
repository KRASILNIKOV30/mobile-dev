package com.example.mobile_dev.lab1.dictionary

import com.example.mobile_dev.lab1.component2

operator fun <T> List<T>.component2(): List<T> = this.drop(1)

data class TranslatorActions(
    val add: (word: String, context: String, translate: String) -> Unit,
    val remove: (word: String, context: String, translate: String) -> Unit,
    val translate: (word: String) -> ContextMap?,
    val getAllTranslates: () -> Dictionary,
)

fun defTranslatorActions(): TranslatorActions {
    val translator = Translator()

    val add = { word: String, context: String, translate: String ->
        translator.add(word, context, translate)
    }

    val remove = { word: String, context: String, translate: String ->
        translator.remove(word, context, translate)
    }

    val translate = { word: String ->
        translator.getTranslate(word)
    }

    val getAllTranslates = { translator.words() }

    return TranslatorActions(
        add,
        remove,
        translate,
        getAllTranslates,
    )
}

fun outputTranslate(word: String, contextMap: ContextMap?) = when {
    contextMap.isNullOrEmpty() -> println("Неизвестное слово")
    else -> {
        println("Перевод слова «$word»")
        contextMap.forEach { (context, translateList) ->
            println("В контексте $context: ${translateList.joinToString(", ")}")
        }
    }
}

val makeCommandHandler = { (add, remove, translate, getAllTranslates): TranslatorActions ->
    { command: String, params: List<String> ->
        when (command) {
            "add" -> add(params[0], params[1], params[2])
            "remove" -> remove(params[0], params[1], params[2])
            "translate" -> outputTranslate(params[0], translate(params[0]))
            "print" -> getAllTranslates().forEach { (word, contextMap) ->
                outputTranslate(
                    word,
                    contextMap
                )
            }
        }
    }
}

fun main() {
    val translatorActions = defTranslatorActions()
    val handleCommand = makeCommandHandler(translatorActions)

    while (true) {
        val args = readln().split(' ')

        val (command, params) = args

        if (command == "exit") {
            break
        }

        handleCommand(command, params)
    }
}