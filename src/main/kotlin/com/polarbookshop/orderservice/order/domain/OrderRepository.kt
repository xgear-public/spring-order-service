package com.polarbookshop.orderservice.order.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository

open interface OrderRepository : ReactiveCrudRepository<Order, Long>