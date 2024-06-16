package com.polarbookshop.orderservice.order.domain

import com.polarbookshop.orderservice.book.Book
import com.polarbookshop.orderservice.book.BookClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OrderService(val orderRepository: OrderRepository, val bookClient: BookClient) {

    fun getAllOrders(): Flux<Order> = orderRepository.findAll()

    fun submitOrder(bookIsbn: String, quantity: Int): Mono<Order> {
        return bookClient.getBookByIsbn(bookIsbn)
            .map { book -> buildAcceptedOrder(book, quantity) }
            .defaultIfEmpty(buildRejectedOrder(bookIsbn, quantity))
            .flatMap(orderRepository::save)
    }

    companion object {
        fun buildRejectedOrder(bookIsbn: String, quantity: Int): Order {
            return Order(
                bookIsbn = bookIsbn,
                bookName = null,
                bookPrice = null,
                quantity = quantity,
                status = OrderStatus.REJECTED
            )
        }

        fun buildAcceptedOrder(book: Book, quantity: Int): Order {
            return Order(
                null,
                book.isbn,
                book.title + " - " + book.author,
                book.price,
                quantity,
                OrderStatus.ACCEPTED
            )
        }
    }
}