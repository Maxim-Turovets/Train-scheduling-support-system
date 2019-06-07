package controller.command.impl;

import controller.command.Command;
import servise.SaveDataServise;

import javax.servlet.http.HttpServletRequest;

public class AddTrainCommand  implements Command {

    @Override
        public String execute(HttpServletRequest request) {
        SaveDataServise servise = new SaveDataServise(request);
        servise.saveDate();
        return "/addTrainJsp";
        }

}
