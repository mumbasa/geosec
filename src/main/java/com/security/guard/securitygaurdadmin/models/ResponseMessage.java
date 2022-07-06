package com.security.guard.securitygaurdadmin.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage {
private String message;
private Object payload;
private long pages;
private long elements;
private int statusCode;
}
