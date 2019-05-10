package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Mail {

    private final String mailTo;
    private final String subject;
    private final String message;
    private String toCc;

//    public Mail(String mailTo, String subject, String message) {
//        this.mailTo = mailTo;
//        this.subject = subject;
//        this.message = message;
//    }
}
