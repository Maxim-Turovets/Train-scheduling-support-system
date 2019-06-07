package controller.command.impl;

import controller.command.Command;
import servise.AddStationServise;

import javax.servlet.http.HttpServletRequest;


public class AddStationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        AddStationServise servise = new AddStationServise(request);
        return "/addRouteJsp";
    }
}
