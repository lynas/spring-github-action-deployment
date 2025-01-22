package com.lynas.controller

import com.lynas.Book
import com.lynas.BookRequest
import com.lynas.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/books")
class BookController(val bookService: BookService) {

    @GetMapping("/name")
    fun ctName() = "BookController"

    @GetMapping("/")
    fun getAllBooks(): List<Book> = bookService.findAll()

    @GetMapping("/{bookId}")
    fun getBookById(@PathVariable bookId: UUID): Book =
        bookService.findBookById(bookId) ?: throw ResourceNotFoundException("Book not found by $bookId")

    @PostMapping("/")
    fun createBook(@RequestBody request: BookRequest): Book {
        return bookService.createBook(request)
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(message: String?) : RuntimeException(message)
