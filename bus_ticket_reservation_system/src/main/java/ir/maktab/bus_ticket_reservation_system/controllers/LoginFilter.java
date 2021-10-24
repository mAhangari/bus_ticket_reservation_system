package ir.maktab.bus_ticket_reservation_system.controllers;

import ir.maktab.bus_ticket_reservation_system.model.User;
import ir.maktab.bus_ticket_reservation_system.service.login.ExceptionHandling.AccountLoginLimitReachedException;
import ir.maktab.bus_ticket_reservation_system.service.login.ExceptionHandling.AccountNotFoundException;
import ir.maktab.bus_ticket_reservation_system.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/user-page")
public class LoginFilter implements Filter {

    @Autowired
    LoginService loginService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        HttpServletRequest  request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        try {
            User account = loginService.login(username, password);
            if (account.isLoggedIn()) {
                session.setAttribute("account", account);
                filterChain.doFilter(request, servletResponse);
            } else {
                dispatchFailedLogin(servletRequest, servletResponse, filterChain);
            }
        } catch (AccountNotFoundException | AccountLoginLimitReachedException foundException) {
            dispatchFailedLogin(servletRequest, servletResponse, filterChain);
        }

    }

    private void dispatchFailedLogin(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        request.setAttribute("message", "Sorry, your username or password was incorrect. Please double-check your username and password.");
        request.setAttribute("account", null);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
