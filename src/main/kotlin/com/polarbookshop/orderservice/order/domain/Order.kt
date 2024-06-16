package com.polarbookshop.orderservice.order.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("orders")
data class Order(

    @Id
    val id: Long? = null,

    val bookIsbn: String,

    val bookName: String?,

    val bookPrice: Double?,

    val quantity: Int,

    val status: OrderStatus,

    @CreatedDate
    val createdDate: Instant = Instant.now(),

    @LastModifiedDate
    val lastModifiedDate: Instant = Instant.now(),

    @Version
    val version: Int = 0,

    )