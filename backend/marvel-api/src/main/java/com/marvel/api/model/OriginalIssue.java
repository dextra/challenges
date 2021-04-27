package com.marvel.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ORIGINAL_ISSUE")
public class OriginalIssue extends GenericKey{
    @Column(name = "RESOURCE_URI")
    private String resourceURI;

    @Column(name = "NAME")
    private String name;
}
