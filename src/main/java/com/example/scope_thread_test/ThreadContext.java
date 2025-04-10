package com.example.scope_thread_test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Getter
@Setter
@AllArgsConstructor
@Component
@Scope(value = "thread", proxyMode = TARGET_CLASS)
//@Scope(value = "request", proxyMode = TARGET_CLASS)
public class ThreadContext {

    private static final Logger log = LoggerFactory.getLogger(ThreadContext.class);
    private String clientId;

    public void clear() {
        setClientId(null);
    }

    public ThreadContext() {
        log.info("in ThreadContext constructor");
    }
}
