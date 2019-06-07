package controller.command;

import controller.command.impl.*;

public class CommandList {

    public static  Command valueOf(String commandName) {
        switch (commandName) {
            case "addRoute":
                return new StartStationCommand();
            case "getInfo":
                return new GetInfoStationCommand();
            case "getSchedule":
                return new GetScheduleCommand();
            case "getMap":
                return new GetMapCommand();
            case "addTrain":
                return  new AddTrainCommand();
            case "addStation":
                return  new AddStationCommand();
            default:
                break;
        }
        return null;
    }

}
