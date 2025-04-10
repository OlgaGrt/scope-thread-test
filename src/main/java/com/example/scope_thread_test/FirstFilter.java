package com.example.scope_thread_test;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class FirstFilter extends OncePerRequestFilter {

    private final ThreadContext threadContext;

    public FirstFilter(ThreadContext threadContext) {
        this.threadContext = threadContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("1: " + threadContext.getClientId());

        filterChain.doFilter(request, response);
    }

}
