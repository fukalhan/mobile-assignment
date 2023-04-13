package cz.quanti.rocketapp.design.presentation

interface StringResources {
    fun getString(stringId: Int): String
    fun getString(stringId: Int, vararg formatArgs: Any): String
}
