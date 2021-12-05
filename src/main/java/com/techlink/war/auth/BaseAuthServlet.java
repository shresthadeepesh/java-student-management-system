/*
 * Copyright (c) 2021 Dipesh Shrestha aka JustaDreamer
 * Github: https://github.com/JustaNormalDreamer
 */

package com.techlink.war.auth;

import com.techlink.common.auth.AuthService;

import javax.servlet.http.HttpServlet;

public class BaseAuthServlet extends HttpServlet {

    protected final AuthService authService;

    public BaseAuthServlet() {
        authService = new AuthService();
    }
}
