package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Subscription;
import com.example.demo.service.SubscriptionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class SubscriptionController {
    private SubscriptionService subscriptionService;
    public SubscriptionController(SubscriptionService subscriptionService)
    {
        this.subscriptionService=subscriptionService;

    }
    @PostMapping("/post/sub")
    public Subscription postMethodName(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
        
    }
    @GetMapping("/get/sub/{id}")
    public Subscription getMethodName(@PathVariable ("id") int id) {
        return subscriptionService.getById(id);
    }
    
    
}
