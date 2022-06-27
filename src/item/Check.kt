package item

import variable.BooleanP

interface Check {
    fun check(line: String): Boolean
}