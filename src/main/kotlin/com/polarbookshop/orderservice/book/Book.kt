package com.polarbookshop.orderservice.book

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import java.time.Instant

data class Book(

    val isbn: String,

    val title: String,

    val author: String,

    val price: Double,

)
