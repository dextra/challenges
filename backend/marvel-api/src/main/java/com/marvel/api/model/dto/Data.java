package com.marvel.api.model.dto;


import com.marvel.api.model.Characters;

import java.util.List;

@lombok.Data
public class Data<T>{
    private int offset;
    private int limit;
    private long total;
    private int count;
    private List<T> data;

    public Data(int offset, int limit, long total, int count, List<T> data) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.count = count;
        this.data = data;
    }
}
