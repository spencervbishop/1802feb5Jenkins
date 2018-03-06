package com.ex.web.dispatcher;

import com.ex.domain.TodoList;
import com.ex.web.Controller;
import com.ex.web.controller.ListDataController;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * This will be the front controller for the applicaton.
 * In this implementation we are hardcoding all of the routes
 * in a better implementation we would at least use XML or Annotations
 * to have the controllers self-register with the front controller
 */
@WebServlet(urlPatterns = {"/api/*"}, loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private final static Map<String, Controller> controllers = new HashMap<>(0);

    @Override
    public void init() throws ServletException {
        controllers.put("lists", new ListDataController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = getServletContext().getContextPath();
        String servletPath = req.getServletPath();
        //are request will come in as /contextPath/servletPath/controllerPath
        //everything in this servlet is hardcoded so it requires us to know a lot more
        //about the controller and request than usual so we will be making a lot of assumptions
        String controllerPath = req.getRequestURI().substring(contextPath.length() + servletPath.length());

        if(req.getMethod().equalsIgnoreCase("GET")) {
            //processGet(req, resp, controllerPath);
            resp.setStatus(404);
        } else if(req.getMethod().equalsIgnoreCase("POST")) {
            //TODO handle post requests
        } else if(req.getMethod().equalsIgnoreCase("PUT")) {
            processPut(req, resp, controllerPath);
        } else if(req.getMethod().equalsIgnoreCase("DELETE")) {
            //TODO handle delete requests
        }
    }

    private void processGet(HttpServletRequest req, HttpServletResponse resp, String controllerPath) throws IOException, ServletException {
        Object r;
        String rData = null;
        if(controllerPath.equalsIgnoreCase("/lists")) {
            r = ((ListDataController)controllers.get("lists")).getAllLists();
            rData = new ObjectMapper().writeValueAsString(r);
        } else if(controllerPath.equalsIgnoreCase("/lists/list")) {
            int id = Integer.parseInt(req.getParameter("id"));
            r = ((ListDataController)controllers.get("lists")).getOneList(id);
            rData = new ObjectMapper().writeValueAsString(r);

        }
        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().write(rData);
    }
    private void processPut(HttpServletRequest req, HttpServletResponse resp, String controllerPath) throws IOException, ServletException {
        int r;
        if(controllerPath.equalsIgnoreCase("/lists/update")) {
            TodoList list = (TodoList)parseBody(req.getReader(), TodoList.class);
            r = ((ListDataController)controllers.get("lists")).updateList(list);

            if(r <= 0) {
                resp.setStatus(500);
            }
        }
    }

    private Object parseBody(BufferedReader in, Class clazz) throws IOException {
        Object o = new ObjectMapper().readValue(in, clazz);
        return o;
    }
}
