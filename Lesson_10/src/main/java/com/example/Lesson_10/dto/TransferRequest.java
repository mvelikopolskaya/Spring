package com.example.Lesson_10.dto;

import java.math.BigDecimal;


public class TransferRequest {
    private long idSender;
    private long idReceiver;
    private BigDecimal amount;

    public long getIdSender() {
        return idSender;
    }

    public long getIdReceiver() {
        return idReceiver;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
