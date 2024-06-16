package com.polarbookshop.orderservice.book

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class BookClient(val webClient: WebClient) {

    fun getBookByIsbn(isbn: String): Mono<Book> {
        return webClient
            .get()
            .uri("/books/$isbn")
            .retrieve()
            .bodyToMono(Book::class.java)

    }

}