package com.app.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        double n1 = Double.parseDouble(req.getParameter("num1"));
        double n2 = Double.parseDouble(req.getParameter("num2"));
        String op = req.getParameter("op");

        double result = 0;

        switch (op) {
            case "+": result = n1 + n2; break;
            case "-": result = n1 - n2; break;
            case "*": result = n1 * n2; break;
            case "/": result = n2 != 0 ? n1 / n2 : 0; break;
        }

        res.setContentType("text/html");

        res.getWriter().println(
        	    "<!DOCTYPE html>" +
        	    "<html>" +
        	    "<head>" +
        	    "<title>Result</title>" +
        	    "<style>" +
        	    "body{height:100vh;display:flex;justify-content:center;align-items:center;" +
        	    "background:linear-gradient(135deg,#667eea,#764ba2);font-family:Arial;}" +
        	    ".box{background:white;padding:30px;border-radius:15px;text-align:center;" +
        	    "width:300px;box-shadow:0 15px 30px rgba(0,0,0,0.3);}" +
        	    "a{display:inline-block;margin-top:15px;text-decoration:none;color:white;" +
        	    "background:#667eea;padding:10px 20px;border-radius:8px;}" +
        	    "a:hover{background:#5a67d8;}" +
        	    "</style>" +
        	    "</head>" +
        	    "<body>" +
        	    "<div class='box'>" +
        	    "<h2>Result</h2>" +
        	    "<h1>" + result + "</h1>" +
        	    "<a href='index.html'>Back</a>" +
        	    "</div>" +
        	    "</body>" +
        	    "</html>"
        	);
    }
    
}
