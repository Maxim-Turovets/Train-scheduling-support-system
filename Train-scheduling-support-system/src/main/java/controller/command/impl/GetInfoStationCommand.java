package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;


public class GetInfoStationCommand  implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/infoJsp";
    }
}
