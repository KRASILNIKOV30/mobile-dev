package com.example.mobile_dev.lab1.dictionary

typealias ContextMap = MutableMap<String, MutableList<String>>
typealias Dictionary = MutableMap<String, ContextMap>

class Translator {
    private var dict: Dictionary = mutableMapOf()

    fun add(word: String, context: String, translate: String) {
        if (!dict.containsKey(word)) {
            dict[word] = mutableMapOf()
        }
        val contextMap = dict[word]
        contextMap ?: return
        if (!contextMap.containsKey(context)) {
            contextMap[context] = mutableListOf()
        }
        val translates = contextMap[context]
        translates ?: return
        translates.add(translate)
    }

    fun remove(word: String, context: String, translate: String) {
        val contextMap = dict[word]
        val translates = contextMap?.get(context)
        if (translates?.remove(translate) == true) {
            if (translates.isEmpty()) {
                contextMap.remove(context)
            }
            if (contextMap.isEmpty()) {
                dict.remove(word)
            }
        }
    }

    fun getTranslate(word: String): ContextMap? {
        return dict[word]
    }

    fun words(): Dictionary {
        return dict
    }
}