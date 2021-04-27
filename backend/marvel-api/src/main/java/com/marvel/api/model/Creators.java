package com.marvel.api.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "CREATORS")
public class Creators extends GenericKey{

    @Column(name = "available")
    private String available;

    @Column(name = "RETURNED")
    private String returned;

    @Column(name = "COLLECTION_URI")
    private String collectionURI;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "comics")
    @Fetch(FetchMode.SUBSELECT)
    private List<Item> items;
}