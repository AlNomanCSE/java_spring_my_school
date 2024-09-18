package com.noman.springweb.model;

import lombok.Data;
@Data
public class Contact {
    private String mobileNum;
    private String name;
    private String email;
    private String subject;
    private String message;
}
