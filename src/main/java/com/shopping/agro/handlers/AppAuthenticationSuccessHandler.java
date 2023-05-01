package com.shopping.agro.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {
        System.out.println("handler...");
    }

}