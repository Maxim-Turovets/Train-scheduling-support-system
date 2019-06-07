package servise;

import model.dao.daointerfaces.DAoSchedule;
import model.dao.daointerfaces.DAoTrain;
import model.dao.imp.ScheduleTableInfo;
import model.dao.imp.TrainTableInfo;

import javax.servlet.http.HttpServletRequest;

public class AddTrainServise {

    private HttpServletRequest request;
    private DAoTrain dAoTrain;
    private DAoSchedule dAoSchedule;
    private String nameTrain;
    private int indexTrain;

    public AddTrainServise(HttpServletRequest request) {
        this.request = request;
        if (request.getParameter("nameTrain")!=null){
        dAoTrain = new TrainTableInfo();
        dAoSchedule = new ScheduleTableInfo();
        nameTrain = request.getParameter("nameTrain");
        indexTrain = dAoTrain.getIndexTrain(nameTrain);
        dAoSchedule.setTrainInSchedule(indexTrain);}
    }





//    RequestDispatcher dispatcher = getServletContext()
//            .getRequestDispatcher("/startStationJsp");
//        dispatcher.forward(request, response);
}
