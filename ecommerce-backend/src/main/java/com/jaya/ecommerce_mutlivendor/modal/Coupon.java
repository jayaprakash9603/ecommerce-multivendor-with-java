package com.jaya.ecommerce_mutlivendor.modal;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String code;

    private String discountPercentage;
    private LocalDate validatityStartDate;
    private LocalDate validatityEndDate;

    private boolean isActive=true;
    private double minimumOrderValue;


    @ManyToMany(mappedBy = "usedCoupons")
    private Set<User>usedByUsers=new HashSet<>();
}
