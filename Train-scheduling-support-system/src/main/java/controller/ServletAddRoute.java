package controller;

import controller.command.Command;
import controller.command.CommandList;
import model.dao.daointerfaces.DAoCrossing;
import model.dao.daointerfaces.DAoRoute;
import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoStation;
import model.dao.imp.*;
import servise.AddStationServise;
import servise.SaveDataServise;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "ServletAddRoute")
public class ServletAddRoute extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName = request.getParameter("command");

            Command command = CommandList.valueOf(commandName);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(command.execute(request));
            dispatcher.forward(request, response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SaveDataServise servise = new SaveDataServise(request);
        servise.getRequest();

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/startStationJsp");
        dispatcher.forward(request, response);
    }




    private void printParametr(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            String fieldName = (String) obj;
            String fieldValue = request.getParameter(fieldName);
            System.out.println(fieldName + " : " + fieldValue + "\n");
        }
    }


}
