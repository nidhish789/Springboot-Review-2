package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Subscription;
import com.example.demo.repository.SubscriptionRepo;

@Service
public class SubscriptionService {
     private SubscriptionRepo subscriptionRepo;
      public SubscriptionService(SubscriptionRepo subscriptionRepo)
      {
        this.subscriptionRepo=subscriptionRepo;

      }
      public Subscription saveSubscription(Subscription subscription)
      {
        return subscriptionRepo.save(subscription);
      }
      public Subscription getById(int id)
      {
        return subscriptionRepo.findById(id).orElse(null);
      }

}
