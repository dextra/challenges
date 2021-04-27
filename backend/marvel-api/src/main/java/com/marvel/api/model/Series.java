package com.marvel.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "SERIES")
public class Series extends GenericKey{

    @Column(name = "AVAILABLE")
    private String available;

    @Column(name = "RETURNED")
    private String returned;

    @Column(name = "COLLECTION_URI")
    private String collectionURI;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "series")
    @Fetch(FetchMode.SUBSELECT)
    private List<Item> items;
}
