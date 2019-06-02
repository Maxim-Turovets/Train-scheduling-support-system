package controller.command.impl;

import controller.command.Command;


public class GetInfoStationCommand  implements Command {
    @Override
    public String execute() {
        return "/infoJsp";
    }
}
