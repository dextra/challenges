package com.marvel.api.interception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvel.api.model.ResponseInvalid;
import com.marvel.api.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterRequestParam implements HandlerInterceptor {

    @Autowired
    private CharactersService charactersService;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String pathError = "/v1/public/invalid/error?id-error=";

        if(request.getParameter("limit") != null && Integer.parseInt(request.getParameter("limit")) > 100){
            response.sendRedirect(pathError+"1");
            return false;
        }

        if(request.getParameter("limit") != null && Integer.parseInt(request.getParameter("limit")) < 1){
            response.sendRedirect(pathError+"2");
            return false;
        }

        if(!charactersService.validaParameter(request.getParameter("limit"),"int")){
            response.sendRedirect(pathError+"3");
            return false;
        }

        if(!charactersService.validaParameter(request.getParameter("modifiedSince"),"int")){
            response.sendRedirect(pathError+"3");
            return false;
        }

        if(!charactersService.validaParameter(request.getParameter("modifiedSince"),"int")){
            response.sendRedirect(pathError+"3");
            return false;
        }

        if(!charactersService.validaParameter(request.getParameter("orderBy"),"order")){
            response.sendRedirect(pathError+"4");
            return false;
        }

        return true;
    }


}
