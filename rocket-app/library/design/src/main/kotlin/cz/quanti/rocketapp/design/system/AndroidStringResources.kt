package cz.quanti.rocketapp.design.system

import android.content.Context
import cz.quanti.rocketapp.design.presentation.StringResources

class AndroidStringResources(
    private val context: Context
) : StringResources {
    override fun getString(stringId: Int): String {
        return context.resources.getString(stringId)
    }

    override fun getString(stringId: Int, vararg formatArgs: Any): String {
        return context.resources.getString(stringId, *formatArgs)
    }
}
