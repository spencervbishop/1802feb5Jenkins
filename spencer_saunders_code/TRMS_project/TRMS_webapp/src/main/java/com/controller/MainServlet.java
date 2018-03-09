package com.controller;

import com.beans.Application;
import com.beans.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/api/*"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    private final static Map<String, Controller> controllers = new HashMap<>(0);

    @Override
    public void init() throws ServletException{
        controllers.put("empdata", new EmployeeController());
        controllers.put("forms", new ApplicationController());
    }

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
            processPost(req, resp, controllerPath);
        } else if(req.getMethod().equalsIgnoreCase("PUT")) {
            //processPut(req, resp, controllerPath);
            System.out.println("process put");
        } else if(req.getMethod().equalsIgnoreCase("DELETE")) {
            //TODO handle delete requests
        }
    }

    private void processPost(HttpServletRequest req, HttpServletResponse resp, String controllerPath) throws IOException, ServletException {
        Object r;
        String rData = null;
        if(controllerPath.equalsIgnoreCase("/login")) {
            Employee testEmployee = (Employee)parseBody(req.getReader(), Employee.class);
            //Employee emp = (Employee)parseBody(req.getParameter("employee"));
            String uname = testEmployee.getUsername();
            String pword = testEmployee.getPassword();
            r = ((EmployeeController) controllers.get("empdata")).getEmployee(uname, pword);
            rData = new ObjectMapper().writeValueAsString(r);
        } else if(controllerPath.equalsIgnoreCase("/form")) {
            Application testApplication = (Application)parseBody(req.getReader(), Application.class);
            r = ((ApplicationController)controllers.get("forms")).saveApplication(testApplication);
            rData = new ObjectMapper().writeValueAsString(r);
        }
        resp.setHeader("Content-Type", "application/json");
        resp.getWriter().write(rData);
    }


//private void processGet(HttpServletRequest req, HttpServletResponse resp, String controllerPath) throws IOException, ServletException {
//        Object r;
//        String rData = null;
//        if(controllerPath.equalsIgnoreCase("/lists")) {
//        r = ((ApplicationController)controllers.get("lists")).getAllLists();
//        rData = new ObjectMapper().writeValueAsString(r);
//        } else if(controllerPath.equalsIgnoreCase("/lists/list")) {
//        int id = Integer.parseInt(req.getParameter("id"));
//        r = ((ListDataController)controllers.get("lists")).getOneList(id);
//        rData = new ObjectMapper().writeValueAsString(r);
//
//        }
//        resp.setHeader("Content-Type", "application/json");
//        resp.getWriter().write(rData);
//        }
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

    //Token json = mapper.readValue(req.getReader(), mapper.getTypeFactory().constructType(Token.class));


    private Object parseBody(BufferedReader in, Class clazz) throws IOException {
        Object mapper = new ObjectMapper().readValue(in, clazz);
        return mapper;
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
        resp.setStatus(200);
    }
}
