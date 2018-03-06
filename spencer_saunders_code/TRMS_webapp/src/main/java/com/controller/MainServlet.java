package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/*"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String contextPath = getServletContext().getContextPath();
        String servletPath = req.getServletPath();
        //request will come in as /contextPath/servletPath/controllerPath
        String controllerPath = req.getRequestURI().substring(contextPath.length() + servletPath.length());

        if(req.getMethod().equalsIgnoreCase("GET")) {
            //processGet(req, resp, controllerPath);
            resp.setStatus(404);
        } else if(req.getMethod().equalsIgnoreCase("POST")) {
            //TODO handle post requests
        } else if(req.getMethod().equalsIgnoreCase("PUT")) {
            //processPut(req, resp, controllerPath);
            System.out.println("process put");
        } else if(req.getMethod().equalsIgnoreCase("DELETE")) {
            //TODO handle delete requests
        }
    }

//    private void processGet(HttpServletRequest req, HttpServletResponse resp, String controllerPath) throws IOException, ServletException {
//        Object r;
//        String rData = null;
//        if(controllerPath.equalsIgnoreCase("/lists")) {
//            r = ((ListDataController)controllers.get("lists")).getAllLists();
//            rData = new ObjectMapper().writeValueAsString(r);
//        } else if(controllerPath.equalsIgnoreCase("/lists/list")) {
//            int id = Integer.parseInt(req.getParameter("id"));
//            r = ((ListDataController)controllers.get("lists")).getOneList(id);
//            rData = new ObjectMapper().writeValueAsString(r);
//
//        }
//        resp.setHeader("Content-Type", "application/json");
//        resp.getWriter().write(rData);
//    }
//
//    private void processPut(HttpServletRequest req, HttpServletResponse resp, String controllerPath) throws IOException, ServletException {
//        int r;
//        if(controllerPath.equalsIgnoreCase("/lists/update")) {
//            TodoList list = (TodoList)parseBody(req.getReader(), TodoList.class);
//            r = ((ListDataController)controllers.get("lists")).updateList(list);
//
//            if(r <= 0) {
//                resp.setStatus(500);
//            }
//        }
//    }

    private Object parseBody(BufferedReader in, Class clazz) throws IOException {
        Object o = new ObjectMapper().readValue(in, clazz);
        return o;
    }

    @Override
    public void init() throws ServletException{
        super.init();
    }

    @Override
    public void destroy(){
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html><body><h1>Hello, World!</h1></body></html>");
        resp.setStatus(200);
        resp.setHeader("Content-Type", "text/html");

        resp.getWriter().write(getServletContext().getInitParameter("Application"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Received your POST request");
    }
}
