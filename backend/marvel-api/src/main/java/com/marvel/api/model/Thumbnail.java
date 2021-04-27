package com.marvel.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "THUMBNAIL")
public class Thumbnail extends GenericKey{

    @Column(name = "PATH")
    private String path;

    @Column(name = "EXTENSION", length = 3)
    private String extension;
}
