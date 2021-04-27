package com.marvel.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "RESPONSE_INVALID")
public class ResponseInvalid extends GenericKey {
    private String code;
    private String message;
}
