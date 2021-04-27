package com.marvel.api.repository;

import com.marvel.api.model.ResponseInvalid;
import com.marvel.api.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ReponseInvalidRepository extends JpaRepository<ResponseInvalid, Long> {

}
