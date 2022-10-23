package com.task3webapppart1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;

public class Msg extends HttpServlet {
    int sum = 0;

    private void loadTemplate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String charset = "ISO8859-2";
        req.setCharacterEncoding(charset);
        resp.setContentType("text/html; charset=" + charset);
        PrintWriter out = resp.getWriter();
        String formFile = getInitParameter("formFormFile");
        ServletContext context = getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-INF/" + formFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) out.println(line);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //getting parameters values from the URI
        PrintWriter out = response.getWriter();
        //load html template
        loadTemplate(request, response);
        Integer[] values = new Integer[2];
        int i = 0;
        try {
            Enumeration parNames = request.getParameterNames();
            while (parNames.hasMoreElements()) {
                String name = (String) parNames.nextElement();
                if (name.contains("text")) { //in the form text fields are called text1, text2
                    String value = request.getParameter(name);
                    values[i] = Integer.valueOf(value); //add the values to  array
                    i++;
                }
            }
            sum = values[0] + values[1];

            out.print("<font color=darkred>");
            out.print("      <center><h2>Result for GET after summing</h2></center>");
            out.println("<center>");
            out.println("<h2>");
            out.println(sum);
            out.print("</h2>");
            out.println("</center>");
            out.print("      </font>");

        } catch (Exception e) {
            out.print("<font color=darkred>");
            out.print("      <center><h2>Please input 2 numbers to obtain the GET result</h2></center>");
            out.print("      </font>");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        //getting parameters values with request.getParameter(name)
        PrintWriter out = response.getWriter();
        //load html template
        loadTemplate(request, response);
        try {
            int x = Integer.parseInt(request.getParameter("text1"));
            int y = Integer.parseInt(request.getParameter("text2"));
            sum = x + y;
            out.print("<font color=darkred>");
            out.print("      <center><h2>Result for POST after summing</h2></center>");
            out.println("<center>");
            out.println("<h2>");
            out.println(sum);
            out.print("</h2>");
            out.println("</center>");
            out.print("      </font>");
        } catch (Exception e) {
            out.print("<font color=darkred>");
            out.print("      <center><h2>Please input 2 numbers to obtain the POST result</h2></center>");
            out.print("      </font>");
        }
    }
}