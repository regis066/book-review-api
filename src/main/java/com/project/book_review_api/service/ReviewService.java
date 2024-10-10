package com.project.book_review_api.service;


import com.project.book_review_api.model.Book;
import com.project.book_review_api.model.Review;
import com.project.book_review_api.repository.BookRepository;
import com.project.book_review_api.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Review addReviewToBook(Long bookId, Review review) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            review.setBook(book.get());
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Book not found with id: " + bookId);
        }
    }

    public Review updateReview(Long bookId,Long reviewId, Review reviewDetails ) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent()) {
            Review existingReview = review.get();
            if (existingReview.getBook().getId().equals(bookId)) {
                existingReview.setReviewName(reviewDetails.getReviewName());
                existingReview.setComment(reviewDetails.getComment());
                existingReview.setRating(reviewDetails.getRating());
                return reviewRepository.save(existingReview);
            } else {
                throw new RuntimeException("Review does not belong to book with id: " + bookId);
            }
        } else {
            throw new RuntimeException("Review not found with id: " + reviewId);
        }
    }


    public void deleteReview(Long bookId, Long reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if (review.isPresent() && review.get().getBook().getId().equals(bookId)) {
            reviewRepository.deleteById(reviewId);
        } else {
            throw new RuntimeException("Review not found or does not belong to book with id: " + bookId);
        }
    }
}
