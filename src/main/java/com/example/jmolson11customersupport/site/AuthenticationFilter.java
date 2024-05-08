package com.example.jmolson11customersupport.site;

import com.example.jmolson11customersupport.entities.UserPrincipal;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.Principal;

@WebFilter(value={"/", "/blog/*", "/sessions"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession(false); // don't create a session if doesn't exit
        final Principal principal = UserPrincipal.getPrincipal(session);
        // no one logged so redirect
        if(principal == null) {
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest)servletRequest).getContextPath() + "/login");
        }
        else {
            filterChain.doFilter(new HttpServletRequestWrapper((HttpServletRequest)servletRequest) {
                // creating the session Principal stuff
                @Override
                public Principal getUserPrincipal() {
                    return principal;}
            }, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}

