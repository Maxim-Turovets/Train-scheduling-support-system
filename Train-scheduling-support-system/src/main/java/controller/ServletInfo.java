package controller;

import model.dao.imp.BaseGetInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

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

            BaseGetInfo baseGetInfo = new BaseGetInfo();
            baseGetInfo.deleteRoute(result);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/scheduleJsp");
            dispatcher.forward(request, response);
        }





   //     BaseGetInfo baseGetInfo = new BaseGetInfo();
   //     ArrayList<String> stationList = baseGetInfo.getDoubleNameCrossing(1);

//        System.out.println(baseGetInfo.getCrossingInStation(stationList));
//        System.out.println(stationList);

//        System.out.println(baseGetInfo.getStartCrossingTimeArray(2));
//        System.out.println(baseGetInfo.getEndCrossingTimeArray(2));

  //      System.out.println(baseGetInfo.getDoubleNameCrossing(1));
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/infoJsp");
            dispatcher.forward(request, response);

    }
}
