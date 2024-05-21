package com.nabilla.myasset.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerAddress;
    private String assetCategory;
    private String currency;
    private Float grossInterest;
    private Float tax;
    private Float yearEndBalance;
    private Date period;

    public Asset(String customerName, String customerAddress, String assetCategory,
                 String currency, Float grossInterest, Float tax, Float yearEndBalance, Date period) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.assetCategory = assetCategory;
        this.currency = currency;
        this.grossInterest = grossInterest;
        this.tax = tax;
        this.yearEndBalance = yearEndBalance;
        this.period = period;
    }
}
