package controller;

import controller.command.Command;
import controller.command.CommandList;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName = request.getParameter("command");
        Command command = CommandList.valueOf(commandName);
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(command.execute(request));
        dispatcher.forward(request, response);

    }
}
