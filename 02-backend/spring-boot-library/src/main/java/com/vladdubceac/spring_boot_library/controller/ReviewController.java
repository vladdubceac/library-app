package com.vladdubceac.spring_boot_library.controller;

import com.vladdubceac.spring_boot_library.request_models.ReviewRequest;
import com.vladdubceac.spring_boot_library.service.ReviewService;
import com.vladdubceac.spring_boot_library.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value = "Authorization")String token, @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, ExtractJWT.EMAIL_EXTRACTION_KEY);

        if(userEmail==null){
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail,bookId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token, @RequestBody ReviewRequest reviewRequest)throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token,ExtractJWT.EMAIL_EXTRACTION_KEY);
        if(userEmail==null){
            throw new Exception("User email is missing");
        }
        reviewService.postReview(userEmail,reviewRequest);
    }
}
