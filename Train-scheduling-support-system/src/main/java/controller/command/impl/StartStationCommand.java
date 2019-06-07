package controller.command.impl;

import controller.command.Command;
import servise.AddTrainServise;

import javax.servlet.http.HttpServletRequest;

public class StartStationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        AddTrainServise servise = new AddTrainServise(request);
        return "/startStationJsp";
    }
}
