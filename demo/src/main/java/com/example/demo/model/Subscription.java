package com.example.demo.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriberid;
    private int premiumfourkHDR;
    private int standard;
    private int basic;
    private int mobile;
    @JsonManagedReference
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Specs> specs;
}
