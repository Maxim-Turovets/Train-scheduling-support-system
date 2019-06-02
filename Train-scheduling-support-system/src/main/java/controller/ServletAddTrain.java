package controller;

import model.dao.imp.BaseGetInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAddTrain")
public class ServletAddTrain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BaseGetInfo baseGetInfo = new BaseGetInfo();
        String nameTrain = request.getParameter("nameTrain");
        int indexTrain = baseGetInfo.getIndexTrain(nameTrain);
        baseGetInfo.setTrainInSchedule(indexTrain);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/startStationJsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
