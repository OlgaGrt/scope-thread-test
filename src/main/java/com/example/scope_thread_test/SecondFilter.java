package com.example.scope_thread_test;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Random;

@AllArgsConstructor
@Component
@Order(2)
public class SecondFilter extends OncePerRequestFilter {

    private final ThreadContext threadContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("2: " + threadContext.getClientId());

        threadContext.setClientId(String.valueOf(new Random().nextInt()));

        filterChain.doFilter(request, response);
    }

}
