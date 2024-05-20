package com.nabilla.myasset.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asset {

    @Id
    @GeneratedValue
    private Long id;
    private String customerName;
    private String customerAddress;
    private String assetCategory;
    private String currency;
    private float grossInterest;
    private float tax;
    private float yearEndBalance;
//    private LocalDate period;
//    private LocalDateTime createdDate;
//    private LocalDateTime updatedDate;

    public Asset(String s, String s1, String s2, String s3, float v, float v1, float v2) {
        this.customerName = s;
        this.customerAddress = s1;
        this.assetCategory = s2;
        this.currency = s3;
        this.grossInterest = v;
        this.tax = v1;
        this.yearEndBalance = v2;
    }
}
