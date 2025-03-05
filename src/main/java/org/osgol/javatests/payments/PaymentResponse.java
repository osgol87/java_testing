package org.osgol.javatests.payments;

public class PaymentResponse {

    enum PaymentStatus {
        OK, ERROR
    }

    private final PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
