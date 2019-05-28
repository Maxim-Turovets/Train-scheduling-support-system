package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletMain")
public class ServletMain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(request.getParameter("addRoute")!=null)
        if(request.getParameter("addRoute").equals("addRoute"))
        {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/startStationJsp");
            dispatcher.forward(request, response);
        }

        if(request.getParameter("getInfo")!=null)
        if(request.getParameter("getInfo").equals("getInfo"))
        {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/infoJsp");
            dispatcher.forward(request, response);
        }


    }
}
