package com.marvel.api.controller;

import com.marvel.api.model.ResponseInvalid;
import com.marvel.api.service.ResponseInvalidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/invalid/error")
public class ResponseInvalidController {

    @Autowired
    ResponseInvalidService responseInvalidService;

    @GetMapping()
    public ResponseEntity<?> sendError(@RequestParam("id-error") Long idError){
        ResponseInvalid responseInvalid = responseInvalidService.findById(idError).get();
        return new ResponseEntity<>(responseInvalid,HttpStatus.valueOf(Integer.parseInt(responseInvalid.getCode())));
    }

}
