package com.stringconcat.people.persistance

import java.util.Optional

fun <T : Any> Optional<T>.toNullable(): T? = this.orElse(null)
