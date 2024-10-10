package com.project.book_review_api.controller;


import com.project.book_review_api.model.Review;
import com.project.book_review_api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books/{bookId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Get all reviews for a specific book
    @GetMapping
    public ResponseEntity<List<Review>> getReviewsByBookId(@PathVariable Long bookId) {
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Add a review to a specific book
    @PostMapping
    public ResponseEntity<Review> addReviewToBook(@PathVariable Long bookId, @RequestBody Review review) {
        Review savedReview = reviewService.addReviewToBook(bookId, review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // Update a review for a specific book
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long bookId, @PathVariable Long reviewId, @RequestBody Review reviewDetails) {
        Review updatedReview = reviewService.updateReview(bookId, reviewId, reviewDetails);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    // Delete a review for a specific book
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long bookId, @PathVariable Long reviewId) {
        reviewService.deleteReview(bookId, reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}