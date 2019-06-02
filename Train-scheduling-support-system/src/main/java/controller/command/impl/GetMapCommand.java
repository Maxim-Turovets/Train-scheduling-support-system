package controller.command.impl;

import controller.command.Command;

public class GetMapCommand implements Command {
    @Override
    public String execute() {
        return "/mapJsp";
    }
}
