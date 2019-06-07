package controller.command.impl;

import controller.command.Command;
import servise.DeleteRouteServise;

import javax.servlet.http.HttpServletRequest;

public class DeleteRouteCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DeleteRouteServise servise = new DeleteRouteServise(request);
        servise.deleteRoute();
        return "/scheduleJsp";
    }
}
