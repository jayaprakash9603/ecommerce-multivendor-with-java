package com.jaya.ecommerce_mutlivendor.modal;

import com.jaya.ecommerce_mutlivendor.domain.PaymentStatus;
import lombok.Data;


@Data
public class PaymentDetails {

    private String paymentId;
    private String razorpayPaymentLinkId;
    private String getRazorpayPaymentLinkReferenceId;
    private String razorpayPaymentLinkStatus;
    private String razorPaymentIdZWSP;
    private PaymentStatus paymentStatus;
}
