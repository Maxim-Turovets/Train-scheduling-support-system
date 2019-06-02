package controller.command.impl;

import controller.command.Command;

public class GetScheduleCommand implements Command {
    @Override
    public String execute() {
        return  "/scheduleJsp";
    }
}
