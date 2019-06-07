package controller;

import model.dao.daointerfaces.DAoRoute;
import model.dao.imp.RouteTableInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletInfo")
public class ServletInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("delete")!=null)
        {
            String strIndex = request.getParameter("delete");
            int result = Integer.parseInt(strIndex);
            System.out.println(result);



            DAoRoute dAoRoute = new RouteTableInfo();


            dAoRoute.deleteRoute(result);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/scheduleJsp");
            dispatcher.forward(request, response);
        }

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/infoJsp");
            dispatcher.forward(request, response);

    }
}
