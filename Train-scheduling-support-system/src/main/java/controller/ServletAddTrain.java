package controller;

import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoTrain;
import model.dao.imp.ScheduleTableInfo;
import model.dao.imp.TrainTableInfo;

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

        DAoTrain dAoTrain = new TrainTableInfo();
        DAoSchedule dAoSchedule = new ScheduleTableInfo();

        String nameTrain = request.getParameter("nameTrain");
        int indexTrain = dAoTrain.getIndexTrain(nameTrain);
        dAoSchedule.setTrainInSchedule(indexTrain);

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/startStationJsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
