package controller.command.impl;

import controller.command.Command;

public class AddRouteCommand implements Command {

    @Override
    public String execute() {
        return "/startStationJsp";
    }
}
