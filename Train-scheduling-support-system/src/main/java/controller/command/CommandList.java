package controller.command;

import controller.command.impl.AddRouteCommand;
import controller.command.impl.GetInfoStationCommand;
import controller.command.impl.GetMapCommand;
import controller.command.impl.GetScheduleCommand;

public class CommandList {

    public static  Command valueOf(String commandName) {
        switch (commandName) {
            case "addRoute":
                return new AddRouteCommand();
            case "getInfo":
                return new GetInfoStationCommand();
            case "getSchedule":
                return new GetScheduleCommand();
            case "getMap":
                return new GetMapCommand();
            default:
                break;
        }
        return null;
    }

}
